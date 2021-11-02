<template>
    <div id="app">
        <travel-list>
            <!-- 자식 정보를 부모가 받을땐 어쨋든 templeate가 필요 -->
            <template slot-scope="{ childitems }">
                <p v-for="item in childitems" :key="item">
                    {{item}}
                </p>
            </template> >
        </travel-list>
        <p>---------------------------경계선-------------------------------</p>
        <travel-list :items="cities">
            <template slot-scope="{items}">
                <p v-for="item in items" :key=item>
                    {{item}}
                </p>
            </template>
        </travel-list>
    </div>
</template>
<script>
import TravelList from '@/components/slot/TravelList.vue';

export default {
    name: 'ScopedSlotTestpage',

    components: {
         TravelList
    },
    data()
    {
        return{
            cities:['Paris','Seoul','Tokyo', 'Seattle', 'Vancouver']

        }
    }
    
}
</script>
