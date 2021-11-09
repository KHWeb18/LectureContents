<template>
    <div>
        <v-simple-table>
            <template>
                <thead>
                    <tr> 
                        <th class="text-center" width="64">No.</th>
                        <th class="text-center">제목</th>
                        <th class="text-center">작성일</th>
                    </tr>
                    <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                        <td colspan="4">
                            현재 등록된 게시물이 없습니다!
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="board of boards" :key="board.boardNo">
                        <td style="text-align:center">{{ board.boardNo }}</td>
                        <td>
                            <router-link :to="{ name: 'NoticeBoardReadPage',
                                                params: { boardNo: board.boardNo.toString() } }">
                                        {{ board.title }}
                            </router-link>
                        </td>
                        <td style="text-align:center">{{ board.regDate }}</td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>
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