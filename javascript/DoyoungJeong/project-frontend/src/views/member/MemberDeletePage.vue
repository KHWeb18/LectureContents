<template>
    <div align="center">
        <p class="memberListTitle" style="margin-top: 60px;">Member Delete</p>
        <p class="subTitle" style="font-style: italic;">정말 이 회원의 정보를 삭제할까요?</p>
        <p class="subTitle">한번 삭제한 회원정보는 복구할 수 없습니다! 신중하게 삭제해주세요.</p>
        <div>
            <v-btn class="btn-flat red-text waves-effect waves-teal" text="text" @click.native="btn_delete($event)" style="margin-right: 40px;">
                삭제
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
    name: 'MemberDeletePage',
    props: {
        memberNo: { //이게 왜 안받아질까 --> router에서 components랑 props설정 때문
            type: String,
            required: true
        }
    },
    data() {
        return {
            //memberNo: 0
        }
    },
    computed: {
        ...mapState(['isLoggedIn'])
    },
    methods: {
        btn_delete() {
            console.log('삭제할 멤버 번호' + this.memberNo)

            axios.delete(`http://localhost:8888/member/delete/${ this.memberNo }`)
                .then(() => {
                    alert('삭제되었습니다!')
                    this.$router.push({
                        name: 'MemberListPage'
                    })
                })
        },
        btn_cancel() {
            this.$router.push({
                name: 'MemberListPage'
            })
        }

    },
    created() {
        // EventBus.$on('sendNum', (payload) => {
        //     this.memberNo = payload
        // })
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
