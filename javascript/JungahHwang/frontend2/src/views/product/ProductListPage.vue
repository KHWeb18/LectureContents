<template>
  <div id="product">
    <h2>상품 목록</h2>
    <router-link :to="{ name: 'ProductRegisterPage'}">
      상품등록
    </router-link>
    <product-list :products="products"></product-list>
  </div>
</template>


<script>
import ProductList from '@/components/product/ProductList'
import { mapActions, mapState } from 'vuex'

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
