<template>
  <div align="center">
    <h2>상품 수정</h2>
    <product-modify v-if="product" :product="product" @submit="onSubmit"></product-modify>
    <p v-else>로딩중..</p>
  </div>
</template>


<script>
import axios from 'axios'
import ProductModify from '@/components/product/ProductModify'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'ProductModifyPage',
  components: {
    ProductModify
  },
  props: {
    productNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['product'])
  },
  methods: {
    ...mapActions(['fetchProduct']),
    onSubmit (payload) {
      const { title, content, price } = payload
      axios.put(`http://localhost:7777/vueproduct/${this.productNo}`, { title, content, price }).then(res => {
        alert('수정이 완료되었습니다')
        this.$router.push({
          name: 'ProductReadPage',
          params: { productNo: res.data.productNo.toString() }
        })
      }).catch(err => {
        alert(err.response.data.message)
      })
    }
  },
  created () {
    this.fetchProduct(this.productNo).catch(err => {
      alert(err.response.data.message)
      this.$router.back()
    })
  }
}
</script>