<template>
  <div id="board">
    <h2>학생들 성적표</h2>
    <student-list :students="students"></student-list>
    <student-average></student-average>

  </div>
</template>

<script>

import { mapState, mapActions } from 'vuex'

import StudentList from "../components/student/StudentList";
import StudentAverage from "../components/student/StudentAverage";
export default {
  name: 'StudentListPage',
  components: {
    StudentAverage,
    StudentList,

  },
  computed: {
    ...mapState(['students'])
  },
  mounted () {
    this.fetchStudentList()
  },
  methods: {
    ...mapActions(['fetchStudentList'])
  }
}
</script>

<style>

</style>