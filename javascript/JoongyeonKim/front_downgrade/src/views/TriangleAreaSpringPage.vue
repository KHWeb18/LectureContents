<template>
    <div align="center">
        <h2>삼각형 넓이 구하기</h2>
        밑변: <input type="number" v-model="bottomline">
        높이: <input type="number" v-model="height"><br>
        결과: {{results}}<br>
        <button v-on:click='calcTriangle'>결과 확인</button>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name:'TriangleAreaSpringPage',
    data () {
        return {
            bottomline: 0,
            height: 0,
            results: 0
        }
    },
    methods: {
        calcTriangle () {
            const { bottomline, height } = this
            axios.post('http://localhost:7777/triangleArea', { bottomline, height })
                    .then(res => {
                        alert('계산 성공! - ' + res)
                        
                        this.results=res.data
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>

