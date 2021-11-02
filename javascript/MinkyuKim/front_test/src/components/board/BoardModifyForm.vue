<template>
    <div>
        <h3>Board Modified Form</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>글번호</td>
                    <td><input type="text" :value="board.boardNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="board.regDate" disabled></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <!-- db에 있던 값을 참조하는거라 문제 board.title이 아닌 title-->
                    <td><input type="text" v-model="title"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <!-- readonly와 disabled는 기능이 거의 유사. 단지 disabled의 경우 손을 못데게 막아둔 것 
                         또한 disabled의 경우 포커싱도 안됨.-->
                    <td><input type="text" :value="board.writer" disabled></td>
                </tr>
                <tr>
                    <td>본문</td>
                    <!-- v-model 함으로써 frontend와 db에 둘다 입력이된다 -->
                    <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <!-- BoardReadPage에 있는 boardNo의 boardNo.toString() 
                    toStrign(객체 boardNo에 대한 정보를 전달)으로 이동한다 
                    즉, 현재 개체(board.boardNo의 문자열을 반환한다.)-->
                <router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'BoardModifyForm',
    props: {
        board: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    },
    created () {
        this.title = this.board.title
        this.content = this.board.content
    }
}
</script>