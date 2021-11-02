<template>
    <div id="product">
        <h2>Vue + Spring 상품 등록 구현</h2>
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
    // 실제 값에 변경이 발생할때 동작함
    computed: {
        ...mapState(['products'])
    },
    // mounted : 객체가 생성되고나서 웹이랑 붙을 때
    mounted () {
        this.fetchProductList()
    },
    methods: {
        ...mapActions(['fetchProductList'])
    }
}
</script>