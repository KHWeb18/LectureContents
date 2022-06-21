<template>
    <div align="center" class="grey darken-0.1" style="height: 100%; padding-top: 60px;">
        <p class="memberListTitle">Concert Request</p>
        <p class="description">아티스트로부터 요청된 공연의 상세정보입니다. 만약 거절을 한다면 사유를 입력해주세요.</p>

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

                    <div v-if="concertRequest.approvedOrNot == null || concertRequest.approvedOrNot == 'A'">승인 대기
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(concertRequest.concertRequestNo, 1)">
                                                <v-icon>done</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 수락</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="red lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(concertRequest.concertRequestNo, 2)">
                                                <v-icon>remove</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 거부</span>    
                                    </v-tooltip>
                                    
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on" disabled>
                                                <v-icon>crop_square</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 보류</span>    
                                    </v-tooltip>
                                </div>

                                <div v-else-if="concertRequest.approvedOrNot == 'N'">게시 불가
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(concertRequest.concertRequestNo, 1)">
                                                <v-icon>done</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 수락</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="red lighten-1" v-bind="attrs" v-on="on" disabled>
                                                <v-icon>remove</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 거절</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(concertRequest.concertRequestNo, 3)">
                                                <v-icon>crop_square</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 보류</span>    
                                    </v-tooltip>
                                </div>

                                <div v-else-if="concertRequest.approvedOrNot == 'Y'">승인 완료 <!-- 순서 버그 있음 -> 해결 같이 툴팁에 다 넣어야됨 -->
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on" disabled>
                                                <v-icon>done</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 수락</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="red lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(concertRequest.concertRequestNo, 2)">
                                                <v-icon>remove</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 거절</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(concertRequest.concertRequestNo, 3)">
                                                <v-icon>crop_square</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 보류</span>    
                                    </v-tooltip>
                                </div>
                    
                    <v-textarea v-if="concertRequest.approvedOrNot == 'N' || concertRequest.approvedOrNot == 'R'"
                        background-color="grey lighten-2"
                        color="teal"
                        label="거절하신다면 사유를 입력해주세요."
                        style="width: 400px; margin-top: 30px; margin-left: 10px;"
                        class="footerText"
                        outlined
                        v-model="writeRequestReply"
                        height="10%;"
                        auto-grow
                        @click="updateReply"
                    ></v-textarea> <!-- height조절이 안되는 버그??? -->

                    <v-textarea v-else-if="concertRequest.approvedOrNot == 'Y' || concertRequest.approvedOrNot == 'A' || concertRequest.approvedOrNot == null"
                        disabled
                        background-color="grey lighten-2"
                        color="teal"
                        label=""
                        style="width: 400px; margin-top: 30px; margin-left: 10px;"
                        class="footerText"
                        outlined
                        height="300px;"
                    ></v-textarea> <!-- height조절이 안되는 버그??? -->

                    <div style="margin-top: 20px;">
                        <button @click="submit" class="btn-flat red-text waves-effect waves-teal" style="font-size: 12px;">확인</button>
                        <button @click="deletee" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 30px; font-size: 12px;">요청 삭제</button>
                        <button @click="cancel" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 30px; font-size: 12px;">뒤로</button>
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
    name: 'RequestReadPage',
    props: {
        concertRequestNo: {
            type: String, //String으로 해도 됨
            required: true
        }
    },
    data() {
        return {
            tmpArr: [],
            writeRequestReply: ''
        }
    },
    computed: {
        ...mapState(['userProfile', 'isLoggedIn', 'concertRequest', 'requestReply'])
    },
    methods: {
        ...mapActions(['fetchConcertRequest', 'fetchRequestReply']),

        approveOrNotConcert(concertRequestNo, tmpNum) {

            this.tmpArr.push(concertRequestNo)
            this.tmpArr.push(tmpNum)

            const numArr = this.tmpArr

            axios.post('http://localhost:8888/member/concertRegister/approveOrNotRequest', { numArr })
                .then(() => {

                    this.tmpArr = []

                    if(tmpNum == 1) {
                        this.$store.state.concertRequest.approvedOrNot = 'Y'
                    } else if(tmpNum == 2) {
                        this.$store.state.concertRequest.approvedOrNot = 'N'
                    } else if(tmpNum == 3) {
                        this.$store.state.concertRequest.approvedOrNot = 'A'
                    }

                })
                .catch(() => {
                    alert('잠시 후에 다시 시도해주세요!')
                    this.tmpArr = []
                })
        },
        submit() {
            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {
                            
                            const concertRequestNo = this.concertRequestNo
                            const requestReply = this.writeRequestReply

                            axios.post('http://localhost:8888/member/concertRegister/leaveReply', { concertRequestNo, requestReply })
                                .then(() => {

                                    alert('적용되었습니다!')
                                    this.$router.push({
                                        name: 'RequestStorePage'
                                    })
                                })
                                .catch(() => {
                                    alert('잠시 후에 다시 시도해주세요!')
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
                name: 'RequestStorePage'
            })
        },
        updateReply() {
            if(this.writeRequestReply == '') {
                this.writeRequestReply = this.$store.state.concertRequest.requestReply
            }
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
