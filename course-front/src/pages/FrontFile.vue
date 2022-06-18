<template>
	<div class="video-cls">
		
		<el-table :data="videoInfoList"  stripe style="margin-left: 5%; margin-right: 10%; width:80%;">
		
			<el-table-column prop="materialId" label="资料编号">
			</el-table-column>
			<el-table-column prop="materialName" label="资料名称">
			</el-table-column>
			<el-table-column prop="teacherName" label="上传者">
			</el-table-column>
			<el-table-column prop="materialCtime" label="上传时间" sortable>
			</el-table-column>


			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-tooltip class="item" effect="dark" content="下载" placement="top-start">
						<el-button type="success" icon="el-icon-download" circle @click="showFile(scope.$index, scope.row)">
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
			showFile(index,row){
				window.open("http://localhost:9091/"+row.materialUrl);
			},
			pageClick(nowPage) {
				this.nowPage = nowPage;
				this.getVideoList();
			},
			
			getVideoList(){
				let item=sessionStorage.getItem("course");
				let obj=JSON.parse(item);
				
				axios.post("/material/getmaterial",{"courseId":obj.courseId,"nowPage":(this.nowPage-1)*this.divideNum,"divideNum":this.divideNum}).then((resp)=>{
					
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
