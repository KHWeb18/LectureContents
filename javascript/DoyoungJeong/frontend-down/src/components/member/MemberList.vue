<template>
    <div align="center">
        <h3>가입한 회원 목록</h3>
        <table border="1">
            <tr>
                <td align="center" width="100">회원번호</td>
                <td align="center" width="80">id</td>
                <td align="center" width="80">pw</td>
                <td align="center" width="80">이름</td>
                <td align="center" width="100">생년월일</td>
                <td align="center" width="150">주소</td>
                <td align="center" width="80">소속</td>
                <td align="center" width="180">가입인사</td>
                <td align="center" width="100">가입일자</td>
            </tr>
            <tr v-if="!members || (Array.isArray(members) && members.length === 0)">
                <!-- 'members가 없으면' 이라는 뜻 -->
                <td colspan="9">
                    가입한 회원이 없습니다.
                </td>
            </tr>
            <tr v-else v-for="member in members" :key="member.components">
                <td align="center">{{ member.memberNo }}</td>
                <td align="center">
                    <router-link :to="{ name: 'MemberReadPage', 
                        params: { memberNo: member.memberNo.toString() } }">
                        <!-- 인자로 들어오는 memberNo은 member의 요소인 memberNo를 toString으로 변환한것이다. -->
                    {{ member.id }}
                    </router-link>                    
                </td>
                <td align="center">{{ member.pw }}</td>
                <td align="center">{{ member.name }}</td>
                <td align="center">{{ member.birthDay }}</td>
                <td align="center">{{ member.address }}</td>
                <td align="center">{{ member.party }}</td>
                <td align="center">{{ member.comment }}</td>
                <td align="center">{{ member.regDate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'MemberList',
    props: {
        members: {
            type: Array
        }
    }
}

</script>