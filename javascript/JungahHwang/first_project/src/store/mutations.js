import {
// Login
  USER_LOGIN,
  USER_INFO,
  FETCH_SESSION,
// Calendar
  OPEN_DETAIL,
  FETCH_RECORD,
// Recommend
  FETCH_RECOMMEND,
  FETCH_RECOMMEND_DETAIL
} from './mutation-types'

export default {
// Login
  [USER_LOGIN] (state, isLogin) {
    state.isLogin = isLogin
    console.log('isLogin: ' + isLogin)
  },
  [USER_INFO] (state, userInfo) {
    state.userInfo = userInfo
    console.log(userInfo)
  },
  [FETCH_SESSION] (state, session) {
    state.session = session
  },

// Calendar
  [OPEN_DETAIL] (state, payload) {
    state.date = payload
    
    console.log(state.date)
  },
  [FETCH_RECORD] (state, record) {
    if (record) {
      record = { food: record[0], exercise: record[1], weight: record[2] }
    } else {
      record = null
    }
    state.record = record
    console.log(record)
  },

// Recommend
  [FETCH_RECOMMEND] (state, recommends) {
    state.recommends = recommends
  },
  [FETCH_RECOMMEND_DETAIL] (state, recommend) {
    state.recommend = recommend
  }
  
}