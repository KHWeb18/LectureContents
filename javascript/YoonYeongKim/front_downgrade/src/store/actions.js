import {
    // TODO
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,
    // 몬스터
    ADD_MONSTER,
    ADD_MANY_MONSTER,
    DEATH,
    // 스프링 랜덤 데이터 통신
    SUCCESS_GEN_RAND_NUM,
    FAIL_GEN_RAND_NUM,
    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    // 판타지 온라인
    FETCH_MONSTER_LIST,
    FETCH_MONSTER,
    // 랜덤 던전
    ALLOC_RANDOM_DUNGEON,
    // 성적 관리
    SCORE_MANAGEMENT,
    // 크롤링
    CRAWL_START
} from './mutation-types'

import axios from 'axios'
import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
    addTodo (context, payload) {
        context.commit(ADD_TODO, payload)
    },
    save ({ state }) {
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }
        // DB 대신 임시적으로 사용하고 있음
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    },
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    clearAll (context) {
        context.commit(CLEAR_ALL)
    },
    toggleTodoStatus ({ commit }, id) {
        commit(TOGGLE_TODO_STATUS, id)
    },
    // 판타지 온라인
    addMonster (context, payload) {
        context.commit(ADD_MONSTER, payload)
    },
    addManyMonster (context, payload) {
        context.commit(ADD_MANY_MONSTER, payload)
    },
    death ({ commit }, payload) {
        commit(DEATH, payload)
    },
    // Spring과 랜덤 데이터 통신
    generateRandomNumber ({ commit }) {
        console.log(commit)
        // axios.get: GET 요청
        // axios.post: POST 요청
        // 특정 URL로 GET 혹은 POST, 그 외의 요청을 보낼 수 있음
        // 보내고 넘겨 받은 데이터는 .then((res)) 절로 수신함
        // .catch((res)) 절은 오류가 발생했을 경우임
        // 어찌 되었든 응답받은 데이터는 res가 가지고 있음
        axios.get('http://localhost:7777/random')
                .then((res) => {
                    commit(SUCCESS_GEN_RAND_NUM, parseInt(res.data.randNumber))
                })
                .catch((res) => {
                    commit(FAIL_GEN_RAND_NUM, res)
                })
    },
    // 게시판
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/vueboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/vueboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    // 판타지 온라인
    fetchMonsterList ({ commit }) {
        return axios.get('http://localhost:7777/vuemonster/lists')
                .then((res) => {
                    commit(FETCH_MONSTER_LIST, res.data)
                })
    },
    fetchMonster ({ commit }, monsterNo) {
        return axios.get(`http://localhost:7777/vuemonster/${monsterNo}`)
                .then((res) => {
                    commit(FETCH_MONSTER, res.data)
                })
    },
    // 랜덤 던전
    randomDungeonList ({ commit }) {
        return axios.get('http://localhost:7777/vuedungeon/randomAlloc')
                .then((res) => {
                    commit(ALLOC_RANDOM_DUNGEON, res.data)
                })

            },
            // 성적 관리
            fetchStudentScoreList ({ commit }) {
                return axios.get('http://localhost:7777/vuescore/scoreManagement')
                        .then((res) => {
                            commit(SCORE_MANAGEMENT, res.data)
                        })
    },
    // 크롤링
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/daumCrawler' + `${category}`)
                .then(({ data }) => {
                    commit('CRAWL_START', data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    }        
}
