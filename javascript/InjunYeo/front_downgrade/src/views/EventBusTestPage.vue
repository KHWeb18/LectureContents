<!--EventBus는 전역변수이기때문에 모든뷰에서 작동함 그래서 Emit을 해도 전역에서 작동하는것-->
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
    background: #3399ff;
    padding: 10px;
}
ul li {
    background: #cce5ff;
    margin: 5px;
}
</style>