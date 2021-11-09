<template>
  <div>
    <p>{{ students }}</p>
    <ul v-for="(dd, idx) in students_details" :key="idx">
      <li v-if="dd.studentGrades == students[0]">
        학생명: {{ students[1] }} 학생 성적: {{students[0]}}<br>
        {{ dd.text }}
      </li>
    </ul>

  </div>
</template>

<script>
import EventBus from "../../eventBus";

export default {
  name: "StudentAverage",
  data () {
    return {
      students_details: [
        { studentGrades: 'A', text: "평균이상입니다!"},
        { studentGrades: 'B', text: "평균이상입니다!"},
        { studentGrades: 'C', text: "평균입니다."},
        { studentGrades: 'D', text: "평균미달"},
        { studentGrades: 'F', text: "낙제"},
      ],
      students: []
    }
  },
  created() {
    EventBus.$on('checkStudentGrades',(payload) => {
      this.students = payload
    })
  }
}
</script>

<style scoped>

</style>