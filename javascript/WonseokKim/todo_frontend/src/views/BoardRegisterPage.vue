<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
// @는 src 자체를 의미 함
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'BoardRegisterPage',
    components: {
        BoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/vueboard/register', { title, writer, content })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        this.$router.push({
                            name: 'BoardListPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>