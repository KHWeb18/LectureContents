<template>
    <div id="monster">
        <h2>매번 새롭게 갱신되는 던전 원정 이벤투!</h2>
        <dungeon-list :dungeons="dungeons"/>
        <combat-power-measure></combat-power-measure>
    </div>
</template>

<script>
import DungeonList from '@/components/dungeon/DungeonList.vue'
import CombatPowerMeasure from '@/components/dungeon/CombatPowerMeasure.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'DungeonListPage',
    components: {
        DungeonList,
        CombatPowerMeasure
    },
    computed: {
        ...mapState(['dungeons'])
    },
    mounted () {
       this.randomDungeonList()
    },
    methods: {
        ...mapActions(['randomDungeonList'])
    }
}
</script>