<template>
  <div>
    <table>
      <tr>
        <td>번호</td>
        <td><input type="text" :value="product.productNo" readonly></td>
      </tr>
      <tr>
        <td>상품</td>
        <td><input type="text" :value="product.title" readonly></td>
      </tr>
      <tr>
        <td>가격</td>
        <td><input type="text" :value="product.price" readonly></td>
      </tr>
      <tr>
        <td>설명</td>
        <td><textarea cols="50" rows="20" :value="product.content" readonly></textarea></td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td><input type="text" :value="product.regDate" readonly></td>
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