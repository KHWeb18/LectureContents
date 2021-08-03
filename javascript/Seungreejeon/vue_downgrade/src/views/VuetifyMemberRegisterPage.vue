<template>
    <div>
        <h2>게시물 작성</h2>
        <vuetify-member-register-form @submit="onSubmit" />
    </div>
</template>

<script>
import VuetifyMemberRegisterForm from '../components/member/VuetifyMemberRegisterForm.vue'

import axios from 'axios'
export default {
    name: 'VuetifyMemberRegisterFormPage',
    components: {
        VuetifyMemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/vuejpamember/register', { id, pw })
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