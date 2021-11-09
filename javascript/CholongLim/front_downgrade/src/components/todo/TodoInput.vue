<template>
  <div>
    <h3>Todo 입력</h3>
    <!-- v-model: 양방향 -->
    <input type="text" v-model="newTodoItem" v-on:keypress.enter="addTodo">
    <button v-on:click="addTodo">추가</button>
  </div>
</template>

<script>

export default {
  data () {
    return {
      newTodoItem: '',
    }
  },
  methods: {
    addTodo () {
      if (this.newTodoItem !== ''){
        var value = this.newTodoItem && this.newTodoItem.trim()
        console.log('addTodo')

        // emit의 역할은 무엇인가?
        // 본인을 둘러싼 컴퍼넌트한테 정보를 준다. = TodoInput
        // emit된 결과는 Todo.vue로 넘어간다.
        this.$emit('addTodo', value)
        this.clearInput()
      }
    },
    clearInput() {
        this.newTodoItem = ''
    }
  }
}

</script>