<template>
    <div>
        <h3>Monster Modified Form</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>몬스터번호</td>
                    <td><input type="text" :value="monster.monsterNo" disabled></td>
                </tr>
                <tr>
                    <td>몬스터명</td>
                    <td><input type="text" v-model="monster_name"></td>
                </tr>
                <tr>
                    <td>체력</td>
                    <td><input type="Number" v-model="monster_hp"></td>
                </tr>
               
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'MonsterReadPage', params: { monsterNo: monster.monsterNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'MonsterModifyForm',
    props: {
        monster: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            monster_name: '',
            monster_hp: ''
        }
    },
    methods: {
        onSubmit () {
            const { monster_name, monster_hp } = this
            this.$emit('submit', { monster_name, monster_hp  })
        }
    },
    created () {
        this.monster_name = this.monster.monster_name
        this.monster_hp = this.monster.monster_hp
        
        
    }
}
</script>