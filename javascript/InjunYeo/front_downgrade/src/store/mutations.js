import{
    ADD_TODO,
    EDIT_TODO,
    REMOVE_TODO,
    SET_EDITTING_ID,
    RESET_EDITTING_ID,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,
    //몬스터
    ADD_MONSTER,
    ADD_MANY_MONSTER,
    DEATH,
    //스프링 관련
    SUCCESS_GEN_RAND_NUM,
    FAIL_GEN_RAND_NUM,
    //board관련
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    //product관련
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,
    //판타지 온라인
    FETCH_MONSTER_LIST,
    FETCH_MONSTER,
    //랜덤 던전
    ALLOC_RANDOM_DUNGEON,
    //성적 관리
    SCORE_MANAGEMENT,
    CALC_MEAN,
    //크롤링
    CRAWL_START,

}from './mutation-types'

//여기는 동기처리를 하기 때문에 데이터 무결성이 보장됨
export default{
    [ADD_TODO] (state,payload){
        const { content } = payload
        state.todoItems.push({ id: state.nextTodoId, content, done: false })
        state.nextTodoId++
    },
    [REMOVE_TODO] (state,id){
        const targetIndex = state.todoItems.findIndex(v=> v.id === id)
        state.todoItems.splice(targetIndex, 1)
    },
    [EDIT_TODO] (state,payload){
        const {id,content} = payload
        const targetIndex = state.todoItems.findIndex(v =>  v.id === id)
        const targetTodoItem = state.todoItems[targetIndex]
        //splice를통해 지운다음 고친다.{ ...targetTodoItem,content } ->  ...targetTodoItem위치부터 content를 채워라 (... 뒤에남아있는것들이 전부다)
        state.todoItems.splice(targetIndex,1, { ...targetTodoItem,content })
    },
    [SET_EDITTING_ID] (state, id){
        state.editingId = id
    },
    [RESET_EDITTING_ID] (state){
        state.editingId = 0
    },
    [CLEAR_ALL](state){
        state.todoItems = []
    },
    [TOGGLE_TODO_STATUS] (state,id){
        //현재 todoItems 배열에서 id로 들어온 todoItem을 찾는다.

            const filtered = state.todoItems.filter(todoItem => {
                return todoItem.id === id
            })
            
            console.log(JSON.stringify(filtered))

            filtered.forEach(todoItem => {
                todoItem.done = !todoItem.done
            })
    }
    ,

    //몬스터 관련
    [ADD_MONSTER] (state,payload){
        const{ name } = payload
        state.monsterElements.push({ monsterId: state.nextMonsterId, name })
        state.nextMonsterId++
    },
    [ADD_MANY_MONSTER](state,payload){

        for(var i=0;i<payload.length;i++){
            state.monsterElements.push(payload[i])
                state.nextMonsterId++
        }
    },
    [DEATH](state,monsterId){
        const targetIndex = state.monsterElements.findIndex(v=> v.monsterId === monsterId)
        state.monsterElements.splice(targetIndex, 1,)
    },

    //스프링 랜덤 데이터 통신
    [SUCCESS_GEN_RAND_NUM] (state,payload){
        console.log('payload='+ payload)
        state.randomFromSpring = payload
    },
    [FAIL_GEN_RAND_NUM](){
        console.log('통신에러')
    },
    //board관련
    [FETCH_BOARD_LIST](state, boards){
        state.boards = boards;

    },
    [FETCH_BOARD](state,board){
        state.board = board
    },
    //product관련
    [FETCH_PRODUCT_LIST](state,products){
        state.products = products;
    },
    [FETCH_PRODUCT](state,product){
        state.product = product
    },
    // 판타지 온라인
    [FETCH_MONSTER_LIST] (state, monsters) {
        state.monsters = monsters
    },
    [FETCH_MONSTER] (state, monster) {
        state.monster = monster
    },
    // 랜덤 던전
    [ALLOC_RANDOM_DUNGEON] (state, dungeons) {
        state.dungeons = dungeons
    },
    //성적 관리
    [SCORE_MANAGEMENT] (state, students){
        state.students = students
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
    [CRAWL_START] (state, payload){
        state.lists = payload
    },

}