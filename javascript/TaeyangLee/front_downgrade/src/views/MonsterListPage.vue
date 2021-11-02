<template>
    <div id="monster">
        <h2>Vue + Spring + DB 몬스터도감</h2>
        <router-link :to="{ name: 'MonsterRegisterPage' }">
            몬스터 등록
        </router-link>
        <monster-listing :monsters="monsters"/>
    </div>
</template>

<script>
import MonsterListing from '@/components/monster/MonsterListing.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'MonsterListPage',
    components: {
        MonsterListing
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