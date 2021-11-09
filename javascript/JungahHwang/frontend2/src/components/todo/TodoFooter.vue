<template>
  <div>
    <button v-on:click="clearTodo">Remove All</button>
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

button {
  background-color: pink;
}
</style>