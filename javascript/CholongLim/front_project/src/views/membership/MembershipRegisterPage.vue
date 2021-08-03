<template>
    <div align="center">
        <h3>회원 가입</h3>
        <membership-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import MembershipRegisterForm from '@/components/membership/MembershipRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'MembershipRegisterPage',
    components: {
        MembershipRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { memName, memID, memPassword, phoneNum, memBirth } = payload
            axios.post('http://localhost:8888/vuemembership/register', { memName, memID, memPassword, phoneNum, memBirth })
                    .then(res => {
                        alert('회원가입이 완료되었습니다.' + res)
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