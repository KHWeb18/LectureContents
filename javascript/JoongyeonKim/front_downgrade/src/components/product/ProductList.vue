<template>
    <div align="center">
        <h3>상품목록 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="350">상품이름</th>
                <th align="center" width="350">판매자</th>
                <th align="center" width="240">금액</th>
                <th align="center" width="640">상품내용</th>
                <th align="center" width="440">날짜</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="5">
                현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productNo">
                <td align="center">{{ product.productNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'ProductReadPage',
                                    params: { productNo: product.productNo.toString() } }">
                        {{ product.name }}
                    </router-link> 
                </td>
                <td align="right">{{ product.writer }}</td>
                <td align="right">{{ product.price }}</td>
                <td align="right">{{ product.description }}</td>
                <td align="center">{{ product.regDate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'ProductList',
    props: {
        products: {
            type: Array
        }
    }
}
</script>