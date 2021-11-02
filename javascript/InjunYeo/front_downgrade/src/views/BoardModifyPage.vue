<template>
    <div align="center">
        <h2>게시물 수정</h2>
        <board-modify-form v-if="board" :board=board @submit="onSubmit"/>
        <p v-else>로딩중.......</p>
    </div>
</template>



<script>
import BoardModifyForm from '@/components/board/BoardModifyForm'
import { mapState,mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'BoardModifyPage',
    components: {
        BoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['board'])
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onSubmit(payload){
            const {title, content} = payload
            axios.put(`http://localhost:7777/vueboard/${this.boardNo}`,{title,content})
                    .then(res=>{
                        alert('수정성공!')
                        //louter link to 랑 역할이 똑같음
                        //자바스크립트 내에서 쓸수없기 때문에 여기서씀
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString()}
                        })
                    })
                    .catch(err =>{
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchBoard(this.boardNo)
            .catch(err=>{
                alert(err.response.data.message)
                this.$router.back()
            })
    }


}
</script>