<template>
    <div id="app">
        <!-- <recent-slot-travel-list #default="{ items }" :items="cities"> -->
            <!--v-slot은 template을 안써도 된다-->
        <recent-slot-travel-list v-slot="{ items }" :items="cities">
            <p v-for="item in items" :key="item">
                {{ item }}
            </p>
        </recent-slot-travel-list>
    </div>
</template>

<script>
import RecentSlotTravelList from '@/components/slot/RecentSlotTravelList.vue'
export default {
    name: 'RecentSlotTestPage',
    components: {
        RecentSlotTravelList
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