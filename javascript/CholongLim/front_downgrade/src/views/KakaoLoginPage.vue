<template>
  <v-container>
        <ul>
            <li v-on:click="kakaoLogin()">
                <a href="javascript:void(0)">
                    <span>카카오 로그인</span>
                </a>
            </li>
        </ul>
    </v-container>
</template>


<script>

import axios from 'axios'
// import '@/kakao/kakao.js'

export default {
    name: 'KakaoLoginPage',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        onSubmit () {
            const { id, pw } = this
            axios.post('http://localhost:5000/login', { userId: id, password: pw })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + JSON.stringify(res.data))
                        } else {
                            alert('로그인 실패! - ' + res.data)
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
        kakaoLogin () {
            window.Kakao.Auth.login({
                success:  (res) => {
                    window.Kakao.API.request({
                        // 자기 자신 찾아오기
                         url: '/v2/user/me',
                        success: (res) => {
                            console.log(res)
                        },
                        fail: (error) => {
                            console.error(error)   
                        }
                    })
                console.log(res)
                },
                fail:(error) => {
                    console.log(error)
                }
            })
        }
    }
}

</script>