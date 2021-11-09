<template>
    <div id="app">
        <travel-list>
            
            <template slot-scope="{ childitems }">
                <p v-for="item in childitems" :key="item">
                    {{ item }}
                </p>
            </template>
        </travel-list>
        <p>---------------------------------------------------</p>
        <!-- :items="cities">이거 props에 바인딩시킨 거 -->
        <!-- 자식 컴포넌트에 cities를 보낸 거  -->
        <travel-list :items="cities">
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
    data () {
        return {
            cities: [
                'pari', 'seo', 'tokyo', 'esea', 'vancouer'
            ]
        }
    }
}
</script>