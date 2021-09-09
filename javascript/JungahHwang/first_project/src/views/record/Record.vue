<template>
  <v-card class="mt-8" color="primary">
    <v-row>
      <v-col cols="12" md="8">
        <v-card class="ma-3 px-3 pb-3">
          <v-toolbar flat>
            <!--
            <v-btn class="mr-4 secondary--text" color="primary" @click="setToday">Today</v-btn>
            -->

            <v-btn fab text small color="secondary" @click="prev">
              <v-icon small>mdi-chevron-left</v-icon>
            </v-btn>
            <v-toolbar-title v-if="$refs.calendar" class="secondary--text">
              {{ $refs.calendar.title }}
              </v-toolbar-title>
            <v-btn fab text small color="secondary" @click="next">
              <v-icon small>mdi-chevron-right</v-icon>
            </v-btn>
          </v-toolbar>
        
        <v-sheet height="350">
          <v-calendar ref="calendar" v-model="focus" color="secondary" 
          :type="type" :events="events" @click:date="viewDay"
          @change="updateRange">
          </v-calendar>
        </v-sheet>  
        </v-card>
      </v-col>

      <v-col cols="12" md="4">
        <record-form></record-form>
      </v-col>
    </v-row>
    
  </v-card>
</template>


<script>
import RecordForm from '@/components/record/RecordForm'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'Record',
  components: {
    RecordForm
  },
  data: () => ({
    focus: '',
    type: 'month',
    events: []
  }),
  computed: {
    ...mapState([ 'date', 'records' ])
  },
  mounted () {
    this.fetchRecords()
    this.fetchRecord(this.date)
    this.$refs.calendar.checkChange()
  },
  methods: {
    ...mapActions(['fetchRecord', 'fetchRecords']),

    viewDay ({ date }) {
      this.focus = date
      this.$store.commit('OPEN_DETAIL', date)
      this.fetchRecord(date)
    },
    setToday () {
      this.focus = ''
    },
    prev () {
      this.$refs.calendar.prev()
    },
    next () {
      this.$refs.calendar.next()
    },
    updateRange () {
      const events = []
      
      for (let i = 0; i < this.records.length; i++) {
        events.push({
          name: '',
          start: this.records[i].date,
          end: this.records[i].date,
          color: 'primary',
        })
      }
      
      this.events = events
    }
  },
}
</script>
