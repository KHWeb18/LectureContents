export default {
    filteredTodoItems (state) {
        //별도의 filter가 없으면 todoitems를 걍 가져온다
        if (!state.filter) {
            return state.todoItems
        }
    },
    getMonsterElements (state) {
        return state.monsterElements
    },
    randomFromSpring (state) {
        return state.randomFromSpring
    },
    AreaFromSpring (state) {
        return state.AreaFromSpring
    }
}