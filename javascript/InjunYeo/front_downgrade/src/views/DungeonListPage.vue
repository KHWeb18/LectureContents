<template>
    <div id="board">
        <h2>이곳은 던전!</h2>
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