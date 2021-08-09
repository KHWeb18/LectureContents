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

import '@morioh/v-lightbox/dist/lightbox.css'

export default {
    name: 'ImageGalleryTestPage',
    data (){
        return {
            images: [
                require('@/assets/imgs/spyder.png'),
                require('@/assets/imgs/X.png'),
                require('@/assets/imgs/Wrangler.png'),
                "http://www.autoview.co.kr/picture/review/201712052202300_1.jpg",
                "http://www.autoherald.co.kr/news/photo/202003/37363_63110_5350.png",
                "https://cdn.top-rider.com/news/photo/202102/60679_125907_1153.jpg",


            ]
        }
    }
}
</script>