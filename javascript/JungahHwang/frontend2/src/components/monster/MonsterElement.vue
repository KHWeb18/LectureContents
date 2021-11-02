<template>
  <div class="monster">
    <li>
      <span v-if="!isEditing">
        {{ monster.name }}
      </span>
      <!-- blur: 입력창의 포커싱 제거 -->
      <input v-else type="text" ref="name" v-bind:value="monster.name"
        v-on:blur="handleBlur" v-on:keydown.enter="editTodo">
      <button v-on:click="death">remove</button>
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
  computed: {
    isEditing () {
      return this.monster.id === this.editingId
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
