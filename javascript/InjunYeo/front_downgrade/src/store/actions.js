import {
    ADD_TODO,
    REMOVE_TODO,
    EDIT_TODO,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,
    //몬스터
    DEATH,
    ADD_MONSTER,
    ADD_MANY_MONSTER,
    //스프링관련
    SUCCESS_GEN_RAND_NUM,
    FAIL_GEN_RAND_NUM,
    //board 관련
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    //product 관련
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,
    //판타지온라인
    FETCH_MONSTER_LIST,
    FETCH_MONSTER,
    ALLOC_RANDOM_DUNGEON,
    //성정 관리 시스템
    SCORE_MANAGEMENT,
    //크롤링
    CRAWL_START,

    

} from './mutation-types'

import axios from 'axios'
import router from '../router'

//보통 action에서 처리하는 것은 비동기 처리를 함
export default{
    addTodo (context,payload){
        //자바스크립트에서 사용하는 동작의 흐름 context
        context.commit(ADD_TODO,payload)
        //커밋을 하면 뮤테이션으로 넘어감
    },
    save( {state} ){
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }
        
        //DB 대신 임시적으로 사용하고 있음
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    },
    removeTodo(context,payload){
        context.commit(REMOVE_TODO,payload)
    },
    //context를 안쓰려면 {{commit}} 객체로 받아야한다.
    editTodo({commit},payload){
        commit(EDIT_TODO,payload)
    },
    crearAll({commit}){
        commit(CLEAR_ALL)
    },
    toggleTodoStatus({commit},id){
        commit(TOGGLE_TODO_STATUS,id)
    },

    //몬스터 관련
    addMonster (context,payload){
        //자바스크립트에서 사용하는 동작의 흐름 context
        context.commit(ADD_MONSTER,payload)
        //커밋을 하면 뮤테이션으로 넘어감
    },
    addManyMonster(context,payload){
        context.commit(ADD_MANY_MONSTER,payload)
    },
    death({commit},payload){
        commit(DEATH,payload)
    },

    //Spring과 랜덤 데이터 통신
    generateRandomNumber({commit}){
        console.log(commit)
        
        //axios.get: GET 요청
        //axios.post: POST 요청
        //특정URL로 GET혹은 POST, 그외의 요청을 보낼수 있음
        //보내고 넘겨 받은 데이터는 .then((res))절로 수신함
        //.catch((res))절은 오류가 발생했을 경우
        //결국은 응답받은 데이터는 res가 가지고있음
        axios.get('http://localhost:7777/random')
                .then((res)=>{
                    commit(SUCCESS_GEN_RAND_NUM, parseInt(res.data.randNumber)) //randNumber 는 spring entity에서 보내는 데이터의 값을 가지고있음
                })
                .catch((res) => {
                    commit(FAIL_GEN_RAND_NUM,res)
                })
    },
    //게시판
    fetchBoardList({commit}){
        return axios.get('http://localhost:7777/vueboard/lists')
                .then((res)=> {
                    commit(FETCH_BOARD_LIST,res.data)
                })
    },
    fetchBoard({commit},boardNo){
        //가변형태가 들어갈때는 ` 으로 써야한다.
        return axios.get(`http://localhost:7777/vueboard/${boardNo}`)
                .then((res)=>{
                    commit(FETCH_BOARD,res.data)
                })
    },

    //product
    fetchProductList({commit}){
        return axios.get('http://localhost:7777/vueproduct/lists')
            .then((res)=> {
                commit(FETCH_PRODUCT_LIST,res.data)
            })

    },
    fetchProduct({commit},productNo){
        //가변형태가 들어갈때는 ` 으로 써야한다.
        return axios.get(`http://localhost:7777/vueproduct/${productNo}`)
                .then((res)=>{
                    commit(FETCH_PRODUCT,res.data)
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
    randomDungeonList({commit}) {
        return axios.get('http://localhost:7777/vuedungeon/randomAlloc')
                .then((res) => {
                    commit(ALLOC_RANDOM_DUNGEON,res.data)
                })
    },
    //성적관리
    fetchStudentScoreList ({ commit }) {
        return axios.get('http://localhost:7777/vuescore/scoreManagement')
                .then((res) => {
                    commit(SCORE_MANAGEMENT, res.data)
                })
    },
    //크롤링
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    },
}
