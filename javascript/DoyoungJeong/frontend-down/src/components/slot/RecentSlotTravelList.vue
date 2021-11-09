<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <slot v-bind:items="filteredList"/>
        <slot :childitems="childitems"/>
    </div>
</template>

<script>

export default {
    props: {
        items: {
            type: Array,
            required: true
        }  
    },
    data() {
        return {
            inputFilter: '',
            childitems: ['one', 'two', 'three']
        }
    },
    computed: {
        filteredList() {
            if(this.items) {
                return this.items.filter(item => item.includes(this.inputFilter))
                //각 요소마다 검사해서 inputFilter가 포함되지 않는 요소들은 걸러짐
            }
            return null
        }
    },
}
</script>
