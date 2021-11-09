<template>
  <div>
    <table border="1">
      <tr>
        <th width="50">번호</th>
        <th width="100">이름</th>
        <th width="100">점수</th>
      </tr>
       <tr v-if="!students || (Array.isArray(students) && students.length === 0)">
        <td colspan="3">
          학생 점수가 없습니다
        </td>
      </tr>
      <tr v-else v-for="(student, idx) in students" :key="idx"
          v-on:click="determinantMean(student.score, student.name)">
        <td align="center">{{ student.studentNo }}</td>
        <td align="center">{{ student.name }}</td>
        <td align="center">{{ student.score }}</td>
      </tr>
    </table>
    <h4>평균 점수: {{ calcMean }}점</h4>
  </div>
</template>


<script>
import EventBus from '@/eventBus'

export default {
  name: 'StudentScore', 
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
    determinantMean(scores, name) {
      var tmp = 0
      var len = this.students.length
      
      for (var i = 0; i < len; i++) {
        tmp += this.students[i].score
      }
      const mean = tmp / len

      const payload = [ mean, scores, name ]
      EventBus.$emit('calcMean', payload)
    }
  },
}
</script>


<style scoped>
table {
  margin: auto;
}
</style>