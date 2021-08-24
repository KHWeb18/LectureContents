<template>
  <v-footer
    padless
    absolute
    inset
    app bottom fixed
  >
    <v-container class="justify center">
        <v-icon size="50px" color="blue darken-2">room_service</v-icon>
        <p>CINZEL BOOKING</p>
        <h4>010.7751.8851</h4>
        <v-btn text  v-if="isLogin === false" router :to="{name: 'ManagerLogin'}">관리자 로그인</v-btn>
        <v-btn text  v-if="isLogin" router :to="{name: 'MyPage'}">관리자 페이지</v-btn>

        <p style="text-align:center;"><strong>PENSION</strong> CINZEL 
        <strong> ADDRESS </strong> 제주 서귀포시 중문관광로72번길 75</p>
         <v-card-text>
        {{ new Date().getFullYear() }} — <strong>COPYRIGHT(C) CINZEL PENSION. ALL RIGHTS RESERVED.</strong>
      </v-card-text>
    </v-container>
  </v-footer>
</template>


<script>

import { mapState } from 'vuex'
  export default {
    computed: {
        ...mapState(["isLogin"])
    },
    data: () => ({
      icons: [
        'home',
        'phone_in_talk',
        'event_available'
      ],
    }),
  }
</script>
