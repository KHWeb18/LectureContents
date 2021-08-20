import {
// Calendar
  OPEN_DETAIL,
  CLOSE_DETAIL
} from './mutation-types'

export default {
// Calendar
  [OPEN_DETAIL] (state, payload) {
    if (state.dialog) {
      state.dialog = false
    } else {
      state.dialog = true
    }
    
    //state.dialog = true
    state.date = payload
    console.log(state.dialog)
    console.log(state.date)
  },
  [CLOSE_DETAIL] (state) {
    state.dialog = false
    console.log(state.dialog)
  }
}