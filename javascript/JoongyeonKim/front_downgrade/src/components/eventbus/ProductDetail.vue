<template>
    <div>
        <p>{{ products }}</p>
        <ul v-for="pd in products_details" :key="pd.pcode">
            <li v-if="pd.pcode == products[0]">
                <!-- 제품을 클릭하면 products[0]가 되어 아래문이 나타난다 -->
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
        // $on은 이벤트를 감지함 <<<
        // $emit은 이벤트를 발생시킴 <<<
        EventBus.$on('sendcode', (payload) => {
            this.products = payload
            //sendcode에 있는 payload 값을 products에 대입한다
            
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