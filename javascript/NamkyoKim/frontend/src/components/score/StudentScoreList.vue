<template>
    <div>
        <h3>학생 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="50">번호</th>
                <th align="center" width="150">이름</th>
                <th align="center" width="150">성적</th>
            </tr>
            <tr v-if="!students || (Array.isArray(students) && students.length === 0)">
                <td colspan="3">
                    학생이 없습니다! 폐교합니다!
                </td>
            </tr>
            <tr v-else v-for="(student, idx) in students" :key="idx">
                <td align="center">{{ student.studentNo }}</td>
                <!-- <td align="center">{{ student.name }}</td> -->
                <td align="center" v-on:click="determinantMean(student.score, $event)">
                    {{ student.name }}
                </td>
                <td align="center">{{ student.score }}</td>
            </tr>
        </table>
        평균: {{ calcMean }}
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