<template>
    <!-- <button @click="addCounter">{{ counter }}</button> -->
    <button v-on:click="addManyMonster">몬스터 100마리 리젠</button>
</template>

<script>
export default {
    name: 'global-component',
    props: ['initialTest', 'monsters'],
    monsterNames: [
        { id: 1, name: "skeleton"},
        { id: 2, name: "zombie"},
        { id: 3, name: "Ghoul"},
        { id: 4, name: "troll"},
        { id: 5, name: "demon"}
    ],

    data() {        
        return {
            counter: this.initialTest,
            monsterArray: this.monsters      
        }
    },
    methods: {
        addCounter() {
            this.counter += 1
        },

        addManyMonster() {
            
            for(var i=0; i<100; i++) {
                var max = this.monsterArray.reduce(function(a, b) {
                    return a > b.id ? a : b.id
                }, 0)
                //var ranNum = Math.floor(Math.random()*5)
                this.monsterArray.push({
                    id: max + 1,
                    // name: this.monsterNames[ranNum].name
                    // 이게 왜 에러가 날까요?
                    name: 'monster'
                })
            }                  
        }
    }
}
</script>