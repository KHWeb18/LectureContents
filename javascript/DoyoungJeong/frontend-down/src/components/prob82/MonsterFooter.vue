<template>
    <div align="center">
        <button v-on:click="removeAll">몬스터 전체 삭제</button>
    </div>
</template>

<script>

export default {
    methods: {
        removeAll() {
            console.log('removeAllMonster')
            this.$emit('removeAllMonster')
        }
    }
}

</script>

<style scoped>

div {
    background-color: #ce3872;
}

</style>
