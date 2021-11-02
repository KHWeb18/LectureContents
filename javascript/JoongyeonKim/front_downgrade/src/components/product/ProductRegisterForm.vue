
<template>
    <form @submit.prevent="onSubmit">
        <h3>상품을 등록하세요!</h3>
        <table>
            <tr>
                <td>상품이름</td>
                <td><input type="text" v-model="name"></td>
            </tr>
            <tr>
                <td>판매자</td>
                <td><input type="text" v-model="writer"></td>
            </tr>
            <tr>
                <td>금액</td>
                <td><input type="number" v-model="price"></td>
            </tr>
            <tr>
                <td>상품내용</td>
                <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
            </tr>
        </table>

        <div>
            <button type="submit">상품등록</button>
            <router-link :to="{ name: 'ProductListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'ProductRegisterForm',
    data () {
        return {
            name: '',
            writer: '',
            price: '',
            description: ''
        }
    },
    methods: {
        onSubmit () {
            const {  name, price, writer, description } = this
            this.$emit('submit', {  name, price, writer, description })
        }
    }
}
</script> 
