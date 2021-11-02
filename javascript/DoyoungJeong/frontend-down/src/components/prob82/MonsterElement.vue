<template>
    <div class="todo">
        <li>
            <span v-if="!isEditing" v-on:dblclick="handleDoubleClick">
                {{ monsterElem.name }} HP.{{ monsterElem.hp }}
            </span>
            <input v-else type="text" ref="name"
                    v-bind:value="monsterElem.name"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editName"/>
            <input type="checkBox" :checked="monsterElem.done" v-on:change="toggleMonsterStatus">        
            <button v-on:click="killMonster">몬스터 삭제</button>
            <!-- ref의 뜻? -->
            <!-- blur는 마우스 포커스를 뗐을 때 발동 -->
        </li>
    </div>        
</template>

<script>

export default {
        name: 'MonsterElement',
        props: {
            monsterElem: {
                type: Object
        },
        editingId: {
            type: Number
        }
    },
    computed: {
        isEditing() {
            return this.monsterElem.monsterId === this.editingId
        } //이부분 잘 모르겠다..
    },
    methods: {
        killMonster() {
            const monsterId = this.monsterElem.monsterId
            this.$emit('killMonster', monsterId)
        },
        editName(event) {
            const monsterId = this.monsterElem.monsterId
            const name = event.target.value.trim()

            if(name.length <= 0) {
                return false
            }
            this.$emit('editName', monsterId, name)
            this.$refs.name.blur()
            //위 refs blur()가 무슨뜻?
        },
        handleDoubleClick() {
            const id = this.monsterElem.monsterId
            this.$emit('setEditingId', id)
        },
        handleBlur() {
            this.$emit('resetEditingId')
        },
        toggleMonsterStatus() {
            this.$emit('toggleMonsterStatus', this.monsterElem.monsterId)
        }
    }
}

</script>