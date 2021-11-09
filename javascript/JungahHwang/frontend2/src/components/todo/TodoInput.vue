<template>
  <div>
    <h3>Todo Input</h3>
    <input type="text" v-model="newTodoItem" v-on:keypress.enter="addTodo">
    <button v-on:click="addTodo">Add</button>
  </div>
</template>


<script>
export default {
  data () {
    return {
      newTodoItem: ''
    }
  },
  methods: {
    addTodo () {
      if (this.newTodoItem !== '') {
        // trim: 문자열에서 선행, 후행, 공백, 줄, 종결자 문자를 제거
        var value = this.newTodoItem && this.newTodoItem.trim()
        console.log('addTodo')

        // emit: 'addTodo' 이벤트가 발생하면 상위 컴포넌트의 onAddTodo() 메소드가 수신
        this.$emit('addTodo', value)
        this.clearInput()
      }
    },
    clearInput () {
      this.newTodoItem = ''
    }
  }
}
</script>