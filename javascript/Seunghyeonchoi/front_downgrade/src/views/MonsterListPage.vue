<template>
    <div id="board">
        <h2>몬스터 도감이닷!</h2>
        <router-link :to="{ name: 'MonsterRegisterPage' }">
            몬스터 도감 등록
        </router-link>
        <monster-list :monsters="monsters"/>
    </div>
</template>

<script>
import MonsterList from '@/components/monster/MonsterList.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'MonsterListPage',
    components: {
        MonsterList
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