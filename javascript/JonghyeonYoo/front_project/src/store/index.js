import Vue from 'vue'
import Vuex from 'vuex'

import actions from './actions'
import mutations from './mutations'
import state from './states'
import getters from './getters'

Vue.use(Vuex)


export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})