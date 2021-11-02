<template>
    <ul>
        <li v-for="product in products" :key="product.pcode"
            v-on:click="sendCode(product.pcode, $event)">
            <!-- product.pcode : 어떤 것을 눌렀는지 찾아 전송시킴 -->
                {{ product.pname }}
        </li>
    </ul>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data () {
        return {
            products: [
                { pcode: 'p01', pname: '노트북' },
                { pcode: 'p02', pname: '컴퓨터' },
                { pcode: 'p03', pname: '자동차' },
            ]
        }
    },
    methods: {
        sendCode(incode, $event) {
            // incode = pcode값
            // $event : 어떤 이벤트가 발생했는지
            const payload = [ incode, $event.target.innerHTML ]
            EventBus.$emit('sendcode', payload)
        }
    }
}
</script>