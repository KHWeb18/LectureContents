<template>
    <div>
      <p>{{ dungeons[0].name }}</p>
        <ul v-for="pm in combat_power_measure" :key="pm.name">
            <li v-if="pm.name == dungeons[0].name">
               필요 전투력: {{ pm.measure }}
            </li>
        </ul>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data () {
        return {
            combat_power_measure: [
                { name: '불타는 대지', measure: 300 },
                { name: '뇌전도원', measure: 600 },
                { name: '심해빙궁', measure: 900 },
                { name: '망자들의 쉼터', measure: 100  },
                { name: '잊혀진 고대의 신전', measure: 300 },
            ],
            dungeons: []
        }
    },
    // created () {
    created: function() {
        EventBus.$on('sendMeasure', (payload) => {
            this.dungeons = payload
        })
    }
}
</script>
