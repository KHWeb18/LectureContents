<template>
  <v-card>
    <v-card-title v-if="date">
      <p>{{date}}</p>
    </v-card-title>
    <v-card-text v-if="!contents">
      <p>활동 기록이 없습니다.</p>
      <v-btn @click="onpenForm">추가하기</v-btn>
    </v-card-text>
    
    <v-dialog v-model="formDialog" hide-overlay persistent max-width="500px">
      <v-card>
        <v-card-title>
          <p>활동 기록하기</p>
          <v-card-text>
            <v-radio-group v-model="radioGroup" row>
              <v-radio v-for="activity in activities" :key="activity" :label="`${activity}`" color="secondary"></v-radio>
            </v-radio-group>
            <v-textarea solo name="input-7-4" label="활동을 기록하세요." v-model="content"></v-textarea>
            <v-btn @click="closeForm">cancel</v-btn>
            <v-btn @click="register">ok</v-btn>
          </v-card-text>
        </v-card-title>
      </v-card>
    </v-dialog>
  </v-card>

  
 
    
<!--
  <v-dialog v-model="dialog" hide-overlay persistent max-width="500px">
    <v-card>
      <v-card-title>
        <p>나의 기록들</p>
      </v-card-title>
      
      <v-card-text v-if="!contents">
        <p>활동 기록이 없습니다.</p>
        <v-btn @click="closeDetail">cancel</v-btn>
        <v-btn @click="onpenForm">추가하기</v-btn>
      </v-card-text>

    </v-card>
  </v-dialog>
-->
    
</template>


<script>
import { mapState } from 'vuex'
import axios from 'axios'

export default {
  name: 'RecordForm',
  data () {
    return {
      contents: null,
      radioGroup: 0,
      activities: [ '식단', '운동', '체중' ],
      content: null,
      formDialog: false
    }
  },
  computed: {
    ...mapState ([ 'date', 'dialog' ])
  },
  methods: {
    closeDetail () {
      this.$store.commit('CLOSE_DETAIL')
    },
    onpenForm () {
      this.formDialog = true
    },
    closeForm () {
      this.formDialog = false
    },
    register () {
      let activity
      
      switch (this.radioGroup) {
        case 0:
          activity = '식단'
          break
        case 1:
          activity = '운동'
          break
        case 2:
          activity = '체중'
          break
      }
      const content = this.content
      const date = this.date

      console.log(activity + ', ' + content + ', ' + date)
      
      axios.post('http://localhost:7777/register', { activity, content, date }).then(() => {
        console.log(activity + ', ' + content + ', ' + date)
        alert(activity + '이 등록되었습니다!')
       }).catch(res => {
        alert(res.response.data.message)
      })
      
      this.formDialog = false
      
    }
  }
  
}
</script>
