<template>
    <div class="img">
        <div class="content">
            <member-register-form @submit="onSubmit" class="comp-login"/>
        </div>
        <div class="img-cover"></div>
    </div>
</template>

<script>
import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'CinzelMemberRegister',
    components: {
        MemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const {  userName, userId, password, passwordReInput,  userPhone, auth } = payload
            axios.post('http://localhost:8888/jpamember/register', {
                         userName, userId, password, passwordReInput, userPhone, auth})
                    .then(res => {
                        if(res.data != "") {
                            alert('회원가입이 완료됐습니다.' + res)
                            this.$router.push({
                            name: 'CinzelMemberLogin'
                        })
                        } else {
                            alert('중복된 아이디입니다.')
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
        
    }
}
</script>

<style scoped>

.comp-login{
    width: 500px;
    height: 500px;
}

.img{
    position: relative;
    background-image: url('https://images.pexels.com/photos/533923/pexels-photo-533923.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');                                                               
    height: 100vh;
    background-size: cover;
  }

  .img-cover{
     position: absolute;
     height: 100%;
     width: 100%;
     background-color: rgba(0, 0, 0, 0.6);                                                                 
     z-index:1;
  }

  .img .content{
     position: absolute;
     top:50%;
     left:50%;
     transform: translate(-50%, -50%);                                                                   
     /* font-size:5rem; */
     color: white;
     z-index: 2;
     text-align: center;
  }
 </style>

 <!--<template>
    <div class="box">
        <member-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'CinzelMemberRegister',
    components: {
        MemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const {  userName, userId, password, passwordReInput,  userPhone, auth } = payload
            axios.post('http://localhost:8888/jpamember/register', {
                         userName, userId, password, passwordReInput, userPhone, auth})
                    .then(res => {
                        if(res.data != "") {
                            alert('회원가입이 완료됐습니다.' + res)
                            this.$router.push({
                            // name: 'CinzelMemberLogin'
                            name: 'MainPage'
                        })
                        } else {
                            alert('중복된 아이디입니다.')
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
        
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');
@import url('https://fonts.googleapis.com/css2?family=Questrial&display=swap');

* {
    box-sizing: border-box;
}

.box{
    margin-bottom: 8%;
    margin-top: 5%;
}

body {
    font-family: 'Montserrat', sans-serif;
    background: #f6f5f7;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: -20px 0 50px;
		margin-top: 20px;
}

h1 {
    font-weight: bold;
    margin-bottom: 2%;
    font-family: 'Questrial';
}

h2 {
    font-weight: bold;
    margin-bottom: 2%;
    font-family: 'Questrial';
    font-size: 35px;
}

p {
    font-size: 14px;
    font-weight: 100;
    line-height: 20px;
    letter-spacing: .5px;
    margin: 20px 0 30px;
}

span {
    font-size: 12px;
    margin-bottom: 12%;
}

a {
    color: #333;
    font-size: 14px;
    text-decoration: none;
    margin: 15px 0;
}

.container {
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 14px 28px rgba(0, 0, 0, .2), 0 10px 10px rgba(0, 0, 0, .2);
    position: relative;
    overflow: hidden;
    width: 768px;
    max-width: 100%;
    min-height: 550px;
}

.form-container form {
    background: #fff;
    display: flex;
    flex-direction: column;
    padding:  0 50px;
    height: 100%;
    justify-content: center;
    align-items: center;
    text-align: center;
}

.social-container {
    margin: 20px 0;
}


.form-container input {
    padding: 12px 15px;
    margin: 8px 0;
    width: 100%;
}

button {
    margin-top: 5%;
    border-radius: 20px;
    border: 1px solid #ffffff;
    background: #3088fabd;
    color: #fff;
    font-size: 12px;
    font-weight: bold;
    padding: 12px 45px;
    letter-spacing: 1px;
    text-transform: uppercase;
    transition: transform 80ms ease-in;
}

button:active {
    transform: scale(.95);
}

button:focus {
    outline: none;
}


.form-container {
    position: absolute;
    top: 0;
    height: 100%;
    transition: all .6s ease-in-out;
}

.sign-in-container {
    left: 0;
    width: 50%;
    z-index: 2;
}

.sign-up-container {
    left: 0;
    width: 50%;
    z-index: 1;
    opacity: 0;
}

.overlay-container {
    position: absolute;
    top: 0;
    left: 50%;
    width: 50%;
    height: 100%;
    overflow: hidden;
    transition: transform .6s ease-in-out;
    z-index: 100;
}

.overlay {
    background: #4193ffbd;
    background: linear-gradient(to right, #197ad4, #4193ffbd) no-repeat 0 0 / cover;
    color: #fff;
    position: relative;
    left: -100%;
    height: 100%;
    width: 200%;
    transform: translateY(0);
    transition: transform .6s ease-in-out;
}

.overlay-panel {
    position: absolute;
    top: 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 0 40px;
    height: 100%;
    width: 50%;
    text-align: center;
    transform: translateY(0);
    transition: transform .6s ease-in-out;
}

.overlay-right {
    right: 0;
    transform: translateY(0);
}


</style>-->