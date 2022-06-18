<template>
	<div>
		<div style="margin-left: 45%;">
			<h1>{{examName}}
				<span style="font-size: 20px;margin-left: 20%;">考试人:{{studentName}}</span>
			</h1>
			<el-button type="danger" style="margin-left: 60%;" @click="examExit()">退出</el-button>
		</div>
		<div v-for="(item,index) in exerInfoList" :key="item.exerId" class="exer-cls">
			<div class="exer-title">{{(index+1)+". "+item.exerContent}}</div>
			<div v-for="(item2,index) in item.chooseInfoVoList" :key="index" class="exer-content">
				<input :type="inputType(item.typeId)" :name="item.exerId" :value="item2.chooseId">{{item2.chooseContent}}
			</div>
			<textarea :style="textArea(item.typeId)" cols="100" rows="5" class="textarea-cls" :name="item.exerId"></textarea>
		</div>
		<el-button type="success" style="margin-left: 47%; width: 150px;" @click="submitExam()">提交</el-button>
	</div>

</template>

<script>
	import axios from 'axios'
	export default {
		created() {
			let item = sessionStorage.getItem("token");
			let obj = JSON.parse(item);
			this.studentName = obj.studentName;
			let item2 = sessionStorage.getItem("exam");
			let obj2 = JSON.parse(item2);
			this.examName = obj2.examName;
			this.examId=obj2.examId;
			this.getAllExer();
		},


		computed: {
			textArea() {
				return function(typeId) {
					if (typeId == "4") {
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
				exerInfoList: [],
				studentName: '',
				examName: '',
				examKresScore: 0,
				examId:'',
			}
		},

		methods: {
			examExit() {



			},
			submitExam() {
				this.$confirm('确认提交？')
					.then((_) => {
						console.log(_);
						for (let item of this.exerInfoList) {
							let allRadioArr = document.getElementsByName(item.exerId);
							let arr=[];
							for (let item2 of allRadioArr) {	
								console.log(item2.type);
								if(item2.type=="radio"){
									if (item2.checked) {
										if (item.exerAnswer == item2.value) {
											this.examKresScore += item.exerValue;
										}
									}
								}else if(item2.type=="checkbox"){
									if (item2.checked) {
										arr.push(item2.value);
									}	
								}
							}
							if(arr.join(',')==item.exerAnswer){//这里是为了复选框使用的
								this.examKresScore += item.exerValue;
							}
						}
						
						let textAreaArr=document.getElementsByClassName("textarea-cls");
						
						let sendObj={};
						if(textAreaArr.length>0){//表示该考试有主观题的部分
							let allArr=[];
							for(let item of textAreaArr){
								let name=item.getAttribute("name");
								let value=item.value;
								
								if(value!=""){
									allArr.push(name+"-"+value);
								}
								
							}
							sendObj={"examId":this.examId,"kexamresScore":this.examKresScore,"zexamContent":allArr.join(',')};
							console.log(allArr);
						}else{
							sendObj={"examId":this.examId,"kexamresScore":this.examKresScore};
						}
						
						axios.post('/kexamres/add',sendObj).then((resp)=>{
							
							this.commOpen(resp.data.message);
							if(resp.data.id==1){
								this.$router.push("/frontdesone");
							}
							// if(resp.data.id==1){
								
								
								
							// }
							
							
							
							
							
						}).catch(err=>{
							console.log(err);
							this.commOpen("请联系管理员");
						})
						
						





					}).catch(_ => {
						console.log(_);
					});


			},



			getAllExer() {

				let item = sessionStorage.getItem("exam");
				let obj = JSON.parse(item);
				axios.post('exer/showallexerbyexamid', {
					"examId": obj.examId
				}).then((resp) => {
					this.exerInfoList = resp.data.map.list;
					console.log(obj.examId);
					console.log(this.exerInfoList);
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
		font-size: 18px;
		font-family: "黑体";
	}
	
	.exer-content {
		margin-top: 1%;
		font-size: 18px;
		font-family: "仿宋";
	}
	
	.exer-cls {
		margin-top: 1%;
		margin-left: 30%;
	}
</style>
