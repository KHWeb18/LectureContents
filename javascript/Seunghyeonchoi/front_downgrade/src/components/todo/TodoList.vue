<template>
    <div>
        <ul>
            <h3>해야할 일 리스트</h3>
            <!-- todoitem in todoitems : 아 mapgetters에 있는 filteredTodoItems에 있는 걸 가져온다 
                  최종적으론 thistodoitems로 대체된다-->
            <todo-item v-for="todoItem in todoItems"
                    v-bind:key="todoItem.id"
                    v-bind:todoItem="todoItem"
                    v-bind:editingId="editingId"
                    v-on:removeTodo="onRemoveTodo"
                    v-on:editTodo="onEditTodo"
                    v-on:setEditingId="SET_EDITTING_ID"
                    v-on:resetEditingId="RESET_EDITTING_ID"
                    v-on:toggleTodoStatus="onToggleTodoStatus"/>
        </ul>
    </div>
</template>

<script>
import TodoItem from './TodoItem.vue'
import { mapState, mapMutations, mapGetters } from 'vuex'
import { RESET_EDITTING_ID, SET_EDITTING_ID } from '../../store/mutation-types'
export default {
    components: {
        'todo-item': TodoItem
    },
    //computed의 용도가 뭐야? 
     computed: {
        ...mapGetters ([
            'filteredTodoItems'
        ]),
        ...mapState ([
            'editingId'
        ]),
        todoItems () {
            return this.filteredTodoItems
        }
    },
    methods: {
        ...mapMutations ([
            SET_EDITTING_ID,
            RESET_EDITTING_ID
        ]),
        onRemoveTodo (id) {
        //todolist를 감싸고 있는 애는 누구? todo지 todo로 가자
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