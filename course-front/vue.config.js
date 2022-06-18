const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{
	  proxy:"http://localhost:9091"//把所有的请求都代理到这个域上
  }
})
