<template>
    <ul>
        <li v-for="product in products" :key="product.pcode"
            v-on:click="sendCode(product.pcode, $event)">
            {{ product.pname }}
        </li>
    </ul>
</template>

<script>
import EventBus from '@/eventBus.js'
//EventBus는 전역변수처럼 활용됨, 어디서나 쓸 수 있음

export default {
    data() {
        return {
            products: [
                { pcode: 'p01', pname: 'laptop' },
                { pcode: 'p02', pname: 'desktop' },
                { pcode: 'p03', pname: 'car' },
            ]
        }
    },
    methods: {
        sendCode(incode, $event) {
            // 여기서 인자로 $event가 들어가는 이유???

            //console.log(incode) --> pcode
            //console.log($event) --> 마우스 클릭 좌표

            console.log($event.target.innerHTML)
            // --> pname이 console창에서 나온다. 즉 HTML창에서 클릭이라는 이벤트의 타겟이 되는
            // 대상들은 pname들이기때문에 $event.target.innerHTML의 값은 pname이 되는것이다!
            
            const payload = [ incode, $event.target.innerHTML ]
            EventBus.$emit('sendcode', payload)
        }
    }
}
</script>
