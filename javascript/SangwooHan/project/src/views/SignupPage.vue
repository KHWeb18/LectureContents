<template>
    <div align="center">
        <signup-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import SignupRegisterForm from '../components/Signup/SignpupRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'SignupPage',
    components: {
        SignupRegisterForm
    },
    methods: {
        onSubmit(payload){
                const {userid, password, name, birthday, gender, address, phoneNo} = payload
                axios.post('http://localhost:9999/vuesignup/register', {userid, password, name, birthday, gender, address, phoneNo})
                .then(res =>{
                    alert('회원가입 성공' + res)
                    this.$router.push({
                        name: 'Home'
                    }) 
                }).catch(res => {
                    alert(res.response.data.message)
                })
                
        }
    }
}
</script>