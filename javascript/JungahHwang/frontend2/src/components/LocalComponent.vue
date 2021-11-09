<template>
  <!-- v-bind:num 과 맵핑 -->
  <div>{{ num }}</div>
</template>

<script>
export default {
  name: 'LocalComponent',
  props: {
    // property : property type
    num: Number
  }
}
</script>