<template>
    <div id="app">
        <!-- 슬롯이 차일드 내부에서 컴포넌트로 감싼 것을 가져온다. -->
        <p>나는?</p>
        <child-com>
            <p>에펠탑 갈까?</p>
        </child-com>
        <p>너는?</p>
    </div>
</template>

<script>

import ChildCom from '@/components/slot/Child'

export default {
    name: 'app',
    components: {
        'child-com': ChildCom
    }    
}
</script>