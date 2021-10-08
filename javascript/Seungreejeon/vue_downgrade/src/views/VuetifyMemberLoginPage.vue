<template>
    <div>
        <h2>회원 가입</h2>
        <VuetifyMemberLoginForm @submit="onSubmit" />

        
    <v-btn tile color="teal" @click="onJPATest">
        Click me
    </v-btn>

    </div>
</template>

<script>
import VuetifyMemberLoginForm from '../components/member/VuetifyMemberLoginForm.vue'

import axios from 'axios'
export default {
    name: 'VuetifyMemberLoginForm',
    components: {
        VuetifyMemberLoginForm
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
        },
         showSession () {
            if (this.isLogin == true) {
                axios.post('http://localhost:7777/jpamember/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
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
            } else {
                alert('먼저 로그인부터 하세요!')
            }
        },
        removeSession () {
            axios.post('http://localhost:7777/jpamember/removeSession')
                    .then(res => {
                        this.isLogin = res.data
                    })
        }
    }

}
</script>

