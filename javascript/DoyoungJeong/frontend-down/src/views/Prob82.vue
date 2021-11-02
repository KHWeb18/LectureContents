<template>
    <div>
        <fantasy-world></fantasy-world>
        <attack-monster v-on:useSkill="calcDamage"></attack-monster>
        <!-- useSkill이 동작함을 감지함과함께 도착하는 값은 AttackMonster컴포넌트에 메소드에서 emit의 첫 번째 인자값이다. -->
         <p>Monster.HP{{ monster.hp }}</p>
         <monster-input
            v-on:addMonster="onAddMonster">
         </monster-input>
         <monster-list
            v-on:killMonster="onkillMonster"  
            v-on:editName="onEditName"
            v-on:toggleMonsterStatus="onToggleMonsterStatus">
        </monster-list>
        <summon-monsters
            v-on:summonManyMonster="onSummonManyMonster">
        </summon-monsters>
        <monster-footer
            v-on:removeAllMonster="onRemoveAllMonster">
        </monster-footer>

    </div>
</template>

<script>

import FantasyWorld from '../components/prob82/FantasyWorld.vue'
import AttackMonster from '../components/prob82/AttackMonster.vue'
import MonsterList from '../components/prob82/MonsterList.vue'
import MonsterInput from '../components/prob82/MonsterInput.vue'
import SummonMonsters from '../components/prob82/SummonMonsters.vue'
import MonsterFooter from '../components/prob82/MonsterFooter.vue'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'Prob82',
    components: {
        'fantasy-world': FantasyWorld,
        'attack-monster': AttackMonster,
        'monster-list': MonsterList,
        'monster-input': MonsterInput,
        'summon-monsters': SummonMonsters,
        MonsterFooter
    },
    data() {
        return {
            monster: {
                hp: 100
            },
            monsterBook: [
                { name: 'skeleton', hp: 20 },
                { name: 'zombie', hp: 30 },
                { name: 'imp', hp: 35 },
                { name: 'fallen', hp: 50 },
                { name: 'troll', hp: 60},
                { name: 'viper', hp: 55 }
            ]
        }
    },    
    computed: {
        ...mapState([
            'nextMonsterId'
        ])
    },
    methods: {
        ...mapActions([
            'addMonster',
            'killMonster',
            'editName',
            'save',
            'clearAllMonster',
            'toggleMonsterStatus',
            'summonManyMonsters'
        ]),
        calcDamage(content) {
            //calcDamge는 useSkill에서 emit 인자값으로 전송한 값을 ()안 content로 받는다.
            const skillDam = { content }     
            this.monster.hp -= skillDam.content
            //skillDam의 값에 인자값을 넣고 활용할 시에는 변수 이름 뒤에 .content을 붙어주어야한다.
        },
        onkillMonster(monsterId) {
            this.killMonster(monsterId)
            this.save()
        },
        onAddMonster(name) {
            const monsterElement = { name }
            this.addMonster(monsterElement)
            this.save()
        },
        onEditName(monsterId, name) {
            console.log('monsterId: ' + JSON.stringify(monsterId))
            console.log('name: ' + JSON.stringify(name))

            this.editName({ monsterId, name })
        },
        onSummonManyMonster() { //숙제부분 ~
            var tempMonsterList = []

            for(var i=0; i<10; i++) {
                var ranNum = Math.floor(Math.random()*this.monsterBook.length)
                //var tempMonsterId = this.monsterElements.length

                tempMonsterList.push({ name: this.monsterBook[ranNum].name, 
                hp: this.monsterBook[ranNum].hp })
                // console.log('nextMonsterId: ' + this.nextMonsterId)
                // this.nextMonsterId++
                // 이 방법 안됨
            }
            this.summonManyMonsters(tempMonsterList)
            //~ 숙제부분
        },
        onRemoveAllMonster() {
            this.clearAllMonster()
        },
        onToggleMonsterStatus(monsterId) {
            this.toggleMonsterStatus(monsterId)
        }
    }
}
</script>



