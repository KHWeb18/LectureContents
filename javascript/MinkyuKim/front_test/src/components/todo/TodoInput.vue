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
                //trim 공백있어도 다 잘라버리고 처리하는 역할
                var value = this.newTodoItem && this.newTodoItem.trim()
                console.log('addTodo')
                // emit의 역할은 무엇인가?
                // addTodo가 있는 곳으로 보내 addTodo를 동작시킴(value값을 전달)
                // 즉 emit을 둘러싼 컴포넌트로
                // emit을 하는게 TodoInput.vue 라면 Todo.vue로 전달
                this.$emit('addTodo', value)
                // emit을하자마자 clearInput이므로 입력창이 비워짐
                this.clearInput()
            }
        },
        clearInput () {
            this.newTodoItem = ''
        }
    }
}
</script>