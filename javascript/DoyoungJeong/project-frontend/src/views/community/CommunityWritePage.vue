<template>
    <div align="center" class="grey darken-0.1" style="height: 850px;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">COMMUNITY COMMENT</h3>
        <p class="description">여러분들의 공연에 대한 기대나 후기를 공유해주세요. :)</p>

        <v-container style="margin-top: 30px;">
            <form @submit.prevent="onSubmit">
                <table style="margin-left: 300px;">
                    <tr>
                        <td class="description" style="width: 100px;">글 제목</td>
                        <v-text-field required v-model="title" style="width: 500px;"/>
                    </tr>
                    <tr>
                        <td class="description" style="width: 100px;">본문</td>
                        <v-textarea required v-model="content" style="width: 500px;" auto-grow></v-textarea>
                    </tr>

                </table>

                <div style="margin-top: 30px;">
                    <v-btn type="submit" text="text" class="btn-flat red-text waves-effect waves-teal">글 게시</v-btn>
                    <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 10px;" @click="goBack">뒤로가기</v-btn>
                </div>
            </form>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'CommunityWritePage' ,
    data() {
        return {
            title: '',
            content: ''
        }
    },
    methods: {
        ...mapActions(['fetchBoardList']),

        onSubmit() {
            if(this.isLoggedIn) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {
                            
                            const id = this.$store.state.userProfile.id
                            const title = this.title
                            const content = this.content
                            
                            axios.post('http://localhost:8888/board/upload', { id, title, content })
                                .then(alert('글이 등록되었습니다 :)'))

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
                name: 'CommunityPage'
            })
        }
    },
    computed: {
        ...mapState(['isLoggedIn', 'userProfile'])
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
    }
}
</script>