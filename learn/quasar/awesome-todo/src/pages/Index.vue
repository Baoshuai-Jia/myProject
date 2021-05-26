<template>
  <q-page  padding>
    <!-- v-model 绑定数据 -->
    <input v-model="message" @keyup="handleKeyup"/>
    <!-- 绑定事件后可以直接写表达式 -->
    <!-- <button @click=" message = '' " >Clear</button> -->
    <!-- 方式二: 事件绑定方法 -->
    <button @click="clearMessage" >Clear</button>
    <h5>{{message}}</h5>
  </q-page>
</template>

<script>
export default {
  data(){
    return{
      message:' I love vue.js so hard '
    }
  },
  methods:{
    clearMessage(){
      this.message = ''
    },
    handleKeyup(e){
      console.log(e)
    }
  }
}
</script>
<style>

</style>
