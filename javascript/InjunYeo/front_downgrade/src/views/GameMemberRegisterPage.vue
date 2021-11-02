<template>
    <div align="center">
        <h2>회원가입</h2>
        <game-member-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import GameMemberRegisterForm from '@/components/member/GameMemberRegisterForm.vue'
import axios from 'axios'


export default {

    //여기서 스택에러가 발생 왜?
    //모듈을 찾게해주는 역할을 한다.
    name: 'GameMemberRegisterPage',
    components:{
        GameMemberRegisterForm
    },
    methods:{
        onSubmit(payload){

            const{id,password } = payload
            axios.post('http://localhost:7777/vuemember/register',{id,password})
                .then(res => {
                    alert('등록성공!'+ res)
                    /*
                    this.$router.push({
                        name: 'BoardReadPage',
                        params: { boardNo: res.data.boardNo.toString()}
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