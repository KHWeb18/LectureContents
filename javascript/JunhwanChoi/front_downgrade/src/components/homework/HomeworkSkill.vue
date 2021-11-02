<template>
    <div>
        <h3>스킬 사용</h3>
        
        <button v-on:click="firstSkill">파이어볼</button>

    </div>
</template>

<script>
export default {
    data () {
        return {
           
        }
    },
    methods: {
        firstSkill () {
            console.log('firstSkill')
            this.$emit('firstSkill', this.atk_coefficient) // 1.(이벤트이름, 입력)
        }
    }
}
</script>