<template>
    <div>
        <p>{{ products }}</p>
        <ul v-for="pd in products_details" :key="pd.pcode">
            <li v-if="pd.pcode == products[0]">
                제품 코드: {{ pd.pcode }} 상세: {{ pd.text }}
            </li>
        </ul>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data () {
        return {
            products_details: [
                { pcode: 'p01', text: "리눅스 노트북은 Dell, Lenovo" },
                { pcode: 'p02', text: "고성능 서버용 컴퓨터는 AMD + Zynq FPGA" },
                { pcode: 'p03', text: "자동차는 Tesla, BMW, Audi" },
            ],
            products: []
        }
    },
    // created () {
    created: function() {
        // $on은 이벤트를 감지함<<<
        // $emit은 이벤트를 발생시킴<<<
        // EventBus.$on('sendcod', (payload)=>{
        // 여기서 sendcode라는 신호가 전달되면 컴퍼넌트내의 products안에 전달된 데이터(payload)값을 넣는다.
        EventBus.$on('sendcode', (payload) => {
            this.products = payload
        })
    }
}
</script>

<style scoped>
div {
    background: #ff4081;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}
</style>