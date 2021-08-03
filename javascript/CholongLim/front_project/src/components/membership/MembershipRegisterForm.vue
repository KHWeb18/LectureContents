<template>
    <form @submit.prevent="onSubmit">
        <label for="name">* 이름</label>
        <span class="box">
            <input type="text" maxlength="5" v-model="memName">
        </span><br>
        <!-- <sapn class="error_sign_up" style aria-live="assertive">아이디를 입력하세요.</sapn> -->

        <label for="name">* 아이디</label>
        <span class="box">
            <input type="text" maxlength="20" v-model="memID">
        </span><br>

        <label for="name">* 비밀번호</label>
        <span class="box">
            <input type="password" maxlength="14" v-model="memPassword">
        </span><br>

        <label for="name">* 전화번호</label>
        <span class="box">
            <input type="text" maxlength="11" v-model="phoneNum">
        </span><br>

        <label for="name">* 생년월일</label>
        <span class="box">
            <input type="text" maxlength="8" v-model="memBirth">
        </span><br>
        <!-- <tr>
            <td>* 이름</td>
            <td><input type="text" v-model="memName"></td>
        </tr>
        <tr>
            <td>* 아이디</td>
            <td><input type="text" v-model="memID"></td>
        </tr>
        <tr>
            <td>* 비밀번호</td>
            <td><input type="password" v-model="memPassword"></td>
        </tr>
        <tr>
            <td>* 전화번호</td>
            <td><input type="text" v-model="phoneNum"></td>
        </tr>
        <tr>
            <td>* 생년월일</td>
            <td><input type="text" v-model="memBirth"></td>
        </tr> -->

        <br><br>
        <div>
            <button type="submit">가입하기</button>
            <router-link :to="{ name: 'Home' }">
                취소하기
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'MembershipRegisterForm',
    data () {
        return {
            memName:'',
            memID: '',
            memPassword: '',
            phoneNum: '',
            memBirth: ''
        }
    },
    methods: {
        onSubmit () {
            if (this.memName !=='' && this.memID !=='' && this.memPassword !=='' &&
                    this.phoneNum !=='' && this.memBirth !=='' ) {
                        const { memName, memID, memPassword, phoneNum, memBirth } = this
                        this.$emit('submit', { memName, memID, memPassword, phoneNum, memBirth })
            } else {
                alert('정보를 모두 입력해주세요.')
            }
        }
    }
}
</script>

<style scoped>

.box {
    display: block;
    width: 300px;
    height: 48px;
}
.error_sign_up {
    display: block;
    font-size: 12px;
    line-height: 14px;
    color: red;
}
</style>

