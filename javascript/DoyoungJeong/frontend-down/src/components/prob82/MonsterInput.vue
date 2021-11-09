<template>
    <div>
        <h3>몬스터 추가</h3>
        <input type="text" v-model="newMonsterElem" v-on:keypress.enter="addMonsterElem">
        <button v-on:click="addMonsterElem">추가</button>
    </div>
</template>

<script>

export default {
    data() {
        return {
            newMonsterElem: ''
        }
    },
    methods: {
        addMonsterElem() {
            if(this.newMonsterElem !== '') {
                var value = this.newMonsterElem && this.newMonsterElem.trim()
                console.log('addMonsterElem')

                this.$emit('addMonster', value)
                //emit은 자기를 둘러싼 컴포넌트에게 정보를 전달한다.
                //emit을 감싼 컴포넌트는 todoInput이다. 그리고 todoInput컴포넌트가있는 Todo.vue에 정보가 전달된다.
                this.clearInput()
            }
        },
        clearInput() {
            this.newMonsterElem = ''
        }
    }
}
</script>