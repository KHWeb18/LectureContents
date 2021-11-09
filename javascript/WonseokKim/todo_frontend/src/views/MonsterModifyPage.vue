<template>
    <div align="center">
        <h2>게시물 수정</h2>
        <monster-modify-form v-if="monster" :monster="monster" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>

import MonsterModifyForm from '@/components/monsterhw/MonsterModifyForm'
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
            const { monster_name, monster_hp, monster_exp, monster_money, monster_description } = payload
            axios.put(`http://localhost:7777/vuemonster/${this.monsterNo}`, { monster_name, monster_hp, monster_exp, monster_money, monster_description })
                    .then(res => {
                        alert('수정 성공!')
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