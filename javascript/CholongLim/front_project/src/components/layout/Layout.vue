<template>
    <v-app id="inspire" class="tour-back">
        <div>
        <v-flex xs4 sm6 md12>
            <div class="container">
                <h1 style="margin-top:0%">in  JEJU</h1>

                <div class="gallery-wrap">
                    <div class="item item-1"></div>
                    <div class="item item-2"></div>
                    <div class="item item-3"></div>
                    <div class="item item-4"></div>
                    <div class="item item-5"></div>
                </div>
            </div>

        <slot name="tour"></slot>

        <v-container style="margin-left:12%;">
            <v-row align="center" justify="center">
            <v-main id="content">
                <slot name="content">
                </slot>
            </v-main>
            </v-row>
        </v-container>
        </v-flex>
        </div>
    </v-app>
</template>

<script>

export default {
    data () {
        return {
            drawer: false,
            left: false
        }
    }
}
</script>

<style lang="scss" scoped>



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

html,body{
  width: 100%;
  height: 100%;
}

.container{
  margin: 0 auto;
  width: 1140px;
}


.gallery-wrap {
  display: flex;
  flex-direction: row;
  width: 100%;
  height: 70vh;
}

.item {
  flex: 1;
  height: 100%;
  background-position: center;
  background-size: cover;
  background-repeat: none;
  transition: flex 0.8s ease;
  
  &:hover{
    flex: 7;
  }
}

.item-1 { 
  background-image: url('https://blog.kakaocdn.net/dn/o1KIw/btqu9mflPY6/rGk1mM3iugV1c6jj9Z3E80/img.jpg');
}
.item-2 { 
  background-image: url('https://blog.kakaocdn.net/dn/LxAwX/btqLNspkM4Z/Wf5VfdXahJMzhLEzHU18F0/img.jpg');
}

.item-3 { 
  background-image: url('https://kr.blog.kkday.com/wp-content/uploads/jeju_cafe_soem_aensseom_2.jpg');
}

.item-4 { 
  background-image: url('https://t1.daumcdn.net/cfile/tistory/991A3B505DE36B0014');
}

.item-5 { 
  background-image: url('https://mblogthumb-phinf.pstatic.net/MjAyMDA4MTBfMjQ4/MDAxNTk3MDI1NTc4ODYy.7S9-t-xXoRuXgbD51sSFZqRLsC2_msB2WXSP-LzY3Ogg.vOaerSQK78DxYru-yFRT1NCvubIKB3CMa7hkDWoBpoAg.JPEG.face8901/12.jpg?type=w800');
}


</style>