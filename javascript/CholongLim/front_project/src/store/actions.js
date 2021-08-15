import {
    // 게시판
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  // 로그아웃 로그인
  LOGIN,
  // 크롤링
  CRAWL_START

} from './mutation-types'

import axios from 'axios'
// import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
     // 게시판
     fetchBoardList ({ commit }) {
        return axios.get('http://localhost:8888/jpaboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
      },
      fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:8888/jpaboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
      },
      login({ commit }) {
          return axios.post('http://localhost:8888/jpamember/needSession')
              .then(res => {
                if (res.data == true) {
                  commit(LOGIN, res.date)
                  alert('세션 정보 유지! - ' + res.data)
                }  else {
                  alert('세션 정보 유지 안되는 중! - ' + res.data)
                }
              })
              .catch(res => {
                  alert(res.response.data.message)
              })
      },
      async crawlFind ({ commit }, category) {
        axios.get('http://localhost:8888/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)
    
                    if (window.location.pathname !== '/daumNewsCrawler') {
                        // router.push('/daumNewsCrawler')
                        this.$router.push({
                          name: 'DaumNewsCrawlerPage'
                        })
                      }
                    })
          }
        }
