<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
//@는 src root파일을 의미한다. ..는 뭐였지? 상위 파일이라는 뜻
import axios from 'axios'

export default {
    name: 'BoardRegisterPage',
    components: {
        'board-register-form': BoardRegisterForm     
    },
    methods: {
        onSubmit(payload) {
            const { title, writer, content } = payload
            axios.post('http://localhost:7777/vueboard/register', { title, writer, content })
            .then(res => {
                alert('등록 성공! ' + res.data)
                this.$router.push({
                    name: 'BoardListPage'
                })
            })
            .catch(res => {
                alert('upload failed ' + res.response.data.message)
            })
        }
    }
}
</script>
