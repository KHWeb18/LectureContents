<template>
    <div id="monster">
        <h2>Vue + Spring 몬스터 도감</h2>
        <router-link :to="{ name: 'MonsterRegisterPage' }">
            몬스터 도감 작성
        </router-link>
        <monster-list :monsters="monsters"/>
    </div>
</template>

<script>
import MonsterList from '@/components/monsterBook/MonsterList.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'MonsterListPage',
    components: {
        MonsterList
    },
    // 실제 값에 변경이 발생할때 동작함
    computed: {
        ...mapState(['monsters'])
    },
    // mounted : 객체가 생성되고나서 웹이랑 붙을 때
    mounted () {
        this.fetchMonsterList()
    },
    methods: {
        ...mapActions(['fetchMonsterList'])
    }
}
</script>