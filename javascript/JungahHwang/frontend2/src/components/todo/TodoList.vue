<template>
  <div>
    <ul>
      <h3>Todo List</h3>
      <!-- TodoItem에 값을 전달할 때 bind를 사용 -->
      <todo-item v-for="todoItem in todoItems" v-bind:key="todoItem.id" 
        v-bind:todoItem="todoItem" v-bind:editingId="editingId" 
        v-on:removeTodo="onRemoveTodo" v-on:editTodo="onEditTodo"
        v-on:setEditingId="SET_EDITING_ID" v-on:resetEditingId="RESET_EDITING_ID"
        v-on:toggleTodoStatus="onToggleTodoStatus">
      </todo-item>
    </ul>
  </div>
</template>


<script>
import TodoItem from './TodoItem.vue'

import { mapState, mapMutations, mapGetters } from 'vuex'
import { SET_EDITING_ID, RESET_EDITING_ID } from '../../store/mutation-types'

export default {
  components: {
    'todo-item': TodoItem
  },
  // computed: VDOM의 변화가 없어도 계산값이 적용되도록 서포트(복잡한 계산은 하지 않음)
  computed: {
    ...mapGetters ([
      'filteredTodoItems'
    ]),
    ...mapState ([
      // editingId를 state에서 중앙관리
      'editingId'
    ]),
    todoItems () {
      return this.filteredTodoItems
    },
  },
  methods: {
    ...mapMutations ([
      SET_EDITING_ID,
      RESET_EDITING_ID
    ]),
    onRemoveTodo (id) {
      this.$emit('removeTodo', id)
    },
    onEditTodo (content, id) {
      this.$emit('editTodo', content, id)
    },
    onToggleTodoStatus (id) {
      this.$emit('toggleTodoStatus', id)
    }
  }
}
</script>