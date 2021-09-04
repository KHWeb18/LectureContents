<template>
  <v-footer
    padless
    absolute
    inset
    app bottom fixed
    color="white darken-1"
  >
    <v-container>
      <div class="justify center">
          <v-icon size="50px" color="blue darken-2">room_service</v-icon>
          <p>CINZEL BOOKING</p>
          <h4>010.7751.8851</h4>
          <!-- <v-btn text  v-if="this.auth == '관리자'" router :to="{name: 'ManagerPage'}">관리자 페이지</v-btn> -->

          <p style="text-align:center;"><strong>PENSION</strong> CINZEL 
          <strong> ADDRESS </strong> 제주 서귀포시 중문관광로72번길 75</p>
      </div>
      <div class="justify center">
        <v-card-text>
          {{ new Date().getFullYear() }} — <strong>COPYRIGHT(C) CINZEL PENSION. ALL RIGHTS RESERVED.</strong>
        </v-card-text>
      </div>
    </v-container>
  </v-footer>
</template>


<script>

import { mapState } from 'vuex'
  export default {
    computed: {
        ...mapState(["isLogin"])
    },
    data() {
      return {
        icons: [
                'home',
                'phone_in_talk',
                'event_available'
        ]
      }
    }
  }
</script>
