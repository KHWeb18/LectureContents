import{
        // 게시판
        FETCH_BOARD_LIST,
        FETCH_BOARD,
            // 크롤링
    CRAWL_START
} from  './mutation-types'
import router from '../router/index'
import axios from 'axios'

export default{
        // 게시판
        fetchBoardList({ commit }) {
            return axios.get('http://localhost:1111/vueboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
        },
        fetchBoard({ commit }, boardNo) {
            return axios.get(`http://localhost:1111/vueboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
        },
    // 크롤링

    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:1111/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    },

    login({state, commit }, loginObj) {
        let selectedUser = null
        state.allUsers.forEach(user => {
            if (user.id === loginObj.id) selectedUser= user
        })
       if (selectedUser === null || selectedUser.password !== loginObj.password)
         commit("loginError")
        else{
            commit("loginSuccess")
            router.push({name: "MyPage"})
        } 
    
    }
}