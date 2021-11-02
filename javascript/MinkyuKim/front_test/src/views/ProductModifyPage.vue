<template>
    <div align="center">
        <h2>상품 수정</h2>
        <!--만약 product가 있다면 product를 바인딩 시키고 submit
            앞의 product는 data의 product, 뒤의 product는 props의 product-->
        <product-modify-form v-if="product" :product="product" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
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
            console.log("payload: " + JSON.stringify(payload))

            const { product_name, description, price } = payload
            axios.put(`http://localhost:7777/vueproduct/${this.productNo}`, { product_name, description, price })
                    .then(res => {
                        alert('수정 성공!')
                        // push의 경우 to의 역할과 같다.( router-link-to)
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