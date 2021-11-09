<template>
    <div align="center">
        <h3>Board Modified Form</h3>
        <form @submit.prevent="onSubmit">
            <!-- .prevent를 붙여주는 이유? -->
            <table>
                <tr>
                    <td>글번호</td>
                    <td><input type="text" v-bind:value="board.boardNo" disabled></td> <!-- disabled는 readonly랑 다르게 아예 클릭조차 안됨다 -->
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" v-model="title"></td>
                    <!-- board.title이라고 하면 db에 있는 정보가 그대로 들어가기 때문에 그냥 title로
                    바꿔줘야한다! -->
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" v-bind:value="board.writer" disabled></td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" v-bind:value="board.regDate" disabled></td>
                </tr>
            </table>
            <button type="submit">수정 완료</button>
            <!-- 이 submit 버튼이 form @submit과 함께 form 안에 들어있어야 했다! 
            즉 하나의 폼에 한 개의 @submit과 하나의 submit버튼만이 존재해야 하는것이다!-->
        </form>

        <router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() }}">
            수정 취소
        </router-link>
    </div>
</template>

<script>

export default {
    name:'BoardModifyForm',
    props: {
        board: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            title: this.board.title,
            content: this.board.content
            // title: '',
            // content: ''
        }
    },
    created() {
        // this.title = this.board.title
        // this.content = this.board.content
        //없어도 잘 작동 함
    },
    methods: {
        onSubmit() {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    }
}

</script>
