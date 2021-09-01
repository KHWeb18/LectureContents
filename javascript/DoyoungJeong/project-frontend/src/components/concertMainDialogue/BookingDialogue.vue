<template>
    <v-dialog v-model="bookingDialog" persistent max-width="400">
        <template v-slot:activator="{ on }">
            <v-btn class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" v-on="on" outlined>예약하기!</v-btn>
        </template>

        <v-card>
            <v-card-title class="headLine">
                <p id="headline" style="margin-bottom: -5px;">Booking Receipt</p>
            </v-card-title>
            <v-card-text>
                <v-container style="width: 80%">
                    <v-layout wrap>
                        <v-flex xs12>
                            <v-text-field label="휴대폰 번호" type="text" required v-model="phoneNumber"></v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="휴대폰 번호 재확인" type="text" required v-model="phoneNumberSub"></v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="이름" type="text" style="width: 70%" required v-model="name"></v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="예약 인원" type="number" style="width: 40%" required v-model="numOfVisitor"></v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <input type="text" id="message" label="메시지" @click="resetText" v-model="message"/>
                        </v-flex>
                        <p align="center" id="description">확인을 누르시면 예약정보가 문자로 전송됩니다!<br>
            본 예약 서비스는 로그인 정보를 기반으로 해당 공연장소로 전달됩니다 :)</p>
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
    data() {
        return {
            phoneNumber: '',
            phoneNumberSub: '',
            name: '',
            numOfVisitor: '',
            message: '해당 공연장 매니저에게 미리 남길 말이 있나요?',
            bookingDialog: false
        }
    },
    methods: {
        confirm() {
            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {
                            alert('예약 정보가 전송되었습니다 :) 이용해주셔서 감사합니다.')
                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
            this.bookingDialog = false  
            this.phoneNumber = '',
            this.phoneNumberSub = '',
            this.name = '',
            this.numOfVisitor = '',
            this.message =  '해당 공연장 매니저에게 미리 남길 말이 있나요?'
        },
        cancel() {
            this.bookingDialog = false   
            this.phoneNumber = '',
            this.phoneNumberSub = '',
            this.name = '',
            this.numOfVisitor = '',
            this.message =  '해당 공연장 매니저에게 미리 남길 말이 있나요?'
        },
        resetText() {
            this.message = ''
        }
    },
    computed: {
        ...mapState(['isLoggedIn'])
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
