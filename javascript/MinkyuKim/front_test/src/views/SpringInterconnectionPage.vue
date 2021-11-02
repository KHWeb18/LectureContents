<template>
    <div>
    <h2>Vue + Spring 기반의 삼각형 넓이 구하기</h2>
    밑변: <input type="number" v-model="width">
    높이: <input type="number" v-model="height"><br>
    결과: {{ results }} <button v-on:click="determinantMean">결과 계산</button>
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
        calcTriangleArea() {
            //alert('클릭 체크')
            const { width, height } = this
            axios.post('http://localhost:7777/calcTriangle', {width, height} )
                    .then(res => {
                        alert('계산 완료! - ' + res)
                        this.results = res.data
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script> 