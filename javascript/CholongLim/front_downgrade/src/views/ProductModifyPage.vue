<template>
    <div align="center">
        <h2>상품 수정</h2>
        <product-modify-form v-if="product" :product="product" @submit="onSubmit"/>
        <p v-else>로딩중 ......</p>
    </div>
</template>

<script>

import ProductModifyForm from '@/components/product/ProductModifyForm'
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
            const { title, price, content } = payload
            axios.put(`http://localhost:7777/vueproduct/${this.productNo}`, { title, price, content })
                    .then(res => {
                        alert('수정하였습니다.')
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