<template>
    <div v-html="$route.query.htmlcode">
    </div>
</template>

<script>

export default {
    name: 'KakaoAuthPage',
    data () {
        return {
            id: '',
            pw: ''
        }
    }
}

</script>