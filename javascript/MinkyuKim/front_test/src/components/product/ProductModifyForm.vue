<template>
    <div>
        <h3>Product Modify Form</h3>
        <!--prevent를 넣은 이유는 실행순서를 보장해주기 때문에
            여기서 submit을하면 바로 처리를 하러 가는데 prevent가 걸려있으면, submit을 했을 때
            onSubmit으로 걸려서 views/productModifyPage.vue로 넘어가 submit이 작동하게 됨.
            즉, 여기(하위컴포넌트)에서 submit 하는것을 막고 상위컴포넌트에서 실행되게 한다. -->
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
                    <td>상품명</td>
                    <td><input type="text" v-model="product_name"></td>
                </tr>
                <tr>
                    <td>판매자</td>
                    <td><input type="text" :value="product.producer" disabled></td>
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
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'ProductReadPage',params: { productNo: product.productNo.toString() } }">
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
            description: '',
            price: 0
        }
    },
    methods: {
        onSubmit () {
            const { product_name, description, price } = this
            this.$emit('submit', { product_name, description, price })
        }
    },
    created () {
        this.product_name = this.product.product_name        
        this.description = this.product.description
        this.price = this.product.price
    }
}
</script>