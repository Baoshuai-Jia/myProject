<template>
  <q-page class="q-pa-md">
    <q-list bordered>

          <q-item
          @click="task.completed = !task.completed"
          v-for="(task,index) in tasks" v-bind:key='index'
          clickable
          v-ripple>
            <q-item-section side top>
              <q-checkbox v-model="task.completed"></q-checkbox>
            </q-item-section>
            <q-item-section>
              <q-item-label>{{task.name}}</q-item-label>
              <q-item-label caption>
                Set the content filtering level to restrict
                apps that can be downloaded
              </q-item-label>
            </q-item-section>
            <q-item-section side top>
              <q-item-label caption>5 min ago</q-item-label>
              <q-icon name="star" color="yellow" />
            </q-item-section>
            <q-item-section side top>
              <q-item-label caption>{{task.dueDate}}</q-item-label>
              <small><q-item-label caption>{{task.dueTime}}</q-item-label></small>
            </q-item-section>
          </q-item>

        </q-list>
  </q-page>
</template>

<script>
  // import Task from '../components/Task.vue'

  export default{
    data() {
      return{
        tasks:[
          {
            id:1,
            name:'Go to shop',
            completed:false,
            dueDate:'2021/05/27',
            dueTime:'16:00'
          },
          {
            id:2,
            name:'Get bananas',
            completed:false,
            dueDate:'2021/05/28',
            dueTime:'16:01'
          },
          {
            id:3,
            name:'Get apples',
            completed:false,
            dueDate:'2021/05/29',
            dueTime:'16:02'
          }
        ]
      }
    }

  }
</script>
<style>

</style>
