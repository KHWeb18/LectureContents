
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Game from '../views/Game.vue'
import Todo from '../views/Todo.vue'
import Homework from '../views/Homework.vue'

//..:상위폴더 @:src폴더를 의미 
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

import GameMemberRegisterPage from '@/views/GameMemberRegisterPage.vue'

//삼목
import Concave from '@/views/Concave.vue'

//product
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'
import ProductReadPage from '@/views/ProductReadPage.vue'
import ProductModifyPage from '@/views/ProductModifyPage.vue'

//monster
import MonsterListPage from '@/views/MonsterListPage.vue'
import MonsterRegisterPage from '@/views/MonsterRegisterPage.vue'
import MonsterReadPage from '@/views/MonsterReadPage.vue'
import MonsterModifyPage from '@/views/MonsterModifyPage.vue'

import EventBusTestPage from '@/views/EventBusTestPage.vue'
//랜덤 던전
import DungeonListPage from '@/views/DungeonListPage.vue';

import OnlyVuePage from '@/views/OnlyVuePage.vue';
import SpringInterconnectionPage from '@/views/SpringInterconnectionPage.vue';
import ScoreManagerPage from '@/views/ScoreManagerPage.vue';

//크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'
import UnNamedSlotTestPage from '@/views/UnNamedSlotTestPage.vue'
import NamedSlotTestPage from '@/views/NamedSlotTestPage.vue'
import ScopedSlotTestPage from '@/views/ScopedSlotTestPage.vue'
import RecentSlotTestPage from '@/views/RecentSlotTestPage.vue'

//Materialize
import MaterializeTestPage from '@/views/MaterializeTestPage.vue'
import MaterializeGridTestPage from '@/views/MaterializeGridTestPage.vue'
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/game',
    name: 'Game',
    component: Game
  },
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/homework',
    name: 'Homework',
    component: Homework
  },
  //board
  {
    path: '/board',
    name: 'BoardListPage',
    components:{
      default: BoardListPage
    } 
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components:{
      default: BoardReadPage
    },
    props:{
      default: true
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components:{
      default: BoardRegisterPage
    } 
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components:{
      default: BoardModifyPage
    },
    props: {
      //라우팅 피라미터를 props에 자동으로 설정하게 서포트함
      default: true
    } 
  },
  //member
  {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components:{
      default: GameMemberRegisterPage
    } 
  },
  {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components:{
      default: GameMemberRegisterPage
    } 
  },
  //삼목
  {
    path: '/concave',
    name: 'Concave',
    components:{
      default: Concave
    } 
  },
  //product
  {
    path: '/product',
    name: 'ProductListPage',
    components:{
      default: ProductListPage
    } 
  },
  {
    path: '/product/create',
    name: 'ProductRegisterPage',
    components:{
      default: ProductRegisterPage
    } 
  },
  {
    path: '/product/:productNo',
    name: 'ProductReadPage',
    components:{
      default: ProductReadPage
    },
    props:{
      default: true
    }
  },
  {
    path: '/product/:productNo/edit',
    name: 'ProductModifyPage',
    components:{
      default: ProductModifyPage
    },
    props: {
      //라우팅 피라미터를 props에 자동으로 설정하게 서포트함
      default: true
    } 
  },
  {
    path: '/monster',
    name: 'MonsterListPage',
    components:{
      default: MonsterListPage
    } 
  },
  {
    path: '/monster/create',
    name: 'MonsterRegisterPage',
    components: {
      default: MonsterRegisterPage
    }
  },
  {
    path: '/monster/:monsterNo',
    name: 'MonsterReadPage',
    components:{
      default: MonsterReadPage
    },
    props:{
      default: true
    }
  },
  {
    path: '/monster/:monsterNo/edit',
    name: 'MonsterModifyPage',
    components:{
      default: MonsterModifyPage
    },
    props: {
      //라우팅 피라미터를 props에 자동으로 설정하게 서포트함
      default: true
    } 
  },
  {
    path: '/eventbusTest',
    name: 'EventBusTestPage',
    components:{
      default: EventBusTestPage
    } 
  },
  {
    path: '/dungeon',
    name: 'DungeonListPage',
    components:{
      default: DungeonListPage
    } 
  },
  {
    path: '/onlyVue',
    name: 'OnlyVuePage',
    components:{
      default: OnlyVuePage
    } 
  },
  {
    path: '/onlyVue',
    name: 'SpringInterconnectionPage',
    components:{
      default: SpringInterconnectionPage
    } 
  },
  {
    path: '/scoreManager',
    name: 'ScoreManagerPage',
    components:{
      default: ScoreManagerPage
    } 
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
    path: '/unNamedSlot',
    name: 'UnNamedSlotTestPage',
    components: {
      default: UnNamedSlotTestPage
    }
  },
  {
    path: '/namedSlot',
    name: 'NamedSlotTestPage',
    components: {
      default: NamedSlotTestPage
    }
  },
  {
    path: '/scopedSlot',
    name: 'ScopedSlotTestPage',
    components: {
      default: ScopedSlotTestPage
    }
  },
  {
    path: '/vSlot',
    name: 'RecentSlotTestPage',
    components: {
      default: RecentSlotTestPage
    }
  },
  {
    path: '/materialize',
    name: 'MaterializeTestPage',
    components: {
      default: MaterializeTestPage
    }
  },
  {
    path: '/materialize',
    name: 'MaterializeGridTestPage',
    components: {
      default: MaterializeGridTestPage
    }
  },
  {
    path: '/vuetifyTest',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },
  
]
  



const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router