<template>
    <div align="center">
        <h2>게시물 수정</h2>             <!--:product는 ProductModifyForm에 있는 props이다 -->
        <product-modify-form v-if="product" :product="product" @submit="onSubmit"/>
    <p v-else>로딩중 .......</p>                 <!--@submit="onSubmit" 을 하면  아래에서 submit이 작동하여 에러가 나지않게 하기위해 필요하다  -->
    </div>
</template>

<script>

import ProductModifyForm from '@/components/product/ProductModifyForm.vue'
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
    computed: {
        ...mapState(['product'])
    },
    methods: {
        ...mapActions(['fetchProduct']),
        onSubmit (payload) {
            const { name, price, description } = payload
            axios.put(`http://localhost:7777/vueproduct/${this.productNo}`, {name, price, description})
            .then(res => {
                alert('수정 성공')
                this.$router.push({
                    name: 'ProductReadPage',
                    params: { productNo: res.data.productNo.toString() }
                })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
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