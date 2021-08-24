<template>
  <div>
    <h2>기록 페이지</h2>
    <v-row>
      <v-col cols="12" md="8">
        <v-card class="pa-3 primary">
          <v-toolbar flat class="primary">
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
        
          <v-calendar ref="calendar" v-model="focus" color="secondary" 
          :type="type" @click:date="viewDay">
          </v-calendar>
          
        </v-card>
      </v-col>

      <v-col cols="12" md="4">
        <record-form></record-form>
      </v-col>
    </v-row>
    
  </div>
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
  }),
  computed: {
    ...mapState([ 'date' ])
  },
  methods: {
    ...mapActions(['fetchActivity']),

    viewDay ({ date }) {
      this.focus = date
      this.$store.commit('OPEN_DETAIL', date)
      this.fetchActivity(date)
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
    
  },
}
</script>
