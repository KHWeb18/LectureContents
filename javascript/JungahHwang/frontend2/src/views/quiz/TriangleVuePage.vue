<template>
  <div>
    <h2>삼각형 넓이 구하기</h2>
    <triangle-vue @submit="onSubmit"></triangle-vue>
    <p>삼각형의 넓이는 {{ this.area }}입니다.</p>
  </div>
</template>


<script>
import TriangleVue from '@/components/quiz/TriangleVue'

export default {
  name: 'TriangleVuePage',
  components: {
    TriangleVue
  },
  data () {
    return {
      area: null
    }
  },
  methods: {
    onSubmit (payload) {
      this.area = payload
    }
  }
}
</script>