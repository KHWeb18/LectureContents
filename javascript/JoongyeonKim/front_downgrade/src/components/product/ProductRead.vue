<template>
    <div align="center">
        <h3>Vue + Spring 상품내용 읽기</h3>
        <table>
            <tr>
                <td>글번호</td>
                <td><input type="text" :value="product.productNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="product.regDate" readonly></td>
            </tr>
            <tr>
                <td>상품이름</td>
                <td><input type="text" :value="product.name" readonly></td>
            </tr>
            <tr>
                <td>금액</td>
                <td><input type="number" :value="product.price" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" :value="product.writer" readonly></td>
            </tr>
            <tr>
                <td>상품내용</td>
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