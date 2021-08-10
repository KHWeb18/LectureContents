<template>
  <v-container overflow="visible">
    <v-row>
      <v-col
        cols="12"
        lg="6"
      >

        <!--               prepend-icon="mdi-calendar" -->
          <!-- <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="dateFormatted"
              label="Date"
              v-bind="attrs"
              @blur="date = parseDate(dateFormatted)"
              v-on="on"
            ></v-text-field>
          </template>-->

          <v-container>
          <v-date-picker
            v-model="date"
            no-title
            @input="menu1 = false"
          ></v-date-picker>
          </v-container>

        <p>Date in ISO format: <strong>{{ date }}</strong></p>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    data: vm => ({
      date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
      menu1: false,
    }),

    computed: {
      computedDateFormatted () {
        return this.formatDate(this.date)
      },
    },

    watch: {
      date () {
        this.dateFormatted = this.formatDate(this.date)
      },
    },

    methods: {
      formatDate (date) {
        if (!date) return null

        const [year, month, day] = date.split('-')
        return `${month}/${day}/${year}`
      },
      parseDate (date) {
        if (!date) return null

        const [month, day, year] = date.split('/')
        return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
      },
    },
  }
</script>

<style scoped>

.calendar-box {
    overflow: visible;
    padding: 50% 0% 50% 0%;
}
</style>