<template>
    <form  @submit.prevent="onSubmit">
        <h3>로그인하기!</h3>
        <table>
              <tr>
                <td>아이디</td>
                <td><input type="text" v-model="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" v-model="pw"></td>
            </tr>
            <tr>
                <td>주소란</td>
                <td><textarea cols="40" rows="1" v-model="address"></textarea></td>
            </tr>
        </table>
        <div>
            <button type="subnmit">회원가입</button>
            <router-link :to="{ name: 'Home'}">돌아가기</router-link>
        </div>

    </form>

</template>

<script>
export default {
    name: 'GameMemberRegisterForm',
    data () {
        return {
            id  : '아이디 입력',
            pw  : '비밀번호입력',
            address : '주소입력'
        }
    },
    methods: {
        onSubmit () {
             const  { id, pw , address} = this
             this.$emit('submit',{id, pw , address})
        }
    }
}
</script>