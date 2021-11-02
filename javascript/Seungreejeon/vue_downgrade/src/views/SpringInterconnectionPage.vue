<template>
  <div>
      <h2>삼각형 넓이 구하기 Spring+ Vue</h2>
      밑변: <input type="number" v-model="width">
      높이: <input type="number" v-model="height">
      결과 {{ results }} <br>
      <button v-on:click="calcTriangleArea">결과 계산</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
    name: "SpringInterconnectionPage",
    
    data() {
      return {
        width: 0,
        height: 0,
        results: 0
      }
    },

      methods: {
        calcTriangleArea() {
          axios.post('http://localhost:7777/calcTriangle', { width:this.width, height:this.height})
          .then(res => {
            alert("계산완료" + res.data)
            this.results = res.data
          })

        }
    }

}
</script>

<style>

</style>