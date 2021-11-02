<template>
    <div>
        <h2>게시글 읽기</h2>
        <board-read v-if="board" v-bind:board="board"/>
        <!-- v-if="board"는 board가 있으면 이라는 뜻??? -->
        <p v-else>로딩중 ...</p>

        <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            게시글 수정
        </router-link>
        
        <router-link :to="{ name: 'BoardListPage' }">
            게시글 목록 보기
        </router-link>
        <button v-on:click="onDelete">게시글 삭제</button>
    </div>
</template>
<!-- 한 vue파일에서 하나의 div만 들어갈 수 있다. 웬만하면 div를 설정 해줘야 에러가 안난다.-->
<script>

import BoardRead from '../components/board/BoardRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'BoardReadPage',
    components: {
        BoardRead
    },
    props: {
        boardNo: {
            type: String,
            //JSON형식으로 정보를 받기 때문에 String으로 지정됨.
            required: true
        }
        //이 boardNo은 밑에 fetchBoard에 인자로 들어가기위해 있는것인가? --> 맞음

        //그리고 boardNo는 어디서 오고 가는 애들이지?
        // --> BoardList에서 링크 인자(params: board.boardNo.toString())로 온 애들이다!
    },
    computed: {
        ...mapState(['board'])
    },
    created() {
        this.fetchBoard(this.boardNo)
            .catch(err => {
                alert(err.response.data.message)
                this.$router.push()
            })
            //객체가 만들어질 때 mapAcions에서 불러온 fetchBoard실행
            //밑 this.$router.push()는 ?
    },
    methods: {
        ...mapActions(['fetchBoard']),

        onDelete() {
            const { boardNo } = this.board
            //확장성을 위해 this.board에서 boardNo만을 뽑아서 객체로 받아 전송한것이다!
            axios.delete(`http://localhost:7777/vueboard/${boardNo}`)
            .then(() => {
                alert('delete completed')
                this.$router.push({ name: 'BoardListPage' })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    }

    
}
</script>
