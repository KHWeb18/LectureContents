<template>
    <button @click="addManyMonster">{{ addMonster }}</button>
</template>


<script>
export default {
    name: 'monster-btn',
    props: ['addmonsterBtn',],
    data () {
        return {
            counter: this.addmonsterBtn
        }
    },
    methods: {
        addManyMonster () {
            this.counter += 1
        }
    }
}
</script>