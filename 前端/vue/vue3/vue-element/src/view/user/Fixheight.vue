<template>
  <h1>我是高度变化</h1>
  <div>
      高度变化
        <div class="hezi"
            :style="{ width: 30 + 'px', height: live2dHeight + 'px'}"
        >
        </div>
        <button @click="jia">高度加</button>
        <button @click="jian">高度减</button>
  </div>
  <!-- {{id}} -->
</template>
<script>
export default {
//   props:['id'],
  name: "Fixheight",
  data(){
      return {
        myHeight: 30,
      }
  },
  computed:{
      live2dHeight(){
        return this.myHeight ?  this.myHeight : 300
      }
  },
  methods:{
      jia(){
          this.myHeight = this.myHeight + 10
      },
      jian(){
          this.myHeight = this.myHeight - 10
      }
  }
};
</script>
<style scoped>
.hezi{
    background-color: red;
    /* margin-left: 300px; */
    /* margin-top: 30px; */
    /* float: left; */
}
</style>
