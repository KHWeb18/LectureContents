<template>
  <div class="out" style="text-align: center; vertical-align: middle">
    <vueper-slides class="in" :touchable="false" :bullets="false" :arrows="false" ref="first" style="width: 50%; height: 30%; display: inline-block;">

      <vueper-slide :key="1">
        <template v-slot:content>

            <div class="row" style="margin-top: 25px; justify-content: center;">
                <v-btn v-if="btnArr[0] == 0" class="ma-1" x-large color="red" plain @click="chooseGenre('ROCK', 0)">
                    <p class="genreText">Rock</p>
                </v-btn>
                <v-btn v-if="btnArr[0] == 1" class="ma-1" x-large color="red" plain disabled>
                    <p class="genreText">Rock</p>
                </v-btn>

                <v-btn v-if="btnArr[1] == 0" class="ma-1" x-large color="teal" plain @click="chooseGenre('HIP-HOP', 1)">
                    <p class="genreText">HipHop</p>
                </v-btn>
                <v-btn v-if="btnArr[1] != 0" class="ma-1" x-large color="red" plain disabled>
                    <p class="genreText">HipHop</p>
                </v-btn>

                <v-btn v-if="btnArr[2] == 0" class="ma-1" x-large color="primary" plain @click="chooseGenre('EDM', 2)">
                    <p class="genreText">EDM</p>
                </v-btn>
                <v-btn v-if="btnArr[2] != 0" class="ma-1" x-large color="red" plain disabled>
                    <p class="genreText">EDM</p>
                </v-btn>

                <v-btn v-if="btnArr[3] == 0" class="ma-1" x-large color="orange" plain @click="chooseGenre('JAZZ', 3)">
                    <p class="genreText">JAZZ</p>
                </v-btn>
                <v-btn v-if="btnArr[3] != 0" class="ma-1" x-large color="red" plain disabled>
                    <p class="genreText">JAZZ</p>
                </v-btn>

                <v-btn  v-if="btnArr[4] == 0" class="ma-1" x-large color="yellow" plain @click="chooseGenre('ACOUSTIC', 4)">
                    <p class="genreText">ACOUSTIC</p>
                </v-btn>
                <v-btn v-if="btnArr[4] != 0" class="ma-1" x-large color="red" plain disabled>
                    <p class="genreText">ACOUSTIC</p>
                </v-btn>
            </div>
            <div style="margin-top: 40px; margin-bottom: 20px;">
                <p class="footerText">선택한 장르 (클릭해서 삭제)</p>
                <div style="height: 15px;">
                    <p v-for="(genre, index) in chosenGenres" :key="index" 
                    class="footerText" style="display: inline; margin-right: 5px; font-size: 20px;" @click="removeGenre(index, $event)">{{ genre }}</p>
                </div>
            </div>
            <v-btn :loading="loading" class="ma-1" x-large color="error" plain @click="confirm">
                NEXT
            </v-btn>
         
        </template>
      </vueper-slide>

      <vueper-slide :key="2">
        <template v-slot:content>
            
            <div style="margin-top: 40px;">
                <p class="footerText">어떤 분위기의 음악을 좋아하시나요?</p>

                <div class="row" style="margin-top: 20px;">
                    <v-checkbox v-model="ex4" label="부드럽고 잔잔한" color="primary" value="primary" 
                    class="footerText" style="margin-right: 50px;"></v-checkbox> <!-- hide-details props는 뭐지???-->
                    
                    <v-checkbox v-model="ex4" label="적당히 신나는" color="success" value="primary" 
                    class="footerText" style="margin-right: 50px;"></v-checkbox>

                    <v-checkbox v-model="ex4" label="보통 정도의 잔잔함과 빠른" color="secondary" value="primary" 
                    class="footerText" style="margin-right: 50px;"></v-checkbox>

                    <v-checkbox v-model="ex4" label="꽤 빠르고 신나는" color="red darken-3" value="primary" 
                    class="footerText" style="margin-right: 50px;"></v-checkbox>

                    <v-checkbox v-model="ex4" label="빠르고 과격한" color="red" value="primary" 
                    class="footerText"></v-checkbox>
                </div>

                <v-btn :loading="disabled" class="ma-1" x-large color="error" plain @click="$refs.first.previous()">
                    BACK
                </v-btn>
                <v-btn :loading="loading" class="ma-1" x-large color="error" plain @click="confirm">
                    NEXT
                </v-btn>
            </div>

        </template>
      </vueper-slide>
      
      <vueper-slide :key="3"
        :style="'background-color: grey'">
        <template v-slot:content>
          <div>
            자기소개: <textarea/><br/>
            <button @click="$refs.first.previous()">이전</button>
            <button v-on:click="showAlert('가입을 축하드립니다')">가입완료</button>
          </div>
        </template>
      </vueper-slide>

    </vueper-slides>

  </div>
</template>

<script>
import { VueperSlides, VueperSlide } from 'vueperslides'
import 'vueperslides/dist/vueperslides.css'

export default {
    name: 'PreferenceBox',
    components: { 
        VueperSlides, 
        VueperSlide 
    },
    data() {
        return {
            loading: false,
            chosenGenres: [],
            btnArr: [0, 0, 0, 0, 0]
        }
    },
    methods: {
        showAlert(msg) {
        alert(msg);
        },
        async confirm() {

            if(this.chosenGenres.length == 0) {
                alert('최소 하나 이상의 장르를 선택해주세요!')
            } else {
                this.loading = true

                await new Promise(resolve => setTimeout(resolve, 2000))

                this.loading = false

                this.$refs.first.next()
            }
        },
        chooseGenre(genre, num) {
            this.chosenGenres.push(genre + ' ')

            for(var i=0; i<5; i++) {
                if(i==num) {
                    this.btnArr[i] = 1
                }
            }
        },
        removeGenre(index, $event) {
            this.chosenGenres.splice(index, 1)

            if($event.target.innerHTML == 'ROCK ') {
                this.btnArr[0] = 0
            } else if($event.target.innerHTML == 'HIP-HOP ') {
                this.btnArr[1] = 0
            } else if($event.target.innerHTML == 'EDM ') {
                this.btnArr[2] = 0
            } else if($event.target.innerHTML == 'JAZZ ') {
                this.btnArr[3] = 0
            } else if($event.target.innerHTML == 'ACOUSTIC ') {
                this.btnArr[4] = 0
            }

            
        }
    }
}
</script>

            