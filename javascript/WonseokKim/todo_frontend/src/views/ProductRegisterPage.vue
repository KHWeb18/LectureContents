<template>
    <div align="center">
        <h2>상품 등록</h2>
        <product-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
// @는 src 자체를 의미 함
import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'ProductRegisterPage',
    components: {
        ProductRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer, price } = payload
            // 수정 필요!!
            axios.post('http://localhost:7777/vueproduct/register', { title, writer, content, price })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        this.$router.push({
                            name: 'ProductListPage',
                            params: { productNo: res.data.productNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>