<template>
  <v-card class="mt-8 mb-10" color="primary">
    <v-row>
      <v-col cols="12" md="6">
        <v-card class="ma-7 primary">
          <v-date-picker  v-model="date" :events="eventList" color="secondary"
            event-color="#FFADAD"  @click:date="viewDay(date)"
            width="100%"></v-date-picker>
        </v-card>
      </v-col>
     
      <v-col cols="12" md="6">
        <read-record></read-record>
      </v-col>
    </v-row>
    
    <v-row v-if="isLogin">
      <v-col>
         <change-record></change-record>
      </v-col>
    </v-row>
  </v-card>
</template>


<script>
import ReadRecord from '@/components/record/ReadRecord'
import ChangeRecord from '@/components/record/ChangeRecord'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'Record',
  components: {
    ReadRecord,
    ChangeRecord,
  },
  data: () => ({
    eventList: [],
    date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
  }),
  computed: {
    ...mapState([ 'selectDate', 'records', 'isLogin' ])
  },
  mounted () {
    this.fetchRecords()
    this.fetchRecord(this.selectDate)

    console.log('mounted: ' + this.records)
  },
  beforeUpdate () {
    console.log('update: ' + this.records)
    
    if (this.isLogin) {
      for (let i = 0; i < this.records.length; i++) {
        this.eventList.push(this.records[i].date)
      }  
    }
  },
  methods: {
    ...mapActions([ 'fetchRecord', 'fetchRecords' ]),

    viewDay (date) {
      console.log(date)
      this.$store.commit('OPEN_DETAIL', date)
      this.fetchRecord(date)
    },
    dateFormat (date) {
      return date.toISOString().substr(0, 10)
    }
  },
}
</script>
