<template>
    <div>
        <h3>학생 성적표 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="150">이름</th>
                <th align="center" width="200">성적</th>
                <th align="center" width="150">날짜</th>
            </tr>
            <tr v-if="!students || (Array.isArray(students) && students.length === 0)">
                <td colspan="4">
                    에러입니다! 성적표를 표시할 수 없습니다.
                </td>
            </tr>
            <tr v-else v-for="(student, idx) in students" :key="idx">
                <td align="center">{{ student.studentNo }}</td>
                <td align="center" v-on:click="determinantMean(student.score, $event)">
                    {{ student.name }}
                </td>
                <td align="center">{{ student.score }}</td>
                <td align="center">{{ student.regDate }}</td>
            </tr>
        </table>
        평균: {{calcMean}}
    </div>
</template>

<script>
 
import EventBus from '@/eventBus.js'

export default {
    name: 'StudentScoreList',
    props: {
        students: {
            type: Array
        }
    },

    computed: {
        calcMean () {
            var tmp = 0
            var len = this.students.length

            for (var i = 0; i < len; i++) {
                tmp += this.students[i].score
            }
            
            return tmp / len
        }
    },
    methods: {
        determinantMean(personalScore, $event) {
            var tmp = 0
            var len = this.students.length
            for (var i = 0; i < len; i++) {
                tmp += this.students[i].score
            }

            const mean = tmp / len
            const payload = [ mean, personalScore, $event.target.innerHTML ]
            EventBus.$emit('calcMean', payload)
        }
    }
}


</script>