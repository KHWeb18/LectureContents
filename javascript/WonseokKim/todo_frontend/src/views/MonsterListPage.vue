<template>
    <div id="monster">
        <h2>Monster 게시판 구현</h2>
        <router-link :to="{ name: 'MonsterRegisterPage' }">
            몬스터 등록
        </router-link>
        <monster-list :monsters="monsters"></monster-list>
    </div>
</template>

<script>

import MonsterList from '@/components/monsterhw/MonsterList.vue'
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
