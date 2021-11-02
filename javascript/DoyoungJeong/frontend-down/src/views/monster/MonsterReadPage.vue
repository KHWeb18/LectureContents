<template>
    <div align="center">
        <h3>Monster Info</h3>
        <button v-on:click="onRemove">Remove Monster</button>

        <monster-read v-if="monster" :monster="monster"/>
        <p v-else>On Loading...</p>

        <router-link :to="{ name: 'MonsterStoragePage' }">
            Back to Storage Page
        </router-link>

        <router-link :to="{ name: 'MonsterModifyPage', params: monsterNo }">
            Modify Monster Status
        </router-link>

    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import MonsterRead from '@/components/monster/MonsterRead.vue' // '../components/monster/MonsterRead.vue'는 안됐다. 하위 컴포넌트라 그런가...

export default {
    name: 'MonsterReadPage',
    components: {
        'monster-read': MonsterRead
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
    created() {
        this.fetchMonster(this.monsterNo) 
            .catch(err => {
                alert(err.response.data.message + ' send failed!')
                //this.$router.push()
            })
    },
    methods: {
        ...mapActions(['fetchMonster']),

        onRemove() {
            const { monsterNo } = this.monster
            //확장성을 위해 this.board에서 boardNo만을 뽑아서 객체로 받아 전송한것이다!
            axios.delete(`http://localhost:7777/vuemonster/${monsterNo}`)
            .then(() => {
                alert('delete completed')
                this.$router.push({ name: 'MonsterStoragePage' })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    }
}
</script>
