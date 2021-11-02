<template>
    <form @submit.prevent="onSubmit">
        <h3>상품 등록 하기</h3>
        <table>
            <tr>
                <td>상품 이름</td>
                <td><input type="text" v-model="name"></td>
            </tr>
            <tr>
                <td>상품 가격</td>
                <td><input type="text" v-model="price"></td>
            </tr>
            <tr>
                <td>제조</td>
                <td><input type="text" v-model="producer"></td>
            </tr>
            <tr>
                <td>상품 상세</td>
                <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
            </tr>

        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{name:'ProductListPage'}">
                취소
            </router-link>
        </div>
    </form>

</template>

<script>
export default {
    name: 'ProductRegisterForm',
    data(){
        return {
            name:'제목을 입력하세요',
            price: '',
            producer: '',
            description: '상품 상세 설명'

        }
    },
    methods:{
        onSubmit(){
            const{ name, price, producer,description } = this
            this.$emit('submit', { name, price, producer,description } )
        }
    }
}
</script>