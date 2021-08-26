<template>
  <v-card>
    <v-card v-if="!isLogin">
      <v-card-text>
        <p>로그인을 해주세요!</p>
      </v-card-text>
    </v-card>

    <v-card v-else>
      <v-card v-if="!activity || (Array.isArray(activity) && activity.length === 0)">
        <v-card-text>
          <p>{{ date }}의 활동 기록이 없습니다.</p>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <add-record></add-record>
        </v-card-actions>
      </v-card>  

      <v-card v-else>
        <v-card-text>
          <v-list-item-title>
            <p>{{ date }}의 활동 기록</p>
          </v-list-item-title>
          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title>식단</v-list-item-title>
              <v-list-item-subtitle>{{ activity.food }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title>운동</v-list-item-title>
              <v-list-item-subtitle>{{ activity.exercise }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title>체중</v-list-item-title>
              <v-list-item-subtitle>{{ activity.weight }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-card-text>  
        <v-card-actions>
          <v-btn @click="deleteRecord" icon small color="secondary" class="pa-6">
            <v-icon>mdi-delete</v-icon>
          </v-btn>
          <v-spacer></v-spacer>
          <modify-record></modify-record>
        </v-card-actions>
      </v-card>
    </v-card>
  </v-card>
</template>


<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
import AddRecord from './AddRecord.vue'
import ModifyRecord from './ModifyRecord.vue'

export default {
  name: 'RecordForm',
  components: {
    AddRecord,
    ModifyRecord
  },
  data () {
    return {

    }
  },
  computed: {
    ...mapState ([ 'date', 'activity', 'isLogin' ]),
  },
  methods: {
    ...mapActions(['fetchActivity']),
    deleteRecord () {
      const date = this.date

      axios.delete(`http://localhost:7777/record/remove/${date}`).then(() => {
        alert(date + ' 의 활동이 삭제되었습니다!')
        this.fetchActivity(this.date)
      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
  
}
</script>
