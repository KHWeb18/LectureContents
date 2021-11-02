<template>
    <div>
        <center>
        <h3>회원정보</h3>
        <table border="1" >
            <tr>
                <td>회원번호</td>
                <td><input type="text" :value="member.memberNo" readonly></td>
            </tr>
            <tr>
                <td>아이디</td>
                <td><input type="text" :value="member.id" readonly></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" :value="member.password" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" :value="member.username" readonly></td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td><input type="text" :value="member.birth" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="member.regDate" readonly></td>
            </tr>   
        </table>
        </center>

    </div>
</template>

<script>
export default {
    name: 'MemberReadForm',
    props: {
        member: {
            type: Object,
            required: true
        }
    }    
}
</script>