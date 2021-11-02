<template>
  <div>
    <button v-on:click="attack">attack</button>
  </div>
</template>

<script>
export default {
  data () {
    return {
       atk_coefficient: 5
    }
  },
  methods: {
    attack () {
      this.$emit('attack', this. atk_coefficient)
    }
  }
}
</script>