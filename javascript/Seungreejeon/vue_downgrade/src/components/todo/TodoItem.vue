  
<template>
    <div class="todo">
        <li>
            <span v-if="!isEditing" @dblclick="handleDoubleClick">
                {{ todoItem.content }}
            </span>
            <input v-else type="text" ref="content"
                    v-bind:value="todoItem.content"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editTodo"/>
            <input type="checkbox" v-bind:checked="todoItem.done"
                    v-on:change="toggleTodoStatus()"/>
            <button v-on:click="removeTodo">지우기</button>
        </li>
    </div>
</template>

<script>
export default {
    name: 'TodoItem',
    props: {
        // todo에서 v-bind를 통해서 값을 받아옴
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
            console.log("toggleTodoStatus()-id: " + id)
            this.$emit('toggleTodoStatus', id)
        },
        handleDoubleClick () {
            const { id } = this.todoItem
            this.$emit('setEditingId', id)
            console.log("handleDoubleClick-id: " + JSON.stringify(id))

            //짧은 sleep 정도로 이해하면됨$
            this.$nextTick(() => {
                this.$refs.content.focus()
            }) 
        }
    }
}
</script>