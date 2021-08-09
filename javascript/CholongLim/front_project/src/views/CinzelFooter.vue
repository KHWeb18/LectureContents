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
    </v-container>
    <v-card
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

      <v-card-text class="white--text pt-0">
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
        {{ new Date().getFullYear() }} — <strong>Cinzel Resort</strong>
      </v-card-text>
    </v-card>
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
