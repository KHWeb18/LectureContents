<template>
    <div>
        <h3>Product Modified Form</h3>
        <!-- prevent 실행하는 순서를 바꿈 , 바로 처리하는 것이 아니라
             productModifyPage의 onSubmit쪽으로 내려감-->
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>상품 번호</td>
                    <td><input type="text" :value="product.productNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="product.regDate" disabled></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" v-model="title"></td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td><input type="text" v-model="price"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" :value="product.writer" disabled></td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'ProductReadPage', params: { productNo: product.productNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'ProductModifyForm',
    props: {
        product: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            price: '',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, price, content } = this
            this.$emit('submit', { title, price, content })
        }
    },
    created () {
        this.title = this.product.title
        this.price = this.product.price
        this.content = this.product.content
    }
}
</script>