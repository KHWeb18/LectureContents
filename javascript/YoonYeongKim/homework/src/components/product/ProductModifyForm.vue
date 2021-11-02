<template>
    <div>
        <h3>Product Modified Form</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>상품번호</td>
                    <td><input type="text" :value="product.productNo" disabled></td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td><input type="text" v-model="name"></td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td><input type="number" v-model="price"></td>
                </tr>
                <tr>
                    <td>상품설명</td>
                    <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="product.regDate" disabled></td>
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
            name: '',
            price: 0,
            description: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, price, description } = this
            this.$emit('submit', { name, price, description })
        }
    },
    created () {
        this.name = this.product.name
        this.price = this.product.price
        this.description = this.product.description       
    }
}
</script> 