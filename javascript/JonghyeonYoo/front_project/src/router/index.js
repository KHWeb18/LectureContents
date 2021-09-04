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

import MyPage from '../views/MyPage.vue'

// detailPage(상세페이지)
import DetailPageTaxi from '@/views/DetailPage/DetailPageTaxi.vue'
import taxiForm from '@/components/detailPageForm/taxiForm.vue'

import blackWidowForm from '@/components/detailPageForm/blackWidowForm.vue'
import DetailPageBlackWidow from '@/views/DetailPage/DetailPageBlackWidow.vue'

//로그인 세션 테스트
import Login from '@/views/Login.vue'


// 크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

//로그인페이지로 이동(미로그인으로 컨텐츠 사용할때)
import GoToLogin from '@/components/member/GoToLogin.vue'

//좋아요 싫어요
import like from '../views/like.vue'

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
  path: '/mypage',
  name: 'MyPage',
  component: MyPage
},
// 상세 페이지
{
  path: '/detailPageTaxi',
  name: 'DetailPageTaxi',
  component: DetailPageTaxi
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
  path: '/detailPageBlackWidow',
  name: 'DetailPageBlackWidow',  
  component: DetailPageBlackWidow,

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

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
