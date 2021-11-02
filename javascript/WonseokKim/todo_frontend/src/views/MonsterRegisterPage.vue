<template>
    <div align="center">
        <h2>몬스터 등록</h2>
        <monster-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
// @는 src 자체를 의미 함
import MonsterRegisterForm from '@/components/monsterhw/MonsterRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'MonsterRegisterPage',
    components: {
        MonsterRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { monster_name, monster_hp, monster_exp, monster_money, monster_description } = payload
            axios.post('http://localhost:7777/vuemonster/register', { monster_name, monster_hp, monster_exp, monster_money, monster_description })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        this.$router.push({
                            name: 'MonsterListPage',
                            params: { monsterNo: res.data.monsterNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>