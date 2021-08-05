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
    data () {
        return {
            images: [
                require('@/assets/img/21guns.jpg'),
                require('@/assets/img/liam.jpeg'),
                require('@/assets/img/slash.jpg'),
                require('@/assets/img/theQuiett.jpg'),
                "https://flutter-kr.io/images/flutter-logo-sharing.png",
                "https://miro.medium.com/max/768/1*8nyFLuZUdtMqWyu7H8glOg.png",
                "https://d2.naver.com/content/images/2020/12/1228.png"
            ]
        }
    }
}
</script>