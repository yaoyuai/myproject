<template>
	<div style="height: 100%;">
		<div class="courseDes-header">
			<div style="margin-left: 60%;position: absolute;margin-top: 10%;"><img src="../img/teacher.png" width="500px"/></div>
			<div class="courseName-cls">
				<el-button type="success" icon="el-icon-s-management" circle></el-button><span style="padding-top: 5%;">{{courseName}}</span>
			</div>
			<div class="teacherName-cls">
				<el-button type="primary" icon="el-icon-s-custom" circle></el-button>授课者:{{teacherNick}}
			</div>
			<br />
			<div class="courseDes-cls">课程简介:{{courseDes}}</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				courseSelect: 10,
				evaluationScore: 5,
				courseName: 'JAVA课程',
				teacherNick: '小白',
				courseDes: 'Java课程是java软件工程师学习和应用java的必要课程，java课程主要学习：Java编程语言，Java类文件格式，Java虚拟机和Java应用程序接口(Java API)，java游戏项目开发等课程。Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有良好的通用性、高效性、平台移植性和安全性， 广泛应用于个人PC、 数据中心、 游戏控制台、 科学超级计算机、移动电话和互联网， 同时拥有全球最大的开发者专业社群。 在全球云计算和移动互联网的产业环境下， Java更具备了显著优势和广阔前景。',
			}
		},
		
		
		
		created() {
			
			let item=sessionStorage.getItem("course");
			let obj=JSON.parse(item);
			this.courseName=obj.courseName;
			this.teacherNick=obj.teacherNick;
			this.courseDes=obj.courseDes;
			// this.courseImg=obj.courseImg;
			// this.courseId=obj.courseId;
			// this.courseCtime=obj.courseCtime;
			// this.courseSelect=obj.courseSelect;
			
			
			
		},
		
		
	}
</script>

<style scoped>
	.courseDes-cls {
		/* 		margin: 0 auto; */
		padding-right: 40%;
		padding-left: 5%;
		padding-top: 2%;
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
		padding-top: 2%;
		padding-left: 5%;
		font-size: 30px;
		font-family: "微软雅黑";
	}

	.courseDes-header {

		height: 700px;
		width: 98%;
		border-radius: 10px;
		background-color: white;
	}
</style>
