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
        // payload : ProductRegisterForm.vue에서 emit으로 받음 
        onSubmit (payload) {
            const { title, price, writer, content } = payload
            axios.post('http://localhost:7777/vueproduct/register', { title, price, writer, content })
                .then(res => {
                    alert('상품 등록이 완료되었습니다.' + res)
                    this.$router.push({
                        name: 'ProductListPage',
                    })
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}

</script>