import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import VueCookies from 'vue-cookies'


import 'material-design-icons/iconfont/material-icons.css'

Vue.config.productionTip = false

Vue.$cookies.config('7200')

new Vue({
  router,
  store,
  vuetify,
  VueCookies,
  render: h => h(App)
}).$mount('#app')
