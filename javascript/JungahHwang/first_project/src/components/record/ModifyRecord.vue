<template>
  <v-dialog v-model="dialog" hide-overlay persistent max-width="500px">
    <template v-slot:activator="{ on }">
      <v-btn v-on="on" icon small color="secondary" class="pa-6" @click="readRecord">
        <v-icon>create</v-icon>
      </v-btn>
    </template>
    <v-card class="primary rounded-xl">
      <v-card-title class="headline secondary--text font-weight-bold">
          <p>{{ selectDate }} 기록 수정하기</p>
        </v-card-title>
        <v-card-text>
          <v-textarea color="secondary" v-model="food" label="식단" 
          clearable clear-icon="mdi-close" outlined></v-textarea>
          <v-textarea color="secondary" v-model="exercise" label="운동" 
          clearable clear-icon="mdi-close" outlined></v-textarea>
          <v-textarea color="secondary" v-model="weight" label="체중" 
          clearable clear-icon="mdi-close" outlined></v-textarea>
        </v-card-text>
        <v-divider></v-divider>
      <v-card-actions>
        <v-btn @click="closeForm" icon small color="secondary" class="pa-6">
          <v-icon>close</v-icon>
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="modifyRecord" icon small color="secondary" class="pa-6">
          <v-icon>done</v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      dialog: false,
      food: null,
      exercise: null,
      weight: null
    }
  },
  computed: {
    ...mapState([ 'selectDate', 'record' ])
  },
  methods: {
    ...mapActions ([ 'fetchRecord', 'fetchRecords' ]),
    
    closeForm () {
      this.dialog = false
    },
    modifyRecord () {
      const food = this.food
      const exercise = this.exercise
      const weight = this.weight
      const date = this.selectDate

      console.log(date + ': ' + food + ', ' + exercise + ', ' + weight)
      
      axios.patch(`http://localhost:7777/record/modify/${date}`, { food, exercise, weight }).then(() => {
        alert('(' + date + ') 활동이 수정되었습니다!')

        this.fetchRecord(date)
        this.fetchRecords()

        this.dialog = false
       }).catch(() => {
      })
    },
    readRecord () {
      this.food = this.record.food,
      this.exercise = this.record.exercise,
      this.weight = this.record.weight
    }
  }
}
</script>