<template>
    <form @submit.prevent="onSubmit">
        <h5>아래 형식에 맞게 입력해주세요</h5>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" v-model="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="text" v-model="pw"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" v-model="name"></td>
            </tr>
            <tr>
                <td>생년월일(6자리 입력)</td>
                <td><input type="text" v-model="birthDay"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" v-model="address"></td>
            </tr>
            <tr>
                <td>소속</td>
                <td><input type="text" v-model="party"></td>
            </tr>
            <tr>
                <td>가입인사</td>
                <td><textarea cols="20" rows="2" v-model="comment"></textarea></td>
            </tr>
        </table>

        <div>
            <router-link :to="{ name: 'MemberListPage'}">
                멤버 리스트로 돌아가기
            </router-link>
            <button type="submit">가입 요청</button>
            <!-- <button v-on:click="request">가입 요청</button> 이렇게는 못쓴다. v-on:click=""에는 메소드가 나와서 실행되어야한다. -->
        </div>
    </form>
</template>

<script>

export default {
    name: 'MemberRegisterForm',
    data() {
        return {
            id: 'ID를 입력하세요',
            pw: '비밀번호를 입력하세요',
            name: '이름을 입력하세요',
            birthDay: '생년월일(6숫자)',
            address: '주소를 입력하세요',
            party: '소속을 입력하세요',
            comment: '가입인사를 남겨주세요'
        }
    },
    methods: {
        onSubmit() {
            const { id, pw, name, birthDay, address, party, comment } = this
            this.$emit('submit', { id, pw, name, birthDay, address, party, comment })

            this.id = ''
            this.pw = ''
            this.name = ''
            this.birthDay = ''
            this.address = ''
            this.party = ''
            this.comment = ''
        }
    }
}
</script>

<style>

table, th, td {
    border: 1px solid #9a9a9a;
    color: #9a9a9a;
    margin-top: 20px;
}
th {
    padding: 10px;
}
td {
    padding: 8px;
}

</style>