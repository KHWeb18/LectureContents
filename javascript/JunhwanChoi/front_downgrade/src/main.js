import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'

import 'materialize-css/dist/css/materialize.min.css'
import 'material-design-icons/iconfont/material-icons.css'

Vue.config.productionTip = false


window.Kakao.init("a818e63658fc26e1a0e593ae63ea1e45")
alert('Kakao 초기화 여부 : ' + window.Kakao.isInitialized())
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')