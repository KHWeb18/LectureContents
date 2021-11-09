<template>
    <form @submit.prevent="onSubmit">
        <h3>삼각형 넓이 구하기</h3>
        <table style="margin: 0 auto">
            <tr>
                <td>밑변</td>
                <td ><input type="text" v-model="base" style="text-align: center"></td>
            </tr>
            <tr>
                <td>높이</td>
                <td><input type="text" v-model="height" style="text-align: center"></td>
            </tr>
             <tr>
                <td>넓이</td>
                <td>{{ this.area }}</td>
            </tr>
            
        </table>
        <button type="onSubmit">값 구하기</button>
        <div>
            <router-link :to="{ name: 'Home' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'TriangleAreaForm',
    data () {
        return {
            base: '',
            height: '',
            area: ''
        }
    },
    methods: {
        onSubmit () {
            this.area = this.base * this.height / 2.0
            alert('값구하기 완료!')
        }
    }
}
</script>