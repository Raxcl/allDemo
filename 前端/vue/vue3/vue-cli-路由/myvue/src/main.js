// import Vue from 'vue'
import {createApp} from 'vue'
import App from './App.vue'
import router from './router' //自动扫描里面的路由配置



const app = createApp(App)
app.use(router)
app.mount('#app')


// createApp(App).mount('#app')
