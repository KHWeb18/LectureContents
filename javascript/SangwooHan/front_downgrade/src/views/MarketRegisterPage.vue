<template>
    <div align="center">
        <h2>물품등록</h2>
        <market-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import axios from 'axios'
import MarketRegisterForm from '../components/market/MarketRegisterForm.vue'


export default {
    name: 'MarketRegisterPage',
    components: {
        MarketRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const {username, name, price, description } = payload
            axios.post('http://localhost:9999/vueTest/register', { username, name, price, description})
            .then(res =>{
                alert('등록완료' + res)
                /*
                this.$router.push({
                        name: 'BoardReadPage',
                        params: { boardNo: res.data.boardNo.toString() }
                })
                */
            })
            .catch(res =>{
                alert(res.response.data.message)
            })
        }
    }
}
</script>