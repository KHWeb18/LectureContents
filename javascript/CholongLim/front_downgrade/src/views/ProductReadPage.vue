<template>
    <div align="center">
        <h2>Vue + Spring 상품 읽기</h2>
        <product-read v-if="product" :product="product"/>
        <p v-else>로딩중 ...... </p>
        <router-link :to="{ name: 'ProductModifyPage', params: { productNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'ProductListPage' }">
            상품 목록
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
            // 데이터가 JSON으로 넘어오고,
            // JSON은 문자이다.
            // 따라서 처음 넘어올때 String으로 넘어옴
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
    // created : 객체가 생성될때
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
                    alert('상품을 삭제했습니다.')
                    this.$router.push({ name: 'ProductListPage' })
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}
</script>