<template>
	<div>

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
		<div style="margin-top: -2%;"><img :src="courseImg"  width="275px" height="120px"></div>

		<iframe style="position: absolute; margin-left: 18%; margin-top: -8%;border: 0px;" scrolling="no" width="82%" height="1100px" :src="iframeSrc"></iframe>

		<el-menu default-active="1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
			@select="selectMenu" style="width: 18%;">
			<el-menu-item index="1">
				<i class="el-icon-menu"></i>
				<span slot="title">课程详情</span>
			</el-menu-item>
			<el-menu-item index="2">
				<i class="el-icon-video-camera"></i>
				<span slot="title">课程视频</span>
			</el-menu-item>
			<el-menu-item index="3">
				<i class="el-icon-document"></i>
				<span slot="title">课程资料</span>
			</el-menu-item>
			<el-menu-item index="4">
				<i class="el-icon-edit-outline"></i>
				<span slot="title">课程训练</span>
			</el-menu-item>
			<el-menu-item index="5">
				<i class="el-icon-edit"></i>
				<span slot="title">课程考试</span>
			</el-menu-item>
			<el-menu-item index="6">
				<i class="el-icon-chat-line-round"></i>
				<span slot="title">课程评价</span>
			</el-menu-item>
			<el-menu-item index="7">
				<i class="el-icon-chat-dot-square"></i>
				<span slot="title">课程评论</span>
			</el-menu-item>
		</el-menu>
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
		},
		data() {
			return {
				
				formLabelWidth:'120px',
				loginFormVisible: false,
				registFormVisible: false,
				registText: "注册",
				loginText: "登录", 
				
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
				
				iframeSrc: '/#/frontdes',
				courseImg:'',
			}
		},
		
		
		created() {
			
			let item=sessionStorage.getItem("course");
			let obj=JSON.parse(item);
			this.courseName=obj.courseName;
			this.teacherNick=obj.teacherNick;
			this.courseDes=obj.courseDes;
			this.courseImg="http://localhost:9091/"+obj.courseImg;
			// this.courseId=obj.courseId;
			// this.courseCtime=obj.courseCtime;
			// this.courseSelect=obj.courseSelect;
			
			
			let item2=sessionStorage.getItem("token");
			if(item2!=null){
				let obj2=JSON.parse(item2);
				
				this.loginText = "用户:" + obj2.studentNick;
				this.registText = "退出";
				this.oneFlag = false;
				this.twoFlag = false;
				
			}
			
			
		},
		
		methods:{
			selectMenu(index, indexPath) {
				if (indexPath[0] == '1') {
					this.iframeSrc = "/#/frontdes"
				} else if (indexPath[0] == "2") {
					this.iframeSrc = "/#/frontvideo"
				} else if (indexPath[0] == "3") {
					this.iframeSrc = "/#/frontfile"
			
				} else if (indexPath[0] == "4") {
					this.iframeSrc = "/#/fronttrain"
			
				} else if (indexPath[0] == "5") {
					this.iframeSrc = "/#/frontexam"
			
				} else if (indexPath[0] == "6") {
					this.iframeSrc = "/#/frontevaluation"
			
				} else if (indexPath[0] == "7") {
					this.iframeSrc = "/#/frontcomment"
				}
			
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
			
		},
		
		
		
	}
</script>

<style>
	html,
	body {
		width: 100%;
		height: 100%;
		background-color: rgb(243, 243, 243);
	}
</style>
