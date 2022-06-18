<template>
	<div class="head">
		<div><span style="font-size: 25px;font-weight: bold;color: black;margin-left: 3%;">课程总评:</span><el-rate v-model="allAvgScore" disabled show-score text-color="#ff9900" score-template="{value}" style="margin-left: 5%;">
				</el-rate></div>
		<div style="margin-left: 4%;padding-top: 2%;" v-for="item in evaluationInfoList" :key="item.evaluationId">
			<el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" style="height: 40px;">
				{{item.studentName}}</el-avatar>
			
			
			
			<span style="margin-left: 2%;">{{item.studentName}}
				<el-rate v-model="item.evaluationScore" disabled show-score text-color="#ff9900" score-template="{value}" style="margin-left: 5%;">
				</el-rate>
			</span>
			<div style="margin-top: 1%;margin-left: 5%;">{{item.evaluationContent}}</div>
			<span style="font-size: 13px;margin-left: 5%;">发表于:{{item.evaluationCtime}}</span>
		</div>

		<el-pagination background layout="prev, pager, next" style="margin-left: 45%;margin-top: 5%;"
			:current-page='nowPage' :pager-count='5' :total="count" :page-count='page' :page-size='divideNum'
			@current-change='pageClick'>
		</el-pagination>
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
				evaluationInfoList: [],
				allAvgScore:0,
			}
		},
		created() {

			this.getFrontEvaluationList();

			
			
			
		},


		methods: {
			getFrontEvaluationList() {
				let item = sessionStorage.getItem("course");
				let obj = JSON.parse(item);
				axios.post("/evaluation/front/list", {
					courseId: obj.courseId,
					nowPage: (this.nowPage - 1) * this.divideNum,
					divideNum: this.divideNum
				}).then((resp) => {
					let count = resp.data.map.count;
					console.log(resp);
					if (count == 0) {
						this.evaluationInfoList = [];
						this.commOpen('暂无评论，快进行学习后评论吧');
						this.count = 0;
						this.nowPage = 1;
						this.page = 1;


					} else {
						this.evaluationInfoList = resp.data.map.list;
						console.log(resp.data.map.list);
						this.count = count;
						let page = count / this.divideNum;
						if (count % this.divideNum > 0) {
							page += 1;
						}
						this.page = page;
						let allSum=0;
						for(let item of this.evaluationInfoList){
							console.log(item.evaluationScore);
							allSum+=parseFloat(item.evaluationScore);
						}
						this.allAvgScore=allSum/parseFloat(this.evaluationInfoList.length);

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
