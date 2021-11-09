<template>
    <div>
        <h3>Vue + Spring 게시물 일기 </h3>
        <table>
            <tr>
                <td>글번호</td>                
                <td><input type="text" :value="board.boardNo" readonly></td>                            
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="board.regDate" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" :value="board.title" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" :value="board.writer" readonly></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" :value="board.content" readonly></textarea></td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'BaordRead',
    props: {
        board: {
            type: Object,
            // required는 반드시 있어야 한다라는 의미.
            // 반대로 default는 false. 
            required: true
        }
    }
}
</script>