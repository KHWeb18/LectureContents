<template>
    <div>
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/4996961/pexels-photo-4996961.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
            </v-img>
        </div>
        <div class="section">
            <p>" We travel, some of us forever, to seek other places, other lives, other souls. "</p>
        </div>
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL RESERVATION</h1>
            <p>| 예약하기 |</p>
        </v-container>

        <v-divider></v-divider>

        <v-container>
            <v-container class="btn-box">
                <v-btn text v-for="book in booking" :key="book" router :to="book.route">
                {{ book.name }}
                </v-btn>
            </v-container>
        </v-container>

    <v-divider></v-divider>

    <v-container>
    <div class="calendar-box">
        <v-row class="fill-height">
            <v-col>
                <v-sheet height="64">
                    <v-toolbar flat="flat">
                        <v-btn outlined="outlined" class="mr-4" color="grey darken-2" @click="setToday">
                            Today
                        </v-btn>
                        <v-btn fab="fab" text="text" small="small" color="grey darken-2" @click="prev">
                            <v-icon small="small">
                                mdi-chevron-left
                            </v-icon>
                        </v-btn>
                        <v-btn fab="fab" text="text" small="small" color="grey darken-2" @click="next">
                            <v-icon small="small">
                                mdi-chevron-right
                            </v-icon>
                        </v-btn>
                        <v-toolbar-title v-if="$refs.calendar">
                            {{ $refs.calendar.title }}
                        </v-toolbar-title>
                        <v-spacer></v-spacer>
                        <v-menu bottom="bottom" right="right">
                            <template v-slot:activator="{ on, attrs }">
                                <v-btn outlined="outlined" color="grey darken-2" v-bind="attrs" v-on="on">
                                    <span>{{ typeToLabel[type] }}</span>
                                    <v-icon right="right">
                                        mdi-menu-down
                                    </v-icon>
                                </v-btn>
                            </template>
                            <v-list>
                                <v-list-item @click="type = 'day'">
                                    <v-list-item-title>Day</v-list-item-title>
                                </v-list-item>
                                <v-list-item @click="type = 'week'">
                                    <v-list-item-title>Week</v-list-item-title>
                                </v-list-item>
                                <v-list-item @click="type = 'month'">
                                    <v-list-item-title>Month</v-list-item-title>
                                </v-list-item>
                                <v-list-item @click="type = '4day'">
                                    <v-list-item-title>4 days</v-list-item-title>
                                </v-list-item>
                            </v-list>
                        </v-menu>
                    </v-toolbar>
                </v-sheet>
                <v-sheet height="600">
                    <v-calendar
                        ref="calendar"
                        v-model="focus"
                        color="primary"
                        :events="events"
                        :event-color="getEventColor"
                        :type="type"
                        @click:event="showEvent"
                        @click:more="viewDay"
                        @click:date="viewDay"
                        @change="updateRange"></v-calendar>
                    <v-menu
                        v-model="selectedOpen"
                        :close-on-content-click="false"
                        :activator="selectedElement"
                        offset-x="offset-x">
                        <v-card color="grey lighten-4" min-width="350px" flat="flat">
                            <v-toolbar :color="selectedEvent.color" dark="dark">
                                <v-btn icon="icon">
                                    <v-icon>mdi-pencil</v-icon>
                                </v-btn>
                                <v-toolbar-title v-html="selectedEvent.name"></v-toolbar-title>
                                <v-spacer></v-spacer>
                                <v-btn icon="icon">
                                    <v-icon>mdi-heart</v-icon>
                                </v-btn>
                                <v-btn icon="icon">
                                    <v-icon>mdi-dots-vertical</v-icon>
                                </v-btn>
                            </v-toolbar>
                            <v-card-text>
                                <span v-html="selectedEvent.details"></span>
                            </v-card-text>
                            <v-card-actions>
                                <v-btn text="text" color="secondary" @click="selectedOpen = false">
                                    Cancel
                                </v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-menu>
                </v-sheet>
            </v-col>
        </v-row>
    </div>
    </v-container>
  </div>
</template>


<script>
  export default {
    data() {
        return {
            booking: [
                {name: '예약달력', route: '/reservation' },
                {name: '예약하기', route: '/book' },
                {name: '요금안내', route: '/pay-information' },
            ],
            focus: '',
            type: 'month',
            typeToLabel: {
                month: 'Month',
                week: 'Week',
                day: 'Day',
                '4day': '4 Days',
            },
            selectedEvent: {},
            selectedElement: null,
            selectedOpen: false,
            events: [],
            colors: ['green', 'orange', 'red'],
            names: ['예약가능', '입금대기', '예약완료']
        }
    },
    mounted () {
      this.$refs.calendar.checkChange()
    },
    methods: {
      viewDay ({ date }) {
        this.focus = date
        this.type = 'day'
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
      updateRange ({ start, end }) {
        const events = []

        const min = new Date(`${start.date}T00:00:00`)
        const max = new Date(`${end.date}T23:59:59`)
        const days = (max.getTime() - min.getTime()) / 86400000
        const eventCount = this.rnd(days, days + 20)

        for (let i = 0; i < eventCount; i++) {
          const allDay = this.rnd(0, 3) === 0
          const firstTimestamp = this.rnd(min.getTime(), max.getTime())
          const first = new Date(firstTimestamp - (firstTimestamp % 900000))
          const secondTimestamp = this.rnd(2, allDay ? 288 : 8) * 900000
          const second = new Date(first.getTime() + secondTimestamp)

          events.push({
            name: this.names[this.rnd(0, this.names.length - 1)],
            start: first,
            end: second,
            color: this.colors[this.rnd(0, this.colors.length - 1)],
            timed: !allDay,
          })
        }

        this.events = events
      },
      rnd (a, b) {
        return Math.floor((b - a + 1) * Math.random()) + a
      }
    }
  }
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');

.btn-box{
    padding: 18px 10px 18px 10px;
    text-align: center;
}

.calendar-box {
    width:70%;
    position: relative;
    left: 15%;
    margin: 15% 0% 15% 0%;
}

.intro-top {
    text-align: left;
}

.about-img-top {
    max-height: 70vh;
}


.section {
    background: #dcdfdc;
    height: 10vh;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}

.about-top {
    padding-top: 10vh;
}

h1 {
    font-family: "Cinzel";
    font-size: 40px;
    text-align: center;
    margin-top: 10px;
}

h2 {
    font-family: 'MonteCarlo';
    font-size: 150px;
    color:darkgrey
}

h3 {
    font-family: "Cinzel";
    font-size: 80px;
    margin-top: 10px;
    color:darkgrey;
}

h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 35px;
}
</style>