<template>
    <div align="center">
        <h2>Vue + Spring 상품 목록 읽기</h2>
        <product-read v-if="product" :product="product"/>
        <p v-else>로딩중 ...... </p>
        
        <router-link :to="{ name: 'ProductModifyPage', params: { productNo } }">
            상품 수정
        </router-link>
        
        <button @click="onDelete">상품 삭제</button>
        
        <router-link :to="{ name: 'ProductListPage' }">
            상품 리스트
        </router-link>
    </div>
</template>

<script>
import ProductRead from '@/components/product/ProductRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'ProductReadPage',
    props: {
        productNo: {
            type: String,
            required: true
        }
    },
    components: {
        ProductRead
    },
    computed: {
        ...mapState(['product'])
    },
    created () {
        this.fetchProduct(this.productNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchProduct']),
        onDelete () {
            const { productNo } = this.product
            axios.delete(`http://localhost:7777/vueproduct/${productNo}`)
                .then(() => {
                alert('삭제 성공!')
                this.$router.push({ name: 'ProductListPage' })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    }
}
</script>
