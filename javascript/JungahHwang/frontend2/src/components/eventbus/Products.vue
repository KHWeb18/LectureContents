<template>
  <ul>
    <!-- sendCode(클릭한 것의 pcode정보, 마우스를 클릭했다는 이벤트 정보)를 담고 있음 -->
    <li v-for="product in products" :key="product.pcode"
      v-on:click="sendCode(product.pcode, $event)">
      {{ product.pname }}
    </li>
  </ul>
</template>


<script>
import EventBus from '@/eventBus'

export default {
  data () {
    return {
      products: [
        { pcode: 'p01', pname: '노트북' },
        { pcode: 'p02', pname: '컴퓨터' },
        { pcode: 'p03', pname: '자동차' }
      ]
    }
  },
  methods: {
    sendCode(incode, $event) {
      // $evnet.target.innerHTML: HTML상에서 무엇을 클릭했는지에 대한 정보
      const payload = [ incode, $event.target.innerHTML ]
            // eventbus에 전달($emit: 이벤트 발생)
            EventBus.$emit('sendcode', payload)
    }
  }
}
</script>