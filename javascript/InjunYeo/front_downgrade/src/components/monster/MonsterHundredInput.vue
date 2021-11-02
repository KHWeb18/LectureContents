<template>
    <div>
        <h3>랜덤 몬스터 100마리추가</h3>
        <input type="text" v-on:keypress.enter="addManyMonster">
        <button v-on:click="addManyMonster">랜덤 몬스터 100마리 추가</button>
    </div>
</template>

<script>
export default {

    methods: {
        addManyMonster () {
         
            console.log('addManyMonster')
            
            this.$emit('addManyMonster')
             
        }
    }
}
</script>