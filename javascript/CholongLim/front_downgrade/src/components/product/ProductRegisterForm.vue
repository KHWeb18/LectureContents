<template>
    <form @submit.prevent="onSubmit">
        <h3>상품 등록 형태</h3>
        <table>
            <tr>
                <td>상품 이름</td>
                <td><input type="text" v-model="title"></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="text" v-model="price"></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" v-model="writer"></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
            </tr>
        </table>

        <div>
            <button type="submit">상품 등록</button>
            <router-link :to="{ name: 'ProductListPage'}">
                상품 목록
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'ProductRegisterForm',
    data () {
        return {
            // return 받는 값들 전체 this
            // 만약 title만 받고싶다면 this.title
            title: '',
            price: '(원)',
            writer: '',
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, price, writer, content } = this
            this.$emit('submit', { title, price, writer, content })
        }
    }
}
</script>