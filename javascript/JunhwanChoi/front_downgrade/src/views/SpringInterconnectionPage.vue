<template>
    <div id="board">
        <h2>vue + spring 기반의 삼격형 넓이 구하기</h2>
        밑변: <input type="number" v-model="width"><br>
        높이: <input type="number" v-model="height"><br>
        결과: {{results}}<button v-on:click="calcTriangleArea">결과 계산</button>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'SpringInterconnectionPage',
  
    data(){
        return{
            width:0,
            height:0,
            results:0
        }
    },
  
    methods: {
        calcTriangleArea(){
            //alert('클릭체크')
            const { width, height  } = this
            axios.post('http://localhost:7777/calcTriangle', { width, height  })
                .then(res=>{
                    alert('계산완료')

                    this.results=res.data
                })
                .catch(res=>{
                    alert(res.respose.data.message)
                })
        }
    }
}
</script>