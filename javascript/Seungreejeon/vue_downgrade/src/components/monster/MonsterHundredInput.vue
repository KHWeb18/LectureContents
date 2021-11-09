<template>
    <div>
        <h3>몬스터 100마리 추가</h3>
        <input type="text" v-on:keypress.enter="addmanyMonster">
        <button v-on:click="addmanyMonster">랜덤 100마리 추가</button>
    </div>
</template>

<script>
export default {

    data () {
        return {
            newMonsterElement: ''
        }
    },
    methods: {
        addmanyMonster () {
            console.log('addManyMonster')
            this.$emit('addManyMonster')            
        }
    }
}
</script>