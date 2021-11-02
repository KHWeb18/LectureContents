<template>
  <v-container>
    <v-row>
      <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
        <v-img :src="image" aspect-ratio="1" class="gery lighten-2">
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
              <v-progress-circular indeterminate color="grey lighten-5">
              </v-progress-circular>
            </v-row>
          </template>
        </v-img>
    </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'ImageGalleryTestPage',
  data() {
    return {
      images: [
        require('@/assets/img/car.jpeg'),
        require('@/assets/img/tesla.jpeg'),
        require('@/assets/img/nissan.jpeg'),
      ]
    }
  },
}
</script>