<template>
  <div id="app">
    <child-com>
      <p>안녕</p>
    </child-com>
  </div>
</template>


<script>
import ChildCom from '@/components/slot/Child'

export default {
  name: 'app',
  components: {
    'child-com': ChildCom
  }
}
</script>