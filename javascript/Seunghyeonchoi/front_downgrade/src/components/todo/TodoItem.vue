<template>
    <div class="todo">
        <li>
             <span v-if="!isEditing" v-on:dblclick="handleDoubleClick">
                <!-- editing이 아니라면 todoItem.content를 출력한다. 아직 editing 활성화 안 해서 null이니깐 ㅇㅇ 그냥 나오겠지 -->
                {{ todoItem.content }}
            </span>
            <input v-else type="text" ref="content"
                    v-bind:value="todoItem.content"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editTodo"/>
            <input type="checkbox"
                    v-bind:checked="todoItem.done"
                    v-on:change="toggleTodoStatus()"/>
            <button v-on:click="removeTodo">지우기</button>
        </li>
    </div>
</template>

<script>
export default {
    name: 'TodoItem',
    // todolist v-bind:editingID 받은 걸 props에 받음
    props: {
        todoItem: {
            type: Object
        },
        editingId: {
            type: Number
        }
    },
    // VDOM 변화가 없어도 계산값이 적용되도록 서포트함
    computed: {
        isEditing () {
            return this.todoItem.id === this.editingId
        }
    },
    methods: {
        removeTodo () {
            const id = this.todoItem.id
                //emit하면 어디로 가지? todoList로 가야지
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
            console.log('toggleTodoStatus() - id: ' + id)
            
            this.$emit('toggleTodoStatus', id)
        },
        handleDoubleClick () {
            const { id } = this.todoItem
            console.log('handleDoubleClick() - id: ' + JSON.stringify(id))
            this.$emit('setEditingId', id)
            this.$nextTick(() => {
                this.$refs.content.focus()
            })
        }
    }
}
</script>