<template>
    <form @submit.prevent="onSubmit">
        <h3>삼각형 정보 입력</h3>
        <table>
            <tr>
                <td>밑변</td>
                <td><input type="number" v-model="width"></td>
            </tr>  
            <tr>
                <td>높이</td>
                <td><input type="number" v-model="height"></td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
           
            <router-link :to="{ name: 'Home' }">
                돌아가기
            </router-link>
        </div>
    </form>
</template>

<script>

export default {
    name: 'Quiz89RegisterForm',
    data () {
        return {
            width: '',
            height: '',
            area: ''
        }
    },
    props: {
        
    },
    methods: {
        onSubmit () {
            const { width, height, area } = this
            this.$emit('submit', { width, height, area })
            this.area = this.height * this.width / 2

        }
    }
}
</script> 