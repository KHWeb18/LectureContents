<template>
    <div>
        <h3>상품 게시물 읽기</h3>
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
                <td>제목</td>
                <td><input type="text" :value="product.title" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" :value="product.writer" readonly></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="text" :value="product.price" readonly></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" :value="product.content" readonly></textarea></td>
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
