<template>
<div class="app">

    <div>
        <member-register-form @submit="onSubmit"/>
        <v-spacer></v-spacer>
    </div>
</div>
</template>

<script>

import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'MemberRegisterTest',
    components: {
        MemberRegisterForm,

    },
    methods: {
        onSubmit (payload) {
            const { userId, password, name, email, phoneNumber, dateOfBirth, auth } = payload
            axios.post('http://localhost:1111/jpamember/register', {
                        userId, password, name, email, phoneNumber, dateOfBirth, auth
                    })
                    .then(res => {
                        
                        alert('등록 성공! - ' + res)
                       
                               this.$router.push({
                            path: '/MemberLogin' 
                        }) 
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
    }
}
</script>