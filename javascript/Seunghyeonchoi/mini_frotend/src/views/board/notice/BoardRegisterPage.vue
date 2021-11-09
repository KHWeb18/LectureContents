<template>
    <div align="center">
        <h2>글쓰기</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import BoardRegisterForm from '@/components/board/notice/BoardRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'BoardRegisterPage',
    components: {
        BoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/noticeboard/register', { title, writer, content })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                         console.log('게시물 번호: ' + res.data.boardNo.toString())

                        this.$router.push({
                            name: 'NoticeBoardListPage'
                            // params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script> 