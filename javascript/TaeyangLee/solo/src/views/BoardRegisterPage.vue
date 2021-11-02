<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>


<script>
import BoardRegisterForm from '@/components/board/BoardRegisterForm'
import axios from 'axios'


export default {
    name: 'BoardRegisterPage',
    components: {
        BoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, writer, content } = payload
            axios.post('http://localhost:7777/board/register',{ title, writer, content })
            .then(res => {
                alert('등록 성공!' + res)
                this.$router.push({
                    name: 'BoardListPage'
                    //params: {boardNo: res.data.boardNo.toString() }
                })
                
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }
    }

}
</script>