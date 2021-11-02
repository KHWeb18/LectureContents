<template>
    <div id="board">
        <center>
        <h2>학생 성적 관리 페이지</h2>
        <student-score-list :students="students"/>
        <mean-determinant></mean-determinant>
        </center>
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