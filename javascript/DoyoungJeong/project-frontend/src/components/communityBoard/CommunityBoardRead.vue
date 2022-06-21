<template>
    <div>
        <v-container style="margin-top: 30px;">
            <table style="margin-left: 300px;">
                <tr>
                    <td class="description" style="width: 100px;">글 제목</td>
                    <v-text-field disabled v-bind:value="board.title" style="width: 500px;"/>
                </tr>
                <tr>
                    <td class="description" style="width: 100px;">본문</td>
                    <v-textarea disabled v-bind:value="board.content" style="width: 500px;" auto-grow></v-textarea>
                </tr>
                <tr>
                    <td class="description" style="width: 100px; color: red;" @click="addReply">댓글 달기</td>
                    <v-text-field style="width: 500px;" v-model="reply" @keydown.enter="addReply"></v-text-field>
                </tr>
            </table>

            <div style="margin-top: 30px;">
                <v-btn type="text" class="btn-flat red-text waves-effect waves-teal" @click="modify">수정, 삭제</v-btn>
                <v-btn type="text" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 30px;" @click="goBack">뒤로가기</v-btn>
            </div>

        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'CommunityBoardRead',
    props: {
        board: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            reply: ''
        }
    },
    computed: {
        ...mapState(['userProfile', 'isLoggedIn', 'replyList'])
    },
    methods: {
        ...mapActions(['fetchReplyList', 'fetchBoard']),

        modify() {
            if(this.$store.state.isLoggedIn && (this.$store.state.userProfile.id == this.$store.state.board.id ||
            this.$store.state.userProfile.id == 'admin@gmail.com')) { 

                this.$router.push({
                    name: 'CommunityModifyPage',
                    params: this.board.boardNo
                })

            } else {
                alert('권한이 없습니다!')
            }
        },
        goBack() {
            this.$router.push({
                name: 'CommunityPage'
            })
        },
        addReply() {
            if(this.isLoggedIn) {
                
                 axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(this.reply == '') {
                            alert('내용을 입력해주세요.')
                        
                        } else if(res.data == true) {

                            //this.$store.state.replyList.push({ id: this.$store.state.userProfile.id, content: this.reply })

                            const boardNo = this.board.boardNo
                            const id = this.$store.state.userProfile.id
                            const content = this.reply

                            axios.post('http://localhost:8888/board/addReply', { boardNo, id, content })
                                .then(alert('댓글이 게시되었습니다!'))

                                this.fetchReplyList(this.board.boardNo) //이거랑..
                                this.reply = ''
                
                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        } 
                    })           

            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
        }
    },
    updated() {
        this.fetchReplyList(this.board.boardNo) //요걸로 댓글 업뎃 시 화면에 바로 적용 완료
    }
}
</script>
