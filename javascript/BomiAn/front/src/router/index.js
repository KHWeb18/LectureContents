import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo'
import Homework from '../views/Homework.vue'

//board
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from  '@/views/BoardRegisterPage.vue'

//member
import MemberListPage from '@/views/MemberListPage.vue'
import MemberRegisterPage from '@/views/MemberRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

//삼목
import Concave from '@/views/Concave.vue'

// product
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'
import ProductReadPage from '@/views/ProductReadPage.vue'
import ProductModifyPage from '@/views/ProductModifyPage.vue'

//monster
import MonsterListPage from '@/views/monster/MonsterListPage.vue'
import MonsterRegisterPage from '@/views/monster/MonsterRegisterPage.vue'
import MonsterReadPage from '@/views/monster/MonsterReadPage.vue'
import MonsterModifyPage from '@/views/monster/MonsterModifyPage.vue'

//eventBus
import EventBusTestPage from '@/views/EventBusTestPage.vue'

//dungeon
import DungeonListPage from '@/views/DungeonListPage'

//area
import CalcAreaPage from '@/views/CalcAreaPage.vue'

//score
import ScoreManagerPage from '@/views/ScoreManagerPage.vue'

// 크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

//slot
import UnNamedSlotTestPage from '@/views/UnNamedSlotTestPage.vue'
import NamedSlotTestPage from '@/views/NamedSlotTestPage.vue'
import ScopedSlotTestPage from '@/views/ScopedSlotTestPage.vue'
import RecentSlotTestPage from '@/views/RecentSlotTestPage.vue'

import MaterializeTestPage from '@/views/MaterializeTestPage.vue'
import MaterializeGridTestPage from '@/views/MaterializeGridTestPage.vue'
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

//jpa member register
import JPAMemberRegisterPage from '@/views/JPAMemberRegisterPage.vue'

//coverflow
import CoverFlowTestPage from '@/views/CoverFlowTestPage.vue'

//vue-awsome-swiper test
import AwsomeSwiperTestPage from '@/views/AwsomeSwiperTestPage.vue'
import LikesFacebookPage from '@/views/LikesFacebookPage.vue'
import ImageGalleryTestPage from '@/views/ImageGalleryTestPage.vue'

import CalendarTestPage from '@/views/CalendarTestPage.vue'

import MemberJoinColumnTestPage from '@/views/MemberJoinColumnTestPage.vue'
import MemberJoinColumnTestForm from '@/components/member/MemberJoinColumnTestForm.vue'
import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'




Vue.use(VueRouter)


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
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/homework',
    name: 'Homework',
    component: Homework
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
    path: '/member',
    name: 'MemberListPage',
    components: {
      default: MemberListPage
    }
  },
  {
    path: '/memeber/create',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage
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
    path: '/concave',
    name: 'Concave',
    components: {
      default: Concave
    }
  },
  {
    path: '/product',
    name: 'ProductListPage',
    components: {
      default: ProductListPage
    }
  },
  {
    path: '/product/create',
    name: 'ProductRegisterPage',
    components: {
      default: ProductRegisterPage
    }
  },
  {
    path: '/product/:productNo',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/product/:productNo/edit',
    name: 'ProductModifyPage',
    components: {
      default: ProductModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/monster',
    name: 'MonsterListPage',
    components: {
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
    components: {
      default: MonsterReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/monster/:monsterNo/edit',
    name: 'MonsterModifyPage',
    components: {
      default: MonsterModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/eventBus',
    name: 'EventBusTestPage',
    component: EventBusTestPage
  },
  {
    path: '/dungeon',
    name: 'DungeonListPage',
    components: {
      default: DungeonListPage
    }
  },
  {
    path: '/calcarea',
    name: 'CalcAreaPage',
    components: {
      default: CalcAreaPage
    }
  },
  {
    path: '/scoreManager',
    name: 'ScoreManagerPage',
    components: {
      default: ScoreManagerPage
    }
  },
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
    path: '/materializeGrid',
    name: 'MaterializeGridTestPage',
    components: {
      default: MaterializeGridTestPage
    }
  },
  {
    path: '/vuetifyAllInOne',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },
  {
    path: '/jpaMemberRegister',
    name: 'JPAMemberRegisterPage',
    components: {
      default: JPAMemberRegisterPage
    }
  },
  {
    path: '/coverflow',
    name: 'CoverFlowTestPage',
    components: {
      default: CoverFlowTestPage
    }
  },
  {
    path: '/awsomeSwiper',
    name: 'AwsomeSwiperTestPage',
    components: {
      default: AwsomeSwiperTestPage
    }
  },
  {
    path: '/facebook',
    name: 'LikesFacebookPage',
    components: {
      default: LikesFacebookPage
    }
  },
  {
    path: '/imgGallery',
    name: 'ImageGalleryTestPage',
    components: {
      default: ImageGalleryTestPage
    }
  },
  {
    path: '/calender',
    name: 'CalendarTestPage',
    components: {
      default: CalendarTestPage
    }
  },
  {
    path: '/memberJoinColumn',
    name: 'MemberJoinColumnTestPage',
    components: {
      default: MemberJoinColumnTestPage
    }
  },
  {
    path: '/memberJoinColumnForm',
    name: 'MemberJoinColumnTestForm',
    components: {
      default: MemberJoinColumnTestForm
    }
  },
  {
    path: '/memberLogin',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
