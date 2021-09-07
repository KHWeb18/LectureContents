<template>
    <div align="center">
        <p class="memberListTitle" style="margin-top: 60px;">My Profile</p>
        <p class="subTitle" style="font-style: italic;">현재 회원님의 가입 정보입니다.</p>
        <v-container style="width: 75%">
            <table border="1px">
                <tr class="footerText">
                    <td width="12%" style="text-align: left">id</td>
                    <td width="10%">password</td>
                    <td width="8%">name</td>
                    <td width="15%">location</td>
                    <td width="10%">identity</td>
                    <td width="15%">birthDay</td>
                    <td width="10%">phoneNo</td>
                    <td width="20%" style="text-align: right">regDate</td>
                </tr>
                <tr v-if="!userProfile">
                    <td colspan="8">회원 정보를 불러오지 못했습니다!</td>
                </tr>

                <tr v-else-if="userProfile" class="item">
                    <td>{{ member.id }}</td>
                    <td>{{ password }}</td>
                    <td>{{ member.name }}</td>
                    <td>{{ member.location }}</td>
                    <td>{{ userIdentity }}</td>
                    <td>{{ member.birthDay }}</td>
                    <td>{{ member.phoneNo }}</td>
                    <td style="text-align: right">{{ member.regDate }}</td>
                </tr>
                <tr class="footerText">
                    <td>선택 취향</td>
                    <td colspan="2">선택한 장르</td>
                    <td colspan="2">곡 느낌 선호사항</td>
                    <td colspan="2">공연장 선호사항</td>
                    <td colspan="2" style="text-align: right">선택한 아티스트</td>
                </tr>
                <tr v-if="taste" class="item">
                    <td></td>
                    <td colspan="2">{{ taste.chosenGenres }}</td>
                    <td colspan="2">{{ taste.speedTaste }}</td>
                    <td colspan="2">{{ taste.atmosphereTaste }}</td>
                    <td colspan="2" style="text-align: right">{{ taste.chosenArtists }}</td>
                </tr>
                <tr v-else-if="!taste" class="item">
                    <td colspan="8">아직 선호사항을 정하지 않으셨어요!</td>             
                </tr>
           
            </table>

            <check-dialogue v-bind:memberNo="member.memberNo"/>

            <!-- <div style="margin-top: 20px;">
                <router-link :to="{ name: 'MemberModifyPage' }" @click.native="btn_withdrawal(userProfile.memberNo)" 
                class="btn-flat red-text waves-effect waves-teal" text="text" style="margin-right: 40px;">
                    수정
                </router-link>
        
                <router-link :to="{ name: 'MemberWithdrawalPage', params: { memberNo: member.memberNo.toString() } }" @click.native="btn_withdrawal(userProfile.memberNo)" 
                class="btn-flat red-text waves-effect waves-teal" text="text">
                    탈퇴
                </router-link>
            </div> -->
        </v-container>
    </div>
</template>

<script>
//import EventBus from '@/eventBus.js'
import { mapActions, mapState } from 'vuex'

import CheckDialogue from '@/components/memberPage/CheckDialogue'

export default {
    name: 'MyProfilePage',
    components: {
        CheckDialogue
    },
    data() {
        return {
            password: "***********"
        }
    },
    computed: {
        ...mapState(['userProfile', 'userIdentity', 'isLoggedIn', 'member', 'taste'])
    },
    methods: {
        ...mapActions(['fetchMember', 'fetchTaste']),

        btn_modify() {
           
        },
        // btn_withdrawal(memberNo) {
        //     const payload = [ memberNo ]

        //     //EventBus.$emit('sendNum', payload)
        //     console.log('The num has been sent! ' + payload)
        // }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity

            this.fetchMember(this.$store.state.userProfile.memberNo)
            this.fetchTaste(this.$store.state.userProfile.memberNo)
        }
    }
}
</script>
