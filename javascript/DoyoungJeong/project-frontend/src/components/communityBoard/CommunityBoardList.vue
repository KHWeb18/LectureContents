<template>
    <div style="margin-top: 20px;">
        <v-container>
            <table>
                <tr>
                    <td class="description" width="15%;">No</td>
                    <td class="description" width="50%;">제목</td>
                    <td class="description" width="15%;">작성자</td>
                    <td class="description" width="30%;" style="text-align: right;">게시일</td>
                </tr>
                <tr v-if="!boards || boards.length == 0">
                    <td colspan="4">게시글들을 불러오는 중입니다. 조금만 기다려주세요. :)</td>
                </tr>
                <tr v-else-if="boards" v-for="(board, index) in boards" v-bind:key="index">
                    <td>{{ board.boardNo }}</td>
                    <td>
                        <p @click="sendNum(board.boardNo)" style="margin-bottom: 0px;">
                            <router-link :to="{ name: 'CommunityReadPage', params: { boardNo: board.boardNo.toString() }}"> <!-- 역시나 params가 안작동함 -->
                                {{ board.title }}
                            </router-link>
                        </p>
                    </td>
                    <td>{{ board.id }}</td>
                    <td style="text-align: right;">{{ board.regDate }}</td>
                </tr>
            </table>
        </v-container>
        
    </div>
</template>

<script>
//import EventBus from '@/eventBus.js'

export default {
    name: 'CommunityBoard',
    props: {
        boards: {
            type: Array
        }
    },
    methods: {
        sendNum() { //(boardNo)
            // const payload = [ boardNo ]

            // EventBus.$emit('sendNum', payload)
            // console.log('The num has been sent! ' + payload)
        }
    }
}
</script>
