<template>

  <q-layout view="hHh lpR lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
        />

        <q-toolbar-title class="absolute-center">
          Awesome TODO
        </q-toolbar-title>

      </q-toolbar>
    </q-header>
    <!-- 设置底部显示栏 -->
    <q-footer>
      <q-tabs >
        <q-route-tab to="/todo" icon="list" label="todo"  />
        <q-route-tab to="/settings" icon="settings" label="settings"   />
        <q-route-tab to="/demo" icon="settings" label="demo"   />
      </q-tabs>
    </q-footer>
      <!--       :breakpoint="767" 表示折叠到一定程度,会隐藏菜单栏 -->
    <q-drawer
      v-model="leftDrawerOpen"
      :breakpoint="767"
      :width="150"
      show-if-above
      bordered
      content-class="bg-primary"
    >
      <q-list dark>
        <q-item-label
          header
          class="text-grey-8"
        >
          Menu
        </q-item-label>
        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import EssentialLink from 'components/EssentialLink.vue'

const linksData = [
  {
    title: 'Todo',
    caption: 'quasar.dev',
    icon: 'list',
    link: '/todo'
  },
  {
    title: 'Settings',
    caption: 'chat.quasar.dev',
    icon: 'settings',
    link: '/settings'
  },
  {
    title: 'demo',
    caption: 'demo',
    icon: 'code',
    link: '/demo'
  },
  // {
  //   title: 'Forum',
  //   caption: 'forum.quasar.dev',
  //   icon: 'record_voice_over',
  //   link: 'https://forum.quasar.dev'
  // },
  // {
  //   title: 'Twitter',
  //   caption: '@quasarframework',
  //   icon: 'rss_feed',
  //   link: 'https://twitter.quasar.dev'
  // },
  // {
  //   title: 'Facebook',
  //   caption: '@QuasarFramework',
  //   icon: 'public',
  //   link: 'https://facebook.quasar.dev'
  // },
  // {
  //   title: 'Quasar Awesome',
  //   caption: 'Community Quasar projects',
  //   icon: 'favorite',
  //   link: 'https://awesome.quasar.dev'
  // }
];

export default {
  name: 'MainLayout',
  components: { EssentialLink },
  data () {
    return {
      leftDrawerOpen: false,
      essentialLinks: linksData
    }
  }
}
</script>

<style lang="scss">
  /* css3响应式布局 达到最小宽度就显示 */
  @media screen and (min-width: 767px){
    .q-footer{
      display: none;
    }
  }
  .q-drawer{
 /*   .q-router-link--active{
      color: white !important;
    } */
  }
</style>
