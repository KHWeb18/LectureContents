<template>
    <div>
        <div align="center">
            <h2>로그인</h2>
        </div>
        <vuetify-member-login-form @submit="onSubmit"/>
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
            const { id, pw } = payload
            axios.post('http://localhost:7777/jpamember/login', { userId: id, password: pw, auth: null })
                    .then(res => {
                        if (res.data == true) {
                            alert('로그인 성공! - ' + res.data)
                        } else {
                            alert('로그인 실패! - ' + res.data)
                        }
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