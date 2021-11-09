<template>
  <form @submit.prevent="onSubmit">
    <table>
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
    </table>
    <div>
      <button type="submit">등록</button>
      <router-link :to="{ name: 'ProductListPage' }">
        목록보기
      </router-link>
    </div>
  </form>
</template>


<script>
export default {
  name: 'ProductRegister',
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
  }
}
</script>