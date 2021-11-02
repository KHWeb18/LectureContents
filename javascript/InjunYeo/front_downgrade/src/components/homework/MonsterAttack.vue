<template>
    <div>
        <button v-on:click="firstSkill">파이어볼</button>
    </div>
</template>
<script>
export default {
    data() {
        return {
            atk_coefficient: 3.8
        }

    },
    methods: {
        firstSkill(){
            console.log('firstSkill')
            this.$emit('firsSkill', this.atk_coefficient)


        }
    }
}
</script>