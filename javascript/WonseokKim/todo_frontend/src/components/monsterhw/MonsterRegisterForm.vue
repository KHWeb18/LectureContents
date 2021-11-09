<template>
    <form @submit.prevent="onSubmit">
        <h3>몬스터 등록 현황</h3>
        <table>
            <tr>
                <td>몬스터 이름</td>
                <td><input type="text" v-model="monster_name"></td>
            </tr>
            <tr>
                <td>몬스터 HP</td>
                <td><input type="text" v-model="monster_hp"></td>
            </tr>
            <tr>
                <td>몬스터 경험치</td>
                <td><input type="text" v-model="monster_exp"></td>
            </tr>
            <tr>
                <td>몬스터 드랍머니</td>
                <td><input type="text" v-model="monster_money"></td>
            </tr>
            <tr>
                <td>몬스터 설명</td>
                <td><textarea cols="50" rows="20" v-model="monster_description"></textarea></td>
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
            monster_hp: '',
            monster_exp: '',
            monster_money: '',
            monster_description: '본문을 작성하면 됩니다.'
        }
    },
    methods: {
        onSubmit () {
            const { monster_name, monster_hp, monster_exp, monster_money, monster_description } = this
            this.$emit('submit', { monster_name, monster_hp, monster_exp, monster_money, monster_description })
        }
    }
}
</script>