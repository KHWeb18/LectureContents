<template>
    <div style="width: 20%; margin-top: 30px;">
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>
                        <input type="text" class="name" disabled v-bind:value="'콘서트명: ' + bookedConcert.concertName" style="color: white;"/>
                    </td>
                </tr>
                <tr>
                    <td v-if="notAlterName">
                        <input type="text" class="name" disabled 
                        v-bind:value="'예약자명: ' + bookedConcert.name" style="color: white; width: 80%; text-align: left;"/>
                        <v-btn text style="color: teal" @click="alterContent(1)"><v-icon>mode_edit</v-icon></v-btn>
                    </td>
                    <td v-else-if="!notAlterName">
                        <v-text-field label="예약자명" required v-model="name" outlined shaped color="teal"                  
                        hint="영문, 한글로 이름을 작성해주세요!"/>
                        <v-btn text style="color: teal" @click="doneAlter(1)"><v-icon>done</v-icon></v-btn>
                    </td>
                </tr>
                <tr>
                    <td v-if="notAlterPhoneNo">
                        <input type="text" class="name" disabled 
                        v-bind:value="'예약 휴대번호: ' + bookedConcert.phoneNumber" style="color: white; width: 80%; text-align: left;"/>
                        <v-btn text style="color: teal" @click="alterContent(2)"><v-icon>mode_edit</v-icon></v-btn>
                    </td>
                    <td v-else-if="!notAlterPhoneNo">
                        <v-text-field label="예약자명" required v-model="phoneNo" outlined shaped color="teal"
                        hint="수정할 전화번호를 입력해주세요!"/>
                        <v-btn text style="color: teal" @click="doneAlter(2)"><v-icon>done</v-icon></v-btn>
                    </td>
                </tr>
                <tr>
                    <td v-if="notAlterNumOfVisitors">
                        <input type="text" class="name" disabled 
                        v-bind:value="'예약 인원: ' + bookedConcert.numOfVisitors + '명'" style="color: white; width: 80%; text-align: left;"/>
                        <v-btn text style="color: teal" @click="alterContent(3)"><v-icon>mode_edit</v-icon></v-btn>
                    </td>
                    <td v-else-if="!notAlterNumOfVisitors">
                        <v-text-field label="예약 인원" type="number" required v-model="numOfVisitors" outlined shaped color="teal"
                        hint="수정할 전화번호를 입력해주세요!" style="width: 50%;"/>
                        <v-btn text style="color: teal" @click="doneAlter(3)"><v-icon>done</v-icon></v-btn>
                    </td>
                </tr>
                <tr>
                    <td v-if="notAlterMessage">
                        <input type="text" class="name" disabled 
                        v-bind:value="'요청메세지: ' + bookedConcert.message" style="color: white; width: 80%; text-align: left;"/>
                        <v-btn text style="color: teal" @click="alterContent(4)"><v-icon>mode_edit</v-icon></v-btn>
                    </td>
                    <td v-else-if="!notAlterMessage">
                        <v-text-field label="요청메세지" type="text" required v-model="message" outlined shaped color="teal"
                        hint="수정할 전화번호를 입력해주세요!"/>
                        <v-btn text style="color: teal" @click="doneAlter(4)"><v-icon>done</v-icon></v-btn>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" class="name" disabled v-bind:value="'예약일시: ' + bookedConcert.regDate" style="color: white;"/>
                    </td>
                </tr>
            </table>

            <div style="margin-top: 20px; margin-bottom: 30px;">
                <v-btn color="error darken-2" text type="submit" style="font-size: 12px;">
                    예약 사항 변경
                </v-btn>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <v-btn color="error darken-3" text @click.native="deleteBooking(bookedConcert.bookedConcertNo)" style="font-size: 12px;">
                    예약 취소
                </v-btn>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <v-btn color="error darken-4" text @click.native="cancel" style="font-size: 12px;">
                    뒤로
                </v-btn>
                
            </div>
        </form>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'BookedConcertAlter',
    props: {
        bookedConcert: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            name: '',
            phoneNo: '',
            numOfVisitors: '',
            message: '',

            notAlterName: true,
            notAlterPhoneNo: true,
            notAlterNumOfVisitors: true,
            notAlterMessage: true
        }
    },
    methods: {
        alterContent(num) {
            if(num == 1) {
                this.notAlterName = false
                this.name = this.bookedConcert.name
            } else if(num == 2) {
                this.notAlterPhoneNo = false
                this.phoneNo = this.bookedConcert.phoneNumber
            } else if(num == 3) {
                this.notAlterNumOfVisitors = false
                this.numOfVisitors = this.bookedConcert.numOfVisitors
            } else if(num == 4) {
                this.notAlterMessage = false
                this.message = this.bookedConcert.message
            }
        },
        doneAlter(num) {
            if(num == 1) {
                this.bookedConcert.name = this.name
                this.notAlterName = true
            } else if(num == 2) {
                this.bookedConcert.phoneNumber = this.phoneNo
                this.notAlterPhoneNo = true
            } else if(num == 3) {
                this.bookedConcert.numOfVisitors = this.numOfVisitors
                this.notAlterNumOfVisitors = true
            } else if(num == 4) {
                this.bookedConcert.message = this.message
                this.notAlterMessage = true
            }
        },
        
        onSubmit() {
            if(this.notAlterName && this.notAlterPhoneNo && this.notAlterNumOfVisitors && this.notAlterMessage) {
                if(this.$store.state.isLoggedIn == true) {

                    axios.post('http://localhost:8888/member/needSession')
                        .then(res => {

                            if(res.data == true) {
                                
                                //아래의 값 넣어주는게 있어야 전에 방문한 페이지의 값이들어가고 현재 페이지의 올바른 값이 들어가지 않음...
                                this.name = this.bookedConcert.name
                                this.phoneNo = this.bookedConcert.phoneNumber
                                this.numOfVisitors = this.bookedConcert.numOfVisitors
                                this.message = this.bookedConcert.message

                                if(!/^[가-힣|a-z|A-Z|0-9|?'#!$|/\s/g]+$/.test(this.name)) {
                                    alert('올바른 이름를 입력해주세요. :)')
                                } else if(!/^[0-1]{3}[0-9]{4}[0-9]{4}/.test(this.phoneNo)) {
                                    alert('올바른 휴대번호를 입력해주세요!')
                                } else if(this.numOfVisitors > 6 || this.numOfVisitors < 1) {
                                    alert('함께 예약 할 수 있는 인원은 최소 1명 이상 6명 이하입니다!')
                                } else {
                                    
                                    const bookedConcertNo = this.bookedConcert.bookedConcertNo
                                    const memberNo = this.$store.state.userProfile.memberNo
                                    const concertNo = this.bookedConcert.concertNo
                                    const name = this.name
                                    const concertName = this.bookedConcert.concertName
                                    const phoneNumber = this.phoneNo
                                    const numOfVisitors = this.numOfVisitors
                                    const message = this.message

                                    this.$emit('submit', { bookedConcertNo, memberNo, concertNo, name, concertName, phoneNumber, numOfVisitors, message })

                                    //alert(JSON.stringify({ bookedConcertNo, memberNo, concertNo, name, concertName, phoneNumber, numOfVisitors, message }))
                                }
                            } else {
                                alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                                this.$store.state.isLoggedIn = false
                            }
                        })
                } else {
                    alert('로그인이 필요한 서비스입니다!')
                }
            } else {
                alert('모든 수정사항을 확인해주세요!')
            }
        },
        deleteBooking(bookedConcertNo) {
            
            axios.delete(`http://localhost:8888/concert/deleteBooking/${bookedConcertNo}`)
                .then(() => {

                    alert('예약이 성공적으로 취소되었습니다!')

                    this.$router.push({
                        name: 'BookedListPage'
                    })
                })
                .catch(() => {
                    alert('잠시후에 다시 시도해주세요!')
                })
        },
        cancel() {
            this.$router.push({
                name: 'BookedListPage'
            })
        }
    }
}
</script>
