<template>
  <div class="monster">
    <router-link :to="{ name: 'MonsterSignupPage' }" 
      class="nav-link" 
      active-class="active">SignUp
    </router-link>
    <router-link :to="{ name: 'MonsterCreatePage' }" 
      class="nav-link" 
      active-class="active">Create
    </router-link>
    <router-link :to="{ name: 'MonsterGuidePage' }" 
      class="nav-link" 
      active-class="active">Guide
    </router-link>
    <router-link :to="{ name: 'MonsterDungeonPage' }" 
      class="nav-link" 
      active-class="active">Dungeon
    </router-link>
    
    <monster-header></monster-header>
    <monster-input v-on:addMonster="onAddMonster"></monster-input>
    <monster-hundred-input v-on:addManyMonster="onAddManyMonster"></monster-hundred-input>
    <monster-list v-on:death="onDeath"></monster-list>
  </div>
</template>


<script>
import { mapActions } from 'vuex'
import MonsterHeader from '@/components/monster/MonsterHeader'
// import MonsterAttack from '../components/quiz/MonsterAttack.vue'
import MonsterInput from '@/components/monster/MonsterInput'
import MonsterList from '@/components/monster/MonsterList'
import MonsterHundredInput from '@/components/monster/MonsterHundredInput'


export default {
  name: 'Monster',
  components: {
    'monster-header': MonsterHeader,
    // 'monster-attack': MonsterAttack
    'monster-input': MonsterInput,
    'monster-list': MonsterList,
    'monster-hundred-input': MonsterHundredInput
  },
  data () {
    return {
      me: {
        atk: 10
      },
      monsters: {
      name: '슬라임',
      hp: 3000
      },
      monsterBook: [
            { name: '리자드', type: '불꽃', hp: 1653, exp: 17, money: 2500 },
            { name: '꼬부기', type: '물', hp: 946, exp: 9, money: 900 },
            { name: '피카츄', type: '전기', hp: 938, exp: 9, money: 900 },
            { name: '푸크린', type: '페어리', hp: 1926, exp: 20, money: 2000 },
            { name: '데구리', type: '바위', hp: 1897, exp: 22, money: 2500 },
            { name: '아라리', type: '풀', hp: 1175, exp: 10, money: 1500 },
            { name: '루주라', type: '얼음', hp: 2555, exp: 28, money: 3000 },
            { name: '디그다', type: '땅', hp: 676, exp: 7, money: 800 },
            { name: '메타몽', type: '노말', hp: 832, exp: 10, money: 1000 },
            { name: '망나뇽', type: '드래곤', hp: 3792, exp: 50, money: 5000 },
            { name: '포니타', type: '불꽃', hp: 1697, exp: 20, money: 3000 },
            { name: '고오스', type: '고스트', hp: 1229, exp: 15, money: 2000 },
            { name: '킹크랩', type: '물', hp: 2829, exp: 30, money: 3500 },
            { name: '샤미드', type: '물', hp: 3114, exp: 35, money: 4000 },
            { name: '암스타', type: '바위', hp: 2786, exp: 30, money: 3000 },
            { name: '프리져', type: '얼음', hp: 3051, exp: 35, money: 3500 },
            { name: '해너츠', type: '풀', hp: 395, exp: 5, money: 500 },
            { name: '메리프', type: '전기', hp: 991, exp: 10, money: 1500 },
            { name: '코코리', type: '땅', hp: 1206, exp: 12, money: 2000 },
            { name: '코코미', type: '얼음', hp: 1069, exp: 10, money: 1500 },
            { name: '마릴리', type: '페어리', hp: 1588, exp: 20, money: 2500 },
            { name: '밀탱크', type: '노말', hp: 2354, exp: 25, money: 3000 },
            { name: '게을킹', type: '노말', hp: 4431, exp: 60, money: 10000 },
            { name: '잠만보', type: '노말', hp: 3225, exp: 35, money: 5000 },
            { name: '그란돈', type: '땅', hp: 4115, exp: 45, money: 7000 },
            { name: '펄기아(1)', type: '물', hp: 8991, exp: 100, money: 20000 },
            { name: '칠색조(1)', type: '불꽃', hp: 13863, exp: 150, money: 30000 },
            { name: '레쿠쟈(1)', type: '드래곤', hp: 18835, exp: 200, money: 50000 },
            { name: '히드런(1)', type: '강철', hp: 23754, exp: 250, money: 80000 },
            { name: '보만다(1)', type: '드래곤', hp: 33749, exp: 350, money: 100000 },
            { name: '펄기아(2)', type: '물', hp: 58991, exp: 500, money: 150000 },
            { name: '칠색조(2)', type: '불꽃', hp: 73863, exp: 700, money: 180000 },
            { name: '레쿠쟈(2)', type: '드래곤', hp: 88835, exp: 900, money: 200000 },
            { name: '히드런(2)', type: '강철', hp: 103754, exp: 1200, money: 250000 },
            { name: '보만다(2)', type: '드래곤', hp: 133749, exp: 1500, money: 300000 },
            { name: '펄기아(3)', type: '물', hp: 158991, exp: 500, money: 400000 },
            { name: '칠색조(3)', type: '불꽃', hp: 173863, exp: 700, money: 480000 },
            { name: '레쿠쟈(3)', type: '드래곤', hp: 218835, exp: 900, money: 550000 },
            { name: '히드런(3)', type: '강철', hp: 303754, exp: 1200, money: 650000 },
            { name: '보만다(3)', type: '드래곤', hp: 433749, exp: 1500, money: 7300000 },
        ]
    }
  },
  methods: {
    ...mapActions ([
      'addMonster',
      'death',
      'save',
      'addManyMonster',
    ]),
    onAddMonster (name) {
      const monsterElement = { name }
      this.addMonster(monsterElement)
      this.save()
    },
    onAttack (content) {
      // {}로 받으면 객체로 받게 됨
      const skill = { content }
      this.monsters.hp -= this.me.atk * skill.content
    },
    onDeath (monsterId) {
      this.death(monsterId)
      this.save()
    },
    onAddManyMonster () {
      var monsterList = []
      
      for (var i = 0; i < 100; i++) {
          var rand = Math.floor(Math.random() * this.monsterBook.length)
          monsterList.push({ monsterId: i, name: this.monsterBook[rand].name, hp: this.monsterBook[rand].hp })
      }
      this.addManyMonster(monsterList)
      this.save()
    },
  }
}
</script>


<style scoped>

body {
  text-align: center;
  background-color: rgb(255, 255, 248);
}

</style>