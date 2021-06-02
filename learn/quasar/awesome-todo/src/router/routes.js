
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '/todo', component: () => import('pages/Index.vue') },
      { path: '/settings', component: () => import('pages/PageSettings.vue') },
      { path: '/demo', component: () => import('pages/Demo.vue') },
      { path: '/mini', component: () => import('pages/Mini.vue') }

    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
