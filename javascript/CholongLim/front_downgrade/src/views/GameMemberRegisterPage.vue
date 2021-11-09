<template>
    <div align="center">
        <h2>판타지 온라인 회원 가입</h2>
        <game-member-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import GameMemberRegisterForm from '@/components/member/GameMemberRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'GameMemberRegisterPage',
    components: {
        GameMemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/vuemember/register', { id, pw })
                    .then(res => {
                        alert('회원가입이 완료되었습니다. - ' + res)
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