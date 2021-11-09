export default {
// Todo
  filteredTodoItems (state) {
    if (!state.filter) {
      return state.todoItems
    }
  },

// Monster
  getMonsterElements (state) {
    return state.monsterElements
  },

// Spring
  randomFromSpring (state) {
    return state.randomFromSpring
  }
}