<template>
  <div>
    <p>
      <input v-model="inputFilter">
    </p>
    <slot :items="filteredList"></slot>
  </div>
</template>

<script>
export default {
  name: "RecentSlotTravelList",
  props: ["items"],
  data () {
    return {
      inputFilter: ""
    }
  },
  computed: {
    filteredList() {
      return this.items.filter(item => item.includes(this.inputFilter))
    }
  }
}
</script>

<style scoped>

</style>