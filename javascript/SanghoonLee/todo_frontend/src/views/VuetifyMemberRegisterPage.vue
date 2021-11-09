<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        </div>
        <vuetify-member-register-form @submit="onSubmit"/>
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
            const { id, pw } = payload
            axios.post('http://localhost:7777/vuejpamember/register', { id, pw })
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