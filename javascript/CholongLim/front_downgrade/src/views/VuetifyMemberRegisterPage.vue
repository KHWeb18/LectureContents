<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        <vuetify-member-register-form @submit="onSubmit"/>
        </div>
    </div>
</template>

<script>
import VuetifyMemberRegisterForm from '@/components/member/VuetifyMemberRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'VuetifyMemberRegisterPage',
    components: {
        VuetifyMemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { name, id, password, phoneNum, memberBirth } = payload
            axios.post('http://localhost:7777/vuejpamembering/register', { name, id, password, phoneNum, memberBirth })
                    .then(res => {
                        alert('회원가입이 완료되었습니다. - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>