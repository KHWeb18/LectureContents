import {
// Login
  FETCH_USER_INFO,
  FETCH_SESSION,
// Calendar
  FETCH_RECORDS,
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

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
// Login
  fetchUserInfo ({ commit }, id) {
    return axios.get(`http://localhost:7777/member/mypage/${id}`).then(res => {
      cookies.set('session', res.data.id)
      commit(FETCH_USER_INFO, res.data)
    })
  },
  fetchSession ({ commit }, session) {
    commit(FETCH_SESSION, session)
  },

// Calendar
  fetchRecords ({ commit }) {
    return axios.get('http://localhost:7777/record/list').then(res => {
      commit(FETCH_RECORDS, res.data)
    })
  },
  fetchRecord ({ commit }, date) {
    return axios.get(`http://localhost:7777/record/${date}`).then(res => {
      commit(FETCH_RECORD, res.data)
    })
  },
  
// Recommend
  fetchRecommends ({ commit }) {
    return axios.get('http://localhost:7777/recommend/lists').then(res => {
      let recommends = []

      for (let i = 0; i < res.data.length; i++) {
        let list = { boardNo: res.data[i][0], id: res.data[i][1], 
          title: res.data[i][2], content: res.data[i][3], regDate: res.data[i][4] }
        
          recommends.push(list)
      }
      console.log(recommends)
      commit(FETCH_RECOMMENDS, recommends)
    })
  },
  fetchRecommend ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/recommend/read/${boardNo}`).then(res => {
 
      let recommend = { boardNo: res.data[0][0], id: res.data[0][1], title: res.data[0][2], 
        content: res.data[0][3], x: res.data[0][4], y: res.data[0][5], placeName: res.data[0][6], 
        address: res.data[0][7], regDate: res.data[0][8] }
      
      console.log(recommend)
      commit(FETCH_RECOMMEND, recommend)
    })
  },

// Together
  fetchTogethers ({ commit }) {
    return axios.get('http://localhost:7777/together/lists').then(res => {
      console.log(res.data)
      
      let togethers = []

      for (let i = 0; i < res.data.length; i++) {
        let list = { boardNo: res.data[i][0], id: res.data[i][1], 
          title: res.data[i][2], content: res.data[i][3], regDate: res.data[i][4] }
        
          togethers.push(list)
      }

      commit(FETCH_TOGETHERS, togethers)
      console.log(togethers)
    })
  },
  fetchTogether ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/together/read/${boardNo}`).then(res => {
      console.log(res.data)
      let together = { boardNo: res.data[0][0], id: res.data[0][1], title: res.data[0][2], 
        content: res.data[0][3], regDate: res.data[0][4] }
      
      console.log(together)
      commit(FETCH_TOGETHER, together)
    })
  },

// Comment
  fetchComments ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/comment/read/${boardNo}`).then(res => {
      console.log('commentList: ' + res.data)

      commit(FETCH_COMMENTS, res.data)
    })
  },
  fetchComment ({ commit }, commentNo) {
    return axios.get(`http://localhost:7777/comment/read/only/${commentNo}`).then(res => {
      console.log(res.data)

      commit(FETCH_COMMENT, res.data)
    })
  }
}