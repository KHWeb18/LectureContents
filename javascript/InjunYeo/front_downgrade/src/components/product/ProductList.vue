<template>
    <div>
        <h2>상품 목록</h2>

        <table border="1">
            <tr>
                <th align="center" width="80">번호</th>
                <th align="center" width="640">상품이름</th>
                <th align="center" width="120">가격</th>
                <th align="center" width="120">제조</th>
                <th align="center" width="200">등록일자</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productNo">
                <td align="center">{{ product.productNo }}</td>
                <td align="left">            
                    <router-link :to="{name: 'ProductReadPage',
                                        params: { productNo: product.productNo.toString()} } ">
                        {{product.name}}
                    </router-link>
                </td>        
                <td align="right">{{product.price}}</td>
                <td align="center">{{product.producer}}</td>
                <td align="center">{{product.regDate}}</td>
            </tr>

        </table>
    </div>
</template>

<script>
export default {
    name: 'ProductList',
    props:{
        products: {
            type: Array
        }
    }
}
</script>