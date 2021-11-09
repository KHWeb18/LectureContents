<template>
  <div align="center">
    <h2>상품등록</h2>
    <product-register @submit="onSubmit"></product-register>
  </div>
</template>


<script>
import axios from 'axios'

import ProductRegister from '@/components/product/ProductRegister.vue'

export default {
  name: 'ProductRegisterPage',
  components: {
    ProductRegister
  },
  methods: {
    onSubmit (payload) {
      const { title, content, price } = payload
      axios.post('http://localhost:7777/vueproduct/register', { title, content, price }).then(res => {
        alert('등록성공!' + res)
      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>