import {
// Calendar
  USER_LOGIN,
  USER_INFO,
  OPEN_DETAIL,
  FETCH_ACTIVITY,
} from './mutation-types'

export default {
// Calendar
  [OPEN_DETAIL] (state, payload) {
    state.date = payload
    
    console.log(state.date)
  },
  [FETCH_ACTIVITY] (state, activity) {
    if (activity) {
      activity = { food: activity[0], exercise: activity[1], weight: activity[2] }
    } else {
      activity = null
    }
    state.activity = activity
    console.log(activity)
  },
  [USER_LOGIN] (state, isLogin) {
    state.isLogin = isLogin
    console.log('isLogin: ' + isLogin)
  },
  [USER_INFO] (state, userInfo) {
    state.userInfo = userInfo
    console.log(userInfo)
    
  }
}