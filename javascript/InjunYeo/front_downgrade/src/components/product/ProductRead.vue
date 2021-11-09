<template>
    <div>
        <h3>Vue+Spirng 상품 상세</h3>
        <table>
            <tr>
                <td>상품번호</td>
                <td><input type="text" :value="product.productNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="product.regDate" readonly></td>
            </tr>
            <tr>
                <td>상품 이름</td>
                <td><input type="text" :value="product.name" readonly></td>
            </tr>
            <tr>
                <td>상품 가격</td>
                <td><input type="text" :value="product.price" readonly></td>
            </tr>
            <tr>
                <td>제조</td>
                <td><input type="text" :value="product.producer" readonly></td>
            </tr>
            <tr>
                <td>상품 상세</td>
                <td><textarea cols="50" rows="20" :value="product.description" readonly></textarea></td>
            </tr>

        </table>
    </div>
</template>


<script>
export default {
    name: 'ProductRead',
    props: {
        product: {
            type: Object,
            required: true
        }
    }
}
</script>