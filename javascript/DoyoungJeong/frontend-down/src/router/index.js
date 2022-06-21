import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo.vue'
import Prob82 from '../views/Prob82.vue'

import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardListPage from '@/views/BoardListPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

import MemberRegisterPage from '@/views/MemberRegisterPage.vue'
import MemberListPage from '@/views/MemberListPage.vue'
import MemberReadPage from '@/views/MemberReadPage.vue'
import MemberModifyPage from '../views/MemberModifyPage.vue'

import Concave from '../views/Concave.vue'

import MonsterStoragePage from '../views/monster/MonsterStoragePage.vue'
import MonsterUploadPage from '../views/monster/MonsterUploadPage.vue'
import MonsterReadPage from '../views/monster/MonsterReadPage.vue'
import MonsterModifyPage from '../views/monster/MonsterModifyPage.vue'

import EventBusTestPage from '@/views/EventBusTestPage.vue'

import DungeonPage from '@/views/DungeonPage.vue'

import StudentScoresPage from '@/views/student/StudentScoresPage.vue'

import TriangleAreaCalc from '@/views/prob89/TriangleAreaCalc.vue'

import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

import UnNamedSlotTestPage from '@/views/UnNamedSlotTestPage.vue'
import NamedSlotTestPage from '@/views/NamedSlotTestPage.vue'
import ScopedSlotTestPage from '@/views/ScopedSlotTestPage.vue'
import RecentSlotTestPage from '@/views/RecentSlotTestPage.vue'

import MaterializeTestPage from '@/views/MaterializeTestPage.vue'
import MaterializeGridTestPage from '@/views/MaterializeGridTestPage.vue'
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

import VueJpaMemberRegister from '@/views/VueJpaMemberRegister.vue'

import CoverFlowTestPage from '@/views/CoverFlowTestPage.vue'
import AwesomeSwiperTest from '@/views/AwesomeSwiperTest.vue'
import CalendarTestPage from '@/views/CalendarTestPage.vue'
import ImageGalleryTestPage from '@/views/ImageGalleryTestPage.vue'
//@는 src, ..는 상위

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
    path: '/prob82',
    name: 'Prob82',
    component: Prob82
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
      default: BoardRegisterPage //components { default: ~ }이거 뭐지? 
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true //props를 보낼 수 있게 활성화한다.
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
    path: '/member',
    name: 'MemberListPage',
    components: {
      default: MemberListPage
    }
  },
  {
    path: '/member/create',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage 
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
    path: '/concave',
    name: 'Concave',
    components: {
      default: Concave
    }
  },
  {
    path: '/monster',
    name: 'MonsterStoragePage',
    components: {
      default: MonsterStoragePage
    }
  },
  {
    path: '/monster',
    name: 'MonsterUploadPage',
    components: {
      default: MonsterUploadPage
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
    path: '/eventbusTest',
    name: 'EventBusTestPage',
    components: {
      default: EventBusTestPage
    }
  },
  {
    path: '/dungeon',
    name: 'DungeonPage',
    components: {
      default: DungeonPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/studentScores',
    name: 'StudentScoresPage',
    components: {
      default: StudentScoresPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/triangleAreaCalc',
    name: 'TriangleAreaCalc',
    components: {
      default: TriangleAreaCalc
    },
    props: {
      default: true
    }
  },
  {
    path: '/daumNewsCrawlerPage',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },
  {
    path: '/unNamedSlotTestPage',
    name: 'UnNamedSlotTestPage',
    components: {
      default: UnNamedSlotTestPage
    }
  },
  {
    path: '/namedSlotTestPage',
    name: 'NamedSlotTestPage',
    components: {
      default: NamedSlotTestPage
    }
  },
  {
    path: '/scopedSlotTestPage',
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
    path: '/materializeGridTestPage',
    name: 'MaterializeGridTestPage',
    components: {
      default: MaterializeGridTestPage
    }
  },
  {
    path: '/vuetifyAllInOneTestPage',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },
  {
    path: '/vueJpaMemberRegister',
    name: 'VueJpaMemberRegister',
    components: {
      default: VueJpaMemberRegister
    }
  },
  {
    path: '/coverFlowTestPage',
    name: 'CoverFlowTestPage',
    components: {
      default: CoverFlowTestPage
    }
  },
  {
    path: '/awesomeSwiperTest',
    name: 'AwesomeSwiperTest',
    components: {
      default: AwesomeSwiperTest
    }
  },
  {
    path: '/calendarTestPage',
    name: 'CalendarTestPage',
    components: {
      default: CalendarTestPage
    }
  },
  {
    path: '/imageGalleryTestPage',
    name: 'ImageGalleryTestPage',
    components: {
      default: ImageGalleryTestPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
