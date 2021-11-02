<template>
    <div align="center">
        <h2>게시글 작성</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import axios from 'axios'


export default {
    name: 'BoardRegisterPage',
    components: {
        BoardRegisterForm
    },
    methods: {
        // payload : BoardRegisterForm.vue에서 emit으로 받음 
        onSubmit (payload) {
            const { title, writer, content } = payload
            axios.post('http://localhost:7777/vueboard/register', { title, writer, content })
                .then(res => {
                    alert('등록이 완료되었습니다.' + res)
                    console.log('게시물 번호 : ' + res.data.boardNo.toString ())
                    this.$router.push({
                        name: 'BoardListPage',
                        /* params: {boardNo: res.data.boardNo.toString () } */
                    })
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}

</script>