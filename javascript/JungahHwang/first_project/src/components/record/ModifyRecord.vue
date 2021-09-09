<template>
  <v-dialog v-model="dialog" hide-overlay persistent max-width="500px">
    <template v-slot:activator="{ on }">
      <v-btn v-on="on" icon small color="secondary" class="pa-6">
        <v-icon>create</v-icon>
      </v-btn>
    </template>
    <v-card>
      <v-card-title>
        <p>{{ date }} 활동 수정하기</p>
      </v-card-title>
      <v-card-text>
        <v-textarea outlined color="secondary" label="식단" v-model="food"></v-textarea>
        <v-textarea outlined color="secondary" label="운동" v-model="exercise"></v-textarea>
        <v-textarea outlined color="secondary" label="체중" v-model="weight"></v-textarea>
      </v-card-text>
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
    ...mapState(['date', 'record'])
  },
  created () {
    this.food = this.record.food,
    this.exercise = this.record.exercise,
    this.weight = this.record.weight
  },
  methods: {
    ...mapActions (['fetchRecord']),
    closeForm () {
      this.dialog = false
    },
    modifyRecord () {
      const food = this.food
      const exercise = this.exercise
      const weight = this.weight
      const date = this.date

      console.log(date + ': ' + food + ', ' + exercise + ', ' + weight)
      
      axios.patch(`http://localhost:7777/record/modify/${date}`, { food, exercise, weight }).then(() => {
        alert(date + ': ' + food + ', ' + exercise + ', ' + weight + '이 수정되었습니다!')

        this.fetchRecord(this.date)

        this.dialog = false
       }).catch(res => {
        alert(res.response.data.message)
      })
      
      
      
    },
  }
}
</script>