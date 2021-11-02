<template>
    <div>{{ num }}</div>
</template>

<script>

export default {
    name: 'LocalComponent',
    props: {
        num: Number
        //Number는 vue에서 쓰이는 자료형이다.
    }
}
</script>
