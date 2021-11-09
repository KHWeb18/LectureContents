<template>
    <div align="center">
        <h3>게시물 목록</h3>
        <table border="1">
            <tr>
                <td align="center" width="80">번호</td>
                <td align="center" width="120">제목</td>
                <td align="center" width="120">작성자</td>
                <td align="center" width="80">등록일자</td>
            </tr>
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <!-- 'boards가 없으면' 이라는 뜻 -->
                <td colspan="4">
                    등록된 게시물이 없습니다.
                </td>
            </tr>
            <tr v-else v-for="board in boards" :key="board.boardNo">
                <td align="center">{{ board.boardNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'BoardReadPage', 
                        params: { boardNo: board.boardNo.toString() } }">
                    {{ board.title }}
                    </router-link>
                    
                </td>
                <td align="right">{{ board.writer }}</td>
                <td align="center">{{ board.regDate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'BoardList',
    props: {
        boards: {
            type: Array
        }
    }
}
</script>

<style>

table {
    float: center;
}

</style>

