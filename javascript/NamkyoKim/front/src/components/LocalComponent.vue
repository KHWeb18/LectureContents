<template>
<!-- 실제 해당 컴포넌트를 사용하는 측에서
    v-bind:num="블라블라" 형식으로 맵핑됨-->
<div>{{ num }}</div>
</template>

<script>

export default {
    name: 'LocalComponent',
    props: {
        num: Number
    }
}
</script>