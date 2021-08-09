import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// test
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

// 메인홈
import MainPage from '@/views/main/MainPage.vue'

//카테고리
import About from '@/views/category/About.vue'
import Tour from '@/views/category/Tour.vue'
import Reservation from '@/views/category/Reservation.vue'
import Board from '@/views/category/Board.vue'

// room
import Room201 from '@/views/category/rooms/Room201.vue'
import Room202 from '@/views/category/rooms/Room202.vue'
import Room301 from '@/views/category/rooms/Room301.vue'
import Room302 from '@/views/category/rooms/Room302.vue'

// 예약하기
import Book from '@/views/Book.vue'

// 요금안내
import PayInformation from '@/views/PayInformation.vue'

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
    path: '/room301',
    name: 'Room301',
    components: {
      default: Room301
    }
  },
  {
    path: '/room302',
    name: 'Room302',
    components: {
      default: Room302
    }
  },
  {
    path: '/room201',
    name: 'Room201',
    components: {
      default: Room201
    }
  },
  {
    path: '/room202',
    name: 'Room202',
    components: {
      default: Room202
    }
  },
  {
    path: '/tour',
    name: 'Tour',
    components: {
      default: Tour
    }
  },
  {
    path: '/reservation',
    name: 'Reservation',
    components: {
      default: Reservation
    }
  },
  {
    path: '/board',
    name: 'Board',
    components: {
      default: Board
    }
  },
  {
    path: '/book',
    name: 'Book',
    components: {
      default: Book
    }
  },
  {
    path: '/pay-information',
    name: 'PayInformation',
    components: {
      default: PayInformation
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
