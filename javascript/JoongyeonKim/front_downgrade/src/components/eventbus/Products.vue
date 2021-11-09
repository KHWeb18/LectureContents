<template>
    <ul>
        <li v-for="product in products" :key="product.pcode"
            v-on:click="sendCode(product.pcode, $event)">
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
                //incode는 템플릿안에 있는 샌드코드 안에있는 product.pcode를 받는다
                //이벤트를 발생시켜 $event.target.innerHTML를 알게한다 (onclick으로는 안됨)
        sendCode(incode, $event) {
            const payload = [ incode, $event.target.innerHTML ]
            
            EventBus.$emit('sendcode', payload)
        }
    }
}
</script> 