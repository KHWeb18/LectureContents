<template>
    <v-container>
        <form @submit.prevent="onSubmit">



            <div justify-center>
        <div>


            <v-icon class="name-icon" color="white">face</v-icon>
            <v-text-field label="이름 (ex. 홍길동)" dense required height="5vh" 
            style="margin-top:10px;" solo
            v-model="userName" :rules="rules_name"
            type="name">
            </v-text-field>

    
            <v-icon class="mail-icon" color="white">email</v-icon>
            <v-text-field label="아이디 (ex. cinzel)" dense required height="5vh" 
                          style="margin-top:10px;" solo
                           v-model="userId" :rules="rules_id"
                            type="id">
            </v-text-field>
            

            <v-icon class="pass-icon" color="white">lock</v-icon>
            <v-text-field label="비밀번호" dense required height="5vh" style="margin-top:10px;" solo
                        v-model="password" :rules="rules_pw" type="password">
            </v-text-field>
            

            <v-icon class="pass-icon" color="white">lock</v-icon>
            <v-text-field label="비밀번호 재입력" dense required height="5vh" style="margin-top:10px;" solo
                        v-model="passwordReInput"  :rules="rules_pw2" type="password">
            </v-text-field>

            <v-icon class="phone-icon" color="white">call</v-icon>
            <v-text-field label="전화번호 (ex.01012345678)" dense required height="5vh" style="margin-top:10px;" solo
                        v-model="userPhone" :rules="rules_call" type="phone">
            </v-text-field>

        <div class="btn-size">
            <v-btn width="410" height="50" type="submit" color="blue" style="float:left; margin-top:6%;"
            class="white--text">
            회원가입
            </v-btn>
            <v-btn width="410" height="50" color="blue darken-4" style="float:left; margin-top:3%;"
            class="white--text" route :to="'/cinzel'">
            취소
            </v-btn>    
        </div>

        </div>
       </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            auth: '개인',
            userName: '',
            rules_name: [
                v => !!v || '이름을 입력해주세요.',
                v => !(v.length >= 5) || '이름은 5자 이상 입력할 수 없습니다.',
                v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '특수문자를 사용할 수 없습니다.'
            ],
            rules_pw: [
                v => !!v || '비밀번호를 입력해주세요.',
                v => v.length >= 6 || '비밀번호를 6자 이상 입력해주세요',
            ],
            rules_pw2: [
                v => !!v || '비밀번호를 입력해주세요.',
                v => v === this.password || '비밀번호가 일치하지 않습니다.'
            ],
            rules_id:[
                v => !!v ||  '아이디를 입력해주세요.',
                v => v.length >= 5 || '아이디를 5자 이상 입력해주세요.'
            ],
            rules_call: [
                v => !!v || '전화번호를 입력해주세요.',
            ],
            
            userId: '',
            password: '',
            passwordReInput: '',
            userPhone: ''
        }
    },
    methods: {
        onSubmit () {
            const {  userName, userId, password, passwordReInput, userPhone, auth } = this
            this.$emit('submit', { userName, userId, password, passwordReInput, userPhone, auth })
        }
    }
}
</script>

<style scoped>

.register-box{
    border: 1px solid #cccccc;
    background-color: white;
    float: left;
    width: 500px;
    height: 500px;
}

.btn-size{
    position: relative;
    left: 13%;
}

.name-icon{
    float: left;
    padding: 15px 20px 15px 20px;
}

.pass-icon{
    float: left;
    padding: 25px 20px 15px 20px;
}

.phone-icon{
    float: left;
    padding: 25px 20px 15px 20px;
}

.mail-icon{
    float: left;
    padding: 25px 20px 15px 20px;
}

h1{
    font-family: "Cinzel";
    font-size: 60px;
    margin: 0;

}

h2{
    font-family: "Cinzel";
    font-size: 30px;
    margin: -3%;
}

</style>