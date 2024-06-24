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
                require('@/assets/img/jeep.jpeg'),
                require('@/assets/img/k8.jpeg'),
                require('@/assets/img/Spyder.jpeg'),
                require('@/assets/img/tesla_model_x.jpeg'),
                "https://media.vlpt.us/images/devpark/post/3f691ef0-d5de-4fc2-81d0-951d8ed8a36d/Ekran-Resmi-2019-11-18-18.08.13.png",
                "https://d2.naver.com/content/images/2020/12/1228.png",
                "https://flutter-kr.io/images/flutter-logo-sharing.png"
            ]
        }
    }
}
</script>