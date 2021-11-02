<template>
    <div>
        <ul>
            <h3>해야할 일 리스트</h3>
            <!-- props로 todoItem(객체)과 editingId(id에 대한 Number값 로 받아왔음. 즉 bind로 연결한 것은 props로 인식시켜 받아온다.
                 todoItems(getters에 있는 것.배열)에 있는것을 todoItem에 하나씩 넣는다.-->

                 <!-- emit에 따라서 해당 이벤트(v-on)를 작동시킴 -->
                 <!-- 이와같은 일련의 과정들은 일괄적으로 처리됨. -->
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
    // computed의 용도 : VDOM이 없어도 결과값이 계산되게함.(복잡한것을 계산시키면 안됨)
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