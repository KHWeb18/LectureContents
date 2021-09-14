<template>
  <v-card class="my-7 mr-7 primary" flat>
    <v-card v-if="!isLogin" class="primary" flat>
      <v-card-text>
        <p class="title">로그인 해주세요.</p>
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

      <v-card v-else>
        
    
        <v-card-text>

          <v-list>
            <v-list-item two-line>
              <v-list-item-content>
                <p class="title font-weight-bold gray--text">식단</p> 
                <p class="subtitle-1">{{record.food}}</p>
              </v-list-item-content>
            </v-list-item>

            <v-list-item two-line>
              <v-list-item-content>
                <p class="title font-weight-bold gray--text">운동</p>
                <p class="subtitle-1">{{ record.exercise }}</p>
              </v-list-item-content>
            </v-list-item>

            <v-list-item two-line>
              <v-list-item-content>
                <p class="title font-weight-bold gray--text">체중</p>
                <p class="subtitle-1">{{ record.weight }}</p>
              </v-list-item-content>
            </v-list-item>
          </v-list> 
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
    ...mapActions([ 'fetchRecord', 'fetchRecords' ]),

    deleteRecord () {
      const date = this.selectDate

      axios.delete(`http://localhost:7777/record/remove/${date}`).then(() => {
        alert('(' + date + ') 활동이 삭제되었습니다!')
        
        this.fetchRecord(date)

        this.fetchRecords()

      }).catch(() => {
      })
    }
  }
  
}
</script>


<style scoped>
.gray--text {
  color:rgb(100, 100, 100)
}
</style>
