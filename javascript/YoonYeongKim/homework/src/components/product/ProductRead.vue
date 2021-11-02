<template>
    <div>
        <h3>Vue + Spring 상품 읽기</h3>
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
                <td>상품명</td>
                <td><input type="text" :value="product.name" readonly></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="number" :value="product.price" readonly></td>
            </tr>
            <tr>
                <td>상품 설명</td>
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