<template>
  <div class="todo">
    <li>
      <span v-if="!isEditing" v-on:dblclick="handleDoubleClick">
        {{ todoItem.content }}
      </span>
      <!-- blur: 입력창의 포커싱 제거 -->
      <input v-else type="text" ref="content" v-bind:value="todoItem.content"
        v-on:blur="handleBlur" v-on:keydown.enter="editTodo">
      <input type="checkbox" v-bind:checked="todoItem.done"
        v-on:change="toggleTodoStatus">
      <button v-on:click="removeTodo">Remove</button>
    </li>
  </div>
</template>


<script>

export default {
  name: 'TodoItem',
  // TodoList에서 전달한 값을 props로 받음(props는 bind로 전달)
  props: {
    todoItem: {
      type: Object
    },
    editingId: {
      type: Number
    }
  },
  // computed: VDOM의 변화가 없어도 계산값이 적용되도록 서포트
  computed: {
    isEditing () {
      return this.todoItem.id === this.editingId
    }
  },
  methods: {
    removeTodo () {
      const id = this.todoItem.id
      this.$emit('removeTodo', id)
    },
    editTodo (event) {
      const id = this.todoItem.id
      const content = event.target.value.trim()

      if (content.length <= 0) {
        return false
      }

      this.$emit('editTodo', content, id)
      this.$refs.content.blur()
    },
    handleBlur () {
      this.$emit('resetEditingId')
    },
    toggleTodoStatus () {
      const id = this.todoItem.id
      this.$emit('toggleTodoStatus', id)
    },
    handleDoubleClick () {
      const { id } = this.todoItem
      this.$emit('setEditingId', id)
      // nextTick: 한 텀 쉬고 동작    
      this.$nextTick(() => {
         this.$refs.content.focus()
      })
     
    }
  }
}
</script>


<style scoped>

button {
  background-color: pink;
}
</style>
