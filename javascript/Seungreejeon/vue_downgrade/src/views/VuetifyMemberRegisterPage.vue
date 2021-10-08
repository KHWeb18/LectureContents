<template>
    <div>
        <h2>회원 가입</h2>
        <vuetify-member-register-form @submit="onSubmit" />

        
    <v-btn tile color="teal" @click="onJPATest">
        Click me
    </v-btn>

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
            axios.post('http://localhost:7777/jpamember/test', { id, pw })
                    .then(res => {
                        alert('등록 성공! - ' + res)

                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
        ,
            onJPATest () {
            axios.post('http://localhost:7777/jpamember/test', {
                        userId: null, password: null, auth: null
                    })
                    .then(res => {
                        alert('테스트 성공! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>

