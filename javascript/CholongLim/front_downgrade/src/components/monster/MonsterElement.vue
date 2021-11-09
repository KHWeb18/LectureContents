<template>
    <div class="todo">
        <li>
            <span v-if="!isEditing">
                {{ monster.name }}
            </span>
            <input v-else type="text" ref="name"
                    v-bind:value="monster.name"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editTodo"/>
            <button v-on:click="death">지우기</button>
        </li>
    </div>
</template>

<script>
export default {
    name: 'MonsterElement',
    props: {
        monster: {
            type: Object
        },
        editingId: {
            type: Number
        }
    },
    // VDOM 변화가 없어도 계산값이 적용되도록 서포트함
    computed: {
        isEditing () {
            return this.monster.monsterId === this.editingId
        }
    },
    methods: {
        death () {
            const monsterId = this.monster.monsterId
            this.$emit('death', monsterId)
        },
        editTodo (event) {
            const monsterId = this.monster.monsterId
            const name = event.target.value.trim()
            if (name.length <= 0) {
                return false
            }
            this.$emit('editTodo', name, monsterId)
            this.$refs.name.blur()
        },
        handleBlur () {
            this.$emit('resetEditingId')
        }
    }
}
</script>