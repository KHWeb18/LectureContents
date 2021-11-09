<template>
  <div>
    <h3>Monster Input</h3>
    <input type="text" v-model="newMonsterElement" v-on:keypress.enter="addMonster">
    <button v-on:click="addMonster">Add</button>
  </div>
</template>


<script>
export default {
  data () {
    return {
      newMonsterElement: ''
    }
  },
  methods: {
    addMonster () {
      if (this.newMonsterElement !== '') {
        var value = this.newMonsterElement && this.newMonsterElement.trim()
        console.log('addMonster')

        this.$emit('addMonster', value)
        this.clearInput()
      }
    },
    clearInput () {
      this.newMonsterElement = ''
    }
  }
}
</script>