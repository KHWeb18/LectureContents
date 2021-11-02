<template>
    <div>
        <h3>Product Modified Form</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>글번호</td>
                    <td><input type="text" :value="product.productNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="product.regDate" disabled></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" v-model="product_name"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" :value="product.producer" disabled></td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
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
            product_name: '',
            description: ''
        }
    },
    methods: {
        onSubmit () {
            const { product_name, description } = this
            this.$emit('submit', { product_name, description })
        }
    },
    created () {
        this.product_name = this.product.product_name
        this.description = this.product.description
    }
}
</script>