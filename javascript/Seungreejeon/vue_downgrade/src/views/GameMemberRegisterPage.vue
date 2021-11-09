<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <game-member-register @submit="onSubmit"/>
    </div>
</template>

<script>
import GameMemberRegister from '../components/member/GameMemberRegisterForm.vue'

import axios from 'axios'
export default {
    name: 'GameMemberRegisterPage',
    components: {
        GameMemberRegister
    },
    methods: {
        onSubmit (payload) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/vuemember/register', { id, pw })
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