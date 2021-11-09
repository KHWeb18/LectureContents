import {
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,

    KILL_MONSTER,
    ADD_MONSTER,
    SUMMON_MANY_MONSTERS,
    EDIT_NAME,
    TOGGLE_MONSTER_STATUS,
    CLEAR_ALL_MONSTER,

    SUCCESS_GEN_RAN_NUM,
    FAIL_GEN_RAN_NUM,

    FETCH_BOARD_LIST,
    FETCH_BOARD,

    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    FETCH_MONSTER_STORAGE,
    FETCH_MONSTER,

    FETCH_DUNGEON_LIST,

    FETCH_STUDENT_LIST,

    CRAWL_START
} from './mutation-types'

import axios from 'axios'
import router from '../router'

export default {
    addTodo (context, payload) { //payload는 todoItem, context는 별로 중요하진 않다.
        context.commit(ADD_TODO, payload)
    },
    save ({ state }) {
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    },
    //밑의 메소드 작성 형식 2개 아무거나 사용하면 된다.
    
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    clearAll(context) {
        context.commit(CLEAR_ALL) 
    },
    toggleTodoStatus ({ commit }, payload) {
        commit(TOGGLE_TODO_STATUS, payload) //payload -> id
    },
    
    generateRandomNumber ({ commit }) {
        console.log(commit)

        axios.get('http://localhost:7777/random')
            .then((res) => {
                commit(SUCCESS_GEN_RAN_NUM, parseInt(res.data.ranNumber))
                //localhost:7777에서 받은 ranNumber값을 int로 변환해 mutation에 있는 SUCCESS_GEN으로 넘긴다.
                //commit은 mutation에 있는 메소드로 가란 뜻. import로 mutation에 있는 메소드를 받아왔기 때문임.
            })
            .catch((res) => {
                commit(FAIL_GEN_RAN_NUM, res)
            })
    },

    
    addMonster ({ commit }, payload) {
        commit(ADD_MONSTER, payload)
    },
    summonManyMonsters ({ commit }, payload) {
        commit(SUMMON_MANY_MONSTERS, payload)
    },
    killMonster ({ commit }, payload) {
        commit(KILL_MONSTER, payload)
    },
    editName ({ commit }, payload) {
        commit(EDIT_NAME, payload)
    },
    clearAllMonster(context) {
        context.commit(CLEAR_ALL_MONSTER) 
    },
    toggleMonsterStatus({ commit }, payload) {
        commit(TOGGLE_MONSTER_STATUS, payload)
    },

    fetchBoardList ({ commit }) { //commit의 뜻은 mutation하는것
        return axios.get('http://localhost:7777/vueboard/list')
            .then((res) => {
                commit(FETCH_BOARD_LIST, res.data)
            })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/vueboard/${boardNo}`) //인자를 받을 때는 ``를 사용한다.
            .then((res) => {
                commit(FETCH_BOARD, res.data)
                //res는 불러온 서버에서 불러온 데이터
                //res데이터를 mutation에 있는 FETCH_BOARD 메소드로 전송
            })
    },

    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/vuemember/list')
        .then((res) => {
            commit(FETCH_MEMBER_LIST, res.data)
        })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/vuemember/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
            })
    },

    fetchMonsterStorage ({ commit }) {
        return axios.get('http://localhost:7777/vuemonster/storage')
        .then((res) => {
            commit(FETCH_MONSTER_STORAGE, res.data)
        }) 
    },
    fetchMonster ({ commit }, monsterNo) {
        return axios.get(`http://localhost:7777/vuemonster/${monsterNo}`)
        .then((res) => {
            commit(FETCH_MONSTER, res.data)
        })
    },

    fetchDungeonList ({ commit }) {
        return axios.get('http://localhost:7777/vuedungeon/list')
        .then((res) => {
            commit(FETCH_DUNGEON_LIST, res.data)
        })
    },

    fetchStudentList ({ commit }) {
        return axios.get('http://localhost:7777/vuestudent/list')
        .then((res) => {
            commit(FETCH_STUDENT_LIST, res.data)
        })
    },

    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    }
}

//action에 있는 것들은 비동기처리 - 대충 보여져도 된다면 action에
//mutation에 있는 것들은 동기처리 - 무결성이 중요하다면 mutation에