<template>
    <div class="todo">
        <todo-header></todo-header>
        <todo-input v-on:addTodo="onAddTodo"></todo-input>
        <todo-list
                v-on:removeTodo="onRemoveTodo"
                v-on:editTodo="onEditTodo"
                v-on:toggleTodoStatus="onToggleTodoStatus">
        </todo-list>
        <todo-footer v-on:removeAll="onClearAll"></todo-footer>
    </div>
</template>

<script>
import TodoHeader from '../components/todo/TodoHeader.vue'
import TodoInput from '../components/todo/TodoInput.vue'
import TodoList from '../components/todo/TodoList.vue'
import TodoFooter from '../components/todo/TodoFooter.vue'

import { mapActions } from 'vuex'
export default {
    name: 'Todo',
    components: {
        'todo-header': TodoHeader,
        'todo-input': TodoInput,
        'todo-list': TodoList,
        'todo-footer': TodoFooter
    },
    methods: {
        ...mapActions ([
            'addTodo',
            'removeTodo',
            'editTodo',
            'save',
            'clearAll',
            'toggleTodoStatus'
        ]),
        onAddTodo (content) {
            const todoItem = { content }
            this.addTodo(todoItem)
            this.save()
        },
        onRemoveTodo (id) {
            this.removeTodo(id)
            this.save()
        },
        onEditTodo (content, id) {
            this.editTodo({ id, content })
            this.save()
        },
        onClearAll () {
            this.clearAll()
            this.save()
        },
        onToggleTodoStatus(id) {
            this.toggleTodoStatus(id)
            this.save()
        }
        
    }
}
</script>

<style>
body {
    text-align: center;
    background-color: #CEDEBD;
}
</style>