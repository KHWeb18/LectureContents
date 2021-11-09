<template>
    <div>
        <h2>스킬 사용</h2>
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
            // emit에서 firskill은 이벤트, this.atk_coefficient는 content(입력)
            // 따라서 firstSkill이라는 이벤트가 발생한다면 content값이 적용된다.
            this.$emit('firstSkill', this.atk_coefficient)
        }
    }
 }

</script>

<style scoped>

div {
    background-color: #77cce3;
}

</style>