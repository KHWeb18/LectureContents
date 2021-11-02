<template>
    <div>
        <form @submit.prevent="onSubmit">
            <h3>Vue+Spirng 상품수정 수정</h3>
            <table>
                <tr>
                    <!--readonly랑 disabled는 비슷하다-->
                    <td>상품 번호</td>
                    <td><input type="text" :value="product.productNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="product.regDate" disabled></td>
                </tr>
                <tr>
                    <td>상품 이름</td>
                    <td><input type="text" v-model=name></td>
                </tr>
                <tr>
                    <td>상품 가격</td>
                    <td><input type="text" v-model=price></td>
                </tr>
                <tr>
                    <td>제조</td>
                    <td><input type="text" :value="product.producer" disabled></td>
                </tr>
                <tr>
                    <td>상품 상세</td>
                    <td><textarea cols="50" rows="20" v-model=description></textarea></td>
                </tr>

            </table>
            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{name:'ProductReadPage',params: { productNo: product.productNo.toString()}}">
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
    data(){
        return {
            name: '',
            description: '',
            price: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, description, price } = this
            this.$emit('submit', { name, description,price })
        }
    },
    created(){
        this.name = this.product.name
        this.price = this.product.price
        this.description = this.product.description
    }
}
</script>