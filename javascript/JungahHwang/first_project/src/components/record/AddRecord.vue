<template>
  <v-dialog v-model="dialog" hide-overlay persistent max-width="500px">
    <template v-slot:activator="{ on }">
      <v-btn v-on="on" icon small color="secondary" class="pa-6">
        <v-icon>add</v-icon>
      </v-btn>
    </template>
      <v-card>
        <v-card-title>
          <p>{{ date }} 활동 기록하기</p>
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
          <v-btn @click="AddRecord" icon small color="secondary" class="pa-6">
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
      weight: null,
    }
  },
  computed: {
    ...mapState(['date', 'activity', 'userInfo'])
  },
  methods: {
    ...mapActions(['fetchActivity']),
    closeForm () {
      this.dialog = false
    },
    AddRecord () {
      const food = this.food
      const exercise = this.exercise
      const weight = this.weight
      const date = this.date
      const id = this.userInfo.id

      console.log(date + '/' + id + ': ' + food + ', ' + exercise + ', ' + weight)
      
      axios.post('http://localhost:7777/record/add', { id, date, food, exercise, weight }).then(() => {
        alert(date + ': ' + food + ', ' + exercise + ', ' + weight + '이 등록되었습니다!')
       }).catch(res => {
        alert(res.response.data.message)
      })
      
      this.dialog = false
      this.fetchActivity(this.date)
    },
  }
}
</script>