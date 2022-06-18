import Vue from 'vue'
import VueRouter from 'vue-router'
import FrontMain from '../pages/FrontMain.vue'
import FrontShou from '../pages/FrontShou.vue'
import OutLogin from '../pages/OutLogin.vue'
import FrontCourse from '../pages/FrontCourse.vue'
import FrontComment from '../pages/FrontComment.vue'
import FrontDes from '../pages/FrontDes.vue'
import FrontEvaluation from '../pages/FrontEvaluation.vue'
import FrontExam from '../pages/FrontExam.vue'
import FrontFile from '../pages/FrontFile.vue'
import FrontTrain from '../pages/FrontTrain.vue'
import FrontVideo from '../pages/FrontVideo.vue'
import FrontDesone from '../pages/FrontDesone.vue'
import FrontDestwo from '../pages/FrontDestwo.vue'
import FrontDesthree from '../pages/FrontDesthree.vue'
import ExamDes from '../pages/ExamDes.vue'
import TrainDes from '../pages/TrainDes.vue'



Vue.use(VueRouter)
const routes = [
	{
		path: '/examdes',
		name: 'examdes',
		component: ExamDes,
	},
	{
		path: '/traindes',
		name: 'traindes',
		component: TrainDes,
	},
	{
		path: '/frontdesthree',
		name: 'frontdesthree',
		component: FrontDesthree,
	},
	{
		path: '/frontdestwo',
		name: 'frontdestwo',
		component: FrontDestwo,
	},
	
	{
		path: '/frontdesone',
		name: 'frontdesone',
		component: FrontDesone,
	},
	
	{
		path: '/frontvideo',
		name: 'frontvideo',
		component: FrontVideo,
	},
	{
		path: '/fronttrain',
		name: 'fronttrain',
		component: FrontTrain,
	},
	{
		path: '/frontfile',
		name: 'frontfile',
		component: FrontFile,
	},
	{
		path: '/frontexam',
		name: 'frontexam',
		component: FrontExam,
	},
	{
		path: '/frontcomment',
		name: 'frontcomment',
		component: FrontComment,
	},
	{
		path: '/frontdes',
		name: 'frontdes',
		component: FrontDes,
	},
	{
		path: '/frontevaluation',
		name: 'frontevaluation',
		component: FrontEvaluation,
	},
	
	
{
	path: '/frontcourse',
	name: 'frontcourse',
	component: FrontCourse
},
{
	path: '/main',
	name: 'main',
	component: FrontMain
}, 
{
	path: '/shou',
	name: 'shou',
	component: FrontShou
},
{
	path: '/outlogin',
	name: 'outlogin',
	component: OutLogin
},
{
	path: '/outmain',
	name: 'outmain ',
	component: OutLogin
},]


const router = new VueRouter({
	routes
})


export default router
