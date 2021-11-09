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
                <td>체력</td>
                <td><input type="number" v-model="hp"></td>
            </tr>
            <tr>
                <td>공격력</td>
                <td><input type="number" v-model="atk"></td>
            </tr>
        </table>
            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'MonsterBookReadPage', params: { monsterNo: monster.monsterNo.toString() } }" >
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'MonsterBookModifyForm',
    props: {
        monster: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            name: '',
            hp: 0,
            atk: 0
        }
    },
    methods: {
        onSubmit () {
            const { name, hp, atk } = this
            this.$emit('submit', { name, hp, atk })
        }
    },
    created () {
        this.name = this.monster.name
        this.hp = this.monster.hp
        this.atk = this.monster.atk
    }
}

</script>