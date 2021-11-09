<template>
    <div align="center">
        <h2>Vue + Spring 몬스터 도감</h2>
        <monster-read v-if="monster" :monster="monster"/>
        <p v-else>로딩중 ...... </p>
        <router-link :to="{ name: 'MonsterModifyPage', params: { monsterNo } }">
            몬스터 도감 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'MonsterListPage' }">
            몬스터 도감 보기
        </router-link>
    </div>
</template>

<script>
import MonsterRead from '@/components/monsterBook/MonsterRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'MonsterReadPage',
    props: {
            // 데이터가 JSON으로 넘어오고,
            // JSON은 문자이다.
            // 따라서 처음 넘어올때 String으로 넘어옴
        monsterNo: {
            type: String,
            required: true
        }
    },
    components: {
        MonsterRead
    },
    computed: {
        ...mapState(['monster'])
    },
    // created : 객체가 생성될때
    created () {
        this.fetchMonster(this.monsterNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchMonster']),
        onDelete () {
            const { monsterNo } = this.monster
            axios.delete(`http://localhost:7777/vuemonster/${monsterNo}`)
                .then(() => {
                    alert('몬스터를 삭제했습니다.')
                    this.$router.push({ name: 'MonsterListPage' })
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}
</script>