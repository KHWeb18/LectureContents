<template>
    <div>
        <p>
            <input type="text" v-model="inputFilter"/>
        </p>
        <!-- 자식 컴포넌트 -> 부모 컴포넌트로 데이터 전달 -->
        <slot v-bind:childitems="childitems"/>
        <slot v-bind:items="filteredList"/>
    </div>
  
</template>

<script>
export default {
    props: {
        items: {
            type: Array
        }
    },
    data() {
        return {
            inputFilter: "",
            childitems: ["one", "two", "three"]
        }
    },
    computed: {
        filteredList() {
            if (this.items) {
                return this.items.filter(item => item.includes(this.inputFilter))
            }
            return 0
        }
    }
}
</script>

<style>

</style>