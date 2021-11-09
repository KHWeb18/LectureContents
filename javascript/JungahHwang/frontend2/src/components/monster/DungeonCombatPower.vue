<template>
  <div>
    <p>{{ dungeons[0] }}</p>
    <ul v-for="cp in combat_power" :key="cp.name">
      <li v-if="cp.name == dungeons[0]">
        전투력 {{ cp.power }} 이상 진입 가능
      </li>
    </ul>
  </div>
</template>


<script>

import EventBus from '@/eventBus'

export default {
  data () {
    return {
      combat_power: [
        { name: 'SS', power: "500" },
        { name: 'S', power: "400" },
        { name: 'A', power: "300" },
        { name: 'B', power: "200" },
        { name: 'C', power: "100" },
      ],
      dungeons: []
    }
  },
  created () {
    EventBus.$on('sendname', (payload) => {
      this.dungeons = payload
    })
  }
}
</script>
