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
            const { name, id, password, phoneNum, birth } = payload
            axios.post('http://localhost:7777/vuemember/register', { name, id, password, phoneNum, birth })
                    .then(res => {
                        alert('회원가입이 완료되었습니다. - ' + res)
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