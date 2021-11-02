<template>
    <button @click="addCounter">{{ counter }}</button>
</template>

<script>
//props에 배치해야만 컴포넌트간 데이터 전달이 가능함
export default {
    //컴포넌트의 이름을 작성ㅎ나다
    //보편적으로 LetsGo라면 Lets-go 같은 형태의 이름으로 작성한다
    //마찬가지로 java의 명명법 같은 형식이라 생각하면된다
    //문법이 관습적인 명명법을 따르는 것들이 있으므로 되도록 지켜주자
    name: 'global-component',
    props: ['initialTest'],
    template: '<button @click="addCounter">{{ counter }}</button>',
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
