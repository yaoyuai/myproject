<template>
	<div class="video-cls">
		
		<el-table :data="videoInfoList" stripe style="margin-left: 5%; margin-right: 10%; width:80%;">
		
			<el-table-column prop="examId" label="考试编号">
			</el-table-column>
			<el-table-column prop="examName" label="考试名称">
			</el-table-column>
			<el-table-column prop="teacherName" label="上传者">
			</el-table-column>
			<el-table-column prop="examCtime" label="上传时间"  sortable>
			</el-table-column>
			<el-table-column prop="examState" label="考试状态">
			</el-table-column>
			


			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-tooltip class="item" effect="dark" content="去考试" placement="top-start">
						<el-button type="success" icon="el-icon-document" circle @click="showFile(scope.$index, scope.row)">
						</el-button>
					</el-tooltip>
					<el-tooltip class="item" effect="dark" content="查看分数" placement="top-start">
						<el-button type="primary" icon="el-icon-search" circle @click="showScore(scope.$index, scope.row)">
						</el-button>
					</el-tooltip>
					</template> 
			</el-table-column>
		</el-table>
		
		<div>
			<el-pagination background layout="prev, pager, next" style="margin-left: 40%;margin-top: 5%;"
				:current-page='nowPage' :pager-count='divideNum' :total="count" :page-count='page' :page-size='divideNum'
				@current-change='pageClick'>
			</el-pagination>
		</div>

		

	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		
		created() {
			this.getVideoList();
			
		},
		
		
		data() {
			return {
				videoInfoList:[],
				nowPage: 1,
				page: 1,
				count: 0,
				divideNum: 5,
			}
		},
		methods: {
			showScore(index,row){
				
				if(row.examState!="已考试"){
					this.commOpen("您还未考试,请考试完查看");
					return;
				}
				axios.post("/zexam/showscore",{"examId":row.examId}).then((resp)=>{
					
					this.commOpen(resp.data.message);
				}).catch(err=>{
					
					console.log(err);
					this.commOpen("请联系管理员");
				})
				
			},
			
			
			
			showFile(index,row){
				if(row.examState=="已考试"){
					this.commOpen("您已考试，请不要重复点击");
					return;
				}
				sessionStorage.setItem("exam",JSON.stringify(row));
				window.open("/#/examdes")
				// window.parent.$router.push("/examdes");
			},
			pageClick(nowPage) {
				this.nowPage = nowPage;
				this.getVideoList();
			},
			
			getVideoList(){
				let item=sessionStorage.getItem("course");
				let obj=JSON.parse(item);
				
				axios.post("/exam/showallexambycourseid",{"courseId":obj.courseId,"nowPage":(this.nowPage-1)*this.divideNum,"divideNum":this.divideNum}).then((resp)=>{
					
					let count = resp.data.map.count;
					if (count == 0) {
						this.videoInfoList = [];
						this.commOpen('暂无数据');
						this.count = 0;
						this.nowPage = 1;
						this.page = 1;
					} else {
						this.videoInfoList = resp.data.map.list;
						this.count = count;
						let page = count / this.divideNum;
						if (count % this.divideNum > 0) {
							page += 1;
						}
						this.page = page;
					}
					
					
				}).catch(err=>{
					console.log(err);
					this.commOpen("请联系管理员");
					
				})
				
				
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
	.video-cls {
		background-color: white;
		height: 700px;
/* 		display: flex;
		flex-wrap: wrap;
		justify-content: space-around; */
	}

	.video-content {
		height: 250px;
	}
</style>
