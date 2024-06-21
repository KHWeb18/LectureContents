import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import MainHome from '../views/MainHome.vue'

import VuetifyAllInOne from '../views/VuetifyAllInOne.vue'
import Header from '../views/Header.vue'
import Banner from '../views/Banner.vue'
import MoviePage from '../views/MoviePage.vue'
import TVprogramPage from '../views/TVprogramPage.vue'

import MemberRegister from '../views/MemberRegister.vue'
import MemberLogin from '../views/MemberLogin.vue'

import Login_Header from '../components/header/Login_Header.vue'


// board(게시판)
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

// 리뷰(게시판)
import ReviewListPage from '@/views/ReviewListPage.vue'
import ReviewRegisterPage from '@/views/ReviewRegisterPage.vue'
import ReviewReadPage from '@/views/ReviewReadPage.vue'
import ReviewModifyPage from '@/views/ReviewModifyPage.vue'


import MyPage from '../views/MyPage.vue'

// detailPage(상세페이지)
import Taxi from '@/views/DetailPage/Taxi.vue'
import taxiForm from '@/components/detailPageForm/taxiForm.vue'

import blackWidowForm from '@/components/detailPageForm/blackWidowForm.vue'
import BlackWidow from '@/views/DetailPage/BlackWidow.vue'

import HarryPotter from '@/views/DetailPage/HarryPotter.vue'
import WatchMen from '@/views/DetailPage/WatchMen.vue'
import GameOfThrones from '@/views/DetailPage/GameOfThrones.vue'
import BandOfBrothers from '@/views/DetailPage/BandOfBrothers.vue'
import Chernobyl from '@/views/DetailPage/Chernobyl.vue'

//로그인 세션 테스트
import Login from '@/views/Login.vue'


// 크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

//로그인페이지로 이동(미로그인으로 컨텐츠 사용할때)
import GoToLogin from '@/components/member/GoToLogin.vue'

//좋아요 싫어요
import like from '../views/like.vue'

// footer
import Footer from '../views/Footer.vue'

Vue.use(VueRouter)


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/mainHome',
    name: 'MainHome',
    component: MainHome
  },


  {
    path: '/vuetifyallinone',
    name: 'VuetifyAllInOne',
    component: VuetifyAllInOne
  },
  {
    path: '/banner',
    name: 'Banner',
    component: Banner
  },
  {
    path: '/header',
    name: 'Header',
    component: Header
  },
  
  {
    path: '/moviepage',
    name: 'MoviePage',
    component: MoviePage
  },
  {
    path: '/tvprogrampage',
    name: 'TVprogramPage',
    component: TVprogramPage
  },

  {
    path: '/memberRegister',
    name: 'MemberRegister',
    component: MemberRegister
  },
  {
    path: '/memberLogin',
    name: 'MemberLogin',

    component: MemberLogin,
    },
{
  path: '/login_header',
  name: 'Login_Header',
  component: Login_Header
},

{
  path: '/board',
  name: 'BoardListPage',
  components: {
    default: BoardListPage
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
    // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함!!
    default: true
  }
},


{
  path: '/review',
  name: 'ReviewListPage',
  components: {
    default: ReviewListPage
  }
},
{
  path: '/review/create',
  name: 'ReviewRegisterPage',
  components: {
    default: ReviewRegisterPage
  }
},
{
  path: '/review/:reviewNo',
  name: 'ReviewReadPage',
  components: {
    default: ReviewReadPage
  },
  props: {
    default: true
  }
},
{
  path: '/review/:reviewNo/edit',
  name: 'ReviewModifyPage',
  components: {
    default: ReviewModifyPage
  },
  props: {
    // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함!!
    default: true
  }
},



{
  path: '/mypage',
  name: 'MyPage',
  component: MyPage
},
// 상세 페이지
{
  path: '/Taxi',
  name: 'Taxi',
  component: Taxi
},
{
  path: '/taxiForm',
  name: 'taxiForm',
  
  component: taxiForm
},
{
  path: '/blackWidowForm',
  name: 'blackWidowForm',
 
  component: blackWidowForm
},
{
  path: '/BlackWidow',
  name: 'BlackWidow',  
  component: BlackWidow,
},
{
  path: '/HarryPotter',
  name: 'HarryPotter',  
  component: HarryPotter,
},
{
  path: '/WatchMen',
  name: 'WatchMen',  
  component: WatchMen,
},
{
  path: '/GameOfThrones',
  name: 'GameOfThrones',  
  component: GameOfThrones,
},
{
  path: '/BandOfBrothers',
  name: 'BandOfBrothers',  
  component: BandOfBrothers,
},
{
  path: '/Chernobyl',
  name: 'Chernobyl',  
  component: Chernobyl,
},

// 로그인 세션 테스트
{
  path: '/login',
  name: 'Login',
  component: Login
},
//크롤링
{
  path: '/daumNewsCrawler',
  name: 'DaumNewsCrawlerPage',
  components: {
    default: DaumNewsCrawlerPage
  }
},
{
  path: '/GoToLogin',
  name: 'GoToLogin',
  components: {
    default: GoToLogin
  }
},
{
  path: '/like',
  name: 'like',
  component: like
},
{
  path: '/Footer',
  name: 'Footer',
  component: Footer
},

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
