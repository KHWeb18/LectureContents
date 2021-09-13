<!--<template>
    <Layout>
        <template #tour>
            <div  class="justify-center">
                <v-row align="center" justify="center">
                 <v-btn @click="start('서귀포+관광')" rounded color="light-blue lighten-2" class="crawler-btn"
                    style="padding: 0px; width: 150px; margin-left:15px;" large>#서귀포 관광지</v-btn>

                    <v-btn @click="food('서귀포+맛집')" rounded color="indigo lighten-2" class="crawler-btn"
                    style="padding: 0px; width: 150px; margin-left:15px;" large>#서귀포 맛집</v-btn>

                    <v-btn @click="cafe('서귀포+카페')" rounded color="purple lighten-2" class="crawler-btn"
                    style="padding: 0px; width: 150px; margin-left:15px;" large>#서귀포 카페</v-btn>
                </v-row>
            </div>
        </template>
        <template #content>
             <v-simple-table class="crawler">
                <template v-slot:default>
                    <tbody>
                        <tr v-for="list of lists" :key="list.title">
                            <td style="color: gray">{{ list.tourNo }}</td>
                            <td><a v-bind:href="list.address">{{ list.title }}</a></td>
                            
                        </tr>
                    </tbody>
                </template>
            </v-simple-table> 

        </template>

    </Layout>
</template>

<script>
import Layout from '@/components/layout/Layout'
import { mapState } from 'vuex'
export default {
    components: {
        Layout
    },
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        start (category) {
            this.$store.dispatch('crawlFind', category)
        },
        food (category) {
            this.$store.dispatch('crawlFind', category)
        },
        cafe (category) {
            this.$store.dispatch('crawlFind', category)
        }
    }
}
</script>

<style scoped>


.crawler-btn{
    text-align: center;
    margin: 0;
    color: white;
}
.crawler{
    width: 800px;
    text-align: center;
    position: relative;
    left:15%;
}

.crawler-color{
    background-color: rgb(233, 233, 233);
}
</style>-->


<template>
    <Layout>
        <menu-bar/>
        <template #tour>
            <div class="btn-back">
                <v-row align="center" justify="center">
                    <v-btn @click="start('서귀포+관광')" class="button2 b-green rot-135">#서귀포 관광</v-btn>
                    <v-btn @click="food('서귀포+맛집')" class="button2 b-pink rot-135">#서귀포 맛집</v-btn>
                    <v-btn @click="cafe('서귀포+카페')" class="button2 b-red rot-135">#서귀포 카페</v-btn>
                    <v-btn @click="market('제주+동문시장')" class="button2 b-orange rot-135">#제주 동문시장</v-btn>
                    <v-btn @click="souvenir('제주+기념품')" class="button2 b-blue rot-135">#제주 기념품</v-btn>
                </v-row>
            </div>
        </template>
        <template #content>
             <v-simple-table class="crawler" dense>
                <template v-slot:default>
                    <tbody>
                        <tr v-for="list of lists" :key="list.title">
                            <td style="color: gray">{{ list.tourNo }}</td>
                            <td><a v-bind:href="list.address" target="_blank">{{ list.title }}</a></td>
                            
                        </tr>
                    </tbody>
                </template>
            </v-simple-table> 
         
            
        </template>

    </Layout>
</template>

<script>
import Layout from '@/components/layout/Layout'
import { mapState } from 'vuex'

export default {
    components: {
        Layout
    },
     data () {
      return {
        jeju:[],
        headers: [
          {
            text: 'No',
            value: 'no'
          },
          { text: 'Content', value: 'content' },
        ],
        loading: false
      }
     },
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        start (category) {
            this.$store.dispatch('crawlFind', category)
        },
        food (category) {
            this.$store.dispatch('crawlFind', category)
        },
        cafe (category) {
            this.$store.dispatch('crawlFind', category)
        },
        market (category) {
            this.$store.dispatch('crawlFind', category)
        },
        souvenir (category) {
            this.$store.dispatch('crawlFind', category)
        }
    }
}
</script>

<style scoped>

.btn-back{
    margin-top:1%;
    text-align: center;
}


.crawler-btn{
    text-align: center;
    margin: 0;
    color: white;
}
.crawler{
    width: 800px;
    text-align: center;
    position: relative;
    left:15%;
}

.crawler-color{
    background-color: rgb(233, 233, 233);
}

/* d여기서부터 */
body {
  font-family: 'Roboto', sans-serif;
}
body, .button:after {
  background: #2c3e50;
}
.ctn {
  display: block;
  margin: auto;
  text-align: center;
}
footer {
  position: fixed;
  bottom: 5px;
  right: 5px;
  color: #FFF;
}
footer a, footer a:after {
  font-size: 1em !important;
}
/*END BODY*/

/*GRADIENTS*/
  /*GREEN*/
  .b-green, .b-green:before {
    background: rgba(73,155,234,1);
    background: -moz-linear-gradient(45deg, rgba(73,155,234,1) 0%, rgba(26,188,156,1) 100%);
    background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(73,155,234,1)), color-stop(100%, rgba(26,188,156,1)));
    background: -webkit-linear-gradient(45deg, rgba(73,155,234,1) 0%, rgba(26,188,156,1) 100%);
    background: -o-linear-gradient(45deg, rgba(73,155,234,1) 0%, rgba(26,188,156,1) 100%);
    background: -ms-linear-gradient(45deg, rgba(73,155,234,1) 0%, rgba(26,188,156,1) 100%);
    background: linear-gradient(45deg, rgba(73,155,234,1) 0%, rgba(26,188,156,1) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#499bea', endColorstr='#1abc9c', GradientType=1 );
  }
  /*PINK*/
  .b-pink, .b-pink:before {
    background: rgba(231,72,234,1);
    background: -moz-linear-gradient(45deg, rgba(231,72,234,1) 0%, rgba(75,26,188,1) 100%);
    background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(231,72,234,1)), color-stop(100%, rgba(75,26,188,1)));
    background: -webkit-linear-gradient(45deg, rgba(231,72,234,1) 0%, rgba(75,26,188,1) 100%);
    background: -o-linear-gradient(45deg, rgba(231,72,234,1) 0%, rgba(75,26,188,1) 100%);
    background: -ms-linear-gradient(45deg, rgba(231,72,234,1) 0%, rgba(75,26,188,1) 100%);
    background: linear-gradient(45deg, rgba(231,72,234,1) 0%, rgba(75,26,188,1) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e748ea', endColorstr='#4b1abc', GradientType=1 );
  }
  /*RED*/
  .b-red, .b-red:before {
    background: rgba(234,110,72,1);
    background: -moz-linear-gradient(45deg, rgba(234,110,72,1) 0%, rgba(188,26,99,1) 100%);
    background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(234,110,72,1)), color-stop(100%, rgba(188,26,99,1)));
    background: -webkit-linear-gradient(45deg, rgba(234,110,72,1) 0%, rgba(188,26,99,1) 100%);
    background: -o-linear-gradient(45deg, rgba(234,110,72,1) 0%, rgba(188,26,99,1) 100%);
    background: -ms-linear-gradient(45deg, rgba(234,110,72,1) 0%, rgba(188,26,99,1) 100%);
    background: linear-gradient(45deg, rgba(234,110,72,1) 0%, rgba(188,26,99,1) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ea6e48', endColorstr='#bc1a63', GradientType=1 );
  }
  /*ORANGE*/
  .b-orange, .b-orange:before {
    background: rgba(255,193,7,1);
    background: -moz-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
    background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(255,193,7,1)), color-stop(100%, rgba(255,87,34,1)));
    background: -webkit-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
    background: -o-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
    background: -ms-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
    background: linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffc107', endColorstr='#ff5722', GradientType=1 );
  }
  /*BLUE*/
  .b-blue, .b-blue:before {
    background: rgba(5,118,255,1);
    background: -moz-linear-gradient(45deg, rgba(5,118,255,1) 0%, rgba(36,248,255,1) 100%);
    background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(5,118,255,1)), color-stop(100%, rgba(36,248,255,1)));
    background: -webkit-linear-gradient(45deg, rgba(5,118,255,1) 0%, rgba(36,248,255,1) 100%);
    background: -o-linear-gradient(45deg, rgba(5,118,255,1) 0%, rgba(36,248,255,1) 100%);
    background: -ms-linear-gradient(45deg, rgba(5,118,255,1) 0%, rgba(36,248,255,1) 100%);
    background: linear-gradient(45deg, rgba(5,118,255,1) 0%, rgba(36,248,255,1) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#0576ff', endColorstr='#24f8ff', GradientType=1 );
  }
/*END GRADIENTS*/
/*BASE BUTTON*/
.button {
  display: inline-block;
  position: relative;
  border-radius: 3px;
  text-decoration: none;
  padding: .5em;
  margin: .5em;
  font-size: 2em;
  font-weight: bold;
  transition: all .5s;
  /* -webkit-background-clip: text; */
  -webkit-text-fill-color: transparent;
}
.button:hover {
  text-shadow: 0px 0px 0px rgba(255, 255, 255, .75);
}
/* .button:hover:after {
  left: 100%;
  top: 100%;
  bottom: 100%;
  right: 100%;
} */
/* .button:before {
  content: '';
  display: block;
  position: absolute;
  left: 0;
  top: 0;
  bottom: 0;
  right: 0;
  z-index: -1;
  border-radius: 5px;
  transition: all .5s;
} */
/* .button:after {
  content: '';
  display: block;
  position: absolute;
  left: 2px;
  top: 2px;
  bottom: 2px;
  right: 2px;
  z-index: -1;
  border-radius: 5px;
  transition: all .5s;
} */
.button2 {
  display: inline-block;
  font-size: 1.2em;
  margin: .4em;
  padding: .5em;
  border-radius: 5px;
  transition: all .5s;
  filter: hue-rotate(0deg);
  color: #FFF;
  text-decoration: none;
}
/*END BASE BUTTON*/
/*ROTATE*/
.rot-360-noscoop:hover {
  filter: hue-rotate(360deg);
  transform: rotate(360deg);
}
.rot-135:hover {
  filter: hue-rotate(135deg);
}
.rot-90:hover {
  filter: hue-rotate(90deg);
}
</style>
