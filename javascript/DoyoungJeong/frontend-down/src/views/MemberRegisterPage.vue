<template>
    <div align="center">
        <h3>회원 가입 양식</h3>
        <member-register-form @submit="onSubmit"/> <!-- 마지막에 /꼭 너주어야한다. memberRegisterForm에서 submit동작을 @submit으로 받았다. -->
    </div>
</template>

<script>

import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'

import axios from 'axios'

export default {
    name: 'MemberRegisterPage',
    components: {
        'member-register-form': MemberRegisterForm
    },
    methods: {
        onSubmit(payload) {
            const { id, pw, name, birthDay, address, party, comment } = payload
            axios.post('http://localhost:7777/vuemember/signup', { id, pw, name, birthDay, address, party, comment })
            .then(res => {
                alert('등록 성공' + res)
                this.$router.push({
                    name: 'MemberListPage'
                })
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }
    }
}
</script>

<style>

</style>
