<template>
    <div>
        <h3>게시물 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">상품번호</th>
                <th align="center" width="300">상품명</th>
                <th align="center" width="150">상품가격</th>
                <th align="center" width="450">상품설명</th>
                <th align="center" width="300">등록일자</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="4">
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