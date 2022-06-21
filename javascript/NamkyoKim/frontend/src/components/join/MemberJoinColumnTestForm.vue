<template>
<v-container>
   <div align="center">
		<form @submit.prevent="onSubmit">
            <div class="row">
                <v-radio-group v-model="radioGroup" row>
                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`">
                    </v-radio>
                </v-radio-group>
            </div>
			<div>
				<label for="id">아이디</label>
				<input type="text" id="id" v-model="id" style="width:300px"/>
			</div>
			<div>
				<label for="password">비밀번호</label>
				<input type="password" id="password" v-model="pw" style="width:300px"/>
			</div>
            <div>
				<label for="name">이름</label>
				<input type="text" id="name" v-model="name" style="width:300px" />
			</div>
			<div>
				<label for="sex">성별</label>
				<input type="text" id="sex" v-model="sex" style="width:300px" />
			</div>
            <div>
				<label for="birth">생년월일</label>
				<input type="text" id="birth" v-model="birth" style="width:300px"/>
			</div>
			<div>
				<label for="phoneNo">핸드폰번호</label>
				<input type="text" id="phoneNo" v-model="phoneNo" style="width:300px"/>
			</div>
			<button type="submit">회원가입</button>
		</form>
	</div>
    </v-container>
</template>

<script>
export default {
    name: 'MemberJoinColumnTestForm',
    data () {
        return {
            radioGroup : 1,
         kindsOfMember: [
             '개인',
             '사업자'
         ], 
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
           const {id, pw, name,sex, phoneNo, birth , radioGroup} = this
           const auth = radioGroup == 0 ? '개인' : '사업자'
            this.$emit('submit', {id, pw, name,sex, phoneNo, birth, auth })
        }
    }
}
</script>
