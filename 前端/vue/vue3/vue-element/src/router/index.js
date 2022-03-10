// import Vue from 'vue'
// import VueRouter from 'vue-router'
// import {createRoute,createWebHashHistory} from 'vue-router'
import {createRouter,createWebHistory} from 'vue-router'

import Login from '../view/Login'
import Main from '../view/Main'
//导入子模块
import UserList from '../view/user/List';
import UserProfile from '../view/user/Profile';
import NotFound from '../view/NotFound';
import MyLogo from '../view/user/mylogo';
import Fixheight from '../view/user/Fixheight';


//安装路由
// Vue.use(VueRouter);

//配置导出路由
export default new createRouter({
    history:createWebHistory(),
    // mode: 'history',
    routes:[
        {
            //路由路径
            path:'/login',
            component:Login
        },
        {
            //路由路径
            path:'/',
            name:'main',
            component:Main,
            children:[
                {
                   path:'/user/profile/:id',
                   name:'userProfile',
                   component:UserProfile,
                   props:true
                },
                {
                    path:'/user/list',
                    component:UserList 
                 },
                 {
                    path:'/user/mylogo',
                    component:MyLogo,
                 },
                 {
                    path:'/user/fixheight',
                    component:Fixheight,
                 },
            ]
        },
        {
            path:'/goHome',
            redirect: '/'
        },
        {
            // path:'*',
            path:'/:catchAll(.*)',
            component: NotFound
        },

]
})