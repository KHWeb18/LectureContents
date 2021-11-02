<template>
    <div>
        <!-- 여기에 prevent를 써주는 이유는 상위 컴포넌트로 전송되는걸 보장하기 위함이다.<template>
                그래서 보통 상위 또는 하위 컴포넌트와 연결돼 form을 전송할 때는 prevent를 써줘야한다.
                prevent를 쓰지 않으면 ?? -->
        <h3>회원 정보 수정 양식</h3>
        <form v-on:submit.prevent="onSubmit">             
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" v-model="id"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text"  v-model="pw" ></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text"  v-model="name"></td>
                </tr>
                <tr>
                    <td>생년월일(6자리 입력)</td>
                    <td><input type="text"  v-model="birthDay"></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text"  v-model="address"></td>
                </tr>
                <tr>
                    <td>소속</td>
                    <td><input type="text"  v-model="party"></td>
                </tr>
                <tr>
                    <td>가입인사</td>
                    <td><textarea cols="20" rows="2"  v-model="comment"></textarea></td>
                </tr>
                <tr>
                    <td>가입일시</td>
                    <td><input type="text" v-bind:value="member.regDate" disabled></td>
                </tr>
            </table>            
            <button type="submit">수정 사항 제출</button>
        </form>
    </div>
</template>

<script>

export default {
    name: 'MemberModifyForm',
    props: {
        member: {
            type: Object,
            required: true
        }
    },
    data() {
        return{
            id: this.member.id,
            pw: this.member.pw,
            name: this.member.name,
            birthDay: this.member.birthDay,
            address: this.member.address,
            party: this.member.party,
            comment: this.member.comment
        }
    },
    methods: {
        onSubmit() {
            const { id, pw, name, birthDay, address, party, comment } = this
            this.$emit('submit', { id, pw, name, birthDay, address, party, comment })
        }
    }
}
</script>
