import Vue from 'vue'
import Vuex from 'vuex'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

// vue를 관리하면서 데이터를 전역으로 관리하고 싶다면 store-index.js 장소에 저장
export default new Vuex.Store({
    state,
    actions,
    mutations,
    getters
  })
