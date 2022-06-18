<template>


	<div>
		<div class="content-first">
			<div class="content-first-left" style="font-family: 微软雅黑;"><i class="el-icon-s-promotion"></i>中小学生课程网</div>
			<div class="content-first-right">
				<div>
					<span style="margin-right: 50px; font-weight: bold;">我的课程</span>
					<el-button type="text" @click="one()">{{registText}}</el-button>
					<el-button type="text" @click="two()"><i class="el-icon-user-solid"></i>{{loginText}}</el-button>
				</div>

			</div>
		</div>


		<div style="width: 800px;margin: 0 auto;">
			<el-input placeholder="搜索感兴趣的课程" v-model="courseDes">
				<template slot="append">
					<el-button type="primary" icon="el-icon-search" @click='buttonSearch()'></el-button>
				</template>
			</el-input>
		</div>





		<el-carousel :interval="4000" type="card" height="300px" style="margin-top: 3   0px;">
			<el-carousel-item v-for="item in imgs" :key="item.id">
				<img :src="item.url" width="100%" height="300px"/>
			</el-carousel-item>
		</el-carousel>









		<div style="margin-left: 50px;font-size: 30px;">热门课程</div>
		<div class="frmae">
			<div class="content-panel">
				<div class="content-panel-flex" v-for='item in courseInfoList' :key="item.courseId"  @click="goToCourseDes(item)" style="cursor: pointer;">
					<div class="content-img"><img :src="item.courseImg"  width="200px" height="200px"/></div>
					<div class="content-userName"><i class="el-icon-star-on"
							style="color: #E6A23C;"></i>{{item.courseName}}</div>
					<div class="content-panel-content">
						<div class="content-fileTitle"><i class="el-icon-upload2"></i>授课者:{{item.teacherNick}}</div>
						<div class="content-fileDes"><i class="el-icon-download"></i>选课次数:{{item.courseSelect}}</div>
					</div>
				</div>

			</div>
		</div>


		<FrontBottom></FrontBottom>






		<el-dialog title="用户登录" :visible.sync="loginFormVisible" width="40%" :rules="rules">
			<el-form :model="loginStudentInfo" ref="login-form" :rules="rules">
				<el-form-item label="用户名" prop="studentName" :label-width="formLabelWidth">
					<el-input v-model="loginStudentInfo.studentName" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="密码" prop="studentPwd" :label-width="formLabelWidth">
					<el-input v-model="loginStudentInfo.studentPwd" autocomplete="off" type="password"></el-input>
				</el-form-item>
				<el-form-item label="验证码" prop="code" :label-width="formLabelWidth">
					<el-input v-model="loginStudentInfo.code"></el-input>
				</el-form-item>
				<img :src='showCode' style="margin-left: 130px; width: 300px; height: 60px;">
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="loginBack()">返 回</el-button>
				<el-button type="primary" @click="studentLogin()">登 录</el-button>
			</div>
		</el-dialog>




		<el-dialog title="用户注册" :visible.sync="registFormVisible" width="40%" :rules="rules">
			<el-form :model="registStudentInfo" ref="regist-form" :rules="rules">
				<el-form-item label="用户名" prop="studentName" :label-width="formLabelWidth">
					<el-input v-model="registStudentInfo.studentName" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="密码" prop="studentPwd" :label-width="formLabelWidth">
					<el-input v-model="registStudentInfo.studentPwd" autocomplete="off" type="password"></el-input>
				</el-form-item>
				<el-form-item label="确认密码" prop="studentRePwd" :label-width="formLabelWidth">
					<el-input v-model="registStudentInfo.studentRePwd" autocomplete="off" type="password"></el-input>
				</el-form-item>
				<el-form-item label="昵称" prop="studentNick" :label-width="formLabelWidth">
					<el-input v-model="registStudentInfo.studentNick" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="性别" prop="studentSex" style="margin-left: 80px;">
					<el-radio-group v-model="registStudentInfo.studentSex">
						<el-radio label="男"></el-radio>
						<el-radio label="女"></el-radio>
					</el-radio-group>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="registBack()">返 回</el-button>
				<el-button type="primary" @click="studentRegist()">确认注册</el-button>
			</div>
		</el-dialog>



	</div>


</template>

<script>
	import FrontBottom from '../components/FrontBottom.vue'
	import axios from 'axios'
	export default {
		inject: ['reload'],
		components: {
			FrontBottom
		},
		data: function() {
			return {
				courseInfoList: [],
				courseDes: '',
				loginFormVisible: false,
				registFormVisible: false,
				loginStudentInfo: {
					studentName: '',
					studentPwd: '',
					code: '',
				},


				registStudentInfo: {
					studentName: '',
					studentPwd: '',
					studentRePwd: '',
					studentNick: '',
					studentSex: '',
				},


				formLabelWidth: '120px',
				registText: "注册",
				loginText: "登录",
				id: 0,
				oneFlag: true,
				twoFlag: true,
				imgs: [{
						id: 1,
						url: require("../assets/6.jpg")
					},
					{
						id: 2,
						url: require("../assets/7.jpg")
					},
					{
						id: 3,
						url: require("../assets/8.jpg")
					},
					{
						id: 4,
						url: require("../assets/9.jpg")
					},
					{
						id: 5,
						url: require("../assets/10.jpg")
					},
				],
			}
		},

		created() {
			this.getCourseInfoList();
			let item=sessionStorage.getItem("token");
			if(item!=null){
				let obj=JSON.parse(item);
				this.loginText = "用户:" + obj.studentNick;
				this.registText = "退出";
				this.oneFlag = false;
				this.twoFlag = false;
			}
		},


		computed: {
			showCode() {
				return this.id == 0 ? 'showCode' : 'showCode?h=' + Math.random();
			},
			rules() {
				return {
					studentName: [{
							required: true,
							message: '用户名必填',
							trigger: 'blur'
						},
						{
							max: 20,
							min: 4,
							message: '用户名6-20位',
							trigger: 'blur'
						}
					],
					studentPwd: [{
							required: true,
							message: '密码必填',
							trigger: 'blur'
						},
						{
							max: 20,
							min: 6,
							message: '密码6-20位',
							trigger: 'blur'
						}
					],
					code: [{
						required: true,
						message: '验证码必填',
						trigger: 'blur'
					}, ],
					studentRePwd: [{
							required: true,
							message: '密码必填',
							trigger: 'blur'
						},
						{
							max: 20,
							min: 6,
							message: '密码6-20位',
							trigger: 'blur'
						}
					],
					studentNick: [

						{
							required: true,
							message: '昵称必填',
							trigger: 'blur'
						},

					],
					studentSex: [{
							required: true,
							message: '性别必填',
							trigger: 'blur'
						},

					]
				}
			},


		},



		methods: {
			goToCourseDes(item){
				sessionStorage.setItem("course",JSON.stringify(item));
				this.$router.push("/frontdesone");
			},
			
			
			
			commOpen(content) {
				this.$alert(content, '提示', {
					confirmButtonText: '确定',
					callback: action => {
						this.$message({
							type: 'info',
							message: `action: ${ action }`
						});
					}
				});
			},

			pageClick(nowPage) {
				this.nowPage = nowPage;
				this.getCourseInfoList();
			},


			buttonSearch() {
				this.$router.push("/main");
			},



			getCourseInfoList() {
				axios.get("./course/selecthotcourse", {
					params: {
						"courseDes": this.courseDes,
						"nowPage": (this.nowPage - 1) * this.divideNum,
						"divideNum": this.divideNum
					},
				}).then((resp) => {
					let count = resp.data.map.count;
					if (count == 0) {
						this.courseInfoList = [];
						this.commOpen('暂无数据');


					} else {
						this.courseInfoList = resp.data.map.list;

					}
					console.log(this.courseInfoList);

				}).catch(err => {
					console.log(err);
					this.commOpen('请联系管理员');
				})
			},



			studentLogin() {

				this.$refs["login-form"].validate((result) => {
					if (result) {

						axios.post("/student/login", this.loginStudentInfo).then((resp) => {

							this.commOpen(resp.data.message);
							if (resp.data.id == 1) {

								sessionStorage.setItem("token",JSON.stringify(resp.data.map.list));
								this.loginText = "用户:" + resp.data.map.list.studentNick;
								this.registText = "退出";
								this.oneFlag = false;
								this.twoFlag = false;
								this.loginBack();
							} else {
								this.id = -1;
							}
						}).catch(err => {
							console.log(err);
							this.commOpen('请联系管理员');
						})
					}
				})

			},


			studentRegist() {


				this.$refs["regist-form"].validate((result) => {
					if (result) {
						if (this.registStudentInfo.studentPwd != this.registStudentInfo.studentRePwd) {
							this.commOpen("两次密码输入不一致");
							return;
						}
						axios.post("/student/regist", this.registStudentInfo).then((resp) => {
							this.commOpen(resp.data.message);
							if (resp.data.id == 1) {
								this.registBack();
								this.loginFormVisible = true;
							}
						}).catch(err => {
							console.log(err);
							this.commOpen('请联系管理员');
						})
					}
				})


			},

			one() {
				this.registFormVisible = this.oneFlag;
				if (!this.oneFlag) {
					this.$confirm('确认退出？')
						.then((_) => {
							console.log(_);
							axios.get("student/exit").then((resp) => {
								if (resp.data.id == 1) {

									this.loginText = "登录";
									this.registText = "注册";
									sessionStorage.removeItem("token");
									this.oneFlag = true;
									this.twoFlag = true;
									location.reload();
								}
							}).catch((err) => {
								console.log(err);
							})
						}).catch(_ => {
							console.log(_);
						});
				}
			},
			two() {
				this.loginFormVisible = this.twoFlag;
				if (!this.twoFlag) {
					//个人信息页面的跳转
				}
			},
			loginBack() {
				this.loginFormVisible = false;
			},
			registBack() {
				this.registFormVisible = false;
			},

		}
	}
</script>

<style>
	.content-first {
		width: 100%;
		display: flex;
		flex-direction: row;
		wrap-option: nowrap;
		justify-content: space-around;
	}

	.content-first-left {
		font-size: 30px;
		font-weight: bold;
	}

	.content-first-right {
		width: 300px;
		height: 100px;
		display: flex;
		flex-direction: row;
		wrap-option: nowrap;
		line-height: 50px;
	}

	.content-first-right div {
		margin-left: 10%;
		cursor: pointer;
	}


	.content-head {
		margin-left: 2%;
	}

	.content-panel {
		display: flex;
		flex-direction: row;
		justify-content: space-around;
		flex-wrap: wrap;
		/*margin-left: 7%;*/
	}

	.content-panel-flex {
		display: flex;
		flex-direction: column;
		border-radius: 10px;
		border: 1px solid gainsboro;
		width: 20%;
		height: 100%;
		margin-left: 30px;
		margin-right: 30px;
		margin-top: 20px;
	}

	.content-panel-content {
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		flex-wrap: nowrap;
		margin: 10px;
	}

	.content-img img {
		/* width: 100%; */
		border-radius: 10px 10px 0px 0px;
	}

	.content-userName {
		margin-left: 10px;
		font-size: 15px;
		font-weight: bold;
	}


	#myNiceCarousel {
		/*width: 100%;*/
	}


	.input-group {
		margin: 0 auto;
		width: 1000px;
		margin-top: -35px;
	}

	.bottom {
		margin-left: 25%;
	}


	#bottom-pager {
		margin-left: 45%;
	}

	.el-carousel__item h3 {
		color: #475669;
		font-size: 14px;
		opacity: 0.75;
		line-height: 200px;
		margin: 0;
	}

	.el-carousel__item:nth-child(2n) {
		background-color: #99a9bf;
	}

	.el-carousel__item:nth-child(2n+1) {
		background-color: #d3dce6;
	}
</style>
