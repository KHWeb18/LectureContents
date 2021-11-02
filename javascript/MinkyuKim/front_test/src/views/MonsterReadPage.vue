<template>
    <div align="center">
        <h2>몬스터 설명 읽기</h2>
        <monster-read v-if="monster" :monster="monster"/>
        <p v-else>로딩중 ...... </p>
        
        <router-link :to="{ name: 'MonsterModifyPage', params: { monsterNo } }">
            등록된 상품 수정
        </router-link>
        <button @click="onDelete">상품 삭제</button>
        
        <router-link :to="{ name: 'MonsterListPage' }">
            상품 보기
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
            // json의 형태는 문자. 따라서 String 데이터타입으로 지정.
            type: String,
            required: true
        }
    },
    components: {
        MonsterRead
    },
    // computed- 실제 동작이 발생될 때 작동
    computed: {
        ...mapState(['monster'])
    },
    // created-객체가 생성될때 작동
    created () {
        this.fetchMonster(this.monsterNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchMonster']),
            // this.boardNo 를 쓰는것이 아니라  this.board 로 사용한 이유는 확장성을 위해.
            // 추후 필요하다면 boardNo뿐만 아니라 다른것도 받아올 수 있음
        onDelete () {
            const { monsterNo } = this.monster
            axios.delete(`http://localhost:7777/vuemonster/${monsterNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'MonsterListPage' })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    }
}
</script>