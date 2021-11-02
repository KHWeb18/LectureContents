<template>
    <div>
        <h3>Board Modified Form</h3>
        <form @submit.prevent="onSubmit">
            <table border="1">
            <tr>
                <td>몬스터번호</td>
                <td><input type="text" :value="monster.monsterNo" disabled></td>
            </tr>
            <tr>
                <td>몬스터명</td>
                <td><input type="text" :value="monster.name" disabled></td>
            </tr>
            <tr>
                <td>체력</td>
                <td><input type="text" :value="monster.hp" disabled></td>
            </tr>
            <tr>
                <td>경험치</td>
                <td><input type="text" v-model="exp" ></td>
            </tr>
            <tr>
                <td>드랍머니</td>
                <td><input type="text" v-model="dropMoney" ></td>
            </tr>
            <tr>
                <td>드랍아이템</td>
                <td><input type="text" v-model="dropItem" ></td>
            </tr>
            <tr>
                <td>몬스터설명</td>
                <td><textarea cols="50" rows="20" :value="monster.description" disabled></textarea></td>
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
            exp: '0',
            dropItem: '',
            dropMoney:'0'
        }
    },
    methods: {
        onSubmit () {
            const {exp,dropItem,dropMoney } = this
            this.$emit('submit', { exp,dropItem,dropMoney })
        }
    },
    created () {
        this.exp = this.monster.exp
        this.dropItem = this.monster.dropItem
        this.dropMoney = this.monster.dropMoney
    }
}
</script>

<style scoped>
    table {
        border: 2px solid #f12e2e;
  }
</style>