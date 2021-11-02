<template>
  <div id="app">
      <!-- <recent-slot-travel-list v-slot="{ items }" :items="cities"> -->
      <recent-slot-travel-list #default="{ items }" :items="cities">
          <p v-for="item in items" :key="item">
              {{item}}
          </p>
          <!-- template 안쓰는 장점 -->
      </recent-slot-travel-list>

  </div>
</template>

<script>
import RecentSlotTravelList from '../components/slot/RecentSlotTravelList';
export default {
    name: 'RecentSlotTravelListPage',
    components: {
        RecentSlotTravelList
    },
    data() {
        return {
            cities: [
                'paris','seoul','newyork','sealttle','vancouver'
            ]
        }
    }

}
</script>

<style>

</style>