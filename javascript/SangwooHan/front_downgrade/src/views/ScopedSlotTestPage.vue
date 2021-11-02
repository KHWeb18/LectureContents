<template>
    <div id="app">
        <travel-list>
            <!-- 자식 정보를 부모가 받을땐 어쩃든 template이 필요함 -->
            <template slot-scope="{ childitems }">
                <p v-for="(item, idx) in childitems" :key="idx">
                    {{item}}
                </p>
            </template>
        </travel-list>
        <p>----------경계선-------------</p> <br>

        <travel-list :items="cities">
            <!-- 전달할 데이터를 items로 설정하고, 이데이터를
            computed()에 정의된 filteredList()의 리턴값으로 전달함
            이값은 사용자가 input에 입력하는 데이터와 양방향 바인딩된
            inputFilter에 의해 필터링된 값이다.-->
            <template slot-scope="{ items }">
                <!-- 전달값 설정-->
                <p v-for="item in items" :key="item">
                    {{item}}
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
                    'Paris','Soul', 'Tokyo', 'Seattle', 'Vancouver'
                ]
        }
    }
}
</script>