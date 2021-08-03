<template>
    <div id="app">
        <travel-list>
            <template slot-scope="{ childitems }"> 
            <!-- 요걸로 자식 component인 TravelList의 childitems를 받았음 -->
                <p v-for="item in childitems" :key="item">
                    {{ item }}
                </p>
            </template>
        </travel-list>
        <p>-------------------------Half Line---------------------------</p>
        <travel-list v-bind:items="cities">
            <!-- 이 컴포넌트에 있는 cities를 자식 컴포넌트에 있는 items라는 이름으로 보낸것! -->
            <template slot-scope="{ items }">
                <p v-for="item in items" :key="item">
                    {{ item }}
                </p>
            </template>
        </travel-list>
    </div>
</template>

<script>
import TravelList from '@/components/slot/TravelList.vue'

export default {
    name: 'ScopedSlotTestPage',
    components: {
        TravelList
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
