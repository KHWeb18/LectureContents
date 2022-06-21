<template>
    <div align="center" style="margin-top: 60px;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">Withdrawal</h3>
        <p class="description" style="margin-right: 20px;">정말로 탈퇴하시나요? 탈퇴하시면 기록된 모든 정보가 사라집니다!</p>

        <div style="margin-top: 50px; margin-right: 20px;">
            <v-btn class="btn-flat red-text waves-effect waves-teal" text="text" @click.native="btn_delete($event)" style="margin-right: 40px;">
                탈퇴
            </v-btn>
            <v-btn class="btn-flat red-text waves-effect waves-teal" text="text" @click.native="btn_cancel($event)">
                취소
            </v-btn>
        </div>
        
    </div>
</template>

<script>
//import EventBus from '@/eventBus.js'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'MemberWithdrawalPage',
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            //memberNo: 0
        }
    },
    methods: {
        btn_delete() {

            console.log('탈퇴할 멤버 번호' + this.$store.state.userProfile.memberNo)

            axios.delete(`http://localhost:8888/member/delete/${ this.$store.state.userProfile.memberNo }`)
                .then(() => {
                    alert('탈퇴처리 완료되었습니다!')

                    this.$cookies.remove("currentUser")
                
                    this.$store.state.isLoggedIn = false
                    this.$store.state.userProfile = null
                    this.$store.state.userIdentity = null

                    this.$router.push({
                        name: 'MainPage'
                    })
                })
        },
        btn_cancel() {
            this.$router.push({
                name: 'MyProfilePage'
            })
        }
    },
    created() {
        // EventBus.$on('sendNum', (payload) => {
        //     this.memberNo = payload
        // })
    },
    computed: {
        ...mapState(['isLoggedIn', 'userProfile'])
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
    }
}
</script>
