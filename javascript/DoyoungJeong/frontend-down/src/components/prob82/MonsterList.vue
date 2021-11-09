<template>
    <div>
        <ul>
            <h4>Monster Array</h4>
            <moster-element v-for="monsterElem in monsterElements"
                v-bind:key="monsterElem.monsterId"
                v-bind:monsterElem="monsterElem"
                v-bind:editingId="editingId"
                v-on:killMonster="onKillMonster"
                v-on:editName="onEditName"
                v-on:toggleMonsterStatus="onToggleMonsterStatus"
                v-on:setEditingId="SET_EDITTING_ID"
                v-on:resetEditingId="RESET_EDITTING_ID"/>           
        </ul>
        <!-- setEditingId는 TodoItem 컴포넌트에 없던데 어디서 실행이 시작되는건지 모르겠습니다. -->
    </div>    
</template>

<script>
import MonsterElement from './MonsterElement.vue'

import { mapState, mapMutations, mapGetters } from 'vuex'
import { RESET_EDITTING_ID, SET_EDITTING_ID } from '../../store/mutation-types'

export default {
    components: {
        'moster-element': MonsterElement      
    },
    computed: {
        ...mapGetters ([
            'getMonsterElements'
            // state에 있는 filter가 null이 아니면 값이 기록된 todoItems반환??
        ]),
        ...mapState ([
            'editingId'
        ]),
        monsterElements() {
            return this.getMonsterElements
            //맨 위 for배열의 monsterElements 값을 준다. 이름이 같아야함.
        }
    },
    methods: {
        ...mapMutations ([
            SET_EDITTING_ID,
            RESET_EDITTING_ID
        ]),
        onKillMonster(monsterId) {
            this.$emit('killMonster', monsterId)
        },
        onEditName(monsterId, name) {
            this.$emit('editName', monsterId, name)
        },
        onToggleMonsterStatus(monsterId) {
            this.$emit('toggleMonsterStatus', monsterId)
        }
    }
}
</script>

<style>
body {
    text-align: center;
    background-color: #CEDEBD;
}
</style>