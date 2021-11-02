<template>
    <div aligh="center">
        <h2>게시글 수정</h2>
        <board-modify-form v-if="board" :board="board" v-on:submit="onSubmit"/>
        <!-- board가 있으면 v-bind:board="board" 없으면 v-else -->
        <p v-else>로딩중...</p>
    </div>
</template>


<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

import BoardModifyForm from '../components/board/BoardModifyForm'

export default {
    name: 'BoardModifyPage',
    components: {
        BoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
            //여기에 boardNo은 어디서와서 나가는?? 이거 질문해야할듯.. --> BoardReadPage에서 링크 params로 들어온 params: { boardNo } 값이다!
        }
    },
    computed: {
        ...mapState(['board'])
    },
    methods: {
        ...mapActions(['fetchBoard']),

        onSubmit(payload) {
            const { title, content } = payload
            axios.put(`http://localhost:7777/vueboard/${this.boardNo}`, { title, content })
                .then(res => {
                    alert('수정 성공')

                    this.$router.push({ //여기서 push는 router-link to: 의 기능과 같다. 링크 이동역할
                        name: 'BoardReadPage',
                        params: { boardNo: res.data.boardNo.toString() }
                        //위 방식은 boardNo객체를 fetchBoard로 가져와 다시 그 안의 boardNo값을 뺀 후 toString으로 변화시킨것이다!
                        //params: { boardNo: this.boardNo } 이렇게 써도 잘 페이지 전환이 가능하다!
                    })
                })
                .catch(err => {
                    alert(err.response.data.message)
                })
        }
    },
    created() {
        this.fetchBoard(this.boardNo)
            .catch(err => {
                alert(err.response.data.message)
                this.$router.back()
            })
    }
}
</script>
