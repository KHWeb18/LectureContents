<template>
    <div>
        <h3>Monster Modify Form</h3>
        <monster-modify v-if="monster" :monster="monster" v-on:submit="onSubmit"/>
        <p v-else>Fetching Info...</p>

        <router-link :to="{ name: 'MonsterReadPage', params: monsterNo }">
            Cancel Modify
        </router-link>
    </div>
</template>

<script>
import axios from 'axios'
import MonsterModify from '@/components/monster/MonsterModify.vue'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'MonsterModifyPage',
    props: {
        monsterNo: {
            type: String,
            //여기 Number가 아니라 String임 Json형태로 들어가야하기때문에...
            required: true
        }
    },
    components: {
        MonsterModify
    },
    methods: {
        onSubmit(payload) {
            const { name, level, strength, hp, attribute, exp } = payload
            axios.put(`http://localhost:7777/vuemonster/${this.monsterNo}`, { name, level, strength, hp, attribute, exp })
                .then(res => {
                    alert('수정 성공! ' + JSON.stringify(res))
                    
                    this.$router.push({
                        name: 'MonsterStoragePage'   
                    })
                    //이거 왜 링크가 이상한대로가냐 하 ㅅㅂ 수정을
                })
                .catch(err => {
                    alert(err.response.data.message)
                })
        },
        ...mapActions(['fetchMonster'])
    },
    computed: {
        ...mapState(['monster'])
    },
    created() {
        this.fetchMonster(this.monsterNo)
            .catch(err => {
                alert(err.response.data.message)
                this.$router.back()
                })
    }

}
</script>
