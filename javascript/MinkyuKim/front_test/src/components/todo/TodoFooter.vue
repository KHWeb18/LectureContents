<template>
    <div>
        <h3>Todo 끝</h3>
        <button v-on:click="clearTodo">싹 다 지 워</button>
    </div>
</template>

<script>

export default {
    methods: {
        clearTodo () {
            console.log('clearTodo')
            this.$emit('removeAll')
        }
    }
}

</script>

<style scoped>

div {
    background-color: #7789c3;

}
</style>