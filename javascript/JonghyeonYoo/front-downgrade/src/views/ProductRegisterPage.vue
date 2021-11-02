<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <product-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'ProductRegisterPage',
    components: {
        ProductRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { product_name, description, producer, price } = payload
            axios.post('http://localhost:7777/vueproduct/register', { product_name, description, producer, price })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        console.log('상품 번호: ' + res.data.productNo.toString())
                        this.$router.push({
                            name: 'ProductListPage'
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>