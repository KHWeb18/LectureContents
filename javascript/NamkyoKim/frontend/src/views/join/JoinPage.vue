<template>
    <div>
        <div align="center">
              <h2>회원가입</h2>
        </div>
        <join-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import JoinRegisterForm from '@/components/join/JoinRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'JoinPage',
    components: {
        JoinRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { id, pw, name,sex, phoneNo, birth } = payload
            axios.post('http://localhost:7777/vuejpamember/register', { id, pw, name,sex, phoneNo, birth })
                    .then(res => {
                        alert('회원가입 성공! - ' + res)
                        //this.$router.push({ name: 'BoardListPage' })
                        
                        this.$router.push({
                            name: 'Home'
                            // params: { boardNo: res.data.boardNo.toString() }
                        })
                        
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script> 