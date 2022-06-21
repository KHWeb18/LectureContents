<template>
    <div>
        <form @submit.prevent="onSubmit"> <!-- prevent없으면 버튼에 창이 새로고침되는 에러 -->
            <v-text-field label="학생 ID" v-model="studentInfo.studentId"/>
            <v-text-field label="학생 비밀번호" v-model="studentInfo.studentPw" type="password"/>
            <v-radio-group v-model="studentInfo.studentGrade" row>
                <v-radio v-for="grade in grades" :key="grade" :label="`${grade}`"> <!-- `${identity}`는 radio 개별 값을 보여줌 -->
                   
                </v-radio>
            </v-radio-group>
            <v-spacer></v-spacer>
            <v-btn type="submit" class="btn waves-effect waves-teal pink">가입!</v-btn>
        </form>
    </div>
</template>

<script>

export default {
    name: 'JoinColumnTestForm',
    data() {
        return {
            studentInfo: {
                studentId: '',
                studentPw: '',
                studentGrade: '',   
            },
            grades: [
                    '1학년', '2학년', '3학년'
                ],
            tmpGrade: ''    
        }
    },
    methods: {
        onSubmit() {
            // const auth = this.studentInfo.studentAuth == 0 ? 'student' : 'teacher'

            if(this.studentInfo.studentGrade == 0) {
                this.tmpGrade = 'freshman'
            } else if(this.studentInfo.studentGrade == 1) {
                this.tmpGrade = 'sophomore'
            } else {
                this.tmpGrade = 'senior'
            }

            const studentGrade = this.tmpGrade
            const { studentId, studentPw } = this.studentInfo
            this.$emit('submit', { studentId, studentPw, studentGrade })
        }   
    }
}
</script>
