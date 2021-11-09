<template>
    <div>
        <h3>몬스터추가</h3>
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
                //emit은 자신을 감싼 컴포넌트에게 값을 전달
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