<template>
    <div style="margin-top: 20px;">
        <v-container>
            <!-- <table>
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
                            <router-link :to="{ name: 'CommunityReadPage', params: { boardNo: board.boardNo.toString() }}"> 
                                {{ board.title }}
                            </router-link>
                        </p>
                    </td>
                    <td>{{ board.id }}</td>
                    <td style="text-align: right;">{{ board.regDate }}</td>
                </tr>
            </table> -->
            <v-data-table :headers="headerTitle"
                        :items="boards"
                        :items-per-page="5"
                        :search="searchTitle"
                        class="elevation-1">

                    <template v-slot:item="{ item, index }"> <!-- v-data-table에서 index뽑는 법 -->
                        <tr>
                            <td>{{ index + 1 }}</td>
                            <td @click="handleClick(item.boardNo)">{{ item.title }}</td>
                            <td>{{ item.id }}</td>
                            <td>{{ item.regDate }}</td>
                        </tr>
                    </template>

            </v-data-table>
            
            <v-text-field label="찾을 게시글의 제목 또는 작성자를 검색하세요." v-model="searchTitle" class="footerText"
            style="width: 300px; float: right;"/>

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
    data() {
        return {
            headerTitle: [
                { text: 'NO', value: 'boardNo', width: '10%'},
                { text: '제목', value: 'title', width: '50%'},
                { text: '작성자', value: 'id', width: '20%'},
                { text: '게시일', value: 'regDate', width: '20%'}
            ],
            searchTitle: ''
        }
    },
    methods: {
        sendNum() { //(boardNo)
            // const payload = [ boardNo ]

            // EventBus.$emit('sendNum', payload)
            // console.log('The num has been sent! ' + payload)
        },
        handleClick(boardNo) {
            this.$router.push({
                name:'CommunityReadPage',
                params: { boardNo: boardNo }
            })
        }
    }
}
</script>

