<template>
    <div align=center>
        <table>
            <tr>
                <td>글번호</td>
                <td><input type="text" v-bind:value="board.boardNo" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" v-bind:value="board.title" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" v-bind:value="board.writer" readonly></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" v-bind:value="board.content" readonly></textarea></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" v-bind:value="board.regDate" readonly></td>
            </tr>

        </table>
    </div>
    <!-- 한 vue파일에서 하나의 div만 들어갈 수 있다 -->
</template>

<script>

export default {
    name: 'BoardRead',
    props: {
        board: {
            type: Object,
            required: true
            //required는 ??? board라는 객체가 꼭 있어야 한다는 뜻!
        }
    }
    
    
}
</script>