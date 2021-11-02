<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>밑면</td>
        <td><input type="number" v-model="width"/></td>
      </tr>
      <tr>
        <td>높이</td>
        <td><input type="number" v-model="height"/></td>
      </tr>
      <button type="submit">계산하기</button>
    </table>  
  </form>
</template>


<script>
export default {
  name: 'TriangleVue',
  data () {
    return {
      width: '',
      height: ''
    }
  },
  methods: {
    onSubmit () {
      let area = this.width * this.height / 2
      this.$emit('submit', area)
    }
  }
}
</script>


<style scoped>
table {
  margin: auto;
}

</style>