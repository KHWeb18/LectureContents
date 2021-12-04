<template>
  <v-card class="mt-5 pa-2" color="primary">
    <v-tooltip top>
      <template v-slot:activator="{on}">
        <p class="headline ma-3" v-on="on" @click="recordPage">Record</p>
      </template>
      <span>이동하기</span>
    </v-tooltip>

    <v-divider></v-divider>

    <v-card v-if="isLogin" class="primary" flat>
      <v-card-text v-if="!record" class="mb-16">
        오늘 기록이 없습니다.
      </v-card-text>
      
      <v-card-text v-else>
        <v-list class="primary ma-n3">
          <v-list-item>
            <v-list-item-title>식단</v-list-item-title>
            <v-list-item-subtitle>{{record.food}}</v-list-item-subtitle>
          </v-list-item>
          <v-list-item>
            <v-list-item-title>운동</v-list-item-title>
            <v-list-item-subtitle>{{record.exercise}}</v-list-item-subtitle>
          </v-list-item>
        </v-list>
      </v-card-text>
    </v-card>
    
    <v-card-text v-else class="mb-15">로그인 해주세요.</v-card-text>
    
  </v-card>
</template>


<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      record: null
    }
  },
  computed: {
    ...mapState([ 'isLogin' ]),
  },
  created () {
    axios.get(`http://localhost:7777/record/${this.date}`).then(res => {
      this.record = res.data
    })
  },
  methods: {
    recordPage () {
      this.$router.push(
        { name: 'Record' } 
      )
    }
  }
}
</script>