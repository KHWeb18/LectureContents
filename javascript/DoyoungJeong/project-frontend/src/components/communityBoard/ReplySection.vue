<template>
    <div style="margin-top: 30px; width: 75%;">
        <v-container style=" margin-left: 370px; width: 50%;">
            <table>
                <tr>
                    <td class="description">작성된 댓글</td>
                </tr>

                <tr v-for="(reply, index) in replyList" :key="index">
                    <td class="description" style="width: 14%;">{{ reply.id }}</td>

                    <td v-if="modifyIndex == index" class="description" style="width: 75%;"><v-text-field v-model="modifyContent"
                    @keydown.enter="submitModified(reply.boardReplyNo, reply.id, index)"></v-text-field></td>

                    <td v-else-if="modifyIndex != index" class="description" style="width: 75%;">{{ reply.content }}</td>


                    <div v-if="modifyIndex == index">

                        <td width="20" style="padding-left: 5px;"><v-btn class="ma-2" text icon color="red lighten-3" 
                        @click="submitModified(reply.boardReplyNo, reply.id, index)"><v-icon>keyboard_arrow_up</v-icon></v-btn></td>

                        <td style="width: 5%; padding-left: 5px;"><v-btn class="ma-2" text icon color="red lighten-3" 
                        @click="cancel()"><v-icon>cancel</v-icon></v-btn></td>

                    </div>

                    <div v-else-if="modifyIndex != index" style="width: 55px;">

                        <td style="width: 55px;"><v-btn class="ma-2" text icon color="red lighten-3" 
                        @click="modifyReply(reply.content, index)"><v-icon>mode_edit</v-icon></v-btn></td>

                    </div>

                    <td style="text-align: right; width: 55px;"><v-btn class="ma-2" text icon color="red lighten-3"
                    @click="deleteReply(reply.boardReplyNo, reply.id, index)"><v-icon>delete</v-icon></v-btn></td>

                </tr>

            </table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'ReplySection',
    // props: {
    //     replyList: {
    //         type: Array
    //     }
    // },
    data() {
        return {
            modifyIndex: -1,
            modifyContent: ''
        }
    },
    computed: {
        ...mapState(['isLoggedIn', 'userProfile', 'board', 'replyList']),
    },
    methods: {
        ...mapActions(['fetchReplyList']),

        cancel() {
            this.modifyIndex = -1
            this.modifyContent = ''
        },
        modifyReply(content, index) {

            this.modifyIndex = index
            this.modifyContent = content

        },
        submitModified(boardReplyNo, id, index) {
            
            if(this.isLoggedIn && (this.userProfile.id == id || this.userProfile.name == '관리자')) {
                
                 axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {

                            this.$store.state.replyList.splice(index, 1, { boardReplyNo: boardReplyNo, boardNo: this.board.boardNo, id: id, content: this.modifyContent })

                            const replyNo = boardReplyNo
                            const content = this.modifyContent

                            axios.put('http://localhost:8888/board/modifyReply', { replyNo, content })
                                .then(alert('댓글이 수정되었습니다 :)'))

                            //this.fetchReplyList(this.board.boardNo)
                            this.modifyIndex = -1
                            this.modifyContent = ''

                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })           

            } else {
                alert('권한이 없습니다!')
            }

        },
        deleteReply(replyNo, id, index) {

            if(this.isLoggedIn && (this.userProfile.id == id || this.userProfile.name == '관리자')) {
                
                 axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {

                            this.$store.state.replyList.splice(index, 1)

                            axios.delete(`http://localhost:8888/board/deleteReply/${ replyNo }`) //db에 입력 직전에 주석친 fetch를 실행해 가져오다보니 업데이트 전의 데이터를 가져오게 된다
                                .then()

                            //this.fetchReplyList(this.board.boardNo)
                            this.modifyIndex = -1

                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })           

            } else {
                alert('권한이 없습니다!')
            }
        }
    }
}
</script>
