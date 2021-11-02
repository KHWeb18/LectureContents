<template>
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>번호</td>
          <td><input type="text" :value="product.productNo" disabled></td>
        </tr>
        <tr>
          <td>상품</td>
          <td><input type="text" v-model="title"></td>
        </tr>
        <tr>
          <td>가격</td>
          <td><input type="text" v-model="price"></td>
        </tr>
        <tr>
          <td>설명</td>
          <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td><input type="text" :value="product.regDate" disabled></td>
        </tr>
      </table>
      <div>
        <button type="submit">수정 완료</button>
        <router-link :to="{ name: 'ProductReadPage', params: { productNo: product.productNo.toString() }}">
          취소
        </router-link>
      </div>
    </form>
  </div>
</template>


<script>
export default {
  name: 'ProductModify',
  props: {
    product: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      content: '',
      price: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, content, price } = this
      this.$emit('submit', { title, content, price })
    }
  },
  created () {
    this.title = this.product.title
    this.content = this.product.content
    this.price = this.product.price
  }
}
</script>