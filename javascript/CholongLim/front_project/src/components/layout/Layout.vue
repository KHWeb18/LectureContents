<template>
    <v-app id="inspire">

        <div>
        <v-flex xs4 sm6 md12>
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/4254556/pexels-photo-4254556.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
            </v-img>
        </div>
        <div class="section">
            <h5>" Once a year, go somewhere you have never been before. "</h5>
        </div>
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL TOUR</h1>
            <p>| 관광 |</p>
        </v-container>
        <v-divider></v-divider>

        

        <v-row align="center" justify="center">
        <div >
            <iframe width="900" height="506" src="https://www.youtube.com/embed/a8taNpbLV4Y" 
                    style="margin-top:5%; margin-bottom:5%; position: relative;"
                    title="YouTube video player" frameborder="0" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                    allowfullscreen>
            </iframe>
   
        </div>
        </v-row>


        <slot name="tour"></slot>

        <v-container>
            <v-main id="content">
                <slot name="content" class="font">
                </slot>
            </v-main>
        </v-container>
        </v-flex>
        </div>
    </v-app>
</template>

<script>
import router from '@/router'
export default {
    data () {
        return {
            drawer: false,
            left: false
        }
    },
    methods: {
        home () {
            (window.location.pathname !== '/') ? router.push('/') : router.go(0)
        },
        category () {
            (window.location.pathname !== '/cinzel') ? router.push('/cinzel') : router.go(0)
        }
    }
}
</script>

<style scoped>



.video-container{
    margin-top: 5%;
    margin-bottom: 5%;
    position: relative;
    width: 10%;
}
.about-img-top {
    max-height: 70vh;
}


.section {
    background: #dcdfdc;
    height: 10vh;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}

.about-top {
    padding-top: 10vh;
}

h1 {
    font-family: "Cinzel";
    font-size: 40px;
    text-align: center;
    margin-top: 10px;
}

h5 {
    font-family: 'Nanum Myeongjo';
    font-size: 20px;
    text-align: center;
}
</style>