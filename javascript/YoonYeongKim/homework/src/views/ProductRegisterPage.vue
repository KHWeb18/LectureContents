<template>
    <div align="center">
        <h2>상품 등록</h2>
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
            const { name, price, description } = payload
            axios.post('http://localhost:7777/vueproduct/register', { name, price, description })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script> 