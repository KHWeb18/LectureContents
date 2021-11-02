<!--spring에서 데이터 연동하는걸  view에서 처리-->
<template>
    <div id="product">
        <h2>Vue+Spring 상품 등록 구현</h2>
        <router-link :to="{name: 'ProductRegisterPage'}">
            상품등록
        </router-link>
        <product-list :products="products"/>
    </div>
</template>

<script>

import ProductList from '@/components/product/ProductList.vue'
import {mapState,mapActions} from 'vuex'

export default {
    
    name: 'ProductListPage',
    components:{
        ProductList,
    },
    //실제값에 변동이발생할때 발생
    computed:{
        ...mapState(['products'])
    },
    mounted(){
        this.fetchProductList()
    },
    methods:{
        ...mapActions(['fetchProductList'])
    }

}
</script>