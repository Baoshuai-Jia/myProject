<template>
  <li>{{task | taskFilter}}
  <div><slot></slot>{{index}}</div>
    <div>{{task.dueDate}}@{{task.dueTime}}</div>
    <button @click="deleteTask(index)">delete</button>
  </li>
</template>

<script>
  export default{
    props:['task','index'],
    filters:{
      taskFilter(value){
        if(value.name == 'Get apples'){
          return value;
        }
        return value.name +':'+value.dueDate;
      }
    },
    methods:{
      deleteTask(index){
        this.tasks.splice(index,1);
      }
    },
  }
</script>

<style>
</style>
