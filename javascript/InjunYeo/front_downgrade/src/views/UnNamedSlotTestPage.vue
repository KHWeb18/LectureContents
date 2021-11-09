<template>
    <div id="app">
        <p>나는?</p>
        <child-com>
            <p>에펠탑</p>
            <p>너는?</p>
        </child-com>
    </div>
</template>

<script>

import ChildCom from '@/components/slot/Child.vue'

export default {
    name: 'app',
    components: {
        'child-com': ChildCom
    }
}
</script>