<template>
<div class="q-pa-md">
    <q-layout view="lHh Lpr lFf" container style="height: 400px" class="my-card">
      <q-header elevated>
        <q-toolbar>
          <q-avatar>
            <q-icon name="timeline"></q-icon>
          </q-avatar>
          <q-toolbar-title>
            <strong>Time</strong> line
          </q-toolbar-title>
        </q-toolbar>
      </q-header>

      <q-page-container>
        <q-page padding>
          <p v-for="n in 15" :key="n">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit nihil praesentium molestias a adipisci, dolore vitae odit, quidem consequatur optio voluptates asperiores pariatur eos numquam rerum delectus commodi perferendis voluptate?
          </p>

          <!-- place QPageScroller at end of page -->
          <q-page-scroller position="bottom-right" :scroll-offset="150" :offset="[18, 18]">
            <q-btn fab icon="keyboard_arrow_up" color="accent" />
          </q-page-scroller>
        </q-page>
      </q-page-container>
    </q-layout>
  </div>
</template>

<script>
</script>

<style lang="sass" scoped>
.my-card
  width: 50%
  max-width: 300px
</style>
