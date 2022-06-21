<template>
    <div>
        <div align="center">
              <h2>회원가입</h2>
        </div>
        <member-join-column-test-form @submit="onSubmit"/>
        <v-container>
        <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="onJPATest">
            <v-icon left>
                ads_click
            </v-icon>
            클릭하세요~
        </v-btn>
        </v-container>
    </div>
</template>

<script>
import MemberJoinColumnTestForm from '@/components/join/MemberJoinColumnTestForm.vue'
import axios from 'axios'
export default {
    name: 'MemberJoinColumnTestPage',
    components: {
        MemberJoinColumnTestForm
    },
    methods: {
        onSubmit (payload) {
            const { id, pw, name,sex, phoneNo, birth, auth } = payload
            axios.post('http://localhost:7777/jpamember/register', { id, pw, name,sex, phoneNo, birth, auth })
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
        },
        onJPATest(){
            axios.post('http://localhost:7777/jpamember/test',
            {id: null, pw: null, name: null,sex: null, phoneNo: null, birth: null, auth: null})
                        .then(res => {
                            alert('테스트 성공!' + res)
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
        }
    }
}
</script> 