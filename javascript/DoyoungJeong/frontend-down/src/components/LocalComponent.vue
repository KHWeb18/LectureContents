<template>
    <div>{{ num }}
        {{ aMonster }}
    </div>
</template>

<script>
export default {
    name: 'LocalComponent',
    props: ['num', 'aMonster']
    // props: {
    //     num: Number,
    //     aMonster: String
    // }
}
</script>