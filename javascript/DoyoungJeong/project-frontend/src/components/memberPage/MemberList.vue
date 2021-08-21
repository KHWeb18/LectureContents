<template>
    <div>
        <span>
            <p class="subTitle">현재 등록된 회원 정보입니다.</p>
            <p style="font-size: 12px; margin-top: -10px;">회원을 탈퇴시키려면 해당 회원의 id를 클릭하세요.</p>
        </span>
        <v-container style="width: 75%">
            <table border="1px">
                <tr class="listItem">
                    <td width="30">memberNo</td>
                    <td width="80" style="text-align: center">id</td>
                    <td width="80">name</td>
                    <td width="100">location</td>
                    <td width="80">identity</td>
                    <td width="100">birthDay</td>
                    <td width="80">phoneNo</td>
                    <td width="180" style="text-align: right">regDate</td>
                </tr>
                <tr v-if="!members">
                    <td colspan="8">회원 정보를 불러오지 못했습니다!</td>
                </tr>
                <tr v-else v-for="(member, index) in members" :key="index" class="item">
                   <td>{{ member.memberNo }}</td>
                   <td>
                       <p @click="sendNum(member.memberNo)" style="margin-bottom: -0px;">
                            <router-link :to="{ name: 'MemberDeletePage' }">
                                    {{ member.id }}
                            </router-link>
                       </p>
                   </td>
                   <td>{{ member.name }}</td>
                   <td>{{ member.location }}</td>
                   <td>{{ member.memberIdentityList[0].identity }}</td> 
                   <td>{{ member.birthDay }}</td>
                   <td>{{ member.phoneNo }}</td>
                   <td style="text-align: right">{{ member.regDate }}</td>
                </tr>
            </table>
        </v-container>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'

export default {
    name: 'MemberList',
    props: {
        members: {
            type: Array,
            requited: true
        }
    },
    data() {
        return {
            
        }
    },
    methods: {
        sendNum(memberNo) {
            const payload = [ memberNo ]

            EventBus.$emit('sendNum', payload)
            console.log('The num has been sent! ' + payload)
        }
    }
}
</script>

<style>

.subTitle {
    font-size: 14px;
    font-style: italic;
    margin-top: -10px;
}

.listItem {
    font-size: 15px;
    font-style: italic;
}

.item {
    font-size: 13px;
}


</style>