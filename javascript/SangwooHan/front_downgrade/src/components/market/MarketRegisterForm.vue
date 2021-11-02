<template>
    <form  @submit.prevent="onSubmit">
      
        <table>
              <tr>
            <td>작성자</td>
            <td><input type="text"  v-model="username"/></td>
            </tr>
            <tr>
            <td>상품명</td>
            <td><input type="text"  v-model="name"/></td>
            </tr>
            <tr>
            <td>가격</td>
            <td><input type="text"  v-model="price"/></td>
            </tr>
             <tr>
            <td>상품설명</td>
            <td><textarea cols="15" rows="10" v-model="description"></textarea></td>
            </tr>
        </table>
        <div>
            <button type="subnmit">물품등록</button>
            <router-link :to="{ name: 'Home'}">돌아가기</router-link>
        </div>

    </form>

</template>

<script>
export default {
    name: 'MarketRegisterForm',
    data () {
        return {
            username  : '아이디 입력',
            name  : '비밀번호입력',
            price : '가격입력',
            description  : '상품설명입력'
        }
    },
    methods: {
        onSubmit () {
             const  { username, name , price, description} = this
             this.$emit('submit',{username, name , price, description})
        }
    }
}
</script>