import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// 메인홈
import MainPage from '@/views/main/MainPage.vue'

// 로그인
import CookieTest from '@/views/CookieTest.vue'
import CinzelMemberLogin from '@/views/member/CinzelMemberLogin.vue'
import MyPage from '@/views/member/MyPage.vue'

// 관리자
import ManagerLogin from '@/views/manager/ManagerLogin.vue'
import ManagerPage from '@/views/manager/ManagerPage.vue'
import MemberAdminister from '@/views/manager/MemberAdminister.vue'
import MemberListPage from '@/views/manager/MemberListPage.vue'
import MemberReadPage from '@/views/manager/MemberReadPage.vue'
import MemberModifyPage from '@/views/manager/MemberModifyPage.vue'


// 회원가입
import CinzelMemberRegister from '@/views/member/CinzelMemberRegister.vue'

//카테고리
import About from '@/views/category/About.vue'
import Tour from '@/views/category/Tour.vue'
import Reservation from '@/views/category/Reservation.vue'

// 크롤링
import TourCrawlerPage from '@/views/TourCrawlerPage.vue'

// board
// import Board from '@/views/category/board/Board.vue'
import BoardListPage from '@/views/category/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/category/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/category/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/category/board/BoardModifyPage.vue'
import BoardSearchPage from '@/views/category/board/BoardSearchPage.vue'

// room
import Room201 from '@/views/category/rooms/Room201.vue'
import Room202 from '@/views/category/rooms/Room202.vue'
import Room301 from '@/views/category/rooms/Room301.vue'
import Room302 from '@/views/category/rooms/Room302.vue'

// 예약하기
import Book from '@/views/Book.vue'
import CompletePayment from '@/views/CompletePayment.vue' 



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/cookie',
    name: 'CookieTest',
    component: CookieTest
  },
  {
    path: '/tourCrawler',
    name: 'TourCrawlerPage',
    components: {
      default: TourCrawlerPage
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
    path: '/login',
    name: 'CinzelMemberLogin',
    components: {
      default: CinzelMemberLogin
    }
  },
  // 관리자
  {
    path: '/managerPage',
    name: 'ManagerPage',
    components: {
      default: ManagerPage
    }
  },
  {
    path: '/memberList',
    name: 'MemberListPage',
    components: {
      default: MemberListPage
    }
  },
  {
    path: '/member/:memberNo',
    name: 'MemberReadPage',
    components: {
      default: MemberReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/member/:memberNo/edit',
    name: 'MemberModifyPage',
    components: {
      default: MemberModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/managerAdiminister',
    name: 'MemberAdminister',
    components: {
      default: MemberAdminister
    }
  },
  {
    path: '/managerLogin',
    name: 'ManagerLogin',
    components: {
      default: ManagerLogin
    }
  },
  {
    path: '/myPage/:memberNo',
    name: 'MyPage',
    components: {
      default: MyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/memberRegister',
    name: 'CinzelMemberRegister',
    components: {
      default: CinzelMemberRegister
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
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/boardSearch',
    name: 'BoardSearchPage',
    components: {
      default: BoardSearchPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
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
    path: '/completePayment',
    name: 'CompletePayment',
    components: {
      default: CompletePayment
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
