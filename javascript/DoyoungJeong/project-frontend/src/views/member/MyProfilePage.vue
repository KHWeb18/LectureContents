<template>
    <div align="center">
        <p class="memberListTitle" style="margin-top: 60px;">My Profile</p>
        <p class="subTitle" style="font-style: italic;">현재 회원님의 가입 정보입니다.</p>
        <v-container style="width: 75%">
            <table border="1px">
                <tr class="listItem">
                    <td width="80" style="text-align: left">id</td>
                    <td width="80">password</td>
                    <td width="80">name</td>
                    <td width="100">location</td>
                    <td width="80">identity</td>
                    <td width="100">birthDay</td>
                    <td width="80">phoneNo</td>
                    <td width="180" style="text-align: right">regDate</td>
                </tr>
                <tr v-if="!userProfile">
                    <td colspan="8">회원 정보를 불러오지 못했습니다!</td>
                </tr>
                <tr v-else class="item">
                   <td>{{ member.id }}</td>
                   <td>{{ password }}</td>
                   <td>{{ member.name }}</td>
                   <td>{{ member.location }}</td>
                   <td>{{ userIdentity }}</td>
                   <td>{{ member.birthDay }}</td>
                   <td>{{ member.phoneNo }}</td>
                   <td style="text-align: right">{{ member.regDate }}</td>
                </tr>
            </table>
            <div style="margin-top: 20px;">
                <router-link :to="{ name: 'MemberModifyPage' }" @click.native="btn_withdrawal(userProfile.memberNo)" 
                class="btn-flat red-text waves-effect waves-teal" text="text" style="margin-right: 40px;">
                    수정
                </router-link>
        
                <router-link :to="{ name: 'MemberWithdrawalPage', params: { memberNo: member.memberNo.toString() } }" @click.native="btn_withdrawal(userProfile.memberNo)" 
                class="btn-flat red-text waves-effect waves-teal" text="text">
                    탈퇴
                </router-link>
            </div>
        </v-container>
    </div>
</template>

<script>
//import EventBus from '@/eventBus.js'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'MyProfilePage',
    data() {
        return {
            password: "***********"
        }
    },
    computed: {
        ...mapState(['userProfile', 'userIdentity', 'isLoggedIn', 'member'])
    },
    methods: {
        ...mapActions(['fetchMember']),

        btn_modify() {
           
        },
        btn_withdrawal(memberNo) {
            const payload = [ memberNo ]

            //EventBus.$emit('sendNum', payload)
            console.log('The num has been sent! ' + payload)
        }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity

            this.fetchMember(this.$store.state.userProfile.memberNo)
        }
    }
}
</script>
