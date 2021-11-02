<template>
    <div class="todo">
        <todo-header></todo-header>
        <!-- todo-input 컴포넌트가 emit(addTodo,~~)를 하면 onAddTodo()가 동작 
            v-on:() 을 발생시켰을때 하는것
        -->
        <todo-input v-on:addTodo="onAddTodo"></todo-input>
        <todo-list
            v-on:removeTodo="onRemoveTodo"
            v-on:editTodo="onEditTodo"
            v-on:toggleTodoStatus="onToggleTodoStatus"
        ></todo-list>
        <todo-footer v-on:removeAll="onClearAll"></todo-footer>
    </div>
</template>

<script>


import TodoHeader from '../components/todo/TodoHeader.vue'
import TodoInput from '../components/todo/TodoInput.vue'
import TodoList from '../components/todo/TodoList.vue'
import TodoFooter from '../components/todo/TodoFooter.vue'


import {mapActions} from 'vuex'

export default {
    name: 'Todo',
    components: {
        'todo-header' : TodoHeader,
        'todo-input' : TodoInput,
        'todo-list' : TodoList,
        'todo-footer' : TodoFooter
    },
    methods:{
        //store 에서 중앙 관리를 하고,
        //중앙 관리에 사용하는 동작들을 action에 몰아넣음
        ...mapActions([
            
            'addTodo',
            'removeTodo',
            'editTodo',
            'crearAll',
            'toggleTodoStatus',
            'save'
        ]),
        //content는 입력값인데 value='onAddTodo' 로 된건가?
        onAddTodo (content) {
            //const는 값을바꾸기 싫은 변수 like final
            const todoItem = { content }
            this.addTodo( todoItem )
            this.save()
        },
        onRemoveTodo(id) {
            this.removeTodo(id)
            this.save()
        },
        onEditTodo (content,id) {
            this.editTodo({ id,content })
            this.save()
        },
        onToggleTodoStatus(id){
            this.toggleTodoStatus(id)
            this.save()
        },
        onClearAll(){
            this.crearAll()
            this.save()

        }

    }
}
</script>

<style>
/*
body {
    text-align: center;
    background-color:#CEDEBD;
}
*/
</style>