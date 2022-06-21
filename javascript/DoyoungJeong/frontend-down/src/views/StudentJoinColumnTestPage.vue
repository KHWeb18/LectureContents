<template>
    <div style="margin-top: 100px;">
        <h3>Join Column 학생 회원가입</h3>
        <v-container style="width: 400px;">
            <join-column-test-form v-on:submit="onSubmit"/>
        </v-container>
    </div>
</template>

<script>
import JoinColumnTestForm from '@/components/jpaTest/JoinColumnTestForm'
import axios from 'axios'

export default {
    name: 'StudentJoinColumnTestPage',
    components: {
        JoinColumnTestForm
    },
    methods: {
        onSubmit(payload) {
            const { studentId, studentPw, studentGrade } = payload

            alert(JSON.stringify({ studentId, studentPw, studentGrade }))
            axios.post('http://localhost:7777/joincolumntest/signup', { studentId, studentPw, studentGrade })
            .then(res => {
                alert('등록 성공' + res.data)
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }   
    }
}
</script>
