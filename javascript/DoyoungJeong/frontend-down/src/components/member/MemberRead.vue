<template>
    <div>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" v-bind:value="member.id" readonly></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="text" v-bind:value="member.pw" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" v-bind:value="member.name" readonly></td>
            </tr>
            <tr>
                <td>생년월일(6자리 입력)</td>
                <td><input type="text" v-bind:value="member.birthDay" readonly></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" v-bind:value="member.address" readonly></td>
            </tr>
            <tr>
                <td>소속</td>
                <td><input type="text" v-bind:value="member.party" readonly></td>
            </tr>
            <tr>
                <td>가입인사</td>
                <td><textarea cols="20" rows="2" v-bind:value="member.comment" readonly></textarea></td>
            </tr>
            <tr>
                <td>가입일시</td>
                <td><input type="text" v-bind:value="member.regDate" readonly></td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'MemberRead',
    props: {
        member: {
            type: Object,
            required: true
        }
    }
}

</script>
