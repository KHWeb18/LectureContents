export default { 
    filteredTodoItems(state) {
        if(!state.filter) {
            return state.todoItems
            //질문 2.
            //state에 있는 filter는 null
            //state에 있는 filter가 null이 아니면 TodoList컴포넌트의 computed에서 todoItem()을 통해 todoItems를 즉각적으로 반환해 출력하란 뜻인가요?
            //여기는 아직 미구현된 부분이다.
        }
    },
    getMonsterElements(state) {
        return state.monsterElements
    },
    randomFromSpring(state) {
        return state.randomFromSpring
    }
}

//getters는 state에 있는 정보들을 가져온다.