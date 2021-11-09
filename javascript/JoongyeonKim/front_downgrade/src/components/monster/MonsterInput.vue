<template>
    <div>
        <h3>몬스터 추가</h3>
        <input type="text" v-model="newMonsterElement" v-on:keypress.enter="addMonster">
        <button v-on:click="addMonster">추가</button>
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
        addMonster () {
            if (this.newMonsterElement !== '') {
                var value = this.newMonsterElement && this.newMonsterElement.trim()
                console.log('addMonster')
                // emit의 역할은 무엇인가 ?
                this.$emit('addMonster', value)
                this.clearInput()
            }
        },
        clearInput () {
            this.newMonsterElement = ''
        }
    }
}
</script>