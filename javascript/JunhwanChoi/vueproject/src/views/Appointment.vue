<template>
    <div>
        <v-container>
            <v-card>
                <v-app id="inspire">
            <div>
            <v-sheet
                tile
                height="54"
                class="d-flex"
            >
                <v-btn
                icon
                class="ma-2"
                @click="$refs.calendar.prev()"
                >
                <v-icon>mdi-chevron-left</v-icon>
                </v-btn>
                <v-spacer></v-spacer>
                <v-btn
                icon
                class="ma-2"
                @click="$refs.calendar.next()"
                >
                <v-icon>mdi-chevron-right</v-icon>
                </v-btn>
            </v-sheet>
            <v-sheet height="600">
                <v-calendar
                ref="calendar"
                v-model="value"
                :weekdays="weekday"
                :type="type"
                @change="getEvents"
                ></v-calendar>
            </v-sheet>
            </div>
        </v-app>
            </v-card>
        </v-container>
        
    </div>
</template>
<script>
export default {
    //https://vuetifyjs.com/en/components/steppers/#usage

  data () {
      return{
            type: 'month',
            types: ['month'],
            weekday: [0, 1, 2, 3, 4, 5, 6],
            weekdays: [
            { text: 'Sun - Sat', value: [0, 1, 2, 3, 4, 5, 6] },
            ],
            value: '',
            events: [],
            
      }
  },
    

  methods: {
    
  }
}
</script>
<style>
    
</style>

