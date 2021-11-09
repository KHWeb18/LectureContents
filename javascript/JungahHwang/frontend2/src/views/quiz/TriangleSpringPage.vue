<template>
  <div>
    <h2>삼각형 넓이 구하기(Spring)</h2>
   <table>
      <tr>
        <td>밑면</td>
        <td><input type="number" v-model="width"/></td>
      </tr>
      <tr>
        <td>높이</td>
        <td><input type="number" v-model="height"/></td>
      </tr>
      <button v-on:click="calcTriangleArea">계산하기</button>
    </table>  
    <p>삼각형의 넓이는 {{ results }}입니다.</p>
  </div>
</template>


<script>
import axios from 'axios'

export default {
  name: 'TriangleSringPage',
  data () {
    return {
      width: 0,
      height: 0,
      results: 0
    }
  },
  methods: {
    calcTriangleArea () {
      const { width, height } = this
      axios.post('http://localhost:7777/calcTriangle', { width, height }).then(res => {
        this.results = res.data
      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>


<style scoped>
table {
  margin: auto;
}

</style>