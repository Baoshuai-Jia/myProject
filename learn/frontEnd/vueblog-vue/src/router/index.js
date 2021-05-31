import Vue from 'vue'
import VueRouter from 'vue-router'
import Blogs from '../views/Blogs.vue'
import BlogsBlogs from '../views/Blogs.vue'
import BlogEdit from '../views/BlogEdit.vue'
import Login from '../views/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Blogs',
    redirect: { name: 'index'}
  },
   {
    path: '/blogs',
    name: 'index',
    component: Blogs
  },
    {
    path: '/blogsBlogs',
    name: 'BlogsBlogs',
    component: BlogsBlogs
  },{
    path: '/blogEdit/add',
    name: 'BlogEdit',
    component: BlogEdit
  },
    {
    path: '/blogEdit/:blogId',
    name: 'BlogEdit',
    component: BlogEdit
  },{
    path: '/blogEdit/:blogId/edit',
    name: 'BlogEdit',
    component: BlogEdit
  },
     {
    path: '/blogEdit',
    name: 'BlogEdit',
    component: BlogEdit
  },
    {
    path: '/login',
    name: 'Login',
    component: Login
  }
]

const router = new VueRouter({
  routes
})

export default router
