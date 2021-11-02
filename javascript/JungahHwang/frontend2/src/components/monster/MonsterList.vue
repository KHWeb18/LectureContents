<template>
  <div>
    <ul>
      <h3>Monster</h3>
      <monster-element v-for="monster in monsterElements" v-bind:key="monster.monsterId"
      v-bind:monster="monster" v-bind:editingId="editingId"
      v-on:death="onDeath" v-on:editTodo="onEditTodo"
      v-on:setEditingId="SET_EDITING_ID" v-on:resetEditingId="RESET_EDITING_ID"></monster-element>
    </ul>
  </div>
</template>


<script>
import MonsterElement from './MonsterElement.vue'

import { mapGetters, mapMutations, mapState } from 'vuex'
import { SET_EDITING_ID, RESET_EDITING_ID } from '../../store/mutation-types'

export default {
  components: {
    'monster-element': MonsterElement
  },
  computed: {
    ...mapGetters ([
      'getMonsterElements'
    ]),
    ...mapState ([
      'editingId'
    ]),
    monsterElements () {
      return this.getMonsterElements
    }
  },
  methods: {
    ...mapMutations ([
      SET_EDITING_ID,
      RESET_EDITING_ID
    ]),
    onDeath (monsterId) {
      this.$emit('death', monsterId)
    },
    onEditTodo (content, id) {
      this.$emit('editTodo', content, id)
    }
  }
} 
</script>