import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import cooikes from 'vue-cookies'
import VueYoutube from 'vue-youtube'
import VueNaverMpas from 'vue-naver-maps'


import 'material-design-icons/iconfont/material-icons.css'

Vue.config.productionTip = false

Vue.use(cooikes)
Vue.$cookies.config('2h')

Vue.use(VueYoutube)

Vue.use(VueNaverMpas, {
  clientID: ''
})

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
