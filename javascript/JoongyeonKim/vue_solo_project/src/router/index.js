import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

//board
import BoardListPage from '@/views/BoardListPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
