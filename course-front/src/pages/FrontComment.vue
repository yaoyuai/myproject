<template>
	<div class="head">
		<el-input type="textarea" :rows="5" placeholder="请输入评论内容" v-model="evaluationContent" style="width: 80%;;margin-left: 2%;margin-top: 2%;" :disabled="textAreaFlag">
		</el-input>
		<div>——</div>
		<el-button type="success" style="margin-left: 85%;margin-top: -10%;position: absolute;" @click="evaluate()" :disabled="evaluateButtonFlag">评价</el-button>



		<div class="video-cls">

			<!-- <div><span style="font-size: 25px;font-weight: bold;color: black;margin-left: 3%;">课程总评:</span>
				<el-rate v-model="allAvgScore" disabled show-score text-color="#ff9900" score-template="{value}"
					style="margin-left: 5%;">
				</el-rate>
			</div> -->
			<div style="margin-left: 4%;padding-top: 2%;" v-for="item in commentInfoList" :key="item.commentId">
				<el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
					style="height: 40px;">
					{{item.studentName}}
				</el-avatar>



<!-- 				<span style="margin-left: 2%;">{{item.studentName}}
					<el-rate v-model="item.evaluationScore" disabled show-score text-color="#ff9900"
						score-template="{value}" style="margin-left: 5%;">
					</el-rate>
				</span> -->
				<div style="margin-top: 1%;margin-left: 5%;">{{item.commentContent}}</div>
				<span style="font-size: 13px;margin-left: 5%;">发表于:{{item.commentCtime}}</span>
				<div style="margin-top: 1%;margin-left: 5%;">教师回复:{{item.teacherContent}}</div>
			</div>

			<el-pagination background layout="prev, pager, next" style="margin-left: 45%;margin-top: 5%;"
				:current-page='nowPage' :pager-count='5' :total="count" :page-count='page' :page-size='divideNum'
				@current-change='pageClick'>
			</el-pagination>



		</div>
	</div>

</template>

<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				nowPage: 1,
				page: 1,
				count: 0,
				divideNum: 5,
				activeIndex: '1',
				courseDes: "",
				courseId: "",
				commentInfoList: [],
				commentContent: '',
			}
		},
		created() {

			this.getFrontEvaluationList();


		},


		methods: {
			// selectHasEvaluation(){
				
			// 	axios.post("evluation/selectstudenthas",{"courseId":this.courseId}).then((resp)=>{
					
			// 		if(resp.data.id==1){
			// 			this.commOpen("您已评价过该课程");
			// 			this.textAreaFlag=true;
			// 			this.evaluateButtonFlag=true;
			// 		}else{
			// 			this.textAreaFlag=false;
			// 			this.evaluateButtonFlag=false;
			// 		}
					
					
					
					
			// 	}).catch(err=>{
			// 		console.log(err);
			// 		this.commOpen("请联系管理员"); 
			// 	})
			// },
			
			
			
			
			
			
			evaluate(){
				if(this.commentContent==""){
					this.commOpen("请输入评论内容");
					return;
				}
				
				
				
				axios.post("comment/add",{"courseId":this.courseId,"commentContent":this.commentContent}).then((resp)=>{
					this.commOpen(resp.data.message);
					if(resp.data.id==1){
						this.commentContent="";
					}
					
					
					
					
				}).catch(err=>{
					console.log(err);
					this.commOpen("请联系管理员");
					
				})
				
				
			},
			getCommentInfoList() {
				let item = sessionStorage.getItem("course");
				let obj = JSON.parse(item);
				axios.post("/comment/list", {
					courseId: obj.courseId,
					nowPage: (this.nowPage - 1) * this.divideNum,
					divideNum: this.divideNum
				}).then((resp) => {
					let count = resp.data.map.count;
					console.log(resp);
					if (count == 0) {
						this.commentInfoList = [];
						this.commOpen('暂无评论，快进行学习后评论吧');
						this.count = 0;
						this.nowPage = 1;
						this.page = 1;


					} else {
						this.commentInfoList = resp.data.map.list;
						this.count = count;
						let page = count / this.divideNum;
						if (count % this.divideNum > 0) {
							page += 1;
						}
						this.page = page;
					}

				}).catch(err => {
					console.log(err);
					this.commOpen("请联系管理员");
				})
			},


			pageClick(nowPage) {
				this.nowPage = nowPage;
				this.getFrontEvaluationList();
			},

			commOpen(content) {
				this.$alert(content, '提示', {
					confirmButtonText: '确定',
				});
			},
		}

	}
</script>

<style scoped>
	.head {
		color: rgb(153, 153, 153);
		margin: 0px;
		padding: 0px;
		height: 1500px;
		width: 100%;
		/* 		margin-left: -1%; */
		/* 		margin-top: -2%; */
		background-color: white;
	}
</style>
