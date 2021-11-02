<template>
  <div id="monster">
    <h2>몬스터 가이드</h2>
    <router-link :to="{ name: 'MonsterCreatePage'}">
      몬스터 등록
    </router-link>
    <monster-guide :monsters="monsters"/>
  </div>
</template>


<script>
import { mapActions, mapState } from 'vuex'
import MonsterGuide from '@/components/monster/MonsterGuide.vue'

export default {
  name: 'MonsterGuidePage',
  components: {
    MonsterGuide
  },
  computed: {
    ...mapState(['monsters'])
  },
  mounted () {
    this.fetchMonsterList()
  },
  methods: {
    ...mapActions(['fetchMonsterList'])
  }

}
</script>
