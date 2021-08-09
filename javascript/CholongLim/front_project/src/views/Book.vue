<template>
  <v-row>
    <v-col
      cols="12"
      sm="6"
    >
      <v-date-picker
        v-model="dates"
        range
      ></v-date-picker>
    </v-col>
    <v-col
      cols="12"
      sm="6"
    >
      <v-text-field
        v-model="dateRangeText"
        label="Date range"
        prepend-icon="mdi-calendar"
        readonly
      ></v-text-field>
      model: {{ dates }}
    </v-col>
  </v-row>
</template>

<script>
  export default {
    data: () => ({
      dates: ['2021-08-10', '2021-08-11'],
    }),
    computed: {
      dateRangeText () {
        return this.dates.join(' ~ ')
      },
    },
  }
</script>