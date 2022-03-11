<template>
  <!-- 使用示例 -->
  <div>
    <div>
      <span>size：</span>
      <!-- <button @click="size = size - 100; width = width - 100; height = height - 100;">减小</button> -->
      <!-- <button @click="size = size + 100; width = width + 100; height = height + 100;">增大</button>  -->
     <button @click="size = size - 100;">减小</button>
      <button @click="size = size + 100;">增大</button>
    </div>
    <!-- 可尝试一个页面上多个模型： -->
    <live2d
      :size="size"
    ></live2d>
  </div>
</template>

<script>
/*
 * 项目中引用包时，将 import 内容替换
 * import live2d from 'vue-live2d'
 */
import live2d from './live2d.vue'

export default {
  name: 'live2d',
  components: {
    live2d
  },
  data () {
    return {
      width: 500,
      height: 500,
      size: 350,
    }
  }
}
</script>

<style>
body {
  margin: 20px;
  padding: 0;
}
</style>
