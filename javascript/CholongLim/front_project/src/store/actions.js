import {
    // 게시판
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  // 회원관리
  FETCH_MEMBER_LIST,
  FETCH_MEMBER,
  // 로그인
  LOGIN_SUCCESS,

  LOGIN_ERROR,
  LOGOUT,
   // 크롤링
   CRAWL_START,

} from './mutation-types'

import axios from 'axios'
import router from '../router'
import cookies from 'vue-cookies'




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
    fetchMember ({ commit }, memberNo) {
      return axios.get(`http://localhost:8888/memberManage/${memberNo}`)
              .then((res) => {
                  commit(FETCH_MEMBER, res.data)
              })
    },
  //로그인 시도
    //   getMemberInfo({commit}) {
    //     let token = localStorage.getItem("access_token")
    //     let config = {
    //         headers: {
    //             "access-token":token
    //         }
    //     }
    //     axios.post('http://localhost:8888/jpamember/needSession', config)
    //                     .then(response => {
    //                         let userInfo = {
    //                           userId: response.data.userId
    //                         }
    //                         commit(LOGIN_SUCCESS, userInfo)
    //                     }) 
    //                     .catch(error => {
    //                         // alert('이메일과 비밀번호를 확인하세요.')
    //                         console.log(error)
    //                     })
    // },
    // logout({commit}) {
    //   axios.post('http://localhost:8888/jpamember/removeSession')
    //   .then(res => {
    //         alert('로그아웃이 완료되었습니다.')
    //         console.log(res)
    //         commit(LOGOUT)
    //         cookies.remove("user")
    //         // let token = null
    //         // localStorage.setItem("access_token", token)
    //         router.push({name: 'MainPage'})
    //   })
    // },
    async login ( { commit },  { userId,password }) {
          axios.post('http://localhost:8888/jpamember/login', { userId, password})
                  .then(res => {
                      if(res.data != "") {
                          alert('로그인이 완료되었습니다.')
                          // console.log(res)
                          commit(LOGIN_SUCCESS)
                          // cookies.set("user",res.data)
                          this.state.session = res.data
                          // console.log(res.data)
                          // console.log(this.state.session.userId)
          
                      } else {
                          alert('아이디와 비밀번호를 확인해주세요.')
                          commit(LOGIN_ERROR)
  
                      }
                  })
                  .catch(res => {
                      console.log(res)
                  })
          
      },
    logout ({commit}) {
      cookies.remove("user")
      commit(LOGOUT)
      alert('로그아웃.')
      // this.$store.state.session = null

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
        
