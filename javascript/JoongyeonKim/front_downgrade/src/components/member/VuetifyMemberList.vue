<template>
    <div align="center">
        <h3>게시물 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="640">아이디</th>
                <th align="center" width="150">비밀번호</th>
                <th align="center" width="240">마지막 정보 수정일</th>
            </tr>
            <tr v-if="!members || (Array.isArray(members) && members.length === 0)">
                <td colspan="4">
                현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="member in members" :key="member.memberNo">
                <td align="center">{{ member.memberNo }}</td>
                <td align="left">{{ member.id }}
                    <!--
                    <router-link :to="{ name: 'BoardReadPage',
                                    params: { memberNo: member.memberNo.toString() } }">
                        {{ board.title }}
                    </router-link> -->
                </td>
                <td align="right">{{ member.pw }}</td>
                <td align="center">{{ member.lastModifiedDate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'VuetifyMemberList',
    props: {
        members: {
            type: Array
        }
    }
}
</script>