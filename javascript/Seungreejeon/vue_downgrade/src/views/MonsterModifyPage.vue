<template>
  <div align="center">
      <h2>게시물 수정</h2>
      <monster-modify-form v-if="mosnter" :mosnter="mosnter" @submit="onSubmit" />
      <!-- <board-modify-form v-if="board" :board="board" @submit="onSubmit" /> -->
      <p v-else>로딩중 </p>
  </div>
</template>

<script>
import MonsterModifyForm from '../components/monster/MonsterModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'


export default {
    name: 'MonsterModifyPage',
    components: {
        MonsterModifyForm
    },
    props: {
        mosnterNo: {
            type: String,
            required: true
        }
    },
    methods: {
            ...mapActions(['fetchMonster']),

            onSubmit (payload) {
            const { name, description } = payload
            axios.put(`http://localhost:7777/vueproduct/${this.monsterNo}`, {name, description})
            .then(res => {
                alert('성공')   
                this.$router.push({
                    name: 'MonsterReadPage',
                    params: { mosnterNo: res.data.productNo.toString()}
                })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }

    },
    computed: {
    ...mapState(['mosnter'])
    },
    created () {
        this.fetchMonster(this.mosterNo)
        .catch(err => {
            alert(err.response.data.message)
            this.$router.back()
        })
    }

}
</script>

<style>

</style>