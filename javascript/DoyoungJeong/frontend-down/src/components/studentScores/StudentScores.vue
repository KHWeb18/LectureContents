<template>
    <div align="center">
        <table>
            <tr>               
                <td align="center" width="80">이름</td>
                <td align="center" width="80">국어</td>
                <td align="center" width="80">수학</td>
                <td align="center" width="80">영어</td>
            </tr>
            <tr v-if="!students && (Array.isArray(students) && students.length == 0)">
                <td colspan="4">학생 성적 정보가 없습니다!</td>
            </tr>
            <tr v-else v-for="(student, index) in students" :key="index">

                <td align="center" width="80" 
                v-on:click="assessment(student.reading, student.math, student.english, $event)">{{ student.name }}</td>

                <td align="center" width="80">{{ student.reading }}</td>
                <td align="center" width="80">{{ student.math }}</td>
                <td align="center" width="80">{{ student.english }}</td>
            </tr>
        </table>
    </div>
</template>

<script>

import EventBus from '@/eventBus.js'

export default {
    name: 'StudentScores',
    props: {
        students: {
            type: Array,
            requried: true
        }
    },
    methods: {
        assessment(score1, score2, score3, $event) {
            var average = Math.round(((score1 + score2 + score3) / 3))
            //int형 변환이 vue에서는 안된다.

            console.log('The average score of this student is: ' + average)

            const payload = [ average, $event.target.innerHTML ]
            EventBus.$emit('assessment', payload)
        }
    }
}
</script>
