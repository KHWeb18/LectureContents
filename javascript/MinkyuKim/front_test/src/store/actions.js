import {
    // TODO
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,

    CLEAR_ALL,
    TOGGLE_TODO_STATUS,
    // 몬스터
    ADD_MONSTER,
    DEATH,
    ADD_MANY_MONSTER,

    // 스프링 랜덤 데이터 통신
    SUCCESS_GEN_RAND_NUM,
    FAIL_GEN_RAND_NUM,

    //게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    
    //상품
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,

    // 판타지 온라인
    FETCH_MONSTER_LIST,
    FETCH_MONSTER,

    // 랜덤 던전
    ALLOC_RANDOM_DUNGEON,

    // 성적 관리
    SCORE_MANAGEMENT,
    CALC_MEAN,

    // 크롤링
    CRAWL_START


} from './mutation-types'

import axios from 'axios'
import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {

    // 여기있는 payload는 Todo.vue의 this.addTodo(todoItem)  todoItem이다
    addTodo (context, payload) {
        // 즉 여기서 payload는 창에서 입력한 데이터이다
        context.commit(ADD_TODO, payload)
    },
    save ({ state }) {
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }
        // localstorage를 db대신 임시적으로 사용하고 있음
        // todoitem nextTodoId값을 저장하고 있음
        // 괄호안의 경우 hash set과 같이 키 벨류값을 의미함.
        // DB 대신 임시적으로 사용하고 있음음
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    },
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    //그냥 commit으로 뮤테이션을 호출할거면 {commit}으로 작성해야하고,
    // 아니면 그냥 context.commit으로 호출하면 된다(동일하다)
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    clearAll (context) {
        //commit을 하게되면 mutation이 바로 작동하게 됨.
        context.commit(CLEAR_ALL)
    },
    toggleTodoStatus ({commit }, id) {
        commit(TOGGLE_TODO_STATUS, id)
    },

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
        
        // axios.get : GET 요청
        // axios.post: POST 요청
        // 특정 URL로 GET 혹은 POST, 그 외의 요청을 보낼 수 있음
        // 보내고 넘겨 받은 데이터는 .then((res)) 절로 수신함
        // .catch((res)) 절은 오류가 발생했을 경우임
        // 어찌 되었든 응답받은 데이터는 res가 가지고 있음        
        // get요청을 날리게 되면 스프링에 있는 /random을 맵핑한 컨트롤러로 날아가게 된다(VueCommController))
        axios.get('http://localhost:7777/random')
                    // 생성된 random 데이터는 res에 들어가게됨. randNumber는 entity의 변수인 randNumber를 의미함.
                    .then((res) => { 
                        // commit을 하면 mutation에 있는 SUCCESS_GEN_RAND_NUM으로 넘어가게됨.
                        // parseInt 값으로
                        commit(SUCCESS_GEN_RAND_NUM, parseInt(res.data.randNumber))
                    })
                    .catch((res) => {
                        commit(FAIL_GEN_RAND_NUM, res)
                    })
        
    },
    // 게시판
    // {commit} 은 뮤테이션 하는 거
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
    
    // 상품
    fetchProductList ({ commit }) {
        return axios.get('http://localhost:7777/vueproduct/lists')
                .then((res) => {
                    commit(FETCH_PRODUCT_LIST, res.data)
                })
    },
    fetchProduct ({ commit }, productNo) {
        return axios.get(`http://localhost:7777/vueproduct/${productNo}`)
                .then((res) => {
                    commit(FETCH_PRODUCT, res.data)
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
    fetchStudentScoreList ({ commit }) {
        return axios.get('http://localhost:7777/vuescore/scoreManagement')
                .then((res) => {
                    commit(SCORE_MANAGEMENT, res.data)
                })
    },
    [CALC_MEAN] (state) {
        state.mean = 0
        var tmp = 0
        var len = state.students.length

        for (var i = 0; i < len; i++) {
            tmp += state.students[i].score
        }

        state.mean = tmp / len
    },
    //크롤링
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/' + `${category}` )
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    }
    
}