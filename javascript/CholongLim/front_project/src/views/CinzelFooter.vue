<template>
  <!-- <v-footer
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

          <p style="text-align:center;"><strong>PENSION</strong> CINZEL 
          <strong> ADDRESS </strong> 제주 서귀포시 중문관광로72번길 75</p>
      </div>
      <div class="justify center">
        <v-card-text>
          {{ new Date().getFullYear() }} — <strong>COPYRIGHT(C) CINZEL PENSION. ALL RIGHTS RESERVED.</strong>
        </v-card-text>
      </div>
    </v-container>
  </v-footer> -->

   <v-footer
    
    padless
  >
    <v-card
      flat
      width="100vw"
      tile
      class="grey lighten-3 text-center"
    >
      <div class="justify center">

      <v-card-text class="pt-0">
         <p style="margin-top:1%;"><b>이용약관</b><b style="padding-left:1%;">개인정보처리방침</b><b style="padding-left:1%;">비즈니스</b><b style="padding-left:1%;">위치기반서비스이용약관</b><b style="padding-left:1%;">고객센터</b></p>
        <p style="margin-bottom:3px;"><b>PENSION</b> CINZEL <b style="padding-left:1%;">ADDRESS</b> 제주 서귀포시 중문관광로72번길 75 <b style="padding-left:1%;">BUSINESS LICENSE</b> 159-38-000965 (대표 : cinzel) </p>
        <p style="margin-bottom:3px;"><b>BUSINESS LICENSE</b> 428-12-00319 (대표 : cinzel)<b style="padding-left:1%;">MAIL ORDER LICENSE</b> 제2021-제주서귀포-0072호</p>
      </v-card-text>
      </div>

      <v-divider></v-divider>

      <v-card-text>
          {{ new Date().getFullYear() }} — <strong>COPYRIGHT(C) CINZEL PENSION. ALL RIGHTS RESERVED.</strong>
        </v-card-text>
    </v-card>
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
