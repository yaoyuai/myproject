<template>
	<div class="firstOne">

		<div class="login-frame">
			<div class="login-panel">
				<div class="right-input">
					<div class="user-login-username">
						<div class="title">后台用户登录</div>

						<el-form :model="userInfo" :rules="rules" ref="login-form" label-width="70px"
							class="demo-ruleForm">
							<el-form-item label="用户名" prop="userName">
								<el-input v-model="userInfo.userName"></el-input>
							</el-form-item>
							<el-form-item label="密码" prop="userPwd">
								<el-input v-model="userInfo.userPwd" type='password'></el-input>
							</el-form-item>
							<el-form-item label="角色" prop="roleId">
								<el-radio v-model="userInfo.roleId" label="1">管理员</el-radio>
								<el-radio v-model="userInfo.roleId" label="2">教师</el-radio>
								<el-radio v-model="userInfo.roleId" label="3">家长</el-radio>
							</el-form-item>

							<el-form-item label="验证码" prop="code">
								<el-input v-model="userInfo.code"></el-input>
							</el-form-item>
							<img :src='showCode' style="margin-left: 60px; width: 400px; height: 50px;">
							<el-button type="success" @click="judgeLogin()" id="imgCode">立即登录</el-button>

						</el-form>


						<div class="problem" @click="judgeRegist()">
								没有账号？去注册
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				userInfo: {
					userName: '',
					userPwd: '',
					code: '',
					roleId: '1',
				},
				id:0,
				formLabelWidth: '90px',
			}

		},

		computed: {
			
			
			showCode() {
				return this.id == 0 ? 'showCode' : 'showCode?h=' + Math.random();
			},
			rules() {
				return {
					userName: [{
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
					userPwd: [{
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
					roleId: [{
						required: true,
						message: '角色必选',
						trigger: 'blur'
					}]

				}
			}
		},
		methods:{
			
			
			judgeRegist(){
				if(this.userInfo.roleId==1){
					this.commOpen("您的角色是管理员，请输入账号密码登录");
					return;
				}
				this.$router.push("/regist");
				
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
			
			judgeLogin(){
				let sendPost="";
				if(this.userInfo.roleId=="1"){
					sendPost="admin/login";
				}else if(this.userInfo.roleId=="2"){
					sendPost="teacher/login"
				}else if(this.userInfo.roleId=="3"){
					sendPost="parent/login"
				}
				this.$refs["login-form"].validate((result) => {
					if(result){
						axios.post(sendPost,this.userInfo).then((resp)=>{
							this.commOpen(resp.data.message);
							if(resp.data.id==1){
								this.$router.push("/outmain");
							}else{
								this.id=-1;
							}
						}).catch(err=>{
							console.log(err);
						})
					}
				})
			}
		},	
	}
</script>

<style scoped="scoped">
	html,
	body {
		padding: 0px;
		margin: 0px;
	}


	.firstOne {
		width: 100%;
		height: 800px;
		/* 		padding: 0px;
		margin: 0px; */
		background-color: rgb(242, 242, 242);
		background-repeat: no-repeat;
		background-position: 0% 0%;
		background-size: cover;
	}


	.login-frame {

		/* 		margin-top: 100px; */
		width: 100%;
		height: 100%;

		/* 	弹性布局 */
		display: flex;
		flex-direction: row;
		flex-wrap: nowrap;
		justify-content: center;
		align-items: center;

	}

	.login-frame .login-panel {

		background-color: white;
		width: 550px;
		height: 450px;
		margin: 0 auto;
		border-radius: 10px;



		/* 	弹性布局 */
		display: flex;
		flex-direction: row;
		flex-wrap: nowrap;
		justify-content: center;
		align-items: center;
	}


	.login-frame .login-panel .right-input .user-login-username {
		/*height: 500px;*/
		/*width: 1000px;*/
		/*margin: 0px;*/
		/*padding: 0px;*/
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
		justify-content: center;
		/*align-items: center;*/
	}

	.login-frame .login-panel .right-input .user-login-username .title {
		color: orange;
		font-weight: bold;
		font-size: 18px;
	}


	/*.login-frame .login-panel .user-login-label{*/
	/*	color: white;*/
	/*	font-size: 20px;*/
	/*	margin-bottom: 15px;*/
	/*	width: 100px;*/
	/*	height: 200px;*/
	/*	!*margin: 0px auto;*!*/
	/*    !*text-align: center;*!*/

	/*	display: flex;*/
	/*	flex-direction: row;*/
	/*	flex-wrap: nowrap;*/
	/*	justify-content: center;*/
	/*	align-items: center;*/
	/*} */
	.login-frame .login-panel .right-input input {
		/* 	margin: -8px; */
		/* 	padding: -5px; */
		/*margin-top: 20px;*/
		/*background-color: rgb(246,250,251);*/
		/*border: 1px solid white;*/
		/*border-bottom: 1px solid gainsboro;*/
		/*width: 400px;*/
		/*height: 40px;*/
		width: 400px;

		/*display: flex;*/
		/*flex-direction: column;*/
		/*flex-wrap: nowrap;*/
		/*justify-content: center;*/
		/*align-items: center;*/

	}

	.last-input {
		width: 400px;

		display: flex;
		flex-direction: row;
		flex-wrap: nowrap;
		justify-content: center;
		align-items: center;
	}

	#code {
		width: 300px;
	}

	.login-frame .login-panel .right-input input:nth-child(3) {
		width: 100px;
	}

	.login-frame .login-panel .right-input input :nth-child(2) {
		width: 100px;
	}

	.login-frame .login-panel .right-input .user-login-username input {
		border-radius: 5px 5px 5px 5px;
		/* 	background-color: rgb(250,255,189); */

		/* 	border-color: white; */

	}

	.login-frame .login-panel .right-input .user-login-password input {
		/* 	background-color: rgb(250,255,189); */
	}


	.login-frame .login-panel .right-input .user-login-code input {
		/* 	border-radius: 0px 0px 5px 5px; */
	}

	.login-frame .login-panel .right-input .user-login-abc {
		width: 236px;
		margin: 0 auto;

		display: flex;
		flex-direction: row;
		flex-wrap: nowrap;
		justify-content: space-between;
		align-items: center;
		background-color: white;
		border-radius: 0px 0px 5px 5px;
		/* 	border: 1px solid white; */


	}

	.user-login-username .special-cls {
		width: 200px;
		height: 30px;
	}

	.login-frame .login-panel .right-input .user-login-abc {

		height: 40px;
	}

	.login-frame .login-panel .right-input .user-login-abc .user-login-abc-img {
		width: 236px;
		height: 40px;
		border-radius: 0px 0px 5px 5px;
	}

	.login-frame .login-panel .right-input .user-login-abc .user-login-abc-a {

		color: lightcoral;


	}

	.login-frame .login-panel .right-input .user-login-abc .user-login-abc-c {

		color: lightgreen;
	}

	.login-frame .login-panel .right-input button {
		/* 		background-color: rgb(241, 163, 31); */
		color: white;
		border: 0px;
		width: 100%;
		height: 40px;
		margin-top: 10px;
		border-radius: 5px;
	}

	/* 
		.login-frame .login-panel .right-input .user-login-username #imgCode {
	
			width: 100px;
			height: 30px;
			/*line-height: 40px;*/

	.input-group {
		margin-top: 20px;
	}

	.problem {
		text-align: center;
		color: #0a67fb;
		cursor: pointer;
	}

	#backButton {
		margin: 0 auto;
		width: 250px;
		color: black;
		background-color: rgb(242, 242, 242);
	}

	.user-login-label {

		/*position: absolute;
	
			/*margin-left: 10px;*/
		text-align: center;
		font-family: "幼圆";
		margin-top: -93px;
	}

	.user-login-label font {
		font-weight: bold;
		font-family: "幼圆";
		font-size: 30px;
	}

	.head-img {
		text-align: center;
		margin-left: -900px;
		height: 100px;
		margin-top: 100px;
	}


	.head-img img {
		width: 100px;
		height: 70px;
		margin-left: 560px;
	}

	.left-img img {
		/*position: absolute;*/
		/*margin-top: 330px;*/
		margin-left: -50px;
		width: 120px;
		height: 200px;
	}
</style>
