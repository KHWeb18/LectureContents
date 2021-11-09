<template>
    <form @submit.prevent="onSubmit">
        <h3>몬스터북 작성 형태</h3>
        <table>
            <tr>
                <td>몬스터명</td>
                <td><input type="text" v-model="monster_name"></td>
            </tr>
            
            <tr>
                <td>체력</td>
                <td><input type="number" v-model="monster_hp"></td>
            </tr>
            
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'MonsterListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'MonsterRegisterForm',
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
    }
}
</script>