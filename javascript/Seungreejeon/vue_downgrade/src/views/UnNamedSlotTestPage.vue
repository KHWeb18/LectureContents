<template>
    <div id="app">
            <p>나는 ?</p>
        <child-com>
            <p>에펠탑 갈까?</p>
            <p>너는 ?</p>
        </child-com>
    </div>
</template>
<script>
import ChildCom from '../components/slot/Chlid.vue'

export default {
    name: "app",
    components: {
        'child-com': ChildCom
    }
}
</script>
<style>
</style>