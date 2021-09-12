import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import axios from 'axios'
import moment from 'moment'
import VueMoment from 'vue-moment'



import 'materialize-css/dist/css/materialize.min.css'
import 'material-design-icons/iconfont/material-icons.css'

import cookies from 'vue-cookies'

Vue.use(cookies)
Vue.use(VueMoment, {
  moment,
});

Vue.config.productionTip = false
Vue.prototype.$http = axios


new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')