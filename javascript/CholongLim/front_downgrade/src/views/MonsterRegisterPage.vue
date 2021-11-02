<template>
    <div align="center">
        <h2>몬스터 도감</h2>
        <monster-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import MonsterRegisterForm from '@/components/monsterBook/MonsterRegisterForm.vue'
import axios from 'axios'


export default {
    name: 'MonsterRegisterrPage',
    components: {
        MonsterRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { name, description, hp, exp, dropMoney, dropItem } = payload
            axios.post('http://localhost:7777/vuemonster/register', { name, description, hp, exp, dropMoney, dropItem })
                .then(res => {
                    alert('몬스터 등록이 완료되었습니다.' + res)
                    console.log('몬스터 번호 : ' + res.data.monsterNo.toString ())
                    this.$router.push({
                        name: 'MonsterListPage',
                    })
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}

</script>