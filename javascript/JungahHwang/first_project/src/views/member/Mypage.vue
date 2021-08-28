<template>
  <v-card flat>
    <v-card v-if="!isLogin" flat class="ma-3">
      <v-card-text >
        <p>로그인을 해주세요.</p>
      </v-card-text>
    </v-card>
    
    <v-card v-else flat class="ma-3">
      <v-card-text>
        <v-list-item-title>
          <p>{{ userInfo.name }}님의 회원정보</p>
        </v-list-item-title>
        
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>이름</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.name }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>생일</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.name }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>성별</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.birth }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>이메일</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.email }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>핸드폰</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.phone }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>주소</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.address }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>

      </v-card-text>
      <v-card-actions>
        <v-btn icon small color="secondary" class="pa-6">
          
        </v-btn>
        <v-spacer></v-spacer>
        
      </v-card-actions>
    </v-card>
  </v-card>
</template>


<script>
import { mapState } from 'vuex'

export default {
  name: 'Mypage',
  data () {
    return {
      
    }
  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  }
}
</script>