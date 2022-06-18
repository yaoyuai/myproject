<template>
	<div>
		<div style="margin-left: 45%;">
			<h1>{{trainName}}
				<span style="font-size: 20px;margin-left: 20%;">训练人:{{studentName}}</span>
			</h1>
			<el-button type="danger" style="margin-left: 60%;" @click="trainExit()">退出</el-button>
		</div>
		<div v-for="(item,index) in trainInfoList" :key="item.exerId" class="exer-cls">
			<div class="exer-title">{{(index+1)+". "+item.exerContent}}</div>
			<div v-for="(item2,index) in item.chooseInfoVoList" :key="index" class="exer-content">
				<input :type="inputType(item.typeId)" :name="item.exerId"
					:value="item2.chooseContent">{{item2.chooseContent}}
			</div>
			<div :style="showStyle" class="spIdClass">





			</div>
			<!-- 			<div :style="showStyle"> -->
			<!-- 				<span>你的答案为:{{submitArr[index].arr.join(',')}}</span>
				<span>正确答案为:{{submitArr[index].answer.join(',')}}</span> -->
			<!-- 			</div> -->
			<!-- 			<div :style="showStyle">答案解析:{{item.exerAnaly}}</div> -->
		</div>



		<el-button type="success" style="margin-left: 47%; width: 150px;" @click="submitExam()"
			:disabled="showAnswerFlag">提交并查看结果</el-button>
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
			this.trainId = obj2.trainId;
			this.getAllTrain();
		},


		computed: {
			showStyle() {
				if (this.showAnswerFlag) {
					return "";
				}
				return "display:none;";
			},



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
				trainId: '',
				submitArr: [],
				showAnswerFlag: false,
			}
		},

		methods: {
			trainExit() {

				this.$confirm('确认退出吗')
					.then((_) => {
						console.log(_);

						window.close();
					}).catch(_ => {
						console.log(_);
					});


			},
			submitExam() {
				this.$confirm('确认提交并查看结果')
					.then((_) => {
						console.log(_);
						this.showAnswerFlag = true;

						//遍历自己的答案 存放到数组中去
						for (let item of this.trainInfoList) {
							let allArr = document.getElementsByName(item.exerId);
							let checkBoxChecked = [];
							let obj = {
								"exerId": item.exerId,
								"arr": [],
								"answerArr": [],
								"exerAnaly": item.exerAnaly
							};
							for (let item2 of allArr) {
								if (item2.checked) {
									checkBoxChecked.push(item2.value.substring(0, 1));
									obj.arr = checkBoxChecked;
									obj.answerArr = [];

									// this.submitArr.push({
									// 	"exerId": item.exerId,
									// 	"arr": checkBoxChecked,
									// 	"answerArr": []
									// });
								}
							}
							this.submitArr.push(obj);

						}




						//遍历选项的答案 存放到数组中去 
						let trainInfoList = this.trainInfoList;
						let submitArr = this.submitArr;
						for (let i = 0; i < trainInfoList.length; i++) {
							let answerArr = [];
							let arr = trainInfoList[i].exerAnswer.split(',');
							let str = '';
							if (arr.length > 1) { //多选题
								for (let item of arr) {
									for (let j = 0; j < trainInfoList[i].chooseInfoVoList.length; j++) {
										if (item == trainInfoList[i].chooseInfoVoList[j].chooseId) {
											str += trainInfoList[i].chooseInfoVoList[j].chooseContent.substring(0, 1);
											if (j != trainInfoList[i].chooseInfoVoList.length -
												1) { //如果不是最后一位记得去拼接一个顿号
												str += "、";
											}
										}
									}
								}

							} else { //单选题、判断题

								for (let j = 0; j < trainInfoList[i].chooseInfoVoList.length; j++) {
									if (arr[0] == trainInfoList[i].chooseInfoVoList[j].chooseId) {
										str += trainInfoList[i].chooseInfoVoList[j].chooseContent.substring(0, 1);
									}
								}
							}
							answerArr.push(str);
							submitArr[i].answerArr = answerArr;

						}


						//这里要把内容拼接进去
						// document.getElementById("spId").innerHTML = "";
						let classArr = document.getElementsByClassName("spIdClass");
						for (let i = 0; i < classArr.length; i++) {
							console.log("执行了");
							if (submitArr[i].arr.join('、') != submitArr[i].answerArr.join(',')) {
								classArr[i].innerHTML = `
											<div style="color:red;margin-top:2%">正确答案:${submitArr[i].answerArr.join(',')}</div>
											<div style="color:red">题目解析:${submitArr[i].exerAnaly}</div></div>`;
							} else {
								classArr[i].innerHTML = `
											<div style="margin-top:2%">正确答案:${submitArr[i].answerArr.join(',')}</div>
											<div>题目解析:${submitArr[i].exerAnaly}</div></div>`;
							}


							console.log(classArr[i].innerHTML);
						}
						// for (let item of this.submitArr) {

						// 	htmlStr += `<div class="answer-cls"><div>你选择的答案:${item.arr.join(',')}</div>
						// 				<div>正确答案:${item.answerArr.join(',')}</div>
						// 				<div>题目解析:${item.exerAnaly}</div></div>`
						// }
						// document.getElementById("spId").innerHTML = htmlStr;





					}).catch(_ => {
						console.log(_);
					});


			},



			getAllTrain() {

				let item = sessionStorage.getItem("train");
				let obj = JSON.parse(item);
				axios.post('exer/showallexerbytrainid', {
					"trainId": obj.trainId
				}).then((resp) => {
					this.trainInfoList = resp.data.map.list;
					console.log(this.trainInfoList);
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

	.answer-cls {
		/* 	position: absolute;
		margin-left: 50%;
		margin-top: 10%; */
	}
</style>
