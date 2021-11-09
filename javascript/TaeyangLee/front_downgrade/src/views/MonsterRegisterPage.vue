<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <monster-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import MonsterRegisterForm from '@/components/monster/MonsterRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'MonsterRegisterPage',
    components: {
        MonsterRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { monster_name, monster_hp } = payload
            axios.post('http://localhost:7777/vuegame/register', { monster_name, monster_hp })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        console.log('몬스터 번호: ' + res.data.monsterNo.toString())
                        this.$router.push({
                            name: 'MonsterListPage'
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>