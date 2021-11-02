<template>
    <div id="app">
        <travel-list>
            <!-- 여기는 바인딩 없기 간거-->
            <!-- 자식 정보를 부모가 받을땐 어쨋든  template이 필요함 -->
            <template slot-scope="{ childitems }">
                <p v-for="item in childitems" :key="item">
                    {{item}}
                </p>
            </template>
        </travel-list>
        <p>----------------경계선 ----------------</p>
        <travel-list :items="cities"><!-- 여기는 props에 바인딩해서 간거-->
            <!-- 전달할 데이터를 items로 설정하고 
                 이 데이터는 computed()에 정의된 filteredList()의 리턴값을 전달함
                 이 값은 사용자가 input에 입력하는 데이터와
                 양방향 바인딩된 inputFilter에 의해 필터링 된 값이다.-->
            <template slot-scope="{items}"><!--자식에있는 props를 맵핑시킨것-->
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
    name: 'ScopeSlotTestPage',
    components:{
        TravelList
    },
    data (){
        return{
            cities: [
                'Paris','Seoul','Tokyo','Seattle','Vancouver'
            ]

        }
    }
    
}
</script>