<template>
    <div align="center">
        <h1>Triangle Area Calculator</h1>

        <!-- <form @submit="onSubmit"> -->
            <div class="inputBox">
                <h5>Enter the width</h5>
                <input type="text" v-model="width">
                <br>
                <h5>Enter the height</h5>
                <input type="text" v-model="height">
            </div>
            <div class="subButton">
                <button v-on:click="onSubmit">Calculate!</button>
            </div>
        <!-- </form> -->
        <!-- form을 썼더니 페이지 자체가 새로고침됨 -->

        <div>
          <h4 v-if="area == 0"></h4>
          <h4 v-else>The Calculated Area is {{ area }}</h4>
        </div>

        <h3 style="margin-top: 20px">Triangle Area Calculator by Spring</h3>
        <div class="inputBox">    
            <h5>Enter the width</h5>
            <input type="text" v-model="widthSpring">
            <br>
            <h5>Enter the height</h5>
            <input type="text" v-model="heightSpring">
        </div>

        <div class="subButton">
            <button v-on:click="onSubmitSpring">Calculate!</button>
        </div>

        <div>
          <h4 v-if="areaSpring == 0"></h4>
          <h4 v-else>The Calculated Area is {{ areaSpring }}</h4>
        </div>
            <!-- <triangle-spring v-on:submitSpring="onSubmitSpring"/> -->
        
    </div>
</template>

<script>

import axios from 'axios'
//import TriangleSpring from '@/components/prob89/TriangleSpring.vue'

export default {
    name: 'TriangleAreaCalc',
    // components: {
    //     'triangle-spring': TriangleSpring
    // },
    data() {
        return {
            width: 0,
            height: 0,
            area: 0,
            widthSpring: 0,
            heightSpring: 0,
            areaSpring: 0
        }
    },
    methods: {
        onSubmit() {
            if(this.width < 0 || isNaN(this.width) || this.height < 0 || isNaN(this.height)) {
                alert("Please Enter legitimate Number!")
                // isNaN 결과 : 문자 포함 시 true / 숫자로만 이루어져 있을 경우 false
                // isNaN은 위처럼 쓰는 거였다
                //??안되네
            }
            
            var tmpArea = (this.width * this.height) / 2
            this.area = tmpArea

            this.width = 0
            this.height = 0
        },
        onSubmitSpring() {
            var  widthSpring = this.widthSpring
            var heightSpring = this.heightSpring
            //const { widthSpring, heightSpring } = payload

            console.log({ widthSpring }, { heightSpring })

            axios.post('http://localhost:7777/triangleArea', { widthSpring, heightSpring })
            .then(res => {
                alert('value sent '+ JSON.stringify(res.data))
                this.areaSpring = res.data
            })
            .catch(res => {
                alert('upload failed ' + res.response.data.message)
            })
        }
    }
}
</script>

<style>

.inputBox {
    margin-top: 20px;
}

.subButton {
    margin-top: 10px;
}

.springBox {
    margin-top: 50px;
}

</style>
