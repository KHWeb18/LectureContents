import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import MainPage from '../views/concert/MainPage.vue'
import ConcertToolBar from '../views/toolBars/ConcertToolBar.vue'
import BottomToolBar from '../views/toolBars/BottomToolBar.vue'
import ConcertDetailPage from '../views/concert/ConcertDetailPage.vue'
import LikedListPage from '../views/concert/LikedListPage.vue'
import AboutUsPage from '../views/concert/AboutUsPage.vue'

import SignupPage from '../views/member/SignupPage.vue'
import InterestedSetUpPage from '../views/member/InterestedSetUpPage.vue'
import MemberListPage from '../views/member/MemberListPage.vue'
import MemberDeletePage from '../views/member/MemberDeletePage.vue'
import MyProfilePage from '../views/member/MyProfilePage.vue'
import MemberModifyPage from '../views/member/MemberModifyPage.vue'
import MemberWithdrawalPage from '../views/member/MemberWithdrawalPage.vue'

import IndieNewsCrawlerPage from '../views/crawling/IndieNewsCrawlerPage.vue'

import CommunityPage from '../views/community/CommunityPage.vue'
import CommunityWritePage from '../views/community/CommunityWritePage.vue'
import CommunityReadPage from '../views/community/CommunityReadPage.vue'
import CommunityModifyPage from '../views/community/CommunityModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/mainPage',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/concertToolBar',
    name: 'ConcertToolBar',
    component: ConcertToolBar
  },
  {
    path: '/bottomToolBar',
    name: 'BottomToolBar',
    component: BottomToolBar
  },
  {
    path: '/concertDetailPage',
    name: 'ConcertDetailPage',
    component: ConcertDetailPage
  },
  {
    path: '/likedListPage',
    name: 'LikedListPage',
    component: LikedListPage
  },
  {
    path: '/signupPage',
    name: 'SignupPage',
    component: SignupPage
  },
  {
    path: '/interestedSetUpPage',
    name: 'InterestedSetUpPage',
    component: InterestedSetUpPage
  },
  {
    path: '/memberListPage',
    name: 'MemberListPage',
    component: MemberListPage
  },
  {
    path: '/memberDelete/:memberNo',
    name: 'MemberDeletePage',
    component: MemberDeletePage,
    props: {
      default: true
    }
  },
  {
    path: '/myProfilePage',
    name: 'MyProfilePage',
    component: MyProfilePage
  },
  {
    path: '/memberModifyPage',
    name: 'MemberModifyPage',
    component: MemberModifyPage
  },
  {
    path: '/memberWithdrawalPage',
    name: 'MemberWithdrawalPage',
    component: MemberWithdrawalPage
  },
  {
    path: '/indieNewsCrawlerPage',
    name: 'IndieNewsCrawlerPage',
    component: IndieNewsCrawlerPage
  },
  {
    path: '/communityPage',
    name: 'CommunityPage',
    component: CommunityPage
  },
  {
    path: '/communityWritePage',
    name: 'CommunityWritePage',
    component: CommunityWritePage
  },
  {
    path: '/communityReadPage',
    name: 'CommunityReadPage',
    component: CommunityReadPage,
    props: {
      default: true
    }
  },
  {
    path: '/communityModifyPage', // /:boardNo을 붙이면 그 화면에서 다른 화면으로 가는 버튼이 안먹히고.. 무조건 나중에 수정하자
    name: 'CommunityModifyPage',
    component: CommunityModifyPage,
    props: {
      default: true
    }
  },
  {
    path: '/aboutUsPage',
    name: 'AboutUsPage',
    component: AboutUsPage
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
