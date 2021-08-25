<template>
    <div align="center" style="margin-top: 60px;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">Withdrawal</h3>
        <p class="description">정말로 탈퇴하시나요? 탈퇴하시면 기록된 모든 정보가 사라집니다!</p>
        <div>
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
import EventBus from '@/eventBus.js'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'MemberWithdrawalPage',
    data() {
        return {
            memberNo: 0
        }
    },
    methods: {
        btn_delete() {
            console.log('탈퇴할 멤버 번호' + this.memberNo)
            axios.delete(`http://localhost:8888/member/delete/${ this.memberNo }`)
                .then(() => {
                    alert('탈퇴처리 완료되었습니다!')
                    this.$store.state.isLoggedIn = false

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
        EventBus.$on('sendNum', (payload) => {
            this.memberNo = payload
        })
    },
    computed: {
        ...mapState(['isLoggedIn'])
    }
}
</script>
