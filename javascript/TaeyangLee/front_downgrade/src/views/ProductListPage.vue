<template>
    <div id="product">
        <h2>Vue + Spring + DB 상품 구현</h2>
        <router-link :to="{ name: 'ProductRegisterPage' }">
            상품 등록
        </router-link>
        <product-list :products="products"/>
    </div>
</template>

<script>
import ProductList from '@/components/product/ProductList.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'ProductListPage',
    components: {
        ProductList
    },
    computed: {
        ...mapState(['products'])
    },
    mounted () {
        this.fetchProductList()
    },
    methods: {
        ...mapActions(['fetchProductList'])
    }
}
</script>