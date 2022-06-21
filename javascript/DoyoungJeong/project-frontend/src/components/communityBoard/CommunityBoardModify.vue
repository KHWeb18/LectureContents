<template>
    <div>
        <v-container style="margin-top: 30px;">
            <table style="margin-left: 300px;">
                <tr>
                    <td class="description" style="width: 100px;">글 제목</td>
                    <v-text-field required v-model="title" style="width: 500px;" outlined color="teal"/>
                </tr>
                <tr>
                    <td class="description" style="width: 100px;">본문</td>
                    <v-textarea required v-model="content" style="width: 500px;" auto-grow outlined></v-textarea>
                </tr>
            </table>

            <div style="margin-top: 30px;">
                <v-btn type="text" class="btn-flat red-text waves-effect waves-teal" @click="modify">수정</v-btn>
                <v-btn type="text" class="btn-flat red-text waves-effect waves-teal"  style="margin-left: 10px;" @click="deletee">삭제</v-btn>
                <v-btn type="text" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 10px;" @click="goBack">취소</v-btn>
            </div>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'CommunityBoardModify',
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
        }
    },
    computed: {
        ...mapState(['userProfile', 'isLoggedIn'])
    },
    methods: {
        ...mapActions(['fetchBoardList']),

        modify() {
            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {

                            const boardNo = this.$store.state.board.boardNo
                            const title = this.title
                            const content = this.content
                            
                            axios.put('http://localhost:8888/board/modify', { boardNo, title, content })
                                .then(() => {
                                    alert('수정이 완료되었습니다!')

                                    this.$router.push({
                                        name: 'CommunityPage'
                                    })
                                })

                                .catch(() => {
                                    alert('게시글 수정 실패. 잠시 후에 다시 시도해주세요!')
                                })
                            
                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
        },
        deletee() {
            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {

                            const boardNo = this.$store.state.board.boardNo
                            
                            axios.delete(`http://localhost:8888/board/delete/${ boardNo }`)
                                .then(alert('게시글이 삭제되었습니다!'))

                                this.fetchBoardList()

                                this.$router.push({
                                    name: 'CommunityPage'
                                })

                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
        },
        goBack() {
            this.$router.push({
                name: 'CommunityReadPage'
            })   
        }
    }
}
</script>
