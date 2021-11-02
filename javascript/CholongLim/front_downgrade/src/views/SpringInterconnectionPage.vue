<template>
    <div>
        <h2>Vue + Spring 기반의 삼각형 넓이 구하기</h2>
        밑변: <input type="number" v-model="width">
        높이: <input type="number" v-model="height"><br>
        <button v-on:click="calcTriangleArea">결과 계산</button><br>
        결과: {{ results }}<br>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name: 'SpringInterconnectionPage',
    data () {
        return {
            width: 0,
            height: 0,
            results: 0
        }
    },
    methods: {
        calcTriangleArea () {
            const { width, height } = this
            axios.post('http://localhost:7777/calcTriangle', { width, height })
            // res = result의 약자로 적어놓은것
            .then(res => {
                    alert('계산 완료 = ' + res)
                    this.results = res.data
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}
</script>