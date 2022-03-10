<template>
  <h1>个人信息</h1>
  <Fixheight/>
  {{id}}
</template>
<script>
import Fixheight from './Fixheight';
export default {
  props:['id'],
  name: "UserProfile",
  components:{
    Fixheight
  },
  beforeRouteEnter:(to, from, next) =>{
    console.log("准备进入个人信息页面");
    next(vm=>{
      //进入路由之前执行getData方法
      vm.getData()
    });
  },
  beforeRouteLeave:(to, from, next) =>{
    console.log("准备离开个人信息页面");
    next();
  },
  methods:{
    getData:function(){
      this.axios({
        method:'get',
        url:'/data.json'
      }).then(function(response){
        console.log(response)
      })
    }
  }
};
</script>
<style scoped></style>
