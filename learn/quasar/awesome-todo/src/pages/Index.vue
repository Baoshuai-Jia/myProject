<template>

    <q-list separator bordered>
      <q-item
        v-for="(task,index) in tasks"
        v-bind:key='index'
        @click="task.completed = !task.completed"
        :class="!task.completed ? 'bg-orange-1' : 'bg-green-1'"
        clickable
        v-ripple>
          <q-item-section side top>
            <q-checkbox v-model="task.completed"></q-checkbox>
          </q-item-section>
          <q-item-section>
            <q-item-label
            :class="{'text-strikethrough':task.completed}"
            >{{task.name}}</q-item-label>
            <q-item-label caption>
              Set the content filtering level to restrict
              apps that can be downloaded
            </q-item-label>
          </q-item-section>

          <q-item-section side  >
            <div class="row">
              <div class="column justify-center">
                <q-icon
                name="event"
                size="18px"
                class="q-mr-xs"
                ></q-icon>
              </div>

              <div class="column">
                <q-item-label caption class="row justify-end">{{task.dueDate}}</q-item-label>
                <small><q-item-label caption class="row justify-end">{{task.dueTime}}</q-item-label></small>
              </div>
            </div>

          </q-item-section>
        </q-item>

    </q-list>

</template>

<script>
  // import Task from '../components/Task.vue'
  import {mapGetters} from 'vuex'
  export default{
    computed:{
      ...mapGetters('tasks',['tasks'])
    }
  }

</script>
<style>

</style>
