<template>
    <form @submit.prevent="onSubmit">
        <h3>게시물 작성 형태</h3>
        <table>
            <tr>
                <td>상품명</td>
                <td><input type="text" v-model="name"></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="number" v-model="price"></td>
            </tr>
            <tr>
                <td>상품 설명</td>
                <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
            </tr>
        </table>

        <div>
            <button type="submit">상품 등록</button>
            <router-link :to="{ name: 'ProductListPage' }">
                취소/상품 목록 보기
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'ProductRegisterForm',
    data () {
        return {
            name: '상품명을 작성하세요.',
            price: '',
            description: '본문을 작성하면 됩니다.'
        }
    },
    methods: {
        onSubmit () {
            const { name, price, description } = this
            this.$emit('submit', { name, price, description })
        }
    }
}
</script> 