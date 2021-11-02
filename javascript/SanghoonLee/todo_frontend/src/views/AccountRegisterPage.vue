<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        </div>
        <account-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import AccountRegisterForm from '@/components/account/AccountRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'AccountRegisterPage',
    components: {
        AccountRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { email, password } = payload
            axios.post('http://localhost:7777/jpasession/register', { email, password })
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