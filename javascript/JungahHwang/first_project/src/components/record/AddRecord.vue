<template>
  <v-dialog v-model="dialog" hide-overlay persistent max-width="500px">
    <template v-slot:activator="{ on }">
      <v-btn v-on="on" icon small color="secondary" class="pa-6">
        <v-icon>add</v-icon>
      </v-btn>
    </template>
      <v-card class="primary rounded-xl">
        <v-card-title class="headline secondary--text font-weight-bold">
          <p>{{ selectDate }} 기록하기</p>
        </v-card-title>
        <v-card-text>
          <v-textarea color="secondary" v-model="food" label="식단" outlined></v-textarea>
          <v-textarea color="secondary" v-model="exercise" label="운동" outlined></v-textarea>
          <v-textarea color="secondary" v-model="weight" label="체중" outlined></v-textarea>
        </v-card-text>
        <v-divider></v-divider>
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
    ...mapState(['selectDate', 'record', 'userInfo'])
  },
  methods: {
    ...mapActions(['fetchRecord']),
    closeForm () {
      this.dialog = false
    },
    AddRecord () {
      const food = this.food
      const exercise = this.exercise
      const weight = this.weight
      const date = this.selectDate
      const id = this.userInfo.id

      console.log(date + '/' + id + ': ' + food + ', ' + exercise + ', ' + weight)
      
      axios.post('http://localhost:7777/record/add', { id, date, food, exercise, weight }).then(() => {
        alert('(' + date + ') 활동이 등록되었습니다!')
        
        this.fetchRecord(date)
        
        this.dialog = false
       }).catch(res => {
        alert(res.response.data.message)
      })
      
      
      
    },
  }
}
</script>