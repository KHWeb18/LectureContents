<template>
  <div id="monster">
    <h2>몬스터 관리 페이지 구현</h2>
    <router-link :to="{ name: 'MonsterRegisterPage' }">
      몬스터 생성하기
    </router-link>
    <monster-list :monsters="monsters" />
  </div>
</template>

<script>
import MonsterList from '@/components/monstergame/MonsterList.vue'
import { mapActions, mapState } from 'vuex'
export default {
  name: 'MonsterListPage',
  components: {
    MonsterList
  },
  computed: {
    ...mapState(['monsters'])
  },
  mounted() {
    this.fetchMonsterList()
  },
  methods: {
    ...mapActions(['fetchMonsterList'])
  },
}
</script>