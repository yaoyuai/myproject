<template>
	<div class="content-first">
		<div class="content-first-left">中小学生课程管理系统</div>
		<div class="content-first-right">
			<div><router-link to="/">我的课程</router-link></div>
			<div>注册</div>
			<div>登录</div>
		</div>
	</div>
</template>

<script>
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
</style>
