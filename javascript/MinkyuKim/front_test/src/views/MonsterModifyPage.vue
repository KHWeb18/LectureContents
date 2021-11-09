<template>
    <div align="center">
        <h2>몬스터 정보 수정</h2>
        <!--만약 monster가 있다면 monster를 바인딩 시키고 submit
            앞의 monster는 data의 monster, 뒤의 monster는 props의 monster-->
        <monster-modify-form v-if="monster" :monster="monster" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>

import MonsterModifyForm from '@/components/monster/MonsterModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'MonsterModifyPage',
    components: {
        MonsterModifyForm
    },
    props: {
        monsterNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['monster'])
    },
    methods: {
        ...mapActions(['fetchMonster']),
        onSubmit (payload) {
            console.log("payload: " + JSON.stringify(payload))

            const { name, hp, exp, dropMoney, dropItem, description } = payload
            axios.put(`http://localhost:7777/vuemonster/${this.monsterNo}`, { name, hp, exp, dropMoney, dropItem, description })
                    .then(res => {
                        alert('수정 성공!')
                        // push의 경우 to의 역할과 같다.( router-link-to)
                        this.$router.push({
                            name: 'MonsterReadPage',
                            params: { monsterNo: res.data.monsterNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchMonster(this.monsterNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>