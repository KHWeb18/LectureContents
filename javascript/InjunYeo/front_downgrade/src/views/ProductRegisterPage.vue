<template>
    <div align="center">
        <h2>상품등록</h2>
        <product-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue'
import axios from 'axios'


export default {

    name: 'ProductRegisterPage',
    components:{
        ProductRegisterForm
    },
    methods:{
        onSubmit(payload){

            const{name, price, producer , description} = payload
            axios.post('http://localhost:7777/vueproduct/register',{name,price,producer,description})
                .then(res => {
                    alert('등록성공!'+ res)
                    
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