<template>
    <div>
        <h3>Student Scores Board</h3>
        <student-scores :students="students"></student-scores>
        <assessment :students="students"></assessment>
    </div>
</template>

<script>
import StudentScores from '@/components/studentScores/StudentScores.vue'
import Assessment from '@/components/studentScores/Assessment.vue'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'StudentScoresPage',
    components: {
        StudentScores,
        Assessment
    },
    computed: {
        ...mapState(['students'])
    },
    mounted() {
        this.fetchStudentList()
    },
    methods: {
        ...mapActions(['fetchStudentList'])
    }
}
</script>
