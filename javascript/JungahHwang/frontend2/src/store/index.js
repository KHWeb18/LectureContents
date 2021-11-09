// 데이터를 중앙관리 -> 전역으로 사용

import Vue from 'vue'
import Vuex from 'vuex'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})
