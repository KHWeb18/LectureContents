<template>
   <div align="center">
       <signup-register-form @submit="onSubmit"/>

      
   </div>
</template>
<script>
import SignupRegisterForm from '@/components/Signup/SignupRegisterForm.vue'
import axios from 'vuex'
export default {
    name: 'SignupRegisterPage',
    components:{
        SignupRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { id, pw , address } = payload
            axios.post('http://localhost:8888/vueboard/register', {id, pw , address})
            .then(res =>{
                alert('회원가입완료!' + res)
              
            })
            .catch(res =>{
                alert(res.response.data.message)
            })
        }
    },
}
</script>