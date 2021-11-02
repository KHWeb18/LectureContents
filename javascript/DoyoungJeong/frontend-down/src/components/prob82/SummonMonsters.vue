<template>
    <div>
        <button v-on:click="summonManyMonster">몬스터 10마리 소환</button>
    </div>
</template>

<script>

export default {
    methods: {
        summonManyMonster() {
            console.log('summonManyMonster')
            this.$emit('summonManyMonster')
        }
    }
}
</script>


