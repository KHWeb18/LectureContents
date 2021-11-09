<template>
    <button @click="addCounter"> {{counter}} </button>
</template> 

<script>

//props: 에 배치해야만 컴포넌트간 데이터 전달이 가능함
export default {
    //컴포넌트 이름을 작성한다
    //보편적으로 LetsGo 라면 lets-go 같은 형태의 이름으로 작성한다
    //마찬가지로 Java의 명명법 같은 형식이라 생각하면 되겠다.
    //문법이 관습적인 명명법을 따르는 것들이 있으므로 되도록 지켜주자!

    name:'global-component',
    props:['initialTest'],
    //템플릿의 경우엔 컴포넌트를 배치했을때 자동으로 생성되는 HTML태그를 의미한다.
    template:'<button @click="addCounter"> {{counter}} </button>',

    data(){
        return {
            counter : this.initialTest
        }
    },

    methods:{
        addCounter(){
            this.counter +=1
        }
    }
}
</script>