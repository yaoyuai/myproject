<template>

	<div style="height: 100%;">
		<div class="content-first">
			<div class="content-first-left" style="font-family: 微软雅黑;">中小学生课程管理系统</div>
			<div class="content-first-right">
				<div>
					<span style="margin-right: 10px; font-weight: bold;" @click="toFrontMain()">主页</span>
					<span style="margin-right: 10px; font-weight: bold;">我的课程</span>
					<el-button type="text" @click="one()">{{registText}}</el-button>
					<el-button type="text" @click="two()"><i class="el-icon-user-solid"></i>{{loginText}}</el-button>
				</div>

			</div>
		</div>
		<div class="courseDes-header">
			<div style="margin-left: 10%;position: absolute;margin-top: 2%;"><img :src="'http://localhost:9091/'+courseImg" width="500px"
					style="border-radius: 10px;" /></div>
			<div class="courseName-cls">
				<span style="padding-top: 5%;padding-left: 45%;">{{courseName}}</span>
			</div>

			<div class="inner-cls">
				<div style="margin-left: 4%;margin-top: 2%;">第一次开课</div>
				<div style="margin-left: 4%;margin-top: 2%;">开课时间:{{courseCtime}}</div>
				<div style="margin-left: 80%;margin-top: 2%; color: rgb(153,153,153);">已有{{courseSelect}}人参与</div>
			</div>
			<div class="joinButton-cls">
				<el-button type="success" round :style="computedOne" @click="selectCourse()">选课
				</el-button>
				<el-button type="primary" round :style="computerdTwo" @click="goToStudy()">进入学习
				</el-button>
				<el-button type="danger" round :style="computedThree" @click="exitCourse()">退课</el-button>
			</div>



			<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal"
				style="width: 80%;margin-left: 10%;margin-top: 2%;">
				<el-menu-item index="1" style="font-size: 20px;" @click="desOne()">课程详情</el-menu-item>
				<el-menu-item index="2" style="font-size: 20px;" @click="desTwo()">课程评价</el-menu-item>
			</el-menu>

			<div>
				<iframe :src="iframeSrc"
					style="width: 80%;margin-left: 10%; height: 1000px;background-color: white;margin-top: 1%; border: 0px;"
					scrolling="no" id="myIframe" ref="myIframe"></iframe>
			</div>


		</div>
		
		
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
	import axios from 'axios'
	export default {
		
		computed:{
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
			showCode() {
				return this.id == 0 ? 'showCode' : 'showCode?h=' + Math.random();
			},
			computedOne(){
				if(this.selectCourseFlag){
					return "width: 200px;height: 45px;"
				}
				return"width: 200px;height: 45px;display: none;"
				
			},
			computerdTwo(){
				if(this.outCourseFlag){
					return "width: 200px;height: 45px;"
				}
				return"width: 200px;height: 45px;display: none;"
				
			},
			computedThree(){
				if(this.gotoStudy){
					return "width: 200px;height: 45px;"
				}
				return"width: 200px;height: 45px;display: none;"
				
			},
		},

		// mounted() {
		// 	this.iframeWin = this.$refs.myIframe.contentWindow;
		// 	//最开始做的是点击事件是没有问题的  后面需要自动传值就不行  也试了模拟点击还是不行
		// 	//原因是iframe还没加载完  所以使用onload
		// 	let that=this;
		// 	document.getElementById("myIframe").onload = function() {
		// 		that.fatherpost();
		// 	};
		// },
		data() {
			return {
				formLabelWidth:'120px',
				loginFormVisible: false,
				registFormVisible: false,
				registText: "注册",
				loginText: "登录", 
				activeIndex: '1',
				courseSelect: "",
				evaluationScore: 5,
				courseName: "",
				teacherNick: "",
				courseDes: "",
				courseImg:"",
				iframeSrc: '/#/frontdesthree',
				courseId: "",
				courseCtime:"",
				selectCourseFlag:true,
				outCourseFlag:false,
				gotoStudy:false,
				id: 0,
				oneFlag: true,
				twoFlag: true,
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
			}
		},
		// mounted() {
		// 	this.courseName
		// }
		
		created() {
			
			
			let item=sessionStorage.getItem("course");
			let obj=JSON.parse(item);
			this.courseName=obj.courseName;
			this.teacherNick=obj.teacherNick;
			this.courseDes=obj.courseDes;
			this.courseImg=obj.courseImg;
			this.courseId=obj.courseId;
			this.courseCtime=obj.courseCtime;
			this.courseSelect=obj.courseSelect;
			
			
			
			let studentNick=sessionStorage.getItem("token");
			if(studentNick==null){
				this.outCourseFlag=false;
				this.gotoStudy=false;
			}else{
				//去查询一下数据库是否有选课，如果有的话选课直接消失
				let item=sessionStorage.getItem("token");
				let obj=JSON.parse(item);
				this.loginText = "用户:" + obj.studentNick;
				this.registText = "退出";
				this.oneFlag = false;
				this.twoFlag = false;
				axios.post('/cousel/selecthascourse',{"studentId":obj.studentId,"courseId":this.courseId}).then((resp)=>{
					if(resp.data.id==1){
						this.outCourseFlag=true;
						this.gotoStudy=true;
						this.selectCourseFlag=false;
						return;
					}else{
						this.selectCourseFlag=true;
					}
					
				}).catch(err=>{
					console.log(err);
					this.commOpen("请联系管理员");
					
					
				})
			}
		},


		methods: {
			goToStudy(){
				
				
				this.$router.push("/frontcourse");
				
			},
			
			
			
			exitCourse(){
				this.$confirm('确认退课？')
					.then((_) => {
						console.log(_);
						let item=sessionStorage.getItem("token");
						let obj=JSON.parse(item);
						let item2=sessionStorage.getItem("course");
						let obj2=JSON.parse(item2);
						axios.post("couout/addcouout",{"studentId":obj.studentId,"courseId":obj2.courseId}).then((resp)=>{
							
							this.commOpen(resp.data.message);
							if(resp.data.id==1){
								window.location.reload();
							}	
						}).catch(err=>{
							console.log(err);
							this.commOpen("请联系管理员");
						})			
					}).catch(_ => {
						console.log(_);
					});
			
				
				
			},
			selectCourse(){
				let item=sessionStorage.getItem("token");
				if(item==null){
					this.commOpen("请先登录");
					return;
				}
				let obj=JSON.parse(item);
				let item2=sessionStorage.getItem("course");
				let obj2=JSON.parse(item2);
				axios.post("/cousel/addcousel",{"studentId":obj.studentId,"courseId":obj2.courseId}).then((resp)=>{
					
					this.commOpen(resp.data.message);
					if(resp.data.id==1){
						window.location.reload();
					}	
				}).catch(err=>{
					console.log(err);
					this.commOpen("请联系管理员");
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
								let item=sessionStorage.getItem("token");
								let obj=JSON.parse(item);
								//登录成功后去查询一下有没有选课
								axios.post('/cousel/selecthascourse',{"studentId":obj.studentId,"courseId":this.courseId}).then((resp)=>{
									if(resp.data.id==1){
										this.outCourseFlag=true;
										this.gotoStudy=true;
										this.selectCourseFlag=false;
										return;
									}
									this.selectCourseFlag=true;
								}).catch(err=>{
									console.log(err);
									this.commOpen("请联系管理员");
									
									
								})
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
			desOne() {
				this.iframeSrc = "/#/frontdesthree"

			},
			desTwo() {

				this.iframeSrc = "/#/frontdestwo"
			},
			
			commOpen(content) {
				this.$alert(content, '提示', {
					confirmButtonText: '确定',
				});
			},
		}

	}
</script>

<style>
	.joinButton-cls {

		margin-top: 12%;
		margin-left: 46%;
	}

	.inner-cls {
		margin-top: 1%;
		position: absolute;
		background-color: rgb(248, 249, 251);
		width: 700px;
		height: 130px;
		margin-left: 45%;
		border-radius: 10px;
	}

	.courseDes-cls {
		/* 		margin: 0 auto; */
		padding-right: 40%;
		padding-left: 5%;
		padding-top: 1%;
		font-size: 23px;
		font-family: "仿宋";
	}

	.teacherName-cls {
		padding-top: 2%;
		padding-left: 5%;
		font-size: 20px;
		font-family: "微软雅黑";
	}

	.courseName-cls {

		font-weight: bold;
		padding-top: 2%;
		padding-left: 5%;
		font-size: 25px;
		font-family: "微软雅黑";
	}

	.courseDes-header {

		height: 100%;
		width: 98%;
		border-radius: 10px;
		background-color: white;
	}
</style>
