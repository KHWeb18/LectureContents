<template>
<v-container>
   <div>
		<form @submit.prevent="onSubmit">
			<div>
				<label for="id">아이디</label>
				<input type="text" id="id" v-model="id" />
			</div>
			<div>
				<label for="password">비밀번호</label>
				<input type="password" id="password" v-model="pw" />
			</div>
            <div>
				<label for="name">이름</label>
				<input type="text" id="name" v-model="name" />
			</div>
			<div>
				<label for="sex">성별</label>
				<input type="text" id="sex" v-model="sex" />
			</div>
            <div>
				<label for="birth">생년월일</label>
				<input type="text" id="birth" v-model="birth" />
			</div>
			<div>
				<label for="phoneNo">핸드폰번호</label>
				<input type="text" id="phoneNo" v-model="phoneNo" />
			</div>
			<button type="submit">회원가입</button>
		</form>
	</div>
    </v-container>
</template>

<script>
export default {
    name: 'JoinRegisterForm',
    data () {
        return {
            id: '',
            pw: '',
            name: '',
            sex: '',
            phoneNo: '',
            birth: ''
        }
    },
    methods: {
        onSubmit () {
            const {id, pw, name,sex, phoneNo, birth} = this
            this.$emit('submit', {id, pw, name,sex, phoneNo, birth})
        }
    }
}
</script>
