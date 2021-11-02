<template>
    <div class="homework">
        <homework-header></homework-header>
        <homework-monster-input v-on:addMonster="onAddMonster"></homework-monster-input>
        <monster-hundred-input v-on:addManyMonster="onAddManyMonster"></monster-hundred-input>
        <!--<monster-attack v-on:firsSkill="onFirstSkill"></monster-attack>-->
        <monster-list
            v-on:death="onDeath"
            >  
            </monster-list>
        <!--<p>이름: {{ monsters.name }} hp: {{ monsters.hp}}</p>-->
    </div>
</template>

<script>

import HomeworkHeader from '../components/homework/HomeworkHeader.vue'
//import MonsterAttack from '../components/homework/MonsterAttack.vue'
import MonsterList from '../components/monster/MonsterList.vue'
import HomeworkMonsterInput from '../components/monster/HomeworkMonsterInput.vue'
import MonsterHundredInput from '../components/monster/MonsterHundredInput.vue'

import {mapActions} from 'vuex'


export default {

    name: 'Homework',
    components:{
        'homework-header': HomeworkHeader,
        'homework-monster-input' : HomeworkMonsterInput,
        'monster-hundred-input' : MonsterHundredInput,
        //'monster-attack': MonsterAttack,
        'monster-list': MonsterList

    },
    data(){
        return{
            charcter:{
                atk:5
            },
            monsters:{
                name: '슬라임',
                hp: 30
            },
            monsterBook: [
                { name: '슬라임', hp: 30, exp: 1, money: 10 },
                { name: '고블린', hp: 50, exp: 2, money: 20 },
                { name: '레드 슬라임', hp: 70, exp: 4, money: 40 },
                { name: '홉 고블린', hp: 120, exp: 8, money: 80 },
                { name: '그린 슬라임', hp: 150, exp: 12, money: 160 },
                { name: '스켈레톤', hp: 200, exp: 20, money: 320 },
                { name: '고블린 마법사', hp: 250, exp: 25, money: 640 },
                { name: '블루 슬라임', hp: 300, exp: 35, money: 1280 },
                { name: '트롤', hp: 500, exp: 50, money: 2000 },
                { name: '원혼', hp: 700, exp: 60, money: 4000 },
                { name: '고블린 족장', hp: 800, exp: 70, money: 5000 },
                { name: '스켈레톤 기사', hp: 1000, exp: 80, money: 10000 },
                { name: '오우거', hp: 1200, exp: 90, money: 12000 },
                { name: '오우거 메이지', hp: 1500, exp: 100, money: 15000 },
                { name: '스켈레톤 근위병', hp: 2000, exp: 120, money: 20000 },
                { name: '고블린 대사장', hp: 2500, exp: 150, money: 25000 },
                { name: '귀인', hp: 2800, exp: 180, money: 28000 },
                { name: '킹 슬라임', hp: 3000, exp: 200, money: 30000 },
                { name: '고스트', hp: 3200, exp: 250, money: 32000 },
                { name: '흡혈귀', hp: 4000, exp: 300, money: 44000 },
                { name: '스켈레톤 나이트', hp: 5500, exp: 350, money: 55000 },
                { name: '메탈 슬라임', hp: 7000, exp: 40000, money: 70000 },
                { name: '리치', hp: 9000, exp: 500, money: 90000 },
                { name: '듀라한', hp: 15000, exp: 700, money: 150000 },
                { name: '리치 킹', hp: 90000, exp: 2500, money: 900000 },
                { name: '뱀파이어 로드', hp: 150000, exp: 4500, money: 1500000 },
                { name: '이무기', hp: 300000, exp: 10000, money: 3000000 },
                { name: '베헤모스', hp: 500000, exp: 20000, money: 5000000 },
                { name: '하급 악마', hp: 1000000, exp: 40000, money: 10000000 },
                { name: '리치 로드', hp: 1500000, exp: 60000, money: 15000000 },
                { name: '베헤모스 킹', hp: 2000000, exp: 80000, money: 20000000 },
                { name: '드래곤', hp: 4000000, exp: 150000, money: 40000000 },
                { name: '데스 나이트', hp: 10000000, exp: 300000, money: 100000000 },
                { name: '고위 악마', hp: 12000000, exp: 600000, money: 200000000 },
                { name: '카오스 드래곤', hp: 99999999, exp: 10000000, money: 100000000 },
                { name: '리무루 템페스트', hp: 999999999999999, exp: 999999999, money: 9999999999 }
        ],
        }
    },
    methods:{
        ...mapActions([
            'addMonster',
            'addManyMonster',
            'death',
            'save'
        ]),
        onAddMonster (name) {
            //const는 값을바꾸기 싫은 변수 like final
            const monsterElement = { name }
            this.addMonster( monsterElement )
            this.save()
        },
        onAddManyMonster(){
            var monsterList = []
            
            for(var i = 0; i<100; i++){
                var rand = Math.floor(Math.random() * this.monsterBook.length)
                monsterList.push({monsterId: i , name: this.monsterBook[rand].name, hp: this.monsterBook[rand].hp})

            }

            this.addManyMonster(monsterList)
            this.save()
        },
        onFirstSkill(content){
            //{} 로 받으면 객체로 받게됨
            
            const cofficient = { content }
            this.monsters.hp -= cofficient.content * this.charcter.atk


        } ,       
        onDeath(monsterId) {
            this.death(monsterId)
            this.save()
        }
    }
    
}
</script>