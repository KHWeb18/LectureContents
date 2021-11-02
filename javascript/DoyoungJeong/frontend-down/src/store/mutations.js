import {
    ADD_TODO,
    EDIT_TODO,
    REMOVE_TODO,
    SET_EDITTING_ID,
    RESET_EDITTING_ID,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,

    KILL_MONSTER,
    ADD_MONSTER,
    SUMMON_MANY_MONSTERS,
    EDIT_NAME,
    CLEAR_ALL_MONSTER,
    TOGGLE_MONSTER_STATUS,

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

export default {
    [ADD_TODO] (state, payload) {
        const { content } = payload
        state.todoItems.push({ id: state.nextTodoId, content, done: false })
        state.nextTodoId++
    },
    [REMOVE_TODO] (state, id) {
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        //인자로 받은 id값과 todoItems에서 같은 id값을 가진 index 순서를 찾는다.

        //state.todoItems.splice(id-1, 1) --> 이 방식은 안됨 왜 안될까?
        //안될 수밖에 없다. todoItems에서 splice를 하면 index번호가 서로 바뀌기 때문에 id-1로 없애고자 하는 대상이 splice(id-1, 1)과 겹치지 않는다.
        state.todoItems.splice(targetIndex, 1)
    },
    [EDIT_TODO] (state, payload) {
        const { id, content } = payload
        //payload는 바뀐 id와 content값을 모두 가진 todoItem객체인가?? --> 객체로 받을 때는 payload를 쓰는것같다.
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        const targetTodoItem = state.todoItems[targetIndex]
        state.todoItems.splice(targetIndex, 1, { ...targetTodoItem, content })
        //targetIndex번호의 항을 하나 지우고 targetTodoItem을 밀어내고 content를 그 항에 넣는다.. 맞나?
        //targetTodoItem의 자리부터 content를 넣는다는 뜻이다.
        //...의 뜻은? 뒤에 남아있는 것들 전부 다!를 뜻하는 것이다. 여러개를 지울 떄 ...이 필요하다.
        //하나만 지울때는 그냥 content만 써도 된다.
    },
    [SET_EDITTING_ID] (state, id) {
        state.editingId = id
    },
    [RESET_EDITTING_ID] (state) {
        state.editingId = 0
    },
    [CLEAR_ALL] (state) {
        state.todoItems = []
    },
    [TOGGLE_TODO_STATUS] (state, id) {
        const filtered = state.todoItems.filter(todoItem => {
            return todoItem.id === id 
        })
        //인자 id값과 같은 id를 return 후,
        //todoItems배열에서 인자 id로 들어온 값만큼의 인덱스 값을가진(리턴된 값의) todoItem을 구한다.

        console.log('filtered: ' + JSON.stringify(filtered))

        filtered.forEach(todoItem => {
            todoItem.done = !todoItem.done
        })
    },


    [ADD_MONSTER] (state, payload) {
        const { name } = payload
        state.monsterElements.push({ monsterId: state.nextMonsterId, name, done: false })
        console.log('nextMonsterId: ' + state.nextMonsterId)
        state.nextMonsterId++
    },
    [SUMMON_MANY_MONSTERS] (state, payload) { //숙제부분
        for(var i=0; i<payload.length; i++) {
            state.monsterElements.push({ monsterId: state.nextMonsterId, name: payload[i].name, hp: payload[i].hp })
            console.log('nextMonsterId: ' + state.nextMonsterId)
            state.nextMonsterId++
        }
    },
    [KILL_MONSTER] (state, monsterId) {
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        state.monsterElements.splice(targetIndex, 1)
    },
    [EDIT_NAME] (state, payload) {
        const { monsterId, name } = payload
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        const targetMonsterElem = state.monsterElements[targetIndex]
        state.monsterElements.splice(targetIndex, 1, { ...targetMonsterElem, name })
    },
    [CLEAR_ALL_MONSTER] (state) {
        state.monsterElements = []
    },
    [TOGGLE_MONSTER_STATUS] (state, monsterId) {
        const filtered = state.monsterElements.filter(monsterElem => {
            return monsterElem.monsterId === monsterId
        })

        filtered.forEach(monsterElem => {
            monsterElem.done = !monsterElem.done
        })
    },

    [SUCCESS_GEN_RAN_NUM] (state, payload) {
        console.log('payload = ' + payload)
        state.randomFromSpring = payload
    },
    [FAIL_GEN_RAN_NUM] () {
        console.log('Connection ERROR!')
    },

    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },

    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },

    [FETCH_MONSTER_STORAGE] (state, monsters) {
        state.monsters = monsters
    },
    [FETCH_MONSTER] (state, monster) {
        state.monster = monster
    },

    [FETCH_DUNGEON_LIST] (state, dungeons) {
        state.dungeons = dungeons
    },

    [FETCH_STUDENT_LIST] (state, students) {
        state.students = students
    },

    [CRAWL_START] (state, payload) {
        state.lists = payload
    }
}

//action에 있는 것들은 비동기처리 - 대충 보여져도 된다면 action에
//mutation에 있는 것들은 동기처리 - 무결성이 중요하다면 mutation에