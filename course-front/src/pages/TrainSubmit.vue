<template>
	<div>
		<div style="margin-left: 45%;">
			<h1>{{trainName}}
				<span style="font-size: 20px;margin-left: 20%;">训练人:{{studentName}}</span>
			</h1>
			<el-button type="danger" style="margin-left: 60%;" @click="trainExit()">返回</el-button>
		</div>
		<div v-for="(item,index) in trainInfoList" :key="item.exerId" class="exer-cls">
			<div class="exer-title">{{(index+1)+". "+item.exerContent}}</div>
			<div v-for="(item2,index) in item.chooseInfoVoList" :key="index" class="exer-content">
				{{item2.chooseContent}}
			</div>
			<div><span>你选择的答案:{{}}</span><span>正确答案:{{item2.chooseId==}}</span></div>
			<div>答案解析{{}}</div>
		</div>
	</div>
</template>


<script>
	import axios from 'axios'
	export default {
		created() {
			let item = sessionStorage.getItem("token");
			let obj = JSON.parse(item);
			this.studentName = obj.studentName;
			let item2 = sessionStorage.getItem("train");
			let obj2 = JSON.parse(item2);
			this.trainName = obj2.trainName;
			this.trainId=obj2.trainId;
			this.getAllTrain();
		},


		computed: {
			textArea() {
				return function(typeId) {
					if (typeId == "3") {
						return "";
					} else {
						return "display:none"
					}
				};


			},
			inputType() {
				return function(typeId) {
					if (typeId == "1") {
						return "radio";
					} else if (typeId == "2") {
						return "checkbox";
					} else {
						return "textarea";
					}
				};

			}

		},
		data() {
			return {
				trainInfoList: [],
				studentName: '',
				trainName: '',
				trainId:'',
			}
		},

		methods: {
			trainExit() {
				
				

			},



			getAllTrain() {

				let item = sessionStorage.getItem("train");
				let obj = JSON.parse(item);
				axios.post('exer/showallexerbytrainid', {
					"train": obj.train
				}).then((resp) => {
					this.trainInfoList = resp.data.map.list;
				}).catch(err => {
					console.log(err);
					this.commOpen("请联系管理员");
				})
			},
			
			
		},
	}
</script>
<style scoped>
	.exer-title {
		font-size: 25px;
	}

	.exer-content {
		margin-top: 2%;
		font-size: 20px;
	}

	.exer-cls {
		margin-top: 2%;
		margin-left: 20%;
	}
</style>
