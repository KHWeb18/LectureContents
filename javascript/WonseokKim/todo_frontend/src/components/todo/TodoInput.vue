<template>
    <div>
        <h3>Todo 입력</h3>
        <input type="text" v-model="newTodoItem" v-on:keypress.enter="addTodo">
        <button v-on:click="addTodo">추가</button>
    </div>
</template>

<script>
export default {
    data () {
        return {
            newTodoItem: ''
        }
    },
    methods: {
        addTodo () {
            if (this.newTodoItem !== '') {
                var value = this.newTodoItem && this.newTodoItem.trim()
                console.log('addTodo')
                // emit은 자기를 둘러싼 녀석에 정보를 준다
                this.$emit('addTodo', value)
                this.clearInput()
            }
        },
        clearInput () {
            this.newTodoItem = ''
        }
    }
}
</script>
