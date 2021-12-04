<template>
  <v-card class="ma-7 mt-n3">
    <v-sparkline :labels="value" :value="value" color="secondary"
      line-width="1" padding="16"></v-sparkline>
  </v-card>
</template>


<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data: () => ({
    value: [],

  }),
  created () {
    axios.get('http://localhost:7777/record/list').then(res => {
      this.value = res.data.splice(-7, 7).map(list => list.weight)
    })
    
    console.log(this.value)

  },
  computed: {
    ...mapState(['records']),
  
  },
  methods: {
   // ...mapActions(['fetchRecords']),

  }
}
</script>