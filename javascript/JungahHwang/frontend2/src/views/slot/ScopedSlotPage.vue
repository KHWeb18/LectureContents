<!-- 기존 slot이 p, div 등의 HTML 태그를 전달하고 자녀 컴포넌트에서 부모 컴포넌트를 사용했다면
     scoped는 템플릿을 이용하여 부모 컴포넌트에서 자녀 컴포넌트의 데이터를 전달할 수 있음 -->
<template>
  <div id="app">
    <travel-list>
      <!-- 자식 정보를 부모가 받을 때는 template이 필요함 -->
      <template slot-scope="{ childitems }">
        <p v-for="item in childitems" :key="item">{{ item }}</p>
      </template>
    </travel-list>
    <p>--------------------------------------------------------------------</p>
    <travel-list :items="cities">
      <!-- 전달할 데이터를 items로 설정하고 이 데이터는 computed에 정의된 filteredList의 리턴값을 전달
           이 값은 사용자가 input에 입력하는 데이터와 양방향 바인딩된 inputFilter에 의해 필터링된 값 -->
      <template slot-scope="{ items }">
        <p v-for="item in items" :key="item">{{ item }}</p>
      </template>
    </travel-list>
  </div>
</template>


<script>
import TravelList from '@/components/slot/TravelList'

export default {
  name: 'ScopedSlotPage',
  components: {
    TravelList
  },
  data () {
    return {
      cities: [
        'Paris', 'Seoul', 'Tokyo', 'Seattle', 'Vancouver'
      ]
    }
  }
}
</script>