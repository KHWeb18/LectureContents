<template>
  <div>
    <h3>Monster Hundred Input</h3>
    <input type="text" v-on:keypress.enter="addManyMonster">
    <button v-on:click="addManyMonster">Add</button>
  </div>
</template>


<script>

export default {
  methods: {
    addManyMonster () {
      console.log('addManyMonster')

      this.$emit('addManydMonster')
    }
  }
}
</script>