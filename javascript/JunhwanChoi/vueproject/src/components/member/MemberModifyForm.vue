<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table border="2">
                <tr>
                    <td>회원번호</td>
                    <td><input type="text" :value="member.memberNo" disabled></td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" :value="member.id" disabled></td>
                </tr>
                <tr style="background-color:yellow;">
                    <td>비밀번호</td>
                    <td><input type="text" v-model="password"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" :value="member.username" disabled></td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td><input type="text" :value="member.birth" disabled></td>
                </tr>
                <tr>
                    <td>생성일</td>
                    <td><input type="text" :value="member.regDate" disabled></td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'MemberReadPage', params: { memberNo: member.memberNo.toString() } }">
                    취소
                </router-link>
            </div>
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
    data () {
        return {
            password: '',
        }
    },
    methods: {
        onSubmit () {
            const { password } = this
            this.$emit('submit', { password })
        }
    },
    created () {
        this.password = this.member.password
        
    }
}
</script>

<style scoped>
    table {
        border: 2px solid #f12e2e;
  }
</style>