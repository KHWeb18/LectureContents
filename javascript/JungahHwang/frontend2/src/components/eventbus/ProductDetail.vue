<template>
  <div>
    <p>{{ products }}</p>
    <ul v-for="pd in products_details" :key="pd.pcode">
      <li v-if="pd.pcode == products[0]">
        제품코드: {{ pd.pcode }} / 상세: {{ pd.text }}
      </li>
    </ul>
  </div>
</template>


<script>

import EventBus from '@/eventBus'

export default {
  data () {
    return {
      products_details: [
        { pcode: 'p01', text: "리눅스 노트북은 Dell, Lenovo" },
        { pcode: 'p02', text: "고성능 서버용 컴퓨터는 AMD + Zynq FPGA" },
        { pcode: 'p03', text: "자동차는 Tesla, BMW, Audi" }
      ],
      products: []
    }
  },
  created () {
    // $on: 이벤트를 감지 (요청하는 대로 계속 작동, $once: 한번만 작동)
    // $emit: 이벤트를 발생시킴
    EventBus.$on('sendcode', (payload) => {
      this.products = payload
    })
  }
}
</script>


<style scoped>

div {
  background: rgb(252, 229, 233);
  padding: 10px;
  font-weight: bold;
}
ul {
  list-style: none;
}
</style>