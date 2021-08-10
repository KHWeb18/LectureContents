<template>
    <div class="todo">
        <li>
            <!--Editing이 아니라면. 현재는 세팅(null, false)을 안해놔서 보이게되어있음.-->
            <span v-if="!isEditing" v-on:dblclick="handleDoubleClick">
                {{ todoItem.content }}
            </span>
            <input v-else type="text" ref="content"
                    v-bind:value="todoItem.content"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editTodo"/>
            
            <input type="checkbox"
                    v-bind:checked="todoItem.done"                
                    v-on:change="toggleTodoStatus()">
                    <!-- v-on:change - 입력이 되면 -->
                    <!--on:change는 checkbox의 변화를 감지한다.-->

            <button v-on:click="removeTodo">지우기</button>
        </li>
    </div>
</template>

<script>
export default {
    name: 'TodoItem',
    // bind로 연결한 값은 props로 받아온다.
    props: {
        todoItem: {
            //todoItem이 객체타입이다 (list, 배열)
            type: Object
        },                
        editingId: {
            type: Number
        }
    },
    // VDOM 변화가 없어도 계산값이 적용되도록 서포트함
    computed: {
        // TodoList에서 bind, mapState로 전달하고 있음 isEditing을. bind-props로 전달
        isEditing () {
            return this.todoItem.id === this.editingId
        }
    },
    methods: {
        removeTodo () {
            const id = this.todoItem.id
            //emit 하면 todoList로 가게된다.
            this.$emit('removeTodo', id)
        },
        // editTodo의 이벤트를 갖고있는것이 event
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
            console.log('toggleTodoStatus() - id: ' + id)

            this.$emit('toggleTodoStatus', id)
        },
        handleDoubleClick () {
            const { id } = this.todoItem
            console.log('handleDoubleClick() - id: ' + JSON.stringify(id))

            this.$emit('setEditingId', id)            
            // nextTick 잠깐 쉬었다가 동작(아주 짧음)
            this.$nextTick(() => {
                this.$refs.content.focus()
            })
        }
    }
}
</script>