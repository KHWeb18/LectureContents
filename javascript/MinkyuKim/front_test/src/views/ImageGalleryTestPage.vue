<!-- Vue Img LightBox
npm install @morioh/v-lightbox --save-dev
이건 아님 다른거 안되어서 다른거로 바꿈-->
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
                require('@/assets/img/test1.jpg'),
                require('@/assets/img/test2.jpg'),
                require('@/assets/img/test3.jpg'),
                "https://media.vlpt.us/images/devpark/post/3f691ef0-d5de-4fc2-81d0-951d8ed8a36d/Ekran-Resmi-2019-11-18-18.08.13.png",
                "https://t2.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/16Sg/image/57Z8R8ddbg5vEo9kaC_n-AoZEuk.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/BiyaRiver.JPG/250px-BiyaRiver.JPG"

            ]
        }
    }
    
}
</script>
