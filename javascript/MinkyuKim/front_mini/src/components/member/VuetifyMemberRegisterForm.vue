<template>
    <v-container>
        <form @submit.prevent="onSubmit">            
            <table>                
                <tr>
                    <td>*아이디</td>
                    <td><input type="text" v-model="id"></td>
                </tr>
                <tr>
                    <td>*비밀번호</td>
                    <td><input type="password" v-model="pw"></td>
                </tr>     
                <tr>
                    <td>*비밀번호 확인</td>
                    <td><input type="password" v-model="pwCheck"></td>
                </tr>     

                <tr>
                    <td>*이름</td>

                    <td><input type="text" v-model="name"></td>
                </tr>

                <tr>
                    <td>*생년월일</td>
                    <td><input type="text" v-model="dateOfBirth"></td>
                </tr>

                <tr>
                    <td>*전화번호</td>
                    <td><input type="number" v-model="phoneNumber"></td>
                </tr>
                <tr>
                    <td>*이메일</td>
                    <td><input type="text" v-model="email"></td>
                </tr>

                <tr>
                    <td>*주소</td>
                    <td><input type="text" v-model="address"></td>
                </tr>
            </table>

            <table>
                <tr>
                    <td>*성별</td>                    
                    <td>
                    <v-radio-group v-model="genderRadioGroup" row>
                        <v-radio v-for="kinds in kindsOfGender" :key="kinds" :label="`${kinds}`"> 
                        </v-radio>
                    </v-radio-group>
                    </td>
                </tr>
            </table>
            <div class="row">
                <td>관심사</td>                             
                <v-checkbox v-model="drawing" label="그림"></v-checkbox>
                <v-checkbox v-model="article" label="소품"></v-checkbox>                      
            </div>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'VuetifyMemberRegisterForm',
    data () {
        return {            
            user_id: '',
            genderRadioGroup: 0,
            kindsOfGender: [
                '남성',
                '여성'
            ],
            id: '',
            pw: '',
            pwCheck: '',
            name: '',
            dateOfBirth: '',
            phoneNumber: '',
            email: '',
            address: '',            
            drawing: '',            
            article : '',            
        }
    },
    methods: {
        onSubmit () {
            const { id, pw, genderRadioGroup, name, dateOfBirth, phoneNumber, email, address, gender, drawing, article} = this
            this.$emit('submit', { id, pw, genderRadioGroup, name, dateOfBirth, phoneNumber, email, address, gender, drawing, article })
        }
    }
}
</script> 
