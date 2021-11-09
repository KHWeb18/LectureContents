<template>
    <div id="board">
        <h2>학생 성적 관리 페이지!</h2>
        <student-score-list :students="students"/><br>
        <mean-determinant></mean-determinant>
    </div>
</template>

<script>
import StudentScoreList from '@/components/score/StudentScoreList.vue'
import MeanDeterminant from '@/components/score/MeanDeterminant.vue'
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
        // 비동기처리를 하여서(fetchStudentScoreList)에서 쓰레드 문제가 발생함.
        this.fetchStudentScoreList()
    },
    methods: {
        ...mapActions(['fetchStudentScoreList'])
    }
}
</script>