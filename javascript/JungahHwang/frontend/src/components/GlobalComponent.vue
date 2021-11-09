<template>
  <button @click="addCounter">{{ counter }}</button>
</template>

<script>
export default {
  // name: 컴포넌트의 이름 작성
  //       보통 globalComponent라면 global-component라고 작성함
  name: 'global-component',
  // props: 컴포넌트 간 데이터 전달이 가능함
  props: ['initialTest'],
  // template: 컴포넌트를 배치했을 때 자동으로 생성되는 HTML 태그를 의미
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