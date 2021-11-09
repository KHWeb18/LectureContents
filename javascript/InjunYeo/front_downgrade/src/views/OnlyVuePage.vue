<template>
    <div>
        <h2>OnlyVue 삼각형 넓이 구하기</h2>
        <input type="number" v-model="width">밑변<br>
        <input type="number" v-model="height">높이<br>
        <input type="number" :results=results readonly>
        <!--결과: {{ results }}-->
        <!--:(바인드를 안쓴이유는?)
            굳이 바인드를 써서 결과를 출력할 이유가 없기때문 바인드 사용가능
        -->

    </div>
</template>

<script>


export default {
    
    name: 'OnlyVuePage',
    data (){
        return{
            width:0,
            height:0,
        }
        

    },
    computed:{
        //results: this.width * this.height / 2.0
        results(){
            return this.width * this.height / 2.0;
        }
    },


}
</script>