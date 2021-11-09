export default {
    filteredTodoItems (state) {
        // 필터가 세팅되어 있지않다면
        if (!state.filter) {
            return state.todoItems
        }
    },
    getMonsterElements (state) {
        return state.monsterElements
    },
    randomFromSpring (state) {
        return state.randomFromSpring
    }
}