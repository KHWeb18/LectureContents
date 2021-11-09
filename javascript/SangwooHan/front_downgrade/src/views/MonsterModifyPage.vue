<template>
    <div align="center">
        <h2>상품 수정</h2>
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
            const { name, description, hp, exp, dropMoney, dropItem  } = payload
            axios.put(`http://localhost:9999/vuemonster/${this.monsterNo}`, {  name, description, hp, exp, dropMoney, dropItem  })
                    .then(res => {
                        alert('수정 성공!')
                        this.$router.push({
                            name: 'MonsterListPage',
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