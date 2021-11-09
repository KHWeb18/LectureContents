<template>
  <div>
    삼각형 높이 <input type="text" v-model="height"><br><br>
    삼각형 넓이 <input type="text" v-model="width"><br><br>
    <button v-on:click="calc">넓이 구하기</button><br><br>
    <h1 v-if="!(height || width)">삼각형의 넓이 : {{ result }}</h1><br><br>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'CalcAreaWithSpring',
  data() {
    return {
      height: 0,
      width: 0,
      result: 0,
    }
  },
  methods: {
    calc() {
      axios.post('http/:localhost7777/vuespring/area')
    }
  },
}
</script>