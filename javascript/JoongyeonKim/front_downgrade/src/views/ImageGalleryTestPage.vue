<template>
    <v-container>
        <v-row>
            <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
                <v-img :src="image" aspect-ratio="1" class="gery lighten-2">
                    <template>
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
    name:'ImageGalleryTestPage',
    components: {
    },
    data () {
        return {
            images: [
                require('@/assets/img/nissan_maxima.png'),
                "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmiro.medium.com%2Fmax%2F1200%2F1*YaThnxIlm3UOG6kPJcFnYQ.jpeg&type=l340_165",
                require('@/assets/img/Spyder.jpg'),
                require('@/assets/img/Spyder.jpg'),
                require('@/assets/img/Spyder.jpg')
            ]
        }
    }
}
</script>