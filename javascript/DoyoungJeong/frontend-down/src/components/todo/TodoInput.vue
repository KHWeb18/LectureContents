<template>
    <div>
        <h3>Todo 입력</h3>
        <input type="text" v-model="newTodoItem" v-on:keypress.enter="addTodo">
        <button v-on:click="addTodo">추가</button>
    </div>
</template>

<script>

export default {
    data() {
        return {
            newTodoItem: ''
        }
    },
    methods: {
        addTodo() {
            if(this.newTodoItem !== '') {
                var value = this.newTodoItem && this.newTodoItem.trim()
                console.log('addTodo')

                this.$emit('addTodo', value)
                //emit은 자기를 둘러싼 컴포넌트에게 정보를 전달한다.
                //emit을 감싼 컴포넌트는 todoInput이다. 그리고 todoInput컴포넌트가있는 Todo.vue에 정보가 전달된다.
                this.clearInput()
            }
        },
        clearInput() {
            this.newTodoItem = ''
        }
    }
}
</script>
