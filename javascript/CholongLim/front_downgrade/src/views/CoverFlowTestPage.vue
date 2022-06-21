<template>
    <v-container>
        <br><br><br>
        <coverflow :coverList="coverList" :coverWidth="260" :index="2"></coverflow>
    </v-container>
</template>

<script>

import coverflow from 'vue-coverflow'
export default {
    name: 'CoverflowTestPage',
    data() {
        return {
            coverList: [
                {
                    // cover: require('@/assets/img/malamute.jpg),
                    cover: 'https://cdnimg.melon.co.kr/cm2/album/images/105/54/246/10554246_20210325161233_500.jpg?304eb9ed9c07a16ec6d6e000dc0e7d91/melon/optimize/90', 
                    title: 'Lilac'
                },
                {
                    cover: 'https://ww.namu.la/s/bded2b2e08e690ab4dafcf6931ca23742efa29aba60d55350816c3441e0d6208849b946c8d683aed2850de028019702746ab51626cc3d4a036d7c0d550c8d7c5e599a445d54cac35513734961eaf270fd87f6abc85e1ffe68b47ec9546a61c55', 
                    title: 'Love Poem'
                },
                {
                    cover: 'https://ww.namu.la/s/630fae57a8926f88019c0a4d1895e025daff5e87a8e0e9e3b7f1ab469354bb998a882f00075cf07487440a0c0059aa3cccad56461387f822f398d0e92c6adda6faea93e14999d329a9ae4bd0a1ab6116109fc01b3f56a5d42f722c610cb8165d5b9de660c9e6e8b4d195fa824ec64cc6', 
                    title: 'flower'
                },
                {
                    cover: 'https://w.namu.la/s/435956cb028808dfb02861f48564d2f29fbd34b79b0549ebe8ea391d03ea039824ccd45e639390391dc487b5ace8c542f2115590fbca9238870a13e3fb4c4a5cf011a7d84b815bd19fb08a71dcda9a0e90aa6cf7fcdf8f1f30c58747989a78457c7f840f50cad0320e8b027282947306', 
                    title: 'Modern Times'
                },
                {
                    cover: 'https://cdnimg.melon.co.kr/cm/album/images/100/56/666/10056666_500.jpg?6aeddbe69ee3e13388eb0d9b81adaca8', 
                    title: 'palette'
                },
                {
                    cover: 'https://cdnimg.melon.co.kr/cm2/album/images/104/26/648/10426648_20200506153340_500.jpg?0ed92b652a9149e26387233529a32781', 
                    title: 'eight'
                },
            ]
        }
    },
    components: {
        coverflow
    }
}
</script>