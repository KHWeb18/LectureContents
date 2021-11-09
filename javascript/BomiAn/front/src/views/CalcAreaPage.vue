<template>
  <div>
    <calc-area></calc-area>
    <calc-area-with-spring/>
  </div>
</template>

<script>
import CalcArea from '../components/calcarea/CalcArea.vue'
export default {
  name: 'CalcAreaPage',
  components: {
    CalcArea
  } 
}
</script>