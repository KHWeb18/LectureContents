<template>
    <div>
        <center>
        <v-card>
            <table border="1" >
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="150" class="trstyle">백신종류</th>
                <th align="center" width="150">나이</th>
                <th align="center" width="150">성별</th>
                <th align="center" width="150">등록일자</th>
                <th align="center" width="150"></th>
            </tr>
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in boards" :key="board.boardNo">
                <td align="center">{{ board.boardNo }}</td>
                <td align="center">{{ board.vaccine }}</td>
                <td align="center">{{ board.age }}</td>
                <td align="center">{{ board.gender }}</td>
                <td align="center">{{ board.regDate }}</td>
                <td align="center">
                    <router-link :to="{ name: 'BoardReadPage',
                                    params: { boardNo: board.boardNo.toString() } }">
                    후기보기
                    </router-link>
                </td>
            </tr>
        </table>
        </v-card>
        
        </center>
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


<style scoped>
    th{
        text-align: center;
        color: rgba(29, 117, 199, 0.945);
    }
    td{
        text-align: center;

    }
    
</style>
