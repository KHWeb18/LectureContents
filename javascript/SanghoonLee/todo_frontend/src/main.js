import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'

import 'materialize-css/dist/css/materialize.min.css'
import 'material-design-icons/iconfont/material-icons.css'
import '@morioh/v-lightbox/dist/lightbox.css'
import Lightbox from '@morioh/v-lightbox'

import cookies from 'vue-cookies'

Vue.use(Lightbox)
Vue.config.productionTip = false

Vue.use(cookies)

window.Kakao.init("7a62c696242b86d3ca340fa4be88e45c")
console.log('Kakao 초기화 여부 : ' + window.Kakao.isInitialized())

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
