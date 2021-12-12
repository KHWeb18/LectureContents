<template>
    <div>
        <board-read v-if="board" :board="board"/>
        <p v-else>로딩중 ...... </p>
        <div align="center">
            <!-- <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link> -->
        <!-- <button @click="onDelete">삭제</button> -->
        <router-link :to="{ name: 'BoardListPage' }">
            게시물 보기
        </router-link>
        </div>
        
    </div>
</template>

<script>
import BoardRead from '@/components/board/BoardRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'BoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        BoardRead
    },
    computed: {
        ...mapState(['board'])
    },
    created () {
        this.fetchBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onDelete () {
            const {boardNo} = this.board
            axios.delete(`http://localhost:3647/vueboard/${boardNo}`)
            .then(()=>{
                alert('삭제성공')
                this.$router.push({name:'BoardListPage'})
            })
            .catch(err=>{
                alert(err.response.data.message)
            })
        }
    }
}
</script>