<template>
    <div align="center" style="height: 100%;">
        <p class="memberListTitle" style="margin-top: 60px;">Profile Modify</p>
        <p class="subTitle" style="font-style: italic;">원하시는 정보를 수정하세요.</p>

        <v-container style="width: 20%">
            <form @submit.prevent="onSubmit">
            
                <v-text-field label="ID(e-mail)" type="text" required v-model="user.id"></v-text-field>
            
                <v-text-field label="비밀번호(10자리 이상)" type="password" required v-model="user.password" class="cutTopMargin"></v-text-field>
                
                <v-text-field label="비밀번호 재확인" type="password" required v-model="user.passwordCheck" class="cutTopMargin"></v-text-field>
                
                <v-text-field label="이름" type="text" required v-model="user.name" class="cutTopMargin"></v-text-field>

                <v-select v-model="user.location" :items="locations" label="지역 선택" multiple class="cutTopMargin"></v-select>
                
                <input type="date" name="date" style="width: 100%;" required v-model="user.birthDay">

                <v-radio-group v-model="user.identity" row style="margin-top: 30px;">
                    <v-radio label="개인" value="individual"></v-radio>
                    <v-radio label="아티스트" value="artist"></v-radio>
                    <!-- <v-radio label="관리자" value="admin"></v-radio> -->
                </v-radio-group>
                
                <v-text-field label="휴대전화" type="text" required v-model="user.phoneNo"></v-text-field>

                <div style="margin-top: 20px;">
                    <v-btn class="btn-flat red-text waves-effect waves-teal" type="submit" @click.native="btn_confirm($event)" style="margin-right: 40px;">
                        수정
                    </v-btn>
                    <v-btn class="btn-flat red-text waves-effect waves-teal" type="text" @click.native="btn_cancel($event)">
                        취소
                    </v-btn>
                </div>

                <check-dialogue/> 

            </form>
        </v-container>
    </div>
</template>

<script>

import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'MemberModifyPage',
    computed: {
        ...mapState(['userProfile', 'userIdentity', 'isLoggedIn'])
    },
    data() {
        return {       
            user: {
                memberNo: this.$store.state.userProfile.memberNo,
                id: '',
                password: '',
                passwordCheck: '',
                name: this.$store.state.userProfile.name, //userProfile을 축소하면서 이게 안나오게됨
                location: '',
                birthDay: '',
                identity: '',
                phoneNo: this.$store.state.userProfile.phoneNo //userProfile을 축소하면서 이게 안나오게됨
            },
            locations: [
                { text: '서울 - 강남', value: '서울 - 강남'},
                { text: '서울 - 홍대', value: '서울 - 홍대'},
                { text: '서울 - 그 외', value: '서울 - 그 외'},
                { text: '부산', value: '부산'},
                { text: '인천', value: '인천'},
                { text: '대구', value: '대구'},
                { text: '전주', value: '전주'}
            ],
        }
    },
    methods: {
        onSubmit() {
            if(this.user.identity == '') {
                alert('개인, 아티스트 구분을 선택해주세요!')
            } else if(this.user.location == '') {
                alert('지역을 선택해주세요!')
            } else if(this.user.id != '' && this.user.password != '' && this.user.name != '' && this.user.location != '' 
            && this.user.birthDay != '' && this.user.identity != ''  && this.user.phoneNo != '' ) {

                if(!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{11,}$/.test(this.user.password)) {
                    alert("비밀번호는 최소 11 자, 최소 하나의 문자 및 하나의 숫자를 입력해 주세요.") 
                } else if(this.user.password != this.user.passwordCheck) {
                    alert('비밀번호와 비밀번호 재확인이 일치하지 않습니다!')
                } else if(!/^[가-힣|a-z|A-Z|/\s/g]+$/.test(this.user.name)) { //   /\s/g   <--스페이스바 허용
                    alert('이름에 올바른 문자를 입력해주세요.') 
                } else if(!/^\d{11}$/.test(this.user.phoneNo)) {
                    alert('올바른 휴대전화 번호 형식이 아닙니다!')
                } else {
                    this.allWritten = true
                    this.confirm()
                }
            }
        },
        confirm() {
            if(this.user.id == '') {
                alert('ID를 입력하세요.')
            } else if(this.user.password == '') {
                alert('비밀번호를 입력하세요.') 
            } else if(this.user.password.length < 11) {
                alert('비밀번호를 10자리 이상으로 설정해주세요.') 
            } else if(this.user.name == '' || this.user.birthDay == '' || this.user.phoneNo == '') {
                alert('항목을 모두 입력해주세요 :)')
            } else if(this.user.password != this.user.passwordCheck) {
                alert('비밀번호와 비밀번호 재확인이 일치하지 않습니다!')
            } else {
                
                const memberNo = this.$store.state.userProfile.memberNo
                const location = JSON.stringify(this.user.location)
                const { id, password, name, birthDay, identity, phoneNo } = this.user

                console.log(JSON.stringify({ memberNo, id, password, name, birthDay, identity, phoneNo } + { location }))

                axios.put('http://localhost:8888/member/modify', { memberNo, id, password, name, location, birthDay, identity, phoneNo })
                .then(res => {
                    alert('정보가 변경되었습니다 :)' + res.data)

                    this.$store.state.isLoggedIn = true;
                    this.$store.state.userIdentity = res.data.identity
                    this.$store.state.userProfile = res.data

                    this.$cookies.set("currentUser", res.data, '120m')
                    //alert('currentUser ' + JSON.stringify(this.$cookies.get("currentUser")))

                    this.$router.push({
                        name: 'MainPage' 
                    })
                    
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
            }
        },
        btn_cancel() {
             this.$router.push({
                name: 'MyProfilePage',
            })
        }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity

            this.user.id = this.$store.state.userProfile.id //data()가 화면에 깔리는게 mounted()보다 빨라서 새로고침 시 값이 없어지기 때문에 여기에 이렇게 적어줌
            this.user.identity = this.$store.state.userIdentity
        }
    }
}
</script>
