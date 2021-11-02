<template>
    <div id="eventBus">
        <h2>EventBus Test</h2>
        <products></products>
        <product-detail></product-detail>
    </div>
</template>

<script>

import Products from '../components/eventbus/Products.vue'
import ProductDetail from '../components/eventbus/ProductDetail.vue'

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
    background: #3399ff;
    padding: 10px;
}
ul li {
    background: #cce5ff;
    margin: 5px;
}
</style>

//event를 쓰는 이유는 event.target.html을 보려고하는 의도이다.
