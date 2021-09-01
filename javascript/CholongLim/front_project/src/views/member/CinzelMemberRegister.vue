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
                            alert('회원가입이 완료됐습니다.' + res)
                            this.$router.push({
                            name: 'CinzelMemberLogin'
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        
                    /*  if(res.data != "") {
                            alert('로그인이 완료되었습니다.')
                            console.log(res)
                            this.isLogined = true;
                            this.$store.commit(LOGIN_SUCCESS)

                            let token = res.data.userId
                            console.log(token)
                            localStorage.setItem("access_token", token)
                            this.$router.push({
                                    name: 'MainPage'
                                    })
                        } else {
                            alert('아이디와 비밀번호를 확인해주세요.')
                            this.$store.commit(LOGIN_ERROR)
                        }*/
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
    background-image: url(https://images.pexels.com/photos/1726429/pexels-photo-1726429.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260);                                                               
    height: 100vh;
    background-size: cover;
  }

  .img-cover{
     position: absolute;
     height: 100%;
     width: 100%;
     background-color: rgba(0, 0, 0, 0.7);                                                                 
     z-index:1;
  }

  .img .content{
     position: absolute;
     top:50%;
     left:50%;
     transform: translate(-50%, -50%);                                                                   
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }

 </style>