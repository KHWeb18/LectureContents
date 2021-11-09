<template>
  <div>
    <p>
      <input v-model="inputFilter"/>
    </p>
    <!-- 자식에서 부모로 데이터 전달 -->
    <slot :childitems="childitems"/>
    <!-- 부모에서 자식으로 데이터 전달 --->
    <slot :items="filteredList"/>
  </div>
</template>


<script>
export default {
  props: ['items'],
  data () {
    return {
      inputFilter: "",
      childitems: ['one', 'two', 'three']
    }
  },
  computed: {
    filteredList () {
      if (this.items) {
        // 자바스크립트는 filter를 사용할 때 배열의 요소 하나하나를 순회하도록 자동화 처리 수행
        return this.items.filter(item => item.includes(this.inputFilter))
        // 글자수로 필터하기
        // this.items.filter(item => item.length > 5)
      }
      return null;
    }
  }
}  
</script>