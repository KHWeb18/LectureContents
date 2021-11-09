<template>
    <div align="center">
        <h2>회원가입</h2>
        <member-register-form @signup="onSignUp"/>
    </div>
</template>

<script>
// @는 src 자체를 의미 함
import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'MemberRegisterPage',
    components: {
        MemberRegisterForm
    },
    methods: {
        onSignUp (payload) {
            const { id, pw } = payload
            // 다시 작성 필요!!!
            axios.post('http://localhost:7777/vuemember/register', { id, pw })
                    .then(res => {
                        alert('가입 성공! - ' + res)
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