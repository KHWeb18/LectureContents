<template>
    <div align="center">
        <h2>판타지 온라인 회원 가입</h2>
        <!-- vue에서는 같은 형식(구성물)이라면 해당 코드만 붙여넣고, 디자인만 신경쓰면 된다 -->
        <!-- 명명법에 의하여 각 스펠링마다 -가 적용된다. board-register-form과 자바스크립트의 BoardRegisterForm은 같다 -->
        <game-member-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import GameMemberRegisterForm from '@/components/member/GameMemberRegisterForm.vue'
// emit보다는 axios가 더 효율적이지만, emit이 필요하면 경우가 있으므로 숙지해야한다.
import axios from 'axios'

export default {
    name: 'GameMemberRegisterPage',
    components: {
        GameMemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            // payload를 레지스터폼에서 emit으로 받았음.
            const { id, pw } = payload
            axios.post('http://localhost:7777/vuemember/register', { id, pw })

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