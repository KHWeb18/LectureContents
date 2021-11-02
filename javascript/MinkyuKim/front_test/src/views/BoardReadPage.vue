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
        boardNo: {
            // json의 형태는 문자. 따라서 String 데이터타입으로 지정.
            type: String,
            required: true
        }
    },
    components: {
        BoardRead
    },
    // computed- 실제 동작이 발생될 때 작동
    computed: {
        ...mapState(['board'])
    },
    // created-객체가 생성될때 작동
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
            // this.boardNo 를 쓰는것이 아니라  this.board 로 사용한 이유는 확장성을 위해.
            // 추후 필요하다면 boardNo뿐만 아니라 다른것도 받아올 수 있음
            const { boardNo } = this.board
            axios.delete(`http://localhost:7777/vueboard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'BoardListPage' })
            })
            .catch(err => {
                alert(err.response.date.message)
            })
        }
    }
}
</script>