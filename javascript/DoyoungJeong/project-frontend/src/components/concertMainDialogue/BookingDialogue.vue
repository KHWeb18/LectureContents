<template>
    <v-dialog v-model="bookingDialog" persistent max-width="400">

        <template v-slot:activator="{ on }">

            <v-btn v-if="!isLoggedIn" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" @click="notLoggedIn" outlined>
                <v-icon color="white">
                    drafts
                </v-icon>
            </v-btn>

            <v-btn v-else class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" v-on="on" @click="setInfo" outlined>
                <v-icon color="white">
                    drafts
                </v-icon>
            </v-btn>

            <!-- <v-btn v-else class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" outlined
            @click="notLoggedIn">예약하기!</v-btn> -->
        </template>

        <v-card>
            <v-card-title class="headLine">
                <p id="headline" style="margin-bottom: 20px;">Booking Receipt</p>
            </v-card-title>
            <v-card-text>
                <v-container style="width: 80%">
                    <v-layout wrap>
                        <form>
                            <v-flex xs12>
                                <v-text-field label="휴대폰 번호" type="text" required v-model="phoneNo"></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="이름" type="text" style="width: 70%" required v-model="name"></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="예약 인원" type="number" style="width: 40%" required v-model="numOfVisitors"></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <input type="text" id="message" label="메시지" @click="resetText" v-model="message"/>
                            </v-flex>
                            <p align="center" id="description">확인을 누르시면 예약정보가 문자로 전송됩니다!<br>
                            본 예약 서비스는 로그인 정보를 기반으로 해당 공연장소로 전달됩니다 :)</p>
                        </form>
                    </v-layout>
                </v-container>
            
            </v-card-text>
            
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="teal darken-1" text @click.native="confirm($event)">
                    확인!
                </v-btn>
                <v-btn color="teal darken-1" text @click.native="cancel($event)">
                    취소
                </v-btn>
            </v-card-actions>

        </v-card>
    </v-dialog>

</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'BookingDialogue',
    props: {
        member: {
            type: Object
        },
        concertNo: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            phoneNo: '',
            name: '',
            numOfVisitors: '',
            message: '해당 공연장 매니저에게 미리 남길 말이 있나요?',
            bookingDialog: false
        }
    },
    methods: {
        notLoggedIn() {
            alert('로그인이 필요한 서비스입니다!')
        },
        confirm() {
            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {

                            if(!/^[가-힣|a-z|A-Z|0-9|?'#!$|/\s/g]+$/.test(this.name)) {
                                alert('올바른 이름를 입력해주세요. :)')
                            } else if(!/^[0-1]{3}[0-9]{3,4}[0-9]{4}/.test(this.phoneNo)) {
                                alert('올바른 휴대번호를 입력해주세요!')
                            } else if(this.numOfVisitors > 6 || this.numOfVisitors < 1) {
                                alert('함께 예약 할 수 있는 인원은 최소 1명 이상 6명 이하입니다!')
                            } else {
                                
                                const memberNo = this.$store.state.userProfile.memberNo
                                const concertNo = this.concertNo
                                const name = this.name
                                const concertName = this.$store.state.concert.concertName
                                const phoneNumber = this.phoneNo
                                const numOfVisitors = this.numOfVisitors
                                const message = this.message

                                //alert(JSON.stringify({ memberNo, concertNo, name, phoneNumber, numOfVisitors, message }))

                                axios.post('http://localhost:8888/concert/makeBooking', { memberNo, concertNo, name, concertName, phoneNumber, numOfVisitors, message })
                                    .then(() => {
                                        alert('예약 정보가 전송되었습니다 :) 이용해주셔서 감사합니다.')

                                        this.$store.state.concert.venueCapacity = this.$store.state.concert.venueCapacity - numOfVisitors
                                        this.$store.state.notBookedYet = false
                                    })
                                    .catch(() => {
                                        alert('잠시 후에 다시 시도해주세요!')
                                    })

                                this.bookingDialog = false
                            }
                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
            // this.bookingDialog = false  
            // this.phoneNumber = '',
            // this.namee = '',
            // this.numOfVisitors = '',
            // this.message =  '해당 공연장 매니저에게 미리 남길 말이 있나요?'
        },
        cancel() {
            this.bookingDialog = false   
            this.phoneNumber = '',
            this.name = '',
            this.numOfVisitors = '',
            this.message =  '해당 공연장 매니저에게 미리 남길 말이 있나요?'
        },
        resetText() {
            this.message = ''
        },
        setInfo() {
            this.phoneNo = this.member.phoneNo
            this.name = this.member.name
        }
    },
    computed: {
        ...mapState(['isLoggedIn', 'userProfile', 'notBookedYet'])
    }
}
</script>

<style>

#message {
    font-size: 12px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
}

</style>
