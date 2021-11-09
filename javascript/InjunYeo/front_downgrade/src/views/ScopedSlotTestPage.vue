<template>
    <div id="app">
        <travel-list>
            <!--자식 정보를 부모가 받을땐 template이 필요함 -->
            <template slot-scope="{ childitems }">
                <p v-for="item in childitems" :key="item">
                    {{item}}
                </p>

            </template>
        </travel-list>
        <p>-----------경계선------------</p>
        <travel-list :items="cities">
            <!-- 전달할 데이터를 items로 설정하고
                이 데이터는 computed()에 정의된 filteredLIst()의 리턴값을 전달함
                이값은 사용자가 input에 입력하는 데이터와
                양방향 바인딩된 inputFulter에 의해 필터링된 값이다 -->
            <template slot-scope="{itemk}">
                <p v-for="item in itemk" :key="item">
                    {{item}}
                </p>
            </template>
        </travel-list>
    </div>
</template>

<script>

import TravelList from '@/components/slot/TravelList';

export default {
    name: 'ScopedSlotTestPage',
    components: {
        TravelList

    },
    data(){
        return{
            cities: [
                'Paris','Seoul','Tokyo','Newyork','Busan'
            ]
        }
    }
}
</script>