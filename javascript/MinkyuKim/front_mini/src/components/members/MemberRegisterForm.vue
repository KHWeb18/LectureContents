<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <div class="row">
                <v-radio-group v-model="radioGroup" row>
                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`"> 
                    </v-radio>
                </v-radio-group>
            </div>
            <tr>
                <th>*아이디</th>
                <td>
                    <input v-model="userId" type="text" maxlength="20">
                    <div v-if="!idValid">
                    영문 또는 숫자로만 입력해주세요.
                    </div>
                </td>
            </tr>
            <tr>
                <th>*비밀번호</th>
                <td>
                    <input v-model="password" type="password" maxlength="16" @blur="passwordValid">
                    <div v-if="!passwordValidFlag">
                    대문자, 소문자, 숫자를 반드시 1개 이상 포함하고 8자이상 16자 이하로 만들어주세요.
                    </div>
                </td>
            </tr>
            <tr>
                <th>*비밀번호 확인</th>
                <td>
                    <input v-model="passwordCheck" type="password" maxlength="16" @blur="passwordCheckValid">
                    <div v-if="!passwordCheckFlag">
                        비밀번호가 동일하지 않습니다.
                    </div>
                </td>
            </tr>
            <tr>
                <th>*이름</th>
                <td>
                    <input v-model="name" type="text" maxlength="20" @blur="nameValid">
                    <div v-if="!nameValidFlag">
                        이름을 입력해주세요
                    </div>
                </td>
            </tr>            
            <tr>
                <th>*생년월일</th>
                <td><input type="text" v-model="dateOfBirth"></td>
            </tr>
            <tr>
                <th>*전화번호</th>
                <td><input type="number" v-model="phoneNumber"></td>
            </tr>
            <tr>
                <th>*이메일</th>
                <td><input type="text" v-model="email"></td>
            </tr>
            <tr>
                <th>*주소</th>
                <td><input type="text" v-model="address"></td>
            </tr>
            <table>
                <tr>
                    <th>*성별</th>                    
                    <td>
                    <v-radio-group v-model="genderRadioGroup" row>
                        <v-radio v-for="kinds in kindsOfGender" :key="kinds" :label="`${kinds}`"> 
                        </v-radio>
                    </v-radio-group>
                    </td>
                </tr>
            </table>
            <div class="row">
                <th>관심사</th>  
                <v-checkbox v-model="drawing" label="그림"></v-checkbox>
                <v-checkbox v-model="article" label="소품"></v-checkbox>                   
                <v-checkbox v-model="largeArtwork" label="대형 작품"></v-checkbox>
            </div>

            <div>
                <button type="submit">가입</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'MemberRegisterForm',
    data () { 
        return { 
            radioGroup: 1,
            kindsOfMember: [
                '구매회원',
                '판매회원'
            ],
            userId: '',
            password: '',
            name: '' ,
            passwordCheck: '',
            passwordValidFlag: true,
            passwordCheckFlag: true,
            nameValidFlag: true,
            genderRadioGroup: 0,
            kindsOfGender: [
                '남성',
                '여성'
            ],
            dateOfBirth: '',
            phoneNumber: '',
            email: '',
            address: '',            
            drawing: '',            
            article : '',
            largeArtwork: ''
        }
    }, 

    computed: {
        idValid () { 
            return /^[A-Za-z0-9]+$/.test(this.userId)
        }    
    },
    methods: {
        onSubmit () {
            const { userId, password, name, dateOfBirth, phoneNumber, email, address, genderRadioGroup, drawing, article, largeArtwork, radioGroup } = this
            const auth = radioGroup == 0 ? '구매회원' : '판매회원'
            const gender = genderRadioGroup == 0 ? '남성' : '여성'
            this.$emit('submit', { userId, password, name, dateOfBirth, phoneNumber, email, address, gender, drawing, article, largeArtwork, auth })
        },
        passwordValid () {
            if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/.test(this.password)) {
                this.passwordValidFlag = true
                } else {
                    this.passwordValidFlag = false 
                    }
        },
        passwordCheckValid () {
            if (this.password === this.passwordCheck) {
                this.passwordCheckFlag = true
                } else {
                    this.passwordCheckFlag = false
            }
        },
        nameValid () {
            if(this.name === '') {
                this.nameValidFlag = true
                } else {
                    this.nameValidFlag = false
            }
        },
        
    }
}
</script> 
