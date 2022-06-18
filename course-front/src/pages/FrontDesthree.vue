<template>

	<div style="height: 1000px; width: 100%; background-color: white;">

		<div
			style="background-color: rgb(245,248,244); height: 100px; width: 90%; margin-left: 5%; border-radius: 10px;">
			<div style="padding-top: 2%;">
				“勤能补拙是良训，一分辛苦一分才。”勤奋是一种美好的品德，
				勤奋是一种努力自强的精神，勤奋是一种勇往直前的精神。一勤天下无难事，勤奋，更是变理想为现实的行动，是由量变到质的过程，是走向成功的阶梯，是成为天才必不可少的条件。
			</div>

			<div>
				<h2 style="margin-top:5%;"><i class="el-icon-reading"></i>课程概述</h2>
				<div style="color: gray;">{{courseDes}}</div>

			</div>




		</div>
	</div>



</template>

<script>
	export default {
		data() {
			return {
				activeIndex: '1',
				courseDes: "",
				courseId: "",
			}
		},
		created() {
			let item=sessionStorage.getItem("course");
			let obj=JSON.parse(item);
			this.courseDes=obj.courseDes;
		}
	}
</script>

<style>
</style>
