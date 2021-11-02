<template>
    <div>
        <h2>Vue + Spring 몬스터정보 읽기</h2>
        <monster-book-read v-if="monster" :monster="monster"/>
        <p v-else>로딩중 .......</p>
        <router-link :to="{ name: 'MonsterBookModifyPage', params: { monsterNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'MonsterBookListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>

import MonsterBookRead from '@/components/monster/MonsterBookRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'MonsterBookReadPage',
    props: {
        monsterNo: {
        type: String,
        required: true
        }
    },
    components: {
        MonsterBookRead
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
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'MonsterBookListPage' })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    }
}

</script>