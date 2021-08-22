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
        <v-btn text router :to="{name: 'ManagerLogin'}">관리자 로그인</v-btn>
        <p style="text-align:center;"><strong>PENSION</strong> CINZEL 
        <strong> ADDRESS </strong> 제주 서귀포시 중문관광로72번길 75</p>
         <v-card-text>
        {{ new Date().getFullYear() }} — <strong>COPYRIGHT(C) CINZEL PENSION. ALL RIGHTS RESERVED.</strong>
      </v-card-text>
    </v-container>
    <!-- <v-card
      flat
      tile
      class="blue darken-4 white--text text-center"
    >
      <v-card-text>
        <v-btn
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon size="24px">
            {{ icon }}
          </v-icon>
        </v-btn>
      </v-card-text>
      <v-btn text class="white--text">관리자 로그인</v-btn>

      <v-card-text class="white--text pt-0" style="width: 100vw;">

        <p style="text-align:center;"><strong>PENSION</strong> CINZEL 
        <strong> ADDRESS </strong> 제주 서귀포시 중문관광로72번길 75</p>
        
        
        I’ve got my ticket for the long way round
        Two bottles of whiskey for the way
        And I sure would like some sweet company
        I’m leaving tomorrow what do you say
         I’ve got my ticket for the long way round
        Two bottles of whiskey for the way
        And I sure would like some sweet company
        I’m leaving tomorrow what do you say
         I’ve got my ticket for the long way round
        Two bottles of whiskey for the way
        And I sure would like some sweet company
        I’m leaving tomorrow what do you say
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        {{ new Date().getFullYear() }} — <strong>COPYRIGHT(C) CINZEL PENSION. ALL RIGHTS RESERVED.</strong>
      </v-card-text>
    </v-card> -->
  </v-footer>
</template>


<script>
  export default {
    data: () => ({
      icons: [
        'home',
        'phone_in_talk',
        'event_available'
      ],
    }),
  }
</script>
