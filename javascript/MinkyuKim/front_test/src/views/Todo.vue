<template>
    <div class="todo">
        <todo-header></todo-header>
        <!-- todo-input 컴포넌트가 emit(addTodo, ~~)를 하면 onAddTodo()가 동작 -->
        <todo-input v-on:addTodo="onAddTodo"></todo-input>
        <!-- 이부분을 작성했다는 것은 todo-list에서 emit이 발생한다는 것
        (emit-removeTodo / emit-updateTodo) 해당부분을 받기 위하여 emit을 사용함
        emit에 의하여 rmoveTodo와 editTodo를 받으면 on~가 실행됨-->        
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
        // store에서 중앙 관리를 하고
        // 중앙 관리에 사용하는 동작들을 action에 몰아넣음
        //... + map + 옵션   ...은 store에 있는 action에 맵핑(map)하겠다.
        // mapAction에 아래항목을 넣은 목적은 중앙(store/states.js)에서 컨트롤하기 위하여. 즉 핵심데이터는 states.js를 보면 알 수 있음)
        // 뷰는 데이터를 중앙관리, 리액트는 중앙관리를 하지못한다는 차이점이 있음
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
        onToggleTodoStatus (id) {
            this.toggleTodoStatus(id)
            this.save()    
        }    
    }
}

</script>

<style>
/*
body {
    text-align: center;
    background-color: #CEDEBD;
}
*/
</style>