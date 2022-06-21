<template>
    <div>
        <v-container style="margin-top: 50px;">

            <form @submit.prevent="checkVal">

                <div class="row" style="justify-content: center;">
                    <v-checkbox label="가입 시 이름과 동일" class="shrink mr-2 footerText" color="teal"/>
                    <input type="text" v-model="regName" required class="footerText" style="width: 300px; margin-left: 30px;"/> 
                </div>

                <v-text-field v-model="artistName" required label="아티스트 이름을 입력해주세요."
                class="footerText" style="width: 490px;"/>

                <v-text-field v-model="venueName" required label="공연 장소를 입력해주세요."
                class="footerText" style="width: 490px;"/>

                <v-text-field v-model="concertName" required label="공연 이름을 입력해주세요."
                class="footerText" style="width: 490px;"/>

                <div style="justify-content: center; margin-top: 10px;" class="row">
                    <label class="footerText" style="margin-left: 60px;">공연 날짜
                        <input type="date" name="date" style="width: 300px; margin-right: 190px;" v-model="dateOfConcert">
                    </label>
                </div>

                <p class="footerText" style="text-align: center; margin-right: 280px; margin-top: 30px;">공연의 시작과 끝 시간을 설정해주세요.</p>

                <div style="justify-content: center; margin-top: 10px;" class="row">
                    <input type="time" v-model="timeOfConcert" style="width: 230px; margin-right: 30px;"/>
                    <input type="time" v-model="timeOfEnd" style="width: 230px; margin-right: 0px;"/>
                </div>

                <p class="footerText" style="text-align: center; margin-top: 30px;">회원님의 공연을 홍보할 사진을 업로드해주세요 :) (파일 이름은 신청자 이름으로 해주세요!)</p>

                <label>Files
                    <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()"> <!-- 변화를 감지하면 handleFileUpload메소드를 실행 -->
                </label>
                
                <br/>

                <div style="margin-top: 50px; margin-bottom: 20px;">
                    <button type="submit" class="btn-flat red-text waves-effect waves-teal">업로드</button>
                    <button @click="cancel" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 50px;">취소</button>
                </div>

            </form>

        </v-container>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'MyRequestModify',
    props: {
        concertRequest: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            regName: this.concertRequest.regName,
            artistName: this.concertRequest.artistName,
            venueName: this.concertRequest.venueName,
            concertName: this.concertRequest.concertName,
            dateOfConcert: '',
            timeOfConcert: '00:00',
            timeOfEnd: '00:00',

            files: '',
        }
    },
    methods: {
        handleFileUpload() {
            this.files = this.$refs.files.files //data의 files는 input에서 받는 ref - files의 id files
        },
        checkVal() {
            //유효성 검사
            if(!/^[가-힣|a-z|A-Z|/\s/g]+$/.test(this.regName)) {
                alert('올바른 이름을 입력해주세요!') 
            } else if(!/^[가-힣|a-z|A-Z|0-9|?'#!$|/\s/g]+$/.test(this.artistName)) {
                alert('올바른 아티스트 이름을 입력해주세요!')
            } else if(!/^[가-힣|a-z|A-Z|0-9|?'#!$|/\s/g]+$/.test(this.venueName)) {
                alert('올바른 장소 이름을 입력해주세요!')
            } else if(this.dateOfConcert == '') {
                alert('날짜를 입력해주세요')
            } else if(this.timeOfConcert == this.timeOfEnd) {
                alert('공연 시간을 다시 한번 확인해주세요!')
            } else if(this.files.length < 2) {
                alert('사진을 두 장 이상 선택해주세요!')
            } else {
                this.submitFiles()
            }
        },
        submitFiles() {

            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {

                            if(this.files.length > 1) {
                                let formData = new FormData()
                                
                                for(var idx=0; idx < this.files.length; idx++) {
                                    formData.append("fileList", this.files[idx])
                                }

                                axios.post('http://localhost:8888/member/concertRegister/sendPic', formData, { //멀티 컨텐츠 날릴때는 무조건 헤더를 이 형식으로 맞춰야한다.
                                    headers: {
                                        'Content-Type': 'multipart/form-data' 
                                    }
                                })
                                .then (res => {
                                    this.responser = res.data 
                                })
                                .catch (res => {
                                    this.response = res.message
                                })
                                //alert('사진 업로드 완료!')

                                const concertRequestNo = this.concertRequest.concertRequestNo
                                //const memberNo = this.$store.state.userProfile.memberNo
                                const { regName, artistName, venueName, concertName, dateOfConcert, timeOfConcert, timeOfEnd } = this

                                this.$emit('submit', { concertRequestNo, regName, artistName, venueName, concertName, dateOfConcert, timeOfConcert, timeOfEnd })

                            } else {
                                alert('사진을 두 장 이상 선택해주세요!')
                            }
                        
                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }

        },
        cancel() {
            this.$router.push({
                name: 'MyRequestReadPage',
                params: { concertRequestNo: this.concertRequest.concertRequestNo }
            })
        }
    }
}
</script>
