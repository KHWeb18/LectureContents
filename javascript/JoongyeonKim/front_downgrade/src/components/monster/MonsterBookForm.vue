<template>
    <form @submit.prevent="onSubmit">
       <h2>새로운 몬스터 입력</h2>
        <table>
            <tr>
                <td>이름</td>
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
            <button type="submit">새로운 몬스터 생성</button>
            <router-link :to="{ name: 'MonsterBookListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'MonsterBookForm',
    data () {
        return {
            name: '',
            hp: '',
            atk: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, hp, atk } = this
            this.$emit('submit', { name, hp, atk })
        }
    }
}
</script> 