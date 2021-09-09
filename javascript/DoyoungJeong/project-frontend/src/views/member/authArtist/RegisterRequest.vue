<template>
    <div align="center" style="height: 100%;">
        <p class="memberListTitle" style="margin-top: 60px;">Concert Request</p>
        <p class="description">관리자에게 공연 정보의 등록을 요청할 수 있습니다. 회원님의 공연을 MUSIC GUETTO에서 홍보하세요!</p>

        <v-container style="margin-top: 50px;">
            <form>
                <div class="row" style="justify-content: center;">
                    <v-checkbox label="가입 시 이름과 동일" class="shrink mr-2 footerText" color="teal"/>
                    <input type="text" v-model="regName" required class="footerText" style="width: 300px; margin-left: 30px;"/> 
                </div>

                <v-text-field v-model="artistName" required label="아티스트 이름을 입력해주세요." 
                class="footerText" style="width: 490px;"/>

                <v-text-field v-model="venueName" required label="공연 장소를 입력해주세요."
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

                <p class="footerText" style="text-align: center; margin-right: 235px; margin-top: 30px;">회원님의 공연을 홍보할 사진을 업로드해주세요!</p>

                <label>Files
                    <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()"> <!-- 변화를 감지하면 handleFileUpload메소드를 실행 -->
                </label>
                
                <br/>

                <div style="margin-top: 50px;">
                    <button @submit="submitFiles()" class="btn-flat red-text waves-effect waves-teal">업로드</button>
                    <button @click="cancel" class="btn-flat red-text waves-effect waves-teal" style="margin-left: 50px;">취소</button>
                </div>
            </form>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'RegisterRequest',
    data() {
        return {
            regName: '이름을 입력해주세요.',
            artistName: '',
            venueName: '',
            dateOfConcert: '',
            timeOfConcert: '00:00',
            timeOfEnd: '00:00',

            files: '',
        }
    },
    methods: {
        setTimeOfConcert() {
            this.setTime = true
        },
        fixTimeOfConcert() {
            this.setTime = false
        },
        handleFileUpload() {
            this.files = this.$refs.files.files //data의 files는 input에서 받는 ref - files의 id files
        },
        submitFiles() {
            let formData = new FormData()
            
            for(var idx=0; idx < this.files.length; idx++) {
                formData.append("fileList", this.files[idx])
            }

            axios.post('http://localhost:8888/member/concertRegister/request', formData, { //멀티 컨텐츠 날릴때는 무조건 헤더를 이 형식으로 맞춰야한다.
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
            alert('사진 업로드 완료!')
        }
    }
}
</script>