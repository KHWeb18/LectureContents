<template>
    <div id="app">
        <recent-slot-travel-list v-slot="{ items }" v-bind:items="cities">
            <!-- 위처럼 template안쓰고 한줄로 작성 가능 -->
            <p v-for="item in items" :key="item">
                {{ item }}
            </p>
        </recent-slot-travel-list>
        <p>-------------------------Half Line---------------------------</p>
        <recent-slot-travel-list v-slot="{ childitems }">
            <!-- 위처럼 template안쓰고 한줄로 작성 가능 -->
            <p v-for="childitem in childitems" :key="childitem">
                {{ childitem }}
            </p>
        </recent-slot-travel-list>

    </div>
    
</template>

<script>

import RecentSlotTravelList from '@/components/slot/RecentSlotTravelList'

export default {
    name: 'RecentSlotTestPage',
    components: {
        RecentSlotTravelList
    },
    data() {
        return {
            cities: [
                'Paris', 'Seoul', 'London', 'New-York', 'Tokyo', 'Beijing' 
            ]
        }
    }
}
</script>
