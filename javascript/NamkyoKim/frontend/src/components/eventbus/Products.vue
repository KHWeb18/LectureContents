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
        sendCode(incode, $event) {
            const payload = [ incode, $event.target.innerHTML ]
            EventBus.$emit('sendcode', payload)
        }
    }
}
</script> 