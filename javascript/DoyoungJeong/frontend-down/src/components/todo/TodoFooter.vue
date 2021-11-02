<template>
    <div>
        <h2>The End of Todo-List</h2>
        <button v-on:click="clearTodo">CLEAR ALL</button>
    </div>
</template>

<script>

export default {
    methods: {
        clearTodo() {
            console.log('clearTodo!')
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
