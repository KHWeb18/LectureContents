<template>
<div>
    <h3>스킬</h3>
    <input type="text" v-on:keypress.enter="firstSkill">
    <button v-on:click="firstSkill">파이어볼</button>
</div>
</template>

<script>
export default {
    data () {
        return {
            atk_coefficient: 3.7
        }
    },
    methods: {
        firstSkill () {
                console.log('firstSkill')

                this.$emit('firstSkill', this.atk_coefficient)
            
        }
    }
}

</script>