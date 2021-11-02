<template>
    <ul>
        <!-- v-for 돌면서 <li>를 해당 갯수만큼 생성해낸다 
            클릭시 sendCode가 실행되면서, 
            어떤것을 눌렀는지에 대한 pcode 정보가 전송되며 이벤트가 발생한다.(product의 pcode 이벤트를 발생 시킨다)
            $event는 어떤 이벤트를 발생하였는지-->
        <li v-for="product in products" :key="product.pcode"
            v-on:click="sendCode(product.pcode, $event)">
                {{ product.pname }}
        </li>
    </ul>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data () {
        return {
            products: [
                { pcode: 'p01', pname: '노트북' },
                { pcode: 'p02', pname: '컴퓨터' },
                { pcode: 'p03', pname: '자동차' },
            ]
        }
    },
    //payload는 pcode의 값
    methods: {
        //incode는 템플릿 안에있는 샌드코드안의 product.pcode를 받는다.
        sendCode(incode, $event) {
            // EvnetBus에 전송시킴
            // $event.target.innerHTML은 노트북, 컴퓨터, 자동차. 즉 products
            const payload = [ incode, $event.target.innerHTML ]
            EventBus.$emit('sendcode', payload)
        }
    }
}
</script> 