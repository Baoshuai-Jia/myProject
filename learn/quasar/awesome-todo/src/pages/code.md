# 第一次还原代码
```
<template>
  <q-page  padding>
    <button style="position: absolute; right: 10px" @click="count ++ ">{{count}}</button>
    <!-- v-model 绑定数据 -->
    <!-- @mouseenter="alertMessage"
      @mouseleave="alertMessage" -->
      <!--       v-autofocus 使用只定义指令 -->
      <!-- 下面代码:绑定class; 并且根据条件显示error的样式 -->
      <!--       v-bind:class="{ 'error': message.length > 22 }"   等于  :style="errorStyle"   后者使用方法,前者使用表达式-->
    <input 
      v-model="message" 
      @keyup="handleKeyup"
      @keyup.enter="alertMessage"
      @keyup.esc="clearMessage"
      v-autofocus
      :style="errorStyle"
      :class="{'error':message.length > 22}"
      ref="messageInput"
      
    />
    <!-- 绑定事件后可以直接写表达式 -->
    <!-- <button @click=" message = '' " >Clear</button> -->
    <!-- 方式二: 事件绑定方法 -->
    <button @click="clearMessage" >Clear</button>

    <div>{{message.length}}</div>

    <!-- v-show 显示还是隐藏 -->
    <!-- v-show="message.length" 等于 v-if="message.length" -->
    <h5 class="border-grey" 
      v-if="message.length"
    >{{message}}</h5>
    <h6 v-else>  No Message entered 😊</h6>

<!-- 计算属性的结果会被缓存，除非依赖的响应式 property 变化才会重新计算 -->
    <p> UpperCase message : {{ messageUppercase }}</p>
    <!-- count 每次加一的时候都会触发这个方法! -->
    <!-- <p> UpperCase message : {{ messageUppercase1() }}</p> -->

    <p>Lowercase message : {{message | messageLowercase }}</p>

  </q-page>
</template>

<script>
export default {
  // 定义一些数据
  data(){
    return{
      message:' I love vue.js so hard ',
      count: 0
    }
  },
  // computed 包含的方法的 计算属性的结果会被缓存，除非依赖的响应式 property 变化才会重新计算
  // 非事件调用的方法(如果<p>标签中调用方法),放到computed中缓存,可以避免页面每次变化的时候该方法都被调用

  // 定义一些缓存的方法,
  computed:{
    messageUppercase(){
      console.log("message uppercase...")
      return this.message.toUpperCase()+this.count
    },
    errorStyle(){
      if(this.message.length > 22){
        return {
          'color':'red',
          'background':'pink'
        }
      }else{
        return ''
      }
    }
  },
  //定义一些方法
  methods:{
    clearMessage(){
      this.message = ''
    },
    alertMessage(){
        alert(this.message)
    },
    handleKeyup(e){
      console.log(e)
      if(e.keyCode == 67){
        this.clearMessage();
      }
      if(e.keyCode == 65){
        this.alertMessage();
      }
    },
    // 
    messageUppercase1(){
      console.log("message1 uppercase...")
      return this.message.toUpperCase()
    }
  },
  //定义一些方法,过滤value
  filters:{
    messageLowercase(value){
      return value.toLowerCase();
    }
  },
  //自定义指令
  directives:{
    autofocus:{
      inserted(el){
        el.focus() 
      }
    }
  },
  //生命周期钩子
  // beforeCreate(){
  //   console.log("beforeCreate")
  // },
  // created(){
  //   console.log("created")
  // },
  // beforeMount(){
  //   console.log("beforeMount")
  // },
  // mounted(){
  //   console.log("mounted")
  // },
  // beforeUpdate(){
  //   console.log("beforeUpdate")
  // },
  // updated(){
  //   console.log("updated")
  // },
  // beforeDestroy(){
  //   console.log("beforeDestroy")
  // },
  //  destroyed(){
  //   console.log("destroyed")
  // },
  //生命周期钩子
  mounted(){
    console.log(this.$refs)
    //使用关联
    // 效果: class="bg-green"
    this.$refs.messageInput.className = 'bg-green'
  }

}
</script>
<style>
.border-grey{
  border: 1px solid grey;
}
input , button {
  font: 23px;
}
.error{
  color: red;
  background: pink;
}
</style>
```

# 代码二: 单文件组件
```
<template>
  <q-page  padding>
    <ul>
      <!-- >{{task.name}}</task> 使用插槽放入组件的 <slot></slot>处 -->
      <!-- 组件的插槽   <div><slot></slot>{{index}}</div> -->
      <task
      v-for="(task,index) in tasks" v-bind:key='index'
      :id="task.id"
      :task="task"
      :index="index"
      >{{task.name}}</task>
    </ul>
  </q-page>
</template>

<script>
  // import Task from '../components/Task.vue'

  export default{
    data(){
      return{
        tasks: [
          {
            id:1,
            name: 'Go to shop',
            dueDate:'2021/05/27',
            dueTime:'10:32'
          },
          {
            id:2,
            name: 'Get bananas',
            dueDate:'2021/05/28',
            dueTime:'10:32'
          },
          {
            id:3,
            name: 'Get apples',
            dueDate:'2021/05/29',
            dueTime:'10:32'
          }
        ]
      }
    },
    components: {
      'task' : require('../components/Task.vue').default
    }
  }
</script>
<style>

</style>

```