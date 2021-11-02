<template>
    <div>
        <h3>Product Modified Form</h3>
        <form @submit.prevent="onSubmit">
           <table>
            <tr>
                <td>상품번호</td>
                <td><input type="text" v-model="monster.monsterNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="monster.regDate" readonly></td>
            </tr>
            <tr>
                <td>상품명</td>
                <td><input type="text" v-model="name" readonly></td>
            </tr>
            <tr>
                <td>HP</td>
                <td><input type="number" v-model="hp" readonly></td>
            </tr>
            <tr>
                <td>경험치</td>
                <td><input type="number" v-model="exp" readonly></td>
            </tr>
            <tr>
                <td>드랍머니</td>
                <td><input type="number" v-model="dropMoney" readonly></td>
            </tr>
            <tr>
                <td>드랍아이템</td>
                <td><input type="text" v-model="dropItem" readonly></td>
            </tr>
            <tr>
                <td>몬스터 설명</td>
                <td><textarea cols="50" rows="20" v-model="description" readonly></textarea></td>
            </tr>
        </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'MonsterReadPage', params: { mosnterNo: monster.mosnterNO.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'MonsterModifyFrom',
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
            exp: 0,
            dropMoney: 0,
            dropItem: '',
            description: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, hp, exp, dropMoney, dropItem, description, } = this
            this.$emit('submit', { name, hp, exp, dropMoney, dropItem, description })
        }
    },
    created () {
        this.name = this.monster.name
        this.description = this.monster.description
        this.exp = this.monster.exp
        this.dropMoney = this.monster.dropMoney
        this.dropItem = this.monster.dropItem
        this.description = this.monster.description
    }
}
</script>