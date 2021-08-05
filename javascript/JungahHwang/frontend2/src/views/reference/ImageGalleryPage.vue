<template>
  <v-container>
    <v-row>
      <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
        <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
              <v-progress-circular indeterminate color="grey light-5"></v-progress-circular>
            </v-row>
          </template>
        </v-img>
      </v-col>
    </v-row>
  </v-container>
</template>


<script>

export default {
  name: 'ImageGalleryPage',
  data () {
    return {
      images: [
        require('@/assets/imgs/Maltese.jpg'),
        require('@/assets/imgs/Pomeranian.jpeg'),
        require('@/assets/imgs/Poodle.jpeg'),
        require('@/assets/imgs/Retriever.jpeg'),
        require('@/assets/imgs/Chihuahua.jpg'),
        require('@/assets/imgs/Spitz.jpg'),
        require('@/assets/imgs/Yorkshire Terrier.jpg'),
        require('@/assets/imgs/Beagle.jpg'),
      ]
    }
  }
}
</script>