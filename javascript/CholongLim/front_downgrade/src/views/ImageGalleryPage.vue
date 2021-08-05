<template>
    <v-container>
        <v-row>
            <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
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
    name: 'ImageGalleryPage',
    data () {
        return {
            images: [
                // require('@/assets/img/malamute.jpg')
                "https://cdnimg.melon.co.kr/cm/album/images/102/65/079/10265079_500.jpg?a61faadae4e836b5339b15a54b3b9525/melon/resize/282/quality/80/optimize",
                "https://cafe24img.poxo.com/withdrama/web/product/big/20191223/181156a3dfb028881af9407266c95f20.jpg",
                "http://image.yes24.com/momo/TopCate851/MidCate009/84865363.jpg",
                "https://w.namu.la/s/a2e864023730426032cdf7f6f55329a5e2d74ded5c8f33d9f2713fcef2b1234613c06bed07b257d1c68131e21684626bb7a50b16d419534d89137b571cfc0fb402cfc4d8e97e90c80c25423d8a114f184c60e28004edad3fd8de395c538c478a",
                "https://cdn.notefolio.net/img/4d/6a/4d6a11236631ee7305dd4e18943733211c991c8442ee7b134de3a8adf077b17a_v1.jpg",
                "http://image.yes24.com/goods/61508337/XL",
                "https://pbs.twimg.com/media/E5mhAOVVIAQRxl9.jpg",
                "https://file.mk.co.kr/meet/neds/2019/07/image_readtop_2019_549689_15637599973835954.jpg",
                "https://i1.sndcdn.com/artworks-000221462612-im0udo-t500x500.jpg"
            ]
        }
    }
}
</script>

<style scoped>


</style>