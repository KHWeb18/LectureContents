import {
    // 게시판
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  // 회원관리
  FETCH_MEMBER_LIST,
  FETCH_MEMBER,
  // 로그인
  LOGIN_SUCCESS,

  // LOGIN_ERROR,
  LOGOUT,
   // 크롤링
   CRAWL_START,

} from './mutation-types'

import axios from 'axios'
import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
     // 게시판
     fetchBoardList ({ commit }) {
        return axios.get('http://localhost:8888/board/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
      },
      fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:8888/board/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
      },
      // 회원관리
     fetchMemberList ({ commit }) {
      return axios.get('http://localhost:8888/memberManage/lists')
              .then((res) => {
                  commit(FETCH_MEMBER_LIST, res.data)
              })
    },
    fetchMember ({ commit }, boardNo) {
      return axios.get(`http://localhost:8888/memberManage/${boardNo}`)
              .then((res) => {
                  commit(FETCH_MEMBER, res.data)
              })
    },
       // 로그인 연습
  //로그인 시도
      getMemberInfo({commit}) {
        let token = localStorage.getItem("access_token")
        let config = {
            headers: {
                "access-token":token
            }
        }
        axios.post('http://localhost:8888/jpamember/needSession', config)
                        .then(response => {
                            let userInfo = {
                              userId: response.data.userId
                            }
                            commit(LOGIN_SUCCESS, userInfo)
                        }) 
                        .catch(error => {
                            // alert('이메일과 비밀번호를 확인하세요.')
                            console.log(error)
                        })
    },
    logout({commit}) {
      axios.post('http://localhost:8888/jpamember/removeSession')
      .then(res => {
            alert('로그아웃이 완료되었습니다.')
            console.log(res)
            commit(LOGOUT)
            let token = null
            localStorage.setItem("access_token", token)
            router.push({name: 'MainPage'})
      })
    },
    // 크롤링
  async crawlFind ({ commit }, category) {
    axios.get('http://localhost:8888/' + `${category}`)
            .then(({ data }) => {
                commit(CRAWL_START, data)

                if (window.location.pathname !== '/tourCrawler') {
                    router.push('/tourCrawler')
                }
            })
  },
}
        
