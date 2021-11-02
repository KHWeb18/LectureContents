<template>
  <div>
    <h2>학생 점수 현황</h2>
    <student-score :students="students"/>
    <student-grade/>
  </div>
</template>


<script>
import StudentScore from '@/components/quiz/StudentScore'
import StudentGrade from '@/components/quiz/StudentGrade'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'StudentScorePage',
  components: {
    StudentScore,
    StudentGrade
  },
  computed: {
    ...mapState(['students'])
  },
  mounted () {
    this.fetchStudentScore()
  },
  methods: {
    ...mapActions(['fetchStudentScore'])
  }
}
</script>