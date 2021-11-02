<template>
  <div id="app">
    <p>나도 되냐?</p>
    <child-com>
      <p>에펠탑 갈까 ?</p>
      <p>되겠냐?</p>
    </child-com> 
    <!-- 차일드 내부에서 컴포넌트를 감싼걸 가져옴 -->
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