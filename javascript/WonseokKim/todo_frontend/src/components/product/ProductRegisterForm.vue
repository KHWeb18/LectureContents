<template> <!-- prevent는 새로고침 방지 -->
    <form @submit.prevent="onSubmit">
        <h3>상품 작성 형태</h3>
        <table>
            <tr>
                <td>제목</td>
                <td><input type="text" v-model="title"></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" v-model="writer"></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="text" v-model="price"></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
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
            title: '제목을 작성하세요.',
            writer: '',
            price:'희망 가격을 적으세요',
            content: '본문을 작성하면 됩니다.'
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content, price } = this
            this.$emit('submit', { title, writer, content, price })
        }
    }
}
</script>