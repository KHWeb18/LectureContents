<template>
    <v-container>
        <table border="1">
            <tr v-for="(board, idx) in boards" v-bind:key="idx">
                <td align="center">
                    <img :src="require(`@/assets/img/${board.img}`)">
                </td>
            </tr>
        </table>
        <button v-on:click="getKakaoAuth">카카오 인증</button>
        <form @submit.prevent="onSubmit">
            <h3>구매 양식</h3>
            <table>
                <tr>
                    <td>구매자 성함</td>
                    <td><input type="text" v-model="name"></td>
                </tr>
                <tr>
                    <td>구매 가격</td>
                    <td><input type="number" v-model="cost" readonly></td>
                </tr>
            </table>

            <div>
                <button type="submit">구매</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>

<script>

import axios from 'axios'

export default {
    name: 'OrderTestPage',
    data () {
        return {
            info: 'Spyder.jpg',
            boards: [
                {
                    img: 'Spyder.jpg'
                }
            ],
            name: '',
            cost: 1000000000
            // imgPath: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, cost } = this
            console.log('name: ' + name + ', cost = ' + cost)
            axios.post('http://localhost:7777/ordertest/order', { name, cost })
                    .then(() => {
                        alert('주문 성공!')
                    })
        },
        getKakaoAuth () {
            axios.get('http://localhost:7777/ordertest/getKakaoAuth')
                    .then(() => {
                        alert('인증 진행!')
                        // this.$router.push({ name: 'KakaoAuthPage', query: { htmlcode: res.data } })
                    })
        }
    }
}

</script>