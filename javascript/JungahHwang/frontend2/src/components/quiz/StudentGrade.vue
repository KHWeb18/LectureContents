<template>
  <div>
    <p v-if="flag && (mean === scores)">{{ name }}의 점수가 평균입니다.</p>
    <p v-else-if="flag && (mean < scores)">{{ name }}의 점수가 평균 이상입니다.</p>
    <p v-else-if="flag && (mean > scores)">{{ name }}의 점수가 평균 이하입니다.</p>
  </div>
</template>


<script>

import EventBus from '@/eventBus'

export default {
  data () {
    return {
      mean: 0,
      scores: 0,
      name: '',
      flag: false
    }
  },
  created () {
    EventBus.$on('calcMean', (payload) => {
      this.mean = payload[0]
      this.scores = payload[1]
      this.name = payload[2] 
      this.flag = true
    })
  }
}
</script>
