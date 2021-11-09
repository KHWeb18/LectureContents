<template>
    <div align="center">
        <h2>게시물 수정</h2>
        <monster-modify-form v-if="monster" :monster=monster @submit="onSubmit"/>
        <p v-else>로딩중.......</p>
    </div>
</template>



<script>
import MonsterModifyForm from '@/components/monster/MonsterModifyForm'
import { mapState,mapActions } from 'vuex'
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
        onSubmit(payload){
            const { name, description, hp, exp, dropMoney, dropItem } = payload
            axios.put(`http://localhost:7777/vuemonster/${this.monsterNo}`,{ name, description, hp, exp, dropMoney, dropItem })
                    .then(res=>{
                        alert('수정성공!')
                        //louter link to 랑 역할이 똑같음
                        //자바스크립트 내에서 쓸수없기 때문에 여기서씀
                        this.$router.push({
                            name: 'MonsterReadPage',
                            params: { monsterNo: res.data.monsterNo.toString()}
                        })
                    })
                    .catch(err =>{
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchMonster(this.monsterNo)
            .catch(err=>{
                alert(err.response.data.message)
                this.$router.back()
            })
    }


}
</script>