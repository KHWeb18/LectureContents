<template>
    <div>
        <div align="center">
            <h2>로그인</h2>
        <vuetify-member-login-form @submit="onSubmit"/>
        </div>
    </div>
</template>

<script>
import VuetifyMemberLoginForm from '@/components/member/VuetifyMemberLoginForm.vue'
import axios from 'axios'
export default {
    name: 'VuetifyMemberLoginPage',
    components: {
        VuetifyMemberLoginForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, password } = payload
            axios.post('http://localhost:7777/jpamember/login', { userId, password, auth: null })
                    .then(res => {
                        if(res.data == true) {
                            alert('로그인 성공. - ' + res.data)
                        } else {
                            alert('이메일 또는 비밀번호를 다시 확인하세요.')
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>