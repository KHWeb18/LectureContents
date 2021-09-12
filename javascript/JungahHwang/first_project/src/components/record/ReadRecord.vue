<template>
  <v-card class="my-7 mr-7 primary" flat>
    <v-card v-if="!isLogin" class="primary" flat>
      <v-card-text>
        <p class="headline">로그인 해주세요.</p>
      </v-card-text>
    </v-card>

    <v-card v-else flat>
      <v-card v-if="!record || (Array.isArray(record) && record.length === 0)">
        <v-card-text>
          <p>{{ selectDate }}의 기록이 없습니다.</p>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <add-record></add-record>
        </v-card-actions>
      </v-card>  

      <v-card v-else height="375">
        <v-card-title class="headline">{{ selectDate }}</v-card-title>
    
        <v-card-text>
          <v-list>
            <v-list-item two-line>
              <v-list-item-content>
                <v-list-item-title>식단</v-list-item-title>
                <v-list-item-subtitle>{{ record.food }}</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>

            <v-list-item two-line>
              <v-list-item-content>
                <v-list-item-title>운동</v-list-item-title>
                <v-list-item-subtitle>{{ record.exercise }}</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>

            <v-list-item two-line>
              <v-list-item-content>
                <v-list-item-title>체중</v-list-item-title>
                <v-list-item-subtitle>{{ record.weight }}</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-list> 
        </v-card-text>  


        <v-card-actions class="mt-5">
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
import AddRecord from '@/components/record/AddRecord'
import ModifyRecord from '@/components/record/ModifyRecord'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

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
    ...mapState ([ 'selectDate', 'record', 'isLogin' ]),
  },
  methods: {
    ...mapActions([ 'fetchRecord' ]),

    deleteRecord () {
      const date = this.selectDate

      axios.delete(`http://localhost:7777/record/remove/${date}`).then(() => {
        alert(date + ' 의 활동이 삭제되었습니다!')
        
        this.fetchRecord(date)

      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
  
}
</script>
