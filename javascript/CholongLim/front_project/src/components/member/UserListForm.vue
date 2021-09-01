<template>
    <div align="center" class="member-box">
        <table>
            <tr class="top-tr">
  
                <th align="center" width="100">이름</th>
                <th align="center" width="100">아이디</th>
                <th align="center" width="200">전화번호</th>
     
            </tr>
             
            <tr v-if="!members || (Array.isArray(members) && members.length === 0)">
                <td colspan="3">
                    등록된 회원이 존재하지 않습니다.
                </td>
            </tr>
            <tr v-else v-for="member in members" :key="member.memberNo">
                <td align="left">
                    <router-link :to="{ name: 'MemberReadPage',
                                    params: { memberNo: member.memberNo.toString() } }">
                        {{ member.userName }}
                    </router-link>
                </td>
                <td align="right">{{ member.userId }}</td>
                <td align="right">{{ member.userPhone }}</td>

            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'UserList',
    props: {
        members: {
            type: Array
        }
    }
}
</script>

<style scoped>

table{
    width: 55%;
    border: 1px solid #ebecec;
}

/* .top-tr {
    background-color: #f6f7f7;
} */

.member-box {
    margin-top: 2%;
}

</style>