import {
// Login
  USER_INFO,
  FETCH_SESSION,

// Calendar
  FETCH_RECORD,

// Recommend
  FETCH_RECOMMEND,
  FETCH_RECOMMEND_DETAIL
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
// Login
  userLogin ({ commit }, id) {
    return axios.get(`http://localhost:7777/member/mypage/${id}`).then(res => {
      cookies.set('session', res.data)
      commit(USER_INFO, cookies.get('session'))
    })
  },
  fetchSession ({ commit }, session) {
    commit(FETCH_SESSION, session)
  },

// Calendar
  fetchRecord ({ commit }, date) {
    return axios.get(`http://localhost:7777/record/${date}`).then(res => {
      commit(FETCH_RECORD, res.data[0])
    })
  },
  
// Recommend
  fetchRecommend ({ commit }) {
    return axios.get('http://localhost:7777/recommend/lists').then(res => {
      console.log(res.data)
      
      let recommends = []

      for (let i = 0; i < res.data.length; i++) {
        let list = { boardNo: res.data[i][0], id: res.data[i][1], 
          title: res.data[i][2], content: res.data[i][3], regDate: res.data[i][4] }
        
          recommends.push(list)
      }

      commit(FETCH_RECOMMEND, recommends)
      console.log(recommends)
    })
  },
  fetchRecommendDetail ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/recommend/read/${boardNo}`).then(res => {
      console.log(res.data)
      let recommend = { boardNo: res.data[0][0], id: res.data[0][1], title: res.data[0][2], 
        content: res.data[0][3], regDate: res.data[0][4] }
      
      console.log(recommend)
      commit(FETCH_RECOMMEND_DETAIL, recommend)
    })
  }
}