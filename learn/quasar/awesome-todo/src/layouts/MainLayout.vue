<template>

  <q-layout view="hHh lpR lFf">
    <q-page-sticky
      position="top-right"
      style="z-index: 3000"
      :offset="[5, 38]"
    >
      <q-btn
        ref="morphedElement2"
        unelevated
        padding="8px"
        @show="1"
        v-model="rightDrawerSetting"
        icon="settings"
        color="primary"
        square
        @click="drawerRight = !drawerRight"
        round dense
      />
    </q-page-sticky>

    <q-drawer
      side="right"
      v-model="drawerRight"
      show-if-above
      bordered
      :width="200"
      :breakpoint="500"

      content-class="bg-grey-3"
    >
      <q-scroll-area class="fit">
        <div class="q-pa-sm">
          <div v-for="n in 50" :key="n">Drawer {{ n }} / 50</div>
        </div>
      </q-scroll-area>
    </q-drawer>


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

        <q-btn-dropdown stretch flat label="某某系统">
          <q-list>
            <q-item-label header>Folders</q-item-label>
            <q-item v-for="n in 3" :key="`x.${n}`" clickable v-close-popup tabindex="0">
              <q-item-section avatar>
                <q-avatar icon="folder" color="secondary" text-color="white" />
              </q-item-section>
              <q-item-section>
                <q-item-label>Photos</q-item-label>
                <q-item-label caption>February 22, 2016</q-item-label>
              </q-item-section>
              <q-item-section side>
                <q-icon name="info" />
              </q-item-section>
            </q-item>
            <q-separator inset spaced />
            <q-item-label header>Files</q-item-label>
            <q-item v-for="n in 3" :key="`y.${n}`" clickable v-close-popup tabindex="0">
              <q-item-section avatar>
                <q-avatar icon="assignment" color="primary" text-color="white" />
              </q-item-section>
              <q-item-section>
                <q-item-label>Vacation</q-item-label>
                <q-item-label caption>February 22, 2016</q-item-label>
              </q-item-section>
              <q-item-section side>
                <q-icon name="info" />
              </q-item-section>
            </q-item>
          </q-list>
        </q-btn-dropdown>

      </q-toolbar>
      <q-toolbar>
        <q-btn color="white" text-color="black" label="Standard（某某子系统）" @click="buttonClick('Standard（某某子系统）')" />
        <q-btn color="primary" label="Primary" @click="buttonClick('Primary')" />
        <q-btn color="secondary" label="Secondary" @click="buttonClick('Secondary')"/>
        <q-btn color="amber" glossy label="Amber" @click="buttonClick('Amber')"/>
        <q-btn color="brown-5" label="Brown 5" @click="buttonClick('Brown 5')"/>
        <q-btn color="deep-orange" glossy label="Deep Orange" @click="buttonClick('Deep Orange')"/>
        <q-btn color="purple" label="Purple" @click="buttonClick('Purple')"/>
        <q-btn color="black" label="Black" @click="buttonClick('Black')"/>
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
  {
    title: 'mini',
    caption: 'mini',
    icon: 'favorite',
    link: '/mini'
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
      essentialLinks: linksData,
      rightDrawerSetting: false,
      drawerLeft: true,
      drawerRight:true

    }
  },
  methods:{
    buttonClick(e){
      alert(e)
    },
    triggerRightDrawer() {
      this.rightDrawerOpen = !this.rightDrawerOpen
      morph({
        from: this.$refs.morphedElement2.$el,
        duration: 30,
        tween: true,
        tweenFromOpacity: 0.8,
        tweenToOpacity: 0.4
      })
    },
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
