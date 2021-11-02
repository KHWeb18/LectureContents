<template>
    <div align="center">
        <h2>Vue + Spring + DB 상품 세부사항</h2>
        <product-read v-if="product" :product="product"/>
        <p v-else>로딩중 ...... </p>
        
        <router-link :to="{ name: 'ProductModifyPage', params: { productNo } }">
            등록된 상품 수정
        </router-link>
        <button @click="onDelete">상품 삭제</button>
        
        <router-link :to="{ name: 'ProductListPage' }">
            상품 보기
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
            // json의 형태는 문자. 따라서 String 데이터타입으로 지정.
            type: String,
            required: true
        }
    },
    components: {
        ProductRead
    },
    // computed- 실제 동작이 발생될 때 작동
    computed: {
        ...mapState(['product'])
    },
    // created-객체가 생성될때 작동
    created () {
        this.fetchProduct(this.productNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchProduct']),
            // this.boardNo 를 쓰는것이 아니라  this.board 로 사용한 이유는 확장성을 위해.
            // 추후 필요하다면 boardNo뿐만 아니라 다른것도 받아올 수 있음
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