<template>
  <div>
    <!-- v-slot="{ items }" == #default="{ items }"-->
    <recent-travel-list v-slot="{ items }" :items="cities">
      <p v-for="item in items" :key="item">{{ item }}</p>
    </recent-travel-list>
  </div>
</template>


<script>
import RecentTravelList from '@/components/slot/RecentTravelList'

export default {
  name: 'RecentSlotPage',
  components: {
    RecentTravelList
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