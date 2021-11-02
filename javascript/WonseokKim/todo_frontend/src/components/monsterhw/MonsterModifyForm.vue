<template>
    <div>
        <h3>Monster Modified Form</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>글번호</td>
                    <td><input type="text" :value="monster.monsterNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="monster.regDate" disabled></td>
                </tr>
                <tr>
                    <td>몬스터 이름</td>
                    <td><input type="text" v-model="monster_name"></td>
                </tr>
                <tr>
                    <td>몬스터 HP</td>
                    <td><input type="text" v-model="monster_hp"></td>
                </tr>
                <tr>
                    <td>몬스터 EXP</td>
                    <td><input type="text" v-model="monster_exp"></td>
                </tr>
                <tr>
                    <td>몬스터 드랍머니</td>
                    <td><input type="text" v-model="monster_money"></td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td><textarea cols="50" rows="20" v-model="monster_description"></textarea></td>
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
            monster_hp: '',
            monster_exp: '',
            monster_money: '',
            monster_description: ''

        }
    },
    methods: {
        onSubmit () {
            const { monster_name, monster_hp, monster_exp, monster_money, monster_description } = this
            this.$emit('submit', { monster_name, monster_hp, monster_exp, monster_money, monster_description })
        }
    },
    created () {
        this.monster_name = this.monster.monster_name
        this.monster_hp = this.monster.monster_hp
        this.monster_exp = this.monster.monster_exp
        this.monster_money = this.monster.monster_money
        this.monster_description = this.monster.monster_description
    }
}
</script>
