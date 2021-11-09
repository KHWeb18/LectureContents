
<template>
    <form @submit.prevent="onSubmit">
        <h3>몬스터를 등록하세요!</h3>
        <table>
            <tr>
                <td>몬스터 이름</td>
                <td><input type="text" v-model="name"></td>
            </tr>
            <tr>
                <td>체력</td>
                <td><input type="number" v-model="hp"></td>
            </tr>
            <tr>
                <td>atk</td>
                <td><input type="number" v-model="atk"></td>
            </tr>
        </table>

        <div>
            <button type="submit">상품등록</button>
            <router-link :to="{ name: 'MonsterBookListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'MonsterBookRegisterForm',
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
            this.$emit('submit', {  name, hp, atk  })
        }
    }
}
</script> 
