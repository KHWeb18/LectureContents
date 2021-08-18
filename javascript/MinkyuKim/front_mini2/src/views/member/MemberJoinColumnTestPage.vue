<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        </div>
        <member-join-column-test-form @submit="onSubmit"/>
        <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="onJPATest">
            <v-icon left>
                ads_click
            </v-icon>
            클릭하세요!
        </v-btn>
    </div>
</template>

<script>
import MemberJoinColumnTestForm from '@/components/member/MemberJoinColumnTestForm.vue'
import axios from 'axios'
export default {
    name: 'MemberJoinColumnTestPage',
    components: {
        MemberJoinColumnTestForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, password, auth } = payload
            axios.post('http://localhost:7777/jpamember/register', {
                        userId, password, auth
                    })
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