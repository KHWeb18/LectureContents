<template>
    <div>
        <p> {{ students }} </p>
      <p v-if="flag && mean < students[0]">
            ㅋㅋ ㄹㅇ 꼴지반인데 이정돈 해야지 
      </p>
      <p v-else-if="flag">
        ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ  부모님 모셔와라 
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
            this.students = [payload[1], payload[2]]
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