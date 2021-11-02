<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <slot :items="filteredList"/>
    </div>
</template>

<script>

export default {
    props: ["items"],
    data () {
        return {
            inputFilter: ""
        }
    },
    computed: {
        filteredList () {
            return this.items.filter(item => item.includes(this.inputFilter))
        }
    }
}

</script>