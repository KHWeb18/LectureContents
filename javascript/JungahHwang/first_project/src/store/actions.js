import {
// Calendar
  USER_INFO,
  FETCH_ACTIVITY
} from './mutation-types'

import axios from 'axios'

export default {
// Calendar
  fetchActivity ({ commit }, date) {
    return axios.get(`http://localhost:7777/record/${date}`).then(res => {
      commit(FETCH_ACTIVITY, res.data[0])
    })
  },
  userLogin ({ commit }, id) {
    return axios.get(`http://localhost:7777/member/mypage/${id}`).then(res => {
      commit(USER_INFO, res.data)
    })
  }
}