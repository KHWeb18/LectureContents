<template>
    <div id="board">
        <h2>기말고사 성적표</h2>
        <student-score-list :students="students"/><br>
        <mean-determinant></mean-determinant>
    </div>
</template>

<script>

import StudentScoreList from '@/components/student/StudentScoreList.vue'
import MeanDeterminant from '@/components/student/MeanDeterminant.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'ScoreManagerPage',
    components: {
        StudentScoreList,
        MeanDeterminant
    },
    computed: {
        ...mapState(['students'])
    },
    mounted () {
        this.fetchStudentScoreList()
    },
    methods: {
        ...mapActions(['fetchStudentScoreList'])
    }
}
</script>

