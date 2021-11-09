<template>
  <div align="center">
      <h2>게시물 수정</h2>
      <product-modify-form v-if="product" :product="product" @submit="onSubmit" />
      <!-- <board-modify-form v-if="board" :board="board" @submit="onSubmit" /> -->
      <p v-else>로딩중 </p>
  </div>
</template>

<script>
import ProductModifyForm from '../components/product/ProductModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'


export default {
    name: 'ProductModifyPage',
    components: {
        ProductModifyForm
    },
    props: {
        productNo: {
            type: String,
            required: true
        }
    },
    methods: {
            ...mapActions(['fetchProduct']),

            onSubmit (payload) {
            const { product_name, description } = payload
            axios.put(`http://localhost:7777/vueproduct/${this.productNo}`, {product_name, description})
            .then(res => {
                alert('성공')   
                this.$router.push({
                    name: 'ProductReadPage',
                    params: { productNo: res.data.productNo.toString()}
                })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }

    },
    computed: {
    ...mapState(['product'])
    },
    created () {
        this.fetchProduct(this.productNo)
        .catch(err => {
            alert(err.response.data.message)
            this.$router.back()
        })
    }

}
</script>

<style>

</style>