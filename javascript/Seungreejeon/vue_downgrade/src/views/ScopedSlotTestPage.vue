<template>
  <div id="app">
      <travel-list>
          <!-- 자식 정보를 부모가 받을땐 어쨋든 template이 필요함 -->
          <template slot-scope="{ childitems }">
              <p v-for="item in childitems" :key="item">
              {{ item }}</p>
          </template>
      </travel-list>
      <p>================경계선===================</p>
      <!-- slot에서 사용하는 v-bind는 자식-> 부모 컴포넌트로 데이터를 전달하는것
      일반 컴포넌트태그에서 v-bind는 import시킨 컴포넌트의 특정 값에 묶는것 -->
      <travel-list :items="cities">
          <template slot-scope="{ items }">
              <p v-for="item in items" :key="item">
              {{ item }}</p>
          </template>
      </travel-list>
  </div>
</template>

<script>
import TravelList from '../components/slot/TravelList.vue'

export default {

    name: 'ScopedSlotTestPage',
    components: {
        TravelList
    },
    data() {
        return {
            cities: [
                'paris', 'tokyo', 'rundon', 'nuwyork', 'seoul'
            ]
        }
    }


}
</script>

<style>

</style>