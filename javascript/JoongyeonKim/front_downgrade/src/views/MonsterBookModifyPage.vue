<template>
    <div align="center">
        <h2>게시물 수정</h2>             <!--:product는 ProductModifyForm에 있는 props이다 -->
        <monster-book-modify-form v-if="monster" :monster="monster" @submit="onSubmit"/>
    <p v-else>로딩중 .......</p>                 <!--@submit="onSubmit" 을 하면  아래에서 submit이 작동하여 에러가 나지않게 하기위해 필요하다  -->
    </div>
</template>

<script>

import MonsterBookModifyForm from '@/components/monster/MonsterBookModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'ProductModifyPage',
    components: {
        MonsterBookModifyForm
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
            const { name, hp, atk } = payload
            axios.put(`http://localhost:7777/vuemonster/${this.monsterNo}`, {name, hp, atk})
            .then(res => {
                alert('수정 성공')
                this.$router.push({
                    name: 'MonsterBookReadPage',
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