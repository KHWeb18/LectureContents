<template>
    <div>
        <child-com>
            <p>에펠탑 갈까?</p>
        </child-com>
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