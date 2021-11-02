<template>
    <div id="app">
        <child>
            <p>child-com</p>
        </child>
    </div>
</template>

<script>

import Child from '@/components/slot/Child'

export default {
    name: 'app',
    components: {
        Child
    }
}
</script>
