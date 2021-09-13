import {
// Login
  USER_LOGIN,
  FETCH_USER_INFO,
  FETCH_SESSION,
// Calendar
  OPEN_DETAIL,
  FETCH_RECORDS,
  FETCH_RECORD,
// Recommend
  FETCH_RECOMMENDS,
  FETCH_RECOMMEND,
// Together
  FETCH_TOGETHERS,
  FETCH_TOGETHER,

// Comment 
  FETCH_RECOMMEND_COMMENTS,
  FETCH_RECOMMEND_COMMENT,
  FETCH_TOGETHER_COMMENTS,
  FETCH_TOGETHER_COMMENT
} from './mutation-types'

export default {
// Login
  [USER_LOGIN] (state, isLogin) {
    state.isLogin = isLogin
    console.log('isLogin: ' + isLogin)
  },
  [FETCH_USER_INFO] (state, userInfo) {
    state.userInfo = userInfo
    console.log('userInfo' + userInfo)
  },
  [FETCH_SESSION] (state, session) {
    state.session = session
  },

// Calendar
  [OPEN_DETAIL] (state, date) {
    state.selectDate = date
    
    console.log(state.selectDate)
  },
  [FETCH_RECORDS] (state, records) {
    state.records = records

    console.log(records)
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
  [FETCH_RECOMMEND_COMMENTS] (state, comments) {
    state.recommendComments = comments
  },
  [FETCH_RECOMMEND_COMMENT] (state, comment) {
    state.recommendComment = comment
  },
  [FETCH_TOGETHER_COMMENTS] (state, comments) {
    state.togetherComments = comments
  },
  [FETCH_TOGETHER_COMMENT] (state, comment) {
    state.togetherComment = comment
  }
}