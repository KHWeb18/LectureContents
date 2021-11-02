<template>
    <div align="center">
        <h2>몬스터 등록</h2>
        <monster-book-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import MonsterBookRegisterForm from '@/components/monster/MonsterBookRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'MonsterBookRegisterPage',
    components: {
        MonsterBookRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { name, hp, atk } = payload
            axios.post('http://localhost:7777/vuemonster/register', { name, hp, atk })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        
                        this.$router.push({
                            name: 'MonsterBookListPage',
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>
