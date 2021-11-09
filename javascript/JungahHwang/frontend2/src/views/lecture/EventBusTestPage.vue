<template>
  <div id="eventbus">
    <h2>EventBus Test</h2>
    <products></products>
    <product-detail></product-detail>
  </div>
</template>


<script>
import Products from '@/components/eventbus/Products'
import ProductDetail from '@/components/eventbus/ProductDetail'

export default {
  name: 'EventBustTestPage',
  components: {
    Products,
    ProductDetail 
  }
}
</script>


<style scoped>

ul {
  list-style-type: none;
  background-color: pink;
  color: white;
  padding: 10px;
  font-weight: bold;
}
ul li {
  margin: 5px;
}

</style>