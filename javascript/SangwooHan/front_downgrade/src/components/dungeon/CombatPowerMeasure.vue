<template>
    <div>
        <p>{{ products }}</p>
        <ul v-for="pd in products_details" :key="pd.pcode">
            <li v-if="pd.pcode == products[0]">
              전투력 {{ text }} 이상 진입가능.
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
                { pcode: 'p01', text: "5" },
                { pcode: 'p02', text: "4" },
                { pcode: 'p03', text: "4" },
            ],
            products: []
        }
    },
    // created () {
    created: function() {

        //$on은 이벤트를 감지함,,
        // $emit은 이벤트를 발생시킴.
        EventBus.$on('sendcode', (payload) => {
            this.products = payload
        })
    }
}
</script>

<style scoped>
div {
    background: green;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}
</style>