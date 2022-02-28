// import Vue from 'vue'
import {createApp} from 'vue'
import App from './App.vue'
import router from './router' //自动扫描里面的路由配置
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'



const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.use(VueAxios, axios)
// app.render()
app.mount('#app')

// createApp(App).mount('#app')
