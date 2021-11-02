  
<template>
    <div align="center">
        <h2>몬스터 정보</h2>
        <monster-read v-if="monster" :monster="monster"/>
        <p v-else>로딩중 ...... </p>
   
        <router-link :to="{ name: 'MonsterModifyPage', params: { monsterNo } }">
            몬스터 정보 변경
        </router-link>

        <button @click="onDelete">삭제</button> -->
        <router-link :to="{ name: 'MonsterListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>
import MonsterRead from '@/components/monster/MonsterRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'MonsterReadPage',
    props: {
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
                    .then(()=>{
                        alert('삭제 성공!')
                        this.$router.push({ name: 'MonsterListPage' })
                    })
                    .catch(err=>{
                        alert(err.response.data.message)
                    })
        }
    }
}
</script>