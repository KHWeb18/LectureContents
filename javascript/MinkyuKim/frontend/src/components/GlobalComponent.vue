<template>
    <button @click="addCounter">{{ counter }}</button>
</template>

<script>
// props에 배치해야만 컴포넌트간 데이터 전달이 가능함
// export는 외부에 보여지는 기능
export default {
    // 컴포넌트의 이름을 작성한다.
    // 보편적으로 LetsGo라면 lets-go 같은 형태의 이름으로 작성한다. (단어 바뀌는 부분에는 짝대기 주의)
    // 마찬가지로 Java의 명명법 같은 형식이라 생각하면 되겠다.
    // 문법이 관습적으로 명명법을 따르는 것들이 있으므로 되도록 지켜주자!
    name: 'global-component',
    // 컴포넌트간의 데이터 전달을 props가 한다.
    // 여기서는 counter가 initialTest 데이터값을 갖고있음. 한번에 initialTest로 전달받는 것이 아니라 counter로부터 전달받음
    props: ['initialTest'],
    // 템플릿의 경우 엔 컴포넌트를 배치했을 때 자동으로 생성되는 HTML 태그를 의미한다. 아래의 템플릿은 주석처리해도 동작된다.
    // template: '<button @click="addCounter">{{ counter }}</button>',
    data () {
        return {
            counter: this.initialTest           
        }
        
    },
    methods: {
        addCounter () {
            this.counter += 1
        }
    }
}
</script>
