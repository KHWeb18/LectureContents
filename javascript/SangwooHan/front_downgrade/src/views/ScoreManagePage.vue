<template>
    <div id="board">
        <h2>누가누가 못햇을까 철수네반 학생성적표..^^</h2>

        <student-score-list :students="students"/>
     <mean-determinant></mean-determinant>
    </div>
</template>

<script>
import StudentScoreList from '@/components/score/StudentScoreList.vue'
import  MeanDeterminant from '@/components/score/MeanDeterminant.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'ScoreManagePage',
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