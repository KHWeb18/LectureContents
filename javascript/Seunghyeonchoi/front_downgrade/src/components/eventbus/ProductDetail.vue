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

        // emit : 이벤트 발생!
        //once : 이벤트 발생시킨놈 찾아!(감지)
        // 누구야? products의 
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