<template>
    <form @submit.prevent="onSubmit">
        <h3>몬스터 도감 등록 형태</h3>
        <table>
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
                <td><input type="number" v-model="dropMoney"></td>
            </tr>
            <tr>
                <td>드랍아이템</td>
                <td><input type="text" v-model="dropItem"></td>
            </tr>
        </table>

        <div>
            <button type="submit">몬스터 등록</button>
            <router-link :to="{ name: 'MonsterListPage'}">
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
            name: '몬스터 이름',
            description: '몬스터 정보',
            hp: 'HP',
            exp: 'EXP',
            dropMoney: '',
            dropItem: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, description, hp, exp, dropMoney, dropItem } = this
            this.$emit('submit', { name, description, hp, exp, dropMoney, dropItem })
        }
    }
}
</script>