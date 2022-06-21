<template>
    <div align="center">
        <h3>JPA Member Register</h3>
        <vue-jpa-member-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import axios from 'axios'
import VueJpaMemberRegisterForm from '../components/member/VueJpaMemberRegisterForm'

export default {
    name: 'VueJpaMemberRegister',
    components: {
        VueJpaMemberRegisterForm
    },
    methods: {
        onSubmit(payload) {

            const { id, password } = payload

            console.log(JSON.stringify({ id, password }))
            console.log(payload)
            
            axios.post('http://localhost:7777/vuejpamember/register', { id, password })
            .then(res => {
                alert('등록 성공' + res)
                this.$router.push({
                    name: 'Home'
                })
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }
    }
}
</script>
