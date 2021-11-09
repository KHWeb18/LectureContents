<template>
    <div align="center">
        <h2>게시물작성</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import axios from 'axios'


export default {

    name: 'BoardRegisterPage',
    components:{
        BoardRegisterForm
    },
    methods:{
        onSubmit(payload){

            const{title, content, writer} = payload
            axios.post('http://localhost:7777/vueboard/register',{title,writer,content})
                .then(res => {
                    alert('등록성공!'+ res)
                    
                    this.$router.push({
                        name: 'BoardListPage',
                       // params: { boardNo: res.data.boardNo.toString()}
                    })
                    
                    
                })
                .catch(res => {
                    alert(res.response.data.message)
                })

        }
    }
    
}
</script>