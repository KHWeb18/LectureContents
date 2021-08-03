import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Login from '../views/Login.vue'
import SignUpRegister from '../views/SignUpRegister.vue'
import VuetifyAllInOne from '../views/VuetifyAllInOne.vue'

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
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signupregister',
    name: 'SignUpRegister',
    component: SignUpRegister
  },
  {
    path: '/vuetifyallinone',
    name: 'VuetifyAllInOne',
    component: VuetifyAllInOne
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
