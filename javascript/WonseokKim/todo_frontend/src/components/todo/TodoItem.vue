<template>
    <div class="todo">
        <li>
            <span v-if="!isEditing" v-on:dblclick="handleDoubleClick">
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
        handleDoubleClick () { // {} = 객체를 만들때 사용
            const { id } = this.todoItem
            console.log('handleDoubleClick() - id: ' + JSON.stringify(id))
            this.$emit('setEditingId', id)
            //nextTick 짧은 시간을 잠시 멈춰서 가자, 슬립(sleep)로 보면 됨 
            this.$nextTick(() => {
                this.$refs.content.focus()
            })
        }
    }
}
</script>