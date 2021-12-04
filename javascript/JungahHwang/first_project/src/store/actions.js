import {
// Login
  FETCH_USER_INFO,
  FETCH_SESSION,
// Record
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
  FETCH_TOGETHER_COMMENT,
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

// Record
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
      commit(FETCH_RECOMMENDS, res.data)
    })
  },
  fetchRecommend ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/recommend/read/${boardNo}`).then(res => {
      commit(FETCH_RECOMMEND, res.data)
    })
  },

// Together
  fetchTogethers ({ commit }) {
    return axios.get('http://localhost:7777/together/lists').then(res => {
      commit(FETCH_TOGETHERS, res.data)
    })
  },
  fetchTogether ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/together/read/${boardNo}`).then(res => {
      console.log(res.data)
      commit(FETCH_TOGETHER, res.data)
    })
  },

// Comment
  fetchRecommendComments ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/recommend/comment/read/${boardNo}`).then(res => {
      commit(FETCH_RECOMMEND_COMMENTS, res.data)
    })
  },
  fetchRecommendComment ({ commit }, commentNo) {
    return axios.get(`http://localhost:7777/recommend/comment/read/only/${commentNo}`).then(res => {
      commit(FETCH_RECOMMEND_COMMENT, res.data)
    })
  },
  fetchTogetherComments ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/together/comment/read/${boardNo}`).then(res => {
      commit(FETCH_TOGETHER_COMMENTS, res.data)
    })
  },
  fetchTogetherComment ({ commit }, commentNo) {
    return axios.get(`http://localhost:7777/together/comment/read/only/${commentNo}`).then(res => {
      commit(FETCH_TOGETHER_COMMENT, res.data)
    })
  },
}