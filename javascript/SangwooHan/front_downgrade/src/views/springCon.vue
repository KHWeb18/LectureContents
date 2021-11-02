<template>
    <div id="board">
        밑변 <input type="number" v-model="width"/>
        높이 <input type="number" v-model="height"/>
        <button v-on:click="CalcArea">넓이구하기(클릭)</button> 
        <h3>삼각형의 넓이는: {{ results}}  </h3>
    </div>
</template>


<script>

import axios from 'axios'
export default {
    name: 'springCon',
    data(){
        return {
            width: 0,
            height: 0,
            results: 0,
        }
    },
    methods: {
       CalcArea () {
            const { width, height } = this
            axios.post('http://localhost:9999/calcTriangle', { width, height })
                    .then(res => {
                        alert('스프링에서 데이터를 가져오는중... 잠시만기다려주세요 - ' + res)
                        this.results = res.data
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>