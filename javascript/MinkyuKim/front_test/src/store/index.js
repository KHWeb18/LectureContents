import Vue from 'vue'
import Vuex from 'vuex'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'
// stor/index 내 변수는 전역변수로 관리된다.
Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})