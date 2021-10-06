<template>
    <div>
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
            const { name, birth, email, password } = payload
            axios.post('http://localhost:3647/jpasession/register', { name, birth, email, password })
                    .then(res => {
                        alert('등록 성공! - ' + res )
                        this.$router.push('/sessionLogin')

                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>