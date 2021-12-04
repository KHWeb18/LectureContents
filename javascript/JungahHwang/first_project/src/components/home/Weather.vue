<template>
  <v-card class="pb-5 primary">
    <v-card class="pa-3 mx-auto primary" max-width="100%" flat>
      <v-slide-group show-arrows>
        <v-slide-item v-for="city in cities" :key="city.name" v-slot="{ active }">
          <v-btn class="ma-2 white gray--text" :input-value="active" active-class="secondary secondary--text"
            depressed rounded @click="selectCity(city.name, city.eng)">
            {{ city.name }}
          </v-btn>
        </v-slide-item>
      </v-slide-group>
    </v-card>

    <v-divider></v-divider>

    <v-card class="primary" flat>
      <v-card-title class="headline gray--text font-weight-bold justify-center ma-5">
        {{ name }}
      </v-card-title>
      
      <v-card class="mx-auto primary" max-width="200" flat>
        <v-img width="200" :src="require(`@/assets/icon/weather/${icon}.png`)"></v-img>
      </v-card>

      <v-list class="primary">
        <v-list-item class="text-center">
          <v-list-item-title class="title font-weight-bold gray--text">
            날씨 {{ weather }}
          </v-list-item-title>
        </v-list-item> 

        <v-list-item class="text-center">
          <v-list-item-title class="gray--text">
            현재 기온 {{ temp }} ℃
          </v-list-item-title>
        </v-list-item>

        <v-list-item class="text-center">
          <v-list-item-title class="gray--text">
            습도 {{ clouds }} %
          </v-list-item-title>
        </v-list-item> 
      </v-list>

    </v-card>

    <v-card class="my-5 mx-auto text-center gray--text rounded-xl" max-width="300" flat>
      야외 운동하기 좋은 날씨에요.
    </v-card>
  </v-card>
</template>


<script>
import axios from 'axios'
export default {
  data () {
    return {
      temp: null,
      clouds: null,
      icon: '02d',
      weather: null,
      city: 'Seoul',
      name: '서울',
      cities: [
        { name: '서울', eng: 'Seoul'},
        { name: '인천', eng: 'Incheon'},
        { name: '광주', eng: 'Gwangju'},
        { name: '대구', eng: 'Daegu'},
        { name: '대전', eng: 'Daejeon'},
        { name: '부산', eng: 'Busan'},
        { name: '울산', eng: 'Ulsan'},
        { name: '제주', eng: 'Jeju'},
      ]
    }
  },
  beforeMount () {
    this.selectCity(this.name, this.city)
  },
  methods: {
    selectCity (name, city) {
      this.name = name

      const key = ''

      axios.get(`https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${key}`).then(res => {
        console.log(res.data)
        const list = res.data

        this.temp = Math.round(list.main.temp)
        this.clouds = list.clouds.all
        this.icon = list.weather[0].icon
        this.weatherCondition(list.weather[0].main)
      })
  
    },
    weatherCondition (data) {
      switch (data) {
        case 'Thunderstorm' :
          this.weather = '천둥번개'
          break
        case 'Drizzle' :
          this.weather = '이슬비'
          break
        case 'Rain' :
          this.weather = '비'
          break
        case 'Snow' :
          this.weather = '눈'
          break
        case 'Clear' :
          this.weather = '맑음'
          break
        case 'Clouds' :
          this.weather = '구름'
          break
        case 'Mist', 'Smoke', 'Fog' :
          this.weather = '안개'
          break
      }
    }
  }
}
</script>


<style scoped>
.gray--text {
  color:rgb(100, 100, 100)
}
</style>