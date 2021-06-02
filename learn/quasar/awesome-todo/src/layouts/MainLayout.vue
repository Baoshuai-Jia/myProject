<template>

  <q-layout view="hHh lpR lFf">
    <q-page-sticky
      position="top-right"
      style="z-index: 3000"
      :offset="ageStickyPosition"
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
        v-drag
      />
    </q-page-sticky>

    <q-drawer
      side="right"
      v-model="drawerRight"
      show-if-above
      bordered
      :width="200"
      :breakpoint="500"

      content-class="bg-blue-1"
    >
      <q-scroll-area class="fit">
        <q-item>
          <q-item-section>
            <q-item-label>主题色</q-item-label>
            <q-item-label class="q-gutter-sm">
                  <span
                    style="width: 20px; height: 20px"
                    :key="index"
                    v-for="(item, index) in styleSettingsData.themeColorSetting"
                    @click="changeThemeColor(index)"
                  >
                    <q-btn
                      :style="item.style"
                      text-color="white"
                      flat
                      icon="done"
                      dense
                      v-if="item.checked"
                      style="width: 18px; height: 18px"
                      size="xs"
                    />
                    <q-btn
                      :style="item.style"
                      text-color="white"
                      flat
                      dense
                      v-else
                      style="width: 18px; height: 18px"
                      size="xs"
                    />
                  </span>
            </q-item-label>
          </q-item-section>
        </q-item>
        <q-item tag="label">
          <q-item-section>
            <q-item-label>迷你菜单</q-item-label>
          </q-item-section>
          <q-item-section side top>
            <q-toggle
              color="primary"
              v-model="fixedHead"
              val="friend"
              @input="changeFixed"
            />
          </q-item-section>
        </q-item>
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
      :width="leftDrawerOpenWidth"
      show-if-above
      bordered
      content-class="bg-primary"
    >
      <q-list dark>
        <q-item-label
          header
          class="text-grey-8"
        >

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
import { morph, colors, copyToClipboard } from 'quasar'

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
      drawerRight:true,
      fixedHead:false,
      leftDrawerOpenWidth:150,
      ageStickyPosition:[5,38],
      styleSettingsData: {
        themeColorSetting: [
          {
            style: 'background-color: rgb(24, 144, 255)',
            color: 'rgb(24, 144, 255)',
            checked: true
          },
          {
            style: 'background-color: rgb(245, 34, 45)',
            color: 'rgb(245, 34, 45)',
            checked: false
          },
          {
            style: 'background-color: rgb(250, 84, 28)',
            color: 'rgb(250, 84, 28)',
            checked: false
          },
          {
            style: 'background-color: rgb(250, 173, 20)',
            color: 'rgb(250, 173, 20)',
            checked: false
          },
          {
            style: 'background-color: rgb(19, 194, 194)',
            color: 'rgb(19, 194, 194)',
            checked: false
          },
          {
            style: 'background-color: rgb(82, 196, 26)',
            color: 'rgb(82, 196, 26)',
            checked: false
          },
          {
            style: 'background-color: rgb(47, 84, 235)',
            color: 'rgb(47, 84, 235)',
            checked: false
          },
          {
            style: 'background-color: rgb(114, 46, 209)',
            color: 'rgb(114, 46, 209)',
            checked: false
          },
          {
            style: 'background-color: rgb(114, 46, 209)',
            color: 'rgb(7,6,6)',
            checked: false
          }
        ],
        fixed: {
          viewHead: 'hHh',
          viewBody: 'LpR',
          viewFoot: 'lfr',
          fixedHead: true,
          fixedFooter: false
        },
        contentSettings: {
          header: true,
          topBar: true,
          topBarGlossy: false,
          footer: true,
          leftMenuHeader: true,
        }
      }
    }
  },
  computed:{
    modifyPageStickyPosition:function (e) {
      return this.qPageStickyPosition;
    }
  },
  directives: {
    drag: {
      inserted:function(el,binding){
        el.onmousedown=function(e){
          e.stopPropagation();
          let disx = e.pageX - el.offsetLeft;
          let disy = e.pageY - el.offsetTop;
          document.onmousemove = function (e){
            e.preventDefault();
            el.style.left = e.pageX - disx+'px';
            el.style.top = e.pageY - disy+'px';
          }
          document.onmouseup = function(){
            document.onmousemove = document.onmouseup = null;
            //binding 传参，可忽略
            if(binding && binding.value){
              binding.value.clientX=parseInt(el.style.left);
              binding.value.clientY=parseInt(el.style.top);
            }

          }
        }
      }
    }
  },
  methods:{
    repositioningPPage(e){
      console.log(e)
    },
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
    changeFixed() {
      this.fixedHead != this.fixedHead;
      if (this.fixedHead){
        this.leftDrawerOpenWidth = 50;
      }else {
        this.leftDrawerOpenWidth = 150;
      }
    },
    changeThemeColor(index){
      for (
        let i = 0;
        i < this.styleSettingsData.themeColorSetting.length;
        ++i
      ) {
        this.styleSettingsData.themeColorSetting[i].checked = false
      }
      colors.setBrand(
        'primary',
        this.styleSettingsData.themeColorSetting[index].color
      )
      this.styleSettingsData.themeColorSetting[index].checked = true
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
