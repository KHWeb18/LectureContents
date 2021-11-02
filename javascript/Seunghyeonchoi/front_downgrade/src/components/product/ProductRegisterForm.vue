<template>
    <form @submit.prevent="onSubmit">
        <h3>게시물 작성 형태</h3>
        <table>
            <tr>
                <td>상품명</td>
                <td><input type="text" v-model="product_name"></td>
            </tr>
            <tr>
                <td>판매자</td>
                <td><input type="text" v-model="producer"></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="number" v-model="price"></td>
            </tr>
            <tr>
                <td>상품 세부사항</td>
                <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
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
            product_name: '',
            producer: '',
            description: '',
            price: ''
        }
    },
    methods: {
        onSubmit () {
            const { product_name, producer, description, price } = this
            this.$emit('submit', { product_name, producer, description, price })
        }
    }
}
</script> 