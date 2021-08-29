<template>
    <div>
        <!-- <h1>{{ userInfo.userId }}</h1> -->
        <h1>님 반갑습니다.</h1>

  

        <!-- <v-dialog v-model="deleteId" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">계정 탈퇴</v-btn>
            </template>
            <v-card>
                 <v-toolbar flat color="grey lighten-3">
                        <v-toolbar-title>계정 탈퇴</v-toolbar-title>
                    </v-toolbar>
                    <div class="pa-3">
                        <v-text-field
                            v-model="password"
                            label="탈퇴하실 계정의 비밀번호를 입력하세요."
                        >
                        </v-text-field>
                        <button @click="onDelete">계정을 삭제합니다.</button>
                        <v-btn color="blue darken-1" text @click="deleteCheck($event)">
                        취소
                    </v-btn>
                    </div>
            </v-card>
        </v-dialog> -->
    </div>
</template>

<script>
// import { mapState } from 'vuex'
// import axios from 'axios'

// export default {
//     data() {
//         return {
//             deleteId : false
//         }
//     },
//     computed: {
//         ...mapState(['member'])
//     },
//     created () {
//         this.fetchMember(this.memberNo)
//                 .catch(err => {
//                     alert(err.response.data.message)
//                     this.$router.push()
//                 })
//     },
//     props: {
//         memberNo: {
//             type: String,
//             required: true
//         }
//     },
//     methods: {
    
//         deleteCheck($event){
//             if($event.target.innerHTML == " 계정을 탈퇴하겠습니다. ") {
//                 alert('결제가 완료되었습니다.')
//                 this.deleteId = true
//             } else {
//                 this.deleteId = false
//             }
//         },
//         onDelete (payload) {
//             const { password } = payload
//             axios.delete(`http://localhost:8888/jpamember/remove`, { password })
//                 .then(res => {
//                     alert('계정을 삭제했습니다.' + res)
//                     this.$router.push({ name: 'MainPage' })
//                 })
//                 .catch(res => {
//                     alert(res.response.data.message)
//                 })
//         }
//     }
// }
</script>
