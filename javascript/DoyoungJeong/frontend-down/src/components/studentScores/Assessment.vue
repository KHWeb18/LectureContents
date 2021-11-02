<template>
    <div class="assessmentBox">
        <h3>학생 이름: {{ studentInfo[1] }}</h3>
        
            <p v-if="totalAverage > studentInfo[0]">
                이 학생의 평균은 {{ studentInfo[0] }}점이고 전체 평균보다 {{ totalAverage - studentInfo[0] }}점 낮습니다.
            </p>
            <p v-else>
                이 학생의 평균은 전체 평균 이상입니다.
            </p>
    </div>
</template>

<script>

import EventBus from '@/eventBus.js'

export default {
    name: 'Assessment',
    props: {
        students: {
            type: Array
        }
    },
    data() {
        return {
            studentInfo: [],
            totalAverage: null,
            noOfSubjects: 3
        }
    },
    created: function() {
        EventBus.$on('assessment', (payload) => {
            //EventBus.$once('sendcode', (payload) => { 
            //once는 한 번 작동 on은 계속 작동
            this.studentInfo = payload

            var total = null
            for(var i=0; i<this.students.length; i++) {
                total += this.students[i].reading + this.students[i].math + this.students[i].english  
            }
            this.totalAverage = Math.round((total / this.students.length) / this.noOfSubjects)
            console.log('totalAverage: ' + this.totalAverage)
        })

    },
    methods: {

    }
}
</script>

<style>

.assessmentBox {
    margin-top: 20px;
}

</style>