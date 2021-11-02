<template>
    <div align="center">
        <h2>판타지온라인</h2>
        <member-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'MemberRegisterPage',
    components: {
        MemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const {id, pw } = payload
            axios.post('http://localhost:7777/vuemember/register', {id, pw })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>