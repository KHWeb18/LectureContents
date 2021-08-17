<template>
    <v-row>
      <v-col cols="12" md="8">
        <v-card>
          <v-toolbar flat>
            <v-btn class="mr-4 secondary--text" color="primary" @click="setToday">Today</v-btn>
            
            <v-btn fab text small color="secondary" @click="prev">
              <v-icon small>mdi-chevron-left</v-icon>
            </v-btn>
            <v-toolbar-title v-if="$refs.calendar" class="secondary--text">{{ $refs.calendar.title }}</v-toolbar-title>
            <v-btn fab text small color="secondary" @click="next">
              <v-icon small>mdi-chevron-right</v-icon>
            </v-btn>
          </v-toolbar>
        
          <v-calendar ref="calendar" v-model="focus" color="secondary" :events="events"
            :event-color="getEventColor" :type="type" @click:event="showEvent"
            @click:more="viewDay" @click:date="viewDay" ></v-calendar>
          <v-menu v-model="selectedOpen" :close-on-content-click="false"
            :activator="selectedElement" offset-x>
            <v-card color="grey lighten-4" min-width="350px" flat>
              <v-toolbar :color="selectedEvent.color" dark>
                <v-btn icon>
                  <v-icon>mdi-pencil</v-icon>
                </v-btn>
                <v-toolbar-title v-html="selectedEvent.name"></v-toolbar-title>
                <v-spacer></v-spacer>
                <v-btn icon>
                  <v-icon>mdi-dots-vertical</v-icon>
                </v-btn>
              </v-toolbar>
              <v-card-text>
                <span v-html="selectedEvent.details"></span>
              </v-card-text>
              <v-card-actions>
                <v-btn text color="secondary" @click="selectedOpen = false">Cancel</v-btn>
              </v-card-actions>
            </v-card>
          </v-menu>
        </v-card>
      </v-col>
      <v-col cols="12" md="4">
        <v-card ref="form" v-model="viewDetail">
          <v-card-title class="text-center justify-center py-6">
            <h1 class="font-weight-bold text-h6 secondary--text">
              test
            </h1>
          </v-card-title>

          <v-tabs v-model="tab" background-color="transparent" color="secondary--text" grow>
            <v-tab v-for="name in names" :key="name">
              {{ name }}
            </v-tab>
          </v-tabs>

          <v-tabs-items v-model="tab">
            <v-tab-item v-for="item in items" :key="item.name" :ref="item.name">
              <v-card flat>
                <v-card-text>{{ item.text }}</v-card-text>
                <v-textarea outlined name="input-7-4" label="기록하세요." 
                  background-color="primary" color="secondary" v-model="item.model"></v-textarea>
                <v-btn @click="btnRecord">record</v-btn>
              </v-card>
            </v-tab-item>
          </v-tabs-items>
        </v-card>
        <!--
        <v-text-field outlined name="input-7-4" label="기록하세요." 
          background-color="primary" color="secondary" v-model="food"></v-text-field>
          -->
          <v-text-field ref="id" color="secondary" label="Id" v-model="id" 
          ></v-text-field>
      </v-col>
    </v-row>

    
</template>


<script>
export default {
  name: 'RecordForm',
  data: () => ({
    focus: '',
    type: 'month',
    selectedEvent: {},
    selectedElement: null,
    selectedOpen: false,
    events: [],
    colors: ['blue', 'indigo', 'deep-purple', 'cyan', 'green', 'orange', 'grey darken-1'],
    names: ['식단', '운동', '체중'],
    items: [
      { name: '식단', text: '식단기록', model: 'food' },
      { name: '운동', text: '운동기록', model: 'exercise'},
      { name: '체중', text: '체중기록', model: 'weight' },
    ],
    viewDetail: false,
    tab: null,
    food: null,
    exercise: null,
    weight: null,
    id: null
  
  }),
  mounted () {
    this.$refs.calendar.checkChange()
  },
  // computed: {
  //   form () {
  //     return {
  //       food: this.food,
  //       exercise: this.exercise,
  //       weight: this.weight
  //     }
  //   }
  // },
  methods: {
    viewDay ({ date }) {
      this.focus = date
      this.viewDetail = true
    },
    getEventColor (event) {
      return event.color
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
    showEvent ({ nativeEvent, event }) {
      const open = () => {
        this.selectedEvent = event
        this.selectedElement = nativeEvent.target
        requestAnimationFrame(() => requestAnimationFrame(() => this.selectedOpen = true))
      }

      if (this.selectedOpen) {
        this.selectedOpen = false
        requestAnimationFrame(() => requestAnimationFrame(() => open()))
      } else {
        open()
      }

      nativeEvent.stopPropagation()
    },
    // updateRange ({ start, end }) {
    //   const events = []

    //   const min = new Date(`${start.date}T00:00:00`)
    //   const max = new Date(`${end.date}T23:59:59`)
    //   const days = (max.getTime() - min.getTime()) / 86400000
    //   const eventCount = this.rnd(days, days + 20)

    //   for (let i = 0; i < eventCount; i++) {
    //     const allDay = this.rnd(0, 3) === 0
    //     const firstTimestamp = this.rnd(min.getTime(), max.getTime())
    //     const first = new Date(firstTimestamp - (firstTimestamp % 900000))
    //     const secondTimestamp = this.rnd(2, allDay ? 288 : 8) * 900000
    //     const second = new Date(first.getTime() + secondTimestamp)

    //     events.push({
    //       name: this.names[this.rnd(0, this.names.length - 1)],
    //       start: first,
    //       end: second,
    //       color: this.colors[this.rnd(0, this.colors.length - 1)],
    //       timed: !allDay,
    //     })
    //   }

    //   this.events = events
    // },
    // rnd (a, b) {
    //   return Math.floor((b - a + 1) * Math.random()) + a
    // },
    btnRecord () {
      const food = this.food
      console.log(food)
    }
  },
}
</script>