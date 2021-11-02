<template>
    <div align="center">
        <h2>Vue + Spring 게시판 읽기</h2>
        <board-read v-if="board" :board="board"/>
        <p v-else>로딩중 ...... </p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'BoardListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>
import BoardRead from '@/components/board/BoardRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'BoardReadPage',
    props: {
            // 데이터가 JSON으로 넘어오고,
            // JSON은 문자이다.
            // 따라서 처음 넘어올때 String으로 넘어옴
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
    // created : 객체가 생성될때
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
            const { boardNo } = this.board
            axios.delete(`http://localhost:7777/vueboard/${boardNo}`)
                .then(() => {
                    alert('게시글을 삭제했습니다.')
                    this.$router.push({ name: 'BoardListPage' })
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}
</script>