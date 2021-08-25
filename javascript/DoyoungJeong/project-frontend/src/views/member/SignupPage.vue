<template>
    <div align="center" class="grey darken-0.1" style="height: 850px;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">SIGN UP</h3>
        <p class="description">MUSIC GHUETTO에 오신것을 환영합니다! 가입하셔서 다양한 공연 정보와 서비스를 사용해보세요. :)</p>
        <v-container style="width: 15%;">
            
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
         
        </v-container>

        <div style="margin-top: 5px;">
            <signup-dialogue :allWritten="allWritten" @signup="signup" @confirm="confirm"/>
        </div>

        <p class="description" style="font-size: 5px; margin-top: 30px;">이용약관 | 개인정보처리방침 | 책임의 한계와 법적고지 | 회원정보 고객센터<br>
        <br>MUSIC GHUETTO Copyright &copy; MUSIC GHUETTO</p>
    </div>
</template>

<script>
import axios from 'axios'
import SignupDialogue from '@/components/concertMainDialogue/SignupDialogue'

export default {
    name: 'SignupPage',
    components: {
        SignupDialogue
    },
    data() {
        return {
            user: {
                id: '',
                password: '',
                passwordCheck: '',
                name: '',
                location: '',
                birthDay: '',
                identity: '',
                phoneNo: '',
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
            signupDialogue: false,
            allWritten: false
        }
    },
    methods: {
        signup() {
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
            } else if(this.user.phoneNo.length > 11) {
                alert('올바른 휴대전화 번호 형식이 아닙니다!')
            } else {
                //const { id, password, name, birthDay, phoneNo } = this.user
                alert('올바른 형식입니다 가입하기를 눌러주세요!')
                this.allWritten = true
            }
        },
        confirm() {
            const location = JSON.stringify(this.user.location)
            const { id, password, name, birthDay, identity, phoneNo } = this.user

            console.log(JSON.stringify({ id, password, name, birthDay, identity, phoneNo } + { location }))

            axios.post('http://localhost:8888/member/signup', { id, password, name, location, birthDay, identity, phoneNo })
            .then(res => {
                alert('회원가입이 완료되었습니다!' + res)
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        },
        cancel() {
           this.$router.push({
                name: 'MainPage',
            })
        },
    }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,900&display=swap');

.topBar {
    font-style: italic;
    font-family: 'Roboto', sans-serif;
    margin-right: 25px;
    color: white;
}

.description {
    font-size: 12px;
    font-style: italic;
    margin-top: 10px;
}

.cutTopMargin {
    margin-top: -10px;
}

</style>


