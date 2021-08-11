<template>
    <div class="img">
        <div class="content">
            <member-login-form @submit="onSubmit" class="comp-login"/>
        </div>
        <div class="img-cover"></div>
    </div>
</template>

<script>
import MemberLoginForm from '@/components/member/MemberLoginForm.vue'
import axios from 'axios'
export default {
    name: 'CinzelMemberLogin',
    components: {
        MemberLoginForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, password } = payload
            axios.post('http://localhost:7777/jpamember/login', { userId, password, auth: null })
                    .then(res => {
                        if(res.data == true) {
                            alert('로그인 성공. - ' + res.data)
                        } else {
                            alert('이메일 또는 비밀번호를 다시 확인하세요.')
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
    background-image: url(https://images.pexels.com/photos/17727/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260);                                                               
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
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }
 </style>