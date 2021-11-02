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
                    <td>등록일자</td>
                    <td><input type="text" :value="monster.regDate" disabled></td>
                </tr>
                <tr>
                    <td>몬스터이름</td>
                    <td><input type="text" v-model="name"></td>
                </tr>
                <tr>
                    <td>몬스터정보</td>
                    <td><textarea cols="50" rows="10" v-model="description"></textarea></td>
                </tr>
                <tr>
                    <td>hp</td>
                    <td><input type="number" v-model="hp"></td>
                </tr>
                <tr>
                    <td>경험치</td>
                    <td><input type="number" v-model="exp"></td>
                </tr>
                <tr>
                    <td>드랍머니</td>
                    <td><input type="text" v-model="dropMoney"></td>
                </tr>
                <tr>
                    <td>드랍아이템</td>
                    <td><input type="text" v-model="dropItem"></td>
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
            name: '',
            description: '',
            hp: 0,
            exp: 0,
            dropMoney: 0,
            dropItem: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, description, hp, exp, dropMoney, dropItem  } = this
            this.$emit('submit', { name, description, hp, exp, dropMoney, dropItem })
        }
    },
    created () {
        this.name = this.monster.name
        this.description = this.monster.description
        this.hp = this.monster.hp
        this.exp = this.monster.exp
        this.dropMoney = this.monster.dropMoney
        this.dropItem = this.monster.dropItem
    }
}
</script>