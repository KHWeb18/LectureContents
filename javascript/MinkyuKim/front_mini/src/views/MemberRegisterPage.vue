<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        </div>
        <member-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import MemberRegisterForm from '@/components/members/MemberRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'MemberRegisterPage',
    components: {
        MemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, password, name, dateOfBirth, phoneNumber, 
                    email, address, gender, drawing, article, largeArtwork, auth } = payload
            axios.post('http://localhost:7777/member/register', { 
                userId, password, name, dateOfBirth, phoneNumber, email, address, gender, drawing, article, largeArtwork, auth })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        /*
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                        */
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script> 