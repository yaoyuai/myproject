<template>



	<div class="out-frame">
		<div class="out-panel">
			<div class="out-panel-head">
				<div class="out-panel-head-font">中小学生课程后台管理</div>
				<!--					<div class="out-panel-head-service">服务热线</div>-->
				<div class="out-panel-head-img" id="img"><img src="./img/yiyuan1.png" /> </div>
				<div class="out-panel-head-welcome" id="adminName">欢迎zhangsan</div>
				<div class="out-panel-head-close" id="logout">注销</div>
				<!--					<div class="out-panel-head-welcome" ><button style="background-color: indianred;color: white;border: 0px;border-radius: 10px;height: 30px;cursor: pointer;" id="updatePwd">修改密码</button></div>-->
			</div>


			<div class="out-panel-left" id="leftPanel">
				<!--						<div class="first-item">-->
				<!--							<div class="first-title">卡片管理</div>-->
				<!--							<div id="user" class="second-item" value="">卡入库</div>-->
				<!--							<div id="ticket" class="second-item">卡注销</div>-->
				<!--							<div id="order" class="second-item">卡查询</div>-->
				<!--							<div id="orderLog" class="second-item">领卡审批</div>-->
				<!--						</div>-->
				<!--						<div class="first-item">-->
				<!--							<div class="first-title">系统管理</div>-->
				<!--							<div id="admin" class="second-item">人员管理</div>-->
				<!--							<div id="power" class="second-item">权限管理</div>-->
				<!--							<div id="role" class="second-item">菜单管理</div>-->
				<!--							<div id="menu" class="second-item">医生排班</div>-->
				<!--							<div id="log" class="second-item">日志查看</div>-->
				<!--						</div>-->
				<!-- 					<div id="user">用户管理</div>
	                                            <div id="text">日志管理</div>
	                                            <div id="front">前台管理</div> -->
				<div class="iframe-cls"><iframe src="welcome.html" id="iframeTest" scrolling="no"></iframe></div>
			</div>


			<!--				<div class="out-panel-content"></div>-->
		</div>
	</div>



</template>

<script>
	import $ from 'jquery'
	export default {
		
		
		data(){
			
			return:{
				
				tree:[],
				
				
			}
		}


		methods: {


			menuClick() {
				$("#leftPanel").click(function() {
						if (e.target.className == "second-item") {
							$("#iframeTest").src = e.target.getAttribute("url");
							return;
						}

						var arr = document.getElementsByClassName("second-item");
						for (var item of arr) {
							$(item).hide(400);
						}
						var showList = e.target.parentElement.children;
						for (var item of showList) {
							$(item).show(400);
						}
					}
				})

			$("#logout").click(function() {

				var msg = "您确认注销吗";
				if (confirm(msg) == true) {
					logOutAdmin();
				}
			})
		},




		showNode(tree) {
			let str = "";
			for (let item of tree) {
				str += `<div class="first-item">`;
				str += `<div class="first-title">${item.menuName}</div>`;
				if (item.childArr.length > 0) {
					for (var item of item.childArr) {
						str += `<div class="second-item" url="${item.menuUrl}">${item.menuName}</div>`;
					}
				}
				str += `</div>`
			}
			str += `<div class="iframe-cls"><iframe src="welcome.html"  id="iframeTest" scrolling="no"></iframe></div>`;
			document.getElementById("leftPanel").innerHTML = str;
			this.menuClick(); //绑定一下点击事件
		}


	}


	}
</script>

<style scoped="scoped">
	html,
	body {
		width: 100%;
		height: 100%;
		padding: 0px;
		margin: 0px;
		/*background-color: rgb(230,230,250);*/
		overflow: hidden;
		overflow-x: hidden;
	}

	.out-frame {
		width: 100%;
		/* 	height: 100px; */
	}

	.out-frame .out-panel .out-panel-head {
		/*position: absolute;*/
		height: 20%;
		width: 100%;
		background-color: rgb(255, 255, 255);
		color: black;
		border-bottom: 7px solid rgb(106, 189, 129);
		font-family: "微软雅黑";

		display: flex;
		flex-direction: row;
		flex-wrap: nowrap;
		justify-content: space-around;
		align-items: center;
		/*background-color: white;*/
		/*border-radius: 0px 0px 5px 5px;*/

	}

	.out-frame .out-panel .out-panel-head .out-panel-head-font {
		/*position: absolute;*/
		top: 25px;
		left: 25px;
		font-size: 28px;

		font-weight: bold;
	}

	.out-frame .out-panel .out-panel-head .out-panel-head-img img {
		width: 100px;
		height: 100px;
		margin-left: 11%;
	}

	/*.out-frame .out-panel .out-panel-head .out-panel-head-service{*/
	/*	position: absolute;*/
	/*	top:35px;*/
	/*	left: 900px;*/
	/*}*/

	/*.out-frame .out-panel .out-panel-head .out-panel-head-welcome{*/
	/*	!*position: absolute;*!*/
	/*	top:35px;*/
	/*	left: 1000px;*/
	/*	*/
	/*}*/

	.out-frame .out-panel .out-panel-head .out-panel-head-close {
		/*position: absolute;*/
		border-bottom: 1px solid cornflowerblue;
		color: cornflowerblue;
		cursor: pointer;
		font-weight: bold;
	}

	/*.out-frame .out-panel .out-div{*/
	/*	!*display: flex;*!*/
	/*	!*flex-direction: row;*!*/
	/*	!*flex-wrap: nowrap;*!*/
	/*	!*justify-content: space-between;*!*/
	/*	!*align-items: center;*!*/

	/*	!*width: 1000px;*!*/

	/*}*/


	.out-frame .out-panel .out-panel-left {
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
		/*top: -5px;*/
		/*justify-content: space-between;*/
		/*align-items: center;*/

		background-color: rgb(242, 242, 242);
		height: 100%;
		width: 13%;

		cursor: pointer;
		/*display: inline;*/
	}




	.iframe-cls {
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
		/*top: -5px;*/
		justify-content: space-between;
		align-items: center;


		position: absolute;
		margin-left: 13%;
		width: 100%;
		height: 100%;
		/*border: 1px solid red;*/
	}

	#iframeTest {
		margin: 0 auto;
		/*margin-left: -100px;*/
		width: 100%;
		height: 100%;
		border: 0px;
	}

	.out-frame .out-panel .out-panel-left div {
		/*	width: 100%;*/
		/*	height: 50px;*/
		/*!* 	background-color: greenyellow; *!*/
		/*	line-height: 50px;*/
		/*	text-align: center;*/
		/*	font-size: 15px;*/
		/*	color: white;*/
		/*	cursor: pointer;*/
	}

	/*.out-frame .out-panel .out-panel-left div:nth-child(1){*/
	/*	!*background-color: rgb(65,65,65);*!*/
	/*	border-bottom: 1px solid white;*/
	/*}*/
	/*.out-frame .out-panel .out-panel-left div:nth-child(6){*/
	/*	background-color: rgb(65,65,65);*/
	/*}*/
	/* .out-frame .out-panel .out-panel-left div:nth-child(3){
		color: rgb(0,139,139);
	}
	 */
	#out {}

	.frame {
		position: absolute;
		width: 100%;
		top: 130px;
		left: 120px;
		/* 	background-repeat: no-repeat;
		background-position: 0% 0%; */
		/* 	 background-size:100% 100%; */
	}


	.panel {

		width: 1200px;
		height: 650px;
		margin: 0 auto;
		border: 2px solid gray;
	}

	.frame .panel .top {
		margin: 0 auto;
		width: 60%;
	}

	.frame .panel .top .selectcls {
		padding: 3px;
	}

	.frame .panel .top font {
		color: #808080;
	}

	.frame .panel .top input[type="text"] {
		width: 150px;
	}

	.frame .panel .top select {
		width: 100px;
	}

	.frame .panel .top button {
		width: 70px;
		height: 30px;
	}

	.frame .panel .tablecontent {
		margin: 0 auto;
		width: 60%;
		height: 200px;
		/* 	border: 3px solid rgb(0,139,139); */
	}

	.frame .panel .tablecontent th {
		background-color: seagreen;
	}

	.frame .panel .tablecontent td {
		text-align: center;
		/* 	border: 1px solid rgb(0,139,139); */
	}

	.frame .panel .tablecontent tr:first-child {
		color: rgb(0, 139, 139);
	}

	.frame .panel .tablecontent td button {
		margin-left: 10px;
		width: 80px;
		height: 30px;
	}

	.frame .panel .tablecontent .sptr {
		background-color: rgb(0, 139, 139);
		color: white;
	}

	.update-frame {
		height: 20%;
		width: 20%;
		position: absolute;
		top: 20%;
		left: 50%;
		background-color: white;
		border: 1px solid black;
	}

	.update-frame .update-panel .updatetable {
		position: absolute;
		top: 80px;
		left: 70px;
		color: #808080;
	}

	.update-frame .update-panel .update-user-frame {
		width: 100%;
		height: 50px;
		/*background-color: ;*/
		text-align: center;
		line-height: 70px;
		background-color: rgb(0, 139, 139);
		color: white;
	}

	.update-frame .update-panel .updatetable input {
		margin: 10px;
		width: 200px;
		height: 20px;
		border: 1px solid darkgray;
	}

	.update-frame .update-panel .updatetable select {
		margin: 10px;
		width: 100px;
		height: 25px;
		border: 1px solid darkgray;
	}

	.update-frame .update-panel .updatebutton {
		position: absolute;
		width: 70px;
		height: 30px;
		top: 300px;
		left: 150px;
	}

	.update-frame .update-panel .cancelbutton {
		position: absolute;
		width: 70px;
		height: 30px;
		top: 300px;
		left: 240px;
	}


	#outNewDiv {
		position: absolute;
		width: 230px;
		height: 70px;
		margin-left: 260px;
		margin-top: -70px;
		background-color: rgb(242, 242, 242);

		text-align: center;
		line-height: 70px;
	}




	.out-frame .out-panel .out-panel-left .first-item {
		/*width: 100%;*/
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
		justify-content: center;
		align-items: center;
	}


	.out-frame .out-panel .out-panel-left .first-item .first-title {
		width: 100%;
		height: 45px;
		line-height: 45px;
		text-align: center;
		color: black;
		background-color: rgb(106, 189, 129);
		font-family: "幼圆";
		font-weight: bold;
	}


	.out-frame .out-panel .out-panel-left .first-item .second-item {
		text-align: center;
		width: 100%;
		height: 45px;
		color: black;
		line-height: 45px;
		display: none;
		font-family: "幼圆";
		font-weight: bold;
	}


	.out-frame .out-panel .out-panel-left .first-item .second-item {
		text-align: center;
		height: 45px;
		color: black;
		line-height: 45px;
		display: none;
		font-family: "幼圆";
		font-weight: bold;
	}







	.edit-frame {
		width: 100%;
		height: 100%;
		display: none;
		position: absolute;
		top: 0px;
		left: 0px;
		right: 0px;
		bottom: 0px;


		/* 	弹性布局 */
		display: flex;
		flex-direction: row;
		flex-wrap: nowrap;
		justify-content: center;
		align-items: center;

		display: none;
		background-color: rgba(169, 169, 169, 0.5);
	}

	.edit-frame .edit-panel {
		width: 28%;
		height: 45%;
		margin: 0 auto;
	}

	.edit-frame .edit-panel .search-item {

		/*margin-top: -50px;*/
		width: 100%;
		height: 100%;
		border: 1px solid black;
		border-radius: 8px;

		/* 	弹性布局 */
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
		justify-content: center;
		align-items: center;

		background-color: white;
		font-size: 18px;
	}

	.edit-frame .edit-panel .search-item .search-carefully {
		margin: 10px;
	}

	.edit-frame .edit-panel .search-item .search-carefully input {

		width: 150px;
		height: 30px;

	}

	.edit-frame .edit-panel .search-item .search-carefully select {

		width: 158px;
		height: 36px;
	}

	.edit-frame .edit-panel .search-item .search-carefully #resetPwd {
		width: 100px;
		height: 40px;
		background-color: lightcoral;
		color: white;
		border-radius: 8px;
		border: 0px;
	}

	/*
	.edit-frame .edit-panel .search-item .search-carefully .search-rolename{
	
		width: 158px;
		height: 36px;
	} */

	.edit-frame .edit-panel .search-item .search-button {
		text-align: center;
		width: 250px;
		height: 10px;


	}

	.edit-frame .edit-panel .search-item .search-button #saveUpdateButton {
		width: 60px;
		height: 35px;
		background-color: rgb(5, 186, 251);
		border: 0px;
		border-radius: 5px;
		color: white;
		cursor: pointer;
	}

	.edit-frame .edit-panel .search-item .search-button #cancelUpdateButton {
		width: 60px;
		height: 35px;
		background-color: rgb(5, 186, 251);
		border: 0px;
		border-radius: 5px;
		color: white;
		cursor: pointer;
	}








	/*.out-frame .out-panel .out-panel-left .second-item{*/
	/*	!*top: 100px;*!*/
	/*	!*position: static;*!*/
	/*	width: 100%;*/
	/*	display: flex;*/
	/*	flex-direction: column;*/
	/*	flex-wrap: nowrap;*/
	/*	justify-content: center;*/
	/*	align-items: center;*/
	/*}*/
	/*.front{*/
	/*	display: none;*/

	/*}*/

	/*.out{*/
	/*	display: none;*/
	/*}*/


	/*#front{*/
	/*	background-color: rgb(65,65,65);*/
	/*}*/


	/*#out{*/
	/*	background-color: rgb(65,65,65);*/
	/*}*/
</style>
