import {
// Login
  USER_LOGIN,
  USER_INFO,
  FETCH_SESSION,
// Calendar
  OPEN_DETAIL,
  FETCH_RECORD,
// Recommend
  FETCH_RECOMMENDS,
  FETCH_RECOMMEND,
// Together
  FETCH_TOGETHERS,
  FETCH_TOGETHER,

// Comment 
  FETCH_COMMENTS,
  FETCH_COMMENT
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
    state.record = record

    console.log(record)
  },

// Recommend
  [FETCH_RECOMMENDS] (state, recommends) {
    state.recommends = recommends
  },
  [FETCH_RECOMMEND] (state, recommend) {
    state.recommend = recommend
  },

// Together
  [FETCH_TOGETHERS] (state, togethers) {
    state.togethers = togethers
  },
  [FETCH_TOGETHER] (state, together) {
    state.together = together
  },

// Comment
  [FETCH_COMMENTS] (state, comments) {
    state.comments = comments
  },
  [FETCH_COMMENT] (state, comment) {
    state.comment = comment
  }
}