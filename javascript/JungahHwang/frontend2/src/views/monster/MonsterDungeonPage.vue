<template>
  <div>
    <h2>Random Monster Dungeon</h2>
    <monster-dungeon :dungeons="dungeons"/>
    <dungeon-combat-power/>
  </div>
</template>


<script>
import MonsterDungeon from '@/components/monster/MonsterDungeon'
import DungeonCombatPower from '@/components/monster/DungeonCombatPower'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'MonsterDungeonPage',
  components: {
    MonsterDungeon,
    DungeonCombatPower
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