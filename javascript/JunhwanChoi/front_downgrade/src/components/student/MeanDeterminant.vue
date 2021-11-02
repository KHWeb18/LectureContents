<template>
    <div>
        <p>{{ students }}</p><br>
        <p v-if="flag && (mean === students[0])">
            딱 평균에 걸쳤습니다!
        </p>
        <p v-else-if="flag && (mean < students[0])">
            평균 이상입니다!
        </p>
        <p v-else-if="flag && (mean > students[0])">
            평균 이하입니다!
        </p>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data () {
        return {
            flag: false,
            mean: 0,
            students: []
        }
    },
    created: function() {
        EventBus.$on('calcMean', (payload) => {
            this.flag = true
            this.mean = payload[0]
            this.students = [ payload[1], payload[2] ]
        })
    }
}
</script>

<style scoped>
div {
    background: #ff4081;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}
</style>