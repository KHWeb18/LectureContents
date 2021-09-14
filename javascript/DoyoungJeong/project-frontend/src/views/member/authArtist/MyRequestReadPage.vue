<template>
    <div align="center" class="grey darken-0.1" style="height: 100%; padding-top: 60px;">
        <p class="memberListTitle">Concert Request</p>
        <p class="description">회원님이 작성한 공연 게시 요청 정보입니다. 거부되어도 재요청을 보낼 수 있습니다. :)</p>

        <v-container style="margin-top: 40px;">

            <div class="row" style="justify-content: center;">

                <div>
                    <p class="footerText" style="font-size: 20px;">이하 공연 업로드 요청사항</p>

                    <br/>

                    <input :value="'요청자: ' + concertRequest.regName" disabled
                    class="footerText" style="width: 350px; color: white;"/>

                    <br/>

                    <input :value="'아티스트: ' + concertRequest.artistName" disabled
                    class="footerText" style="width: 350px; color: white;"/>

                    <br/>

                    <input :value="'장소: ' + concertRequest.venueName" disabled
                    class="footerText" style="width: 350px; color: white;"/>

                    <br/>

                    <input :value="'공연명: ' + concertRequest.concertName" disabled
                    class="footerText" style="width: 350px; color: white;"/>

                    <br/>

                    <input :value="'공연 일자: ' + concertRequest.dateOfConcert + ' ' + concertRequest.timeOfConcert" disabled
                    class="footerText" style="width: 350px; color: white;"/>

                    <br/>

                    <input :value="'요청 일자: ' + concertRequest.regDate" disabled
                    class="footerText" style="width: 350px; color: white;"/>

                    <br/>
                    <br/>

                    <td v-if="concertRequest.approvedOrNot == null || concertRequest.approvedOrNot == 'A'" class="footerText">
                        게시 요청 대기 중
                        <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on">
                            <v-icon>crop_square</v-icon>
                        </v-btn>
                    </td>

                    <td v-else-if="concertRequest.approvedOrNot == 'Y'" class="footerText">
                        게시 요청 수락됨
                        <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on">
                            <v-icon>done</v-icon>
                        </v-btn>
                    </td>

                    <td v-else-if="concertRequest.approvedOrNot == 'N'" class="footerText">
                        게시 요청 거부됨
                        <v-btn class="ma-2" text icon color="error lighten-1" v-bind="attrs" v-on="on">
                            <v-icon>remove</v-icon>
                        </v-btn>
                    </td>

                    <td v-else-if="concertRequest.approvedOrNot == 'R'" class="footerText">
                        수정된 요청 대기 중
                        <v-btn class="ma-2" text icon color="orange lighten-1" v-bind="attrs" v-on="on">
                            <v-icon>replay</v-icon>
                        </v-btn>
                    </td>

                    <v-textarea v-if="concertRequest.approvedOrNot == 'N'"
                        background-color="grey lighten-2"
                        color="teal"
                        label="등록을 못해드려 죄송합니다. :( 상기 이유는 다음과 같습니다."
                        style="width: 400px; margin-top: 30px; margin-left: 10px;"
                        class="footerText"
                        outlined
                        v-model="concertRequest.requestReply"
                        height="10%;"
                        auto-grow
                        readonly
                    ></v-textarea> <!-- height조절이 안되는 버그??? -->

                    <div style="margin-top: 20px;">
                        <button @click="modify" class="btn-flat red-text waves-effect waves-teal" style="font-size: 12px;">요청 사항 변경</button>
                        <button @click="deletee" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 50px; font-size: 12px;">요청 취소</button>
                        <button @click="cancel" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 50px; font-size: 12px;">뒤로</button>
                    </div>

                </div>
            </div>

        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'MyRequestReadPage',
    props: {
        concertRequestNo: {
            type: String, //String으로 해도 됨
            required: true
        }
    },

    computed: {
        ...mapState(['userProfile', 'isLoggedIn', 'concertRequest'])
    },
    methods: {
        ...mapActions(['fetchConcertRequest']),

        modify() {
            this.$router.push({
                name: 'MyRequestModifyPage',
                params: { concertRequestNo: this.concertRequestNo }
            })
        },
        deletee() {
            
            axios.delete(`http://localhost:8888/member/concertRegister/requestDelete/${this.concertRequestNo}`)
                .then(() => {
                    alert('게시 요청이 삭제되었습니다.')

                    this.$router.push({
                        name: 'MyRequestListPage'
                    })
                })
                .catch(() => {
                    alert('잠시 후에 다시 시도해주세요!')
                })
        },
        cancel() {
            this.$router.push({
                name: 'MyRequestListPage'
            })
        }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
        this.fetchConcertRequest(this.concertRequestNo)
        //this.writeRequestReply = this.$store.state.concertRequest.requestReply 왜 바로 패치가 안되지 하 ㅅㅂ ㅠㅠ
    }
}
</script>
