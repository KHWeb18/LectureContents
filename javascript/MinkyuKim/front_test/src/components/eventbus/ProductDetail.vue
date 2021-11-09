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
    //객체가 생성될 때 sendcode를 가져온다.
    //sendcode 이벤트는 product에 의하여 발생
    // created () {
    created: function() {
        // $on은 이벤트를 감지함 <<<
        // $emit은 이벤트를 발생시킴 <<<
        // 여러번 작용
        EventBus.$on('sendcode', (payload) => { 
        //한번만 작용
        //EventBus.$once('sendcode', (payload) => {
        this.products = payload
        })
    }
}
</script>

<style scoped>
div {
    background: #353032;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}
</style> 