<template>
    <v-container>
        <form @submit.prevent="onSubmit">



            <div justify-center>
        <div>

            <v-icon class="name-icon" color="white">face</v-icon>
            <v-text-field label="이름" dense required height="5vh" style="margin-top:10px;" solo
                           v-model="userName" :rules="[v => !!v || '필수정보입니다.']" type="name">
            </v-text-field>

            <v-icon class="mail-icon" color="white">email</v-icon>
            <v-text-field label="아이디" dense required height="5vh" style="margin-top:10px;" solo
                           v-model="userId" :rules="[v => !!v || '필수정보입니다.']" type="id">
            </v-text-field>

            <v-icon class="pass-icon" color="white">lock</v-icon>
            <v-text-field label="비밀번호" dense required height="5vh" style="margin-top:10px;" solo
                        v-model="password" :rules="[v => !!v || '필수정보입니다.']" type="password">
            </v-text-field>

            <v-icon class="phone-icon" color="white">call</v-icon>
            <v-text-field label="전화번호" dense required height="5vh" style="margin-top:10px;" solo
                        v-model="userPhone" :rules="[v => !!v || '필수정보입니다.']" type="phone">
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
            userName: '',
            userId: '',
            password: '',
            userPhone: ''
        }
    },
    methods: {
        onSubmit () {
            const {  userName, userId, password, userPhone } = this
            this.$emit('submit', { userName, userId, password, userPhone })
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
    padding: 7px 20px 15px 20px;
}

.pass-icon{
    float: left;
    padding: 16px 20px 15px 20px;
}

.phone-icon{
    float: left;
    padding: 16px 20px 15px 20px;
}

.mail-icon{
    float: left;
    padding: 16px 20px 15px 20px;
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