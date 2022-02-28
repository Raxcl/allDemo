// import Vue from 'vue'
// import VueRouter from 'vue-router'
// import {createRoute,createWebHashHistory} from 'vue-router'
import {createRouter,createWebHashHistory} from 'vue-router'

import ContentTest from '../components/Content'
import MainTest from '../components/Main'


//安装路由
// Vue.use(VueRouter);

//配置导出路由
export default new createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            //路由路径
            path:'/content',
            name:'content',
            component:ContentTest
        },
        {
            //路由路径
            path:'/main',
            name:'main',
            component:MainTest
        },

]
})