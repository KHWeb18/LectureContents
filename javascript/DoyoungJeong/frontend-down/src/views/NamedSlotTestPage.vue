<template>
    <div id="app">
        <child-com :ran_album="ranAlbum">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/21guns.jpg"/>
                    <figcaption>21 Guns</figcaption>
                </figure>
                <!-- figure는 그림과 글짜를 한꺼번에 묶는것, figcaption은 이미지에 들어가는 캡션 -->
            </div>
            <div slot="footer">
                <footer>
                    <p>&copy; All right reserved</p>
                </footer>
            </div>
        </child-com>
    </div>
</template>

<script>

import ChildCom from '@/components/slot/ChildCom.vue'

export default {
    name: 'NamedSlotTestPage',
    components: {
        'child-com': ChildCom
    },
    data() {
        return {
            albums: [
                { singer_Name: 'slash', pic: require('@/assets/img/slash.jpg') },
                { singer_Name: 'liam', pic: require('@/assets/img/liam.jpeg') },
                { singer_Name: 'theQuite', pic: require('@/assets/img/theQuiett.jpg') }
            ]
        }
    },
    computed: {
        ranAlbum() {
            return this.albums[Math.floor(Math.random()*this.albums.length)]
        }
    }
}
</script>
