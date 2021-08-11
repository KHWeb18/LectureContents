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
            const { userId, password, auth } = payload
            axios.post('http://localhost:7777/jpamember/register', {
                        userId, password, auth
                    })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
        onJPATest () {
            axios.post('http://localhost:7777/jpamember/test', {
                        userId: null, password: null, auth: null
                    })
                    .then(res => {
                        alert('테스트 성공! - ' + res)
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