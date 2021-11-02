<template>
    <div id="eventbus">
        <h2>EventBus 테스트</h2>
        <products></products>
        <product-detail></product-detail>
    </div>
</template>

<script>


import Products from '@/components/eventbus/Products.vue'
import ProductDetail from '@/components/eventbus/ProductDetail.vue'

export default {
    name: 'EventBusTestPage',
    components: {
        Products,
        ProductDetail
    }
}
</script>

<style scoped>

ul {
    list-style-type: none;
    background:plum;
    padding: 10px;
}

ul li {
    background: powderblue;
    margin: 5px;
}
</style>