import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// test
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

// 메인홈
import MainPage from '@/views/main/MainPage.vue'

//카테고리
import About from '@/views/category/About.vue'
import RoomSuite from '@/views/category/RoomSuite.vue'
import RoomRoyal from '@/views/category/RoomRoyal.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/vuetifyTest',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },
  {
    path: '/cinzel',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  },
  {
    path: '/about',
    name: 'About',
    components: {
      default: About
    }
  },
  {
    path: '/suite',
    name: 'RoomSuite',
    components: {
      default: RoomSuite
    }
  },
  {
    path: '/royal',
    name: 'RoomRoyal',
    components: {
      default: RoomRoyal
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
