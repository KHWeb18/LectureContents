<template>
    <div>
        <h2>회원가입</h2>
        <member-join-colum-test-form @submit="onSubmit" />
        <v-btn tile color="teal" @click="onJPATest">
            <v-icon left>
                ads_click
            </v-icon>
            클릭하세요!
        </v-btn>
    </div>
    
</template>

<script>
import MemberJoinColumTestForm from '../components/member/MemberJoinColumTestForm'

import axios from 'axios'
export default {
    name: 'MemeberJoinColumTestPage',
    components: {
        MemberJoinColumTestForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, password, auth } = payload
            axios.post('http://localhost:7777/jpamember/register', { userId, password, auth })
                    .then(res => {
                        alert('등록 성공! - ' + res)

                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
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

