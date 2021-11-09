var app = new Vue ({
    el: '#app',
    data: {
        randNum: 0,
        count: 0,
        shopView: false,
        shopList: [],
        shopListValue: [],
        inventoryView: false,
        myInventory: [],
        myInventoryValue: [],
        jobListView: false,
        jobStat: false,
        myStatus: {
            level: 1,
            hp: 100,
            mp: 30,
            atk: 50,
            itemAtk: 0,
            defaultAtk: 50,
            str: 10, // 근력
            intelligence: 10, // 지능
            dex: 10, // 기교
            vit: 10, // 활력
            def: 10, // 방어력
            men: 10, // 정신력
            needExp: 20, // 전체 필요 경험치량
            currentExp: 0, // 현재 경험치량
            myMoney: 0,
            myJob: 'Adventurer',
            
        },
        monsterGuide: [
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
        ],
        myMonsters: [ 
            { no: 1, name: '에나비', type: ' 노말 ', hp: 739, exp: 10, money: 1000 },
            { no: 2, name: '이브이', type: ' 노말 ', hp: 1071, exp: 15, money: 2000 },
            { no: 3, name: '루브도', type: ' 노말 ', hp: 431, exp: 5, money: 500 }
        ],
        itemGuide: [
            { name: 'HP 포션 I', price: 50000, effect: { desc: 'hp 회복(50)', amount: 50 }},
            { name: 'HP 포션 II', price: 75000, effect: { desc: 'hp 회복(70)', amount: 70 }},
            { name: 'HP 포션 III', price: 100000, effect: { desc: 'hp 회복(100)', amount: 100 }},
            { name: 'HP 포션 IV', price: 125000, effect: { desc: 'hp 회복(150)', amount: 150 }},
            { name: 'HP 포션 V', price: 150000, effect: { desc: 'hp 회복(200)', amount: 200 }},
            { name: '검', price: 500000, effect: { desc: '무기(100)', atk: 100 }},
            { name: '강철검', price: 800000, effect: { desc: '무기(200)', atk: 200 }},
            { name: '은검', price: 1500000, effect: { desc: '무기(300)', atk: 300 }},
            { name: '금검', price: 2000000, effect: { desc: '무기(400)', atk: 400 }},
        ]
         
    },
    methods: {
        addMonster: function (){
            this.randNum = Math.floor(Math.random() * this.monsterGuide.length)     

            var max = this.myMonsters.reduce( function (a, b) {
                return a > b.no ? a : b.no
            }, 0)

            this.myMonsters.push(
                { no: max + 1, name: this.monsterGuide[this.randNum].name, type: this.monsterGuide[this.randNum].type, 
                    hp: this.monsterGuide[this.randNum].hp, exp: this.monsterGuide[this.randNum].exp, money: this.monsterGuide[this.randNum].money }
            )
        },
        addManyMonster (){
            for (var i = 0; i < 100; i++){
                var max = this.myMonsters.reduce( function(a, b){
                    return a > b.no ? a : b.no
                },0)

                this.randNum = Math.floor(Math.random() * this.monsterGuide.length)

                this.myMonsters.push(
                    { no: max + 1, name: this.monsterGuide[this.randNum].name, type: this.monsterGuide[this.randNum].type, 
                        hp: this.monsterGuide[this.randNum].hp, exp: this.monsterGuide[this.randNum].exp, money: this.monsterGuide[this.randNum].money }
                )
            }
        },
        removeMonster: function (index) {
            this.myMonsters.splice(index, 1)
        },
        userAttack: function (index) {
            this.myMonsters[index].hp -= this.myStatus.atk
        },
        userStrongAttack: function (index) {
            this.myMonsters[index].hp -= ( this.myStatus.atk * 3 +
                                            this.myStatus.str * 5 +
                                            this.myStatus.dex * 3 +
                                            this.myStatus.intelligence * 1.5 )
        },
        skill: function () {
            for (var i = 0; i < this.myMonsters.length; i++){
                this.myMonsters[i].hp = parseInt(this.myMonsters[i].hp - this.myStatus.atk * 2)
            }
        },
        shuffleShopList () {
            if (!this.shopView){
                this.shopListValue = []
            }
            for (var i = 0; i < 10; i++){
                var randIdx = Math.floor(Math.random() * this.itemGuide.length)
                this.shopList[i] = this.itemGuide[randIdx]
            }
        },
        buyItem () {
            var tmpSum = 0

            console.log('addItem(): ' + this.shopListValue.length)
            console.log('shoplist length: ' + this.shopList.length)

            for (var i = 0; i < this.shopListValue.length; i++){
                console.log('선택된 값: ' + this.shopListValue[i])

                for (var j = 0; j < this.shopList.length; j++){
                    if (this.shopListValue[i] == j) {
                        tmpSum += this.shopList[j].price
                        break
                    }
                }
            }

            if (this.myStatus.myMoney - tmpSum >= 0) {
                this.myStatus.myMoney -= tmpSum

                for (var i = 0; i < this.shopListValue.length; i++){
                    this.myInventory.push(
                        { name: this.shopList[this.shopListValue[i]].name, 
                        effect: this.shopList[this.shopListValue[i]].effect }
                    )
                }
                alert('구매가 완료되었습니다!')
            } else {
                alert('잔액이 부족합니다!')
            }
        },
        equipItem () {
            var tmpSum = 0

            console.log('equipItem(): ' + this.myInventoryValue.length)
            console.log('myInventory length: ' + this.myInventory.length)

            for (var i = 0; i < this.myInventoryValue.length; i++) {
                console.log('외곽 루프 - 선택된 값: ' + this.myInventoryValue[i])

                for (var j = 0; j < this.myInventory.length; j++) {
                    console.log('내부 루프')

                    if (this.myInventoryValue[i] == j) {
                        console.log('매칭 성공!')

                        tmpSum += this.myInventory[j].effect.atk
                        break
                    } 
                } 
            }
            this.myStatus.itemAtk = tmpSum
            this.myStatus.atk = this.myStatus.defaultAtk + tmpSum 
            
            alert('장착되었습니다!')
        },
        jobSkill: function () {
            if (this.myStatus.myJob === 'Magician'){
                for (var i = 0; i < this.myMonsters.length; i++){
                    this.myMonsters[i].hp = parseInt(this.myMonsters[i].hp - (this.myStatus.atk * 4 + this.myStatus.intelligence * 3))
                }
            } else if (this.myStatus.myJob === 'Warrior'){
                for (var i = 0; i < this.myMonsters.length; i++){
                    this.myMonsters[i].hp = parseInt(this.myMonsters[i].hp - (this.myStatus.atk * 4 + this.myStatus.def * 3))
                }
            } else if (this.myStatus.myJob === 'Knight'){
                for (var i = 0; i < this.myMonsters.length; i++){
                    this.myMonsters[i].hp = parseInt(this.myMonsters[i].hp - (this.myStatus.atk * 4 + this.myStatus.vit * 3))
                }
            }
        },
        userJobAttack: function (index) {
            if (this.myStatus.myJob === 'Magician'){
                this.myMonsters[index].hp -= ( this.myStatus.atk * 5 +
                                                this.myStatus.intelligence * 3 +
                                                this.myStatus.vit * 3 +
                                                this.myStatus.men * 3 )
            } else if (this.myStatus.myJob === 'Warrior'){
                this.myMonsters[index].hp -= ( this.myStatus.atk * 5 +
                                                this.myStatus.str * 3 +
                                                this.myStatus.def * 3 +
                                                this.myStatus.vit * 3 )
            } else if (this.myStatus.myJob === 'Knight'){
                this.myMonsters[index].hp -= ( this.myStatus.atk * 5 +
                                                this.myStatus.str * 3 +
                                                this.myStatus.vit * 3 +
                                                this.myStatus.def * 3 )
            }                                 
        },
    },
    beforeUpdate() {
        for(var i = 0; i < this.myMonsters.length; i++){
            if(this.myMonsters[i].hp <= 0){
                this.myStatus.currentExp += this.myMonsters[i].exp
                this.myStatus.myMoney += this.myMonsters[i].money
                this.myMonsters.splice(i, 1)
            }
        }
        
        for (; this.myStatus.currentExp >= this.myStatus.needExp; ) {
            this.myStatus.currentExp = parseInt(this.myStatus.currentExp - this.myStatus.needExp)
            
            if (this.myStatus.myJob === 'Adventurer') { 
                this.myStatus.level += 1
                this.myStatus.hp *= 1.1
                this.myStatus.atk *= 1.05
                this.myStatus.defaultAtk *= 1.05
                this.myStatus.str *= 1.1
                this.myStatus.intelligence *= 1.1
                this.myStatus.dex *= 1.1
                this.myStatus.vit *= 1.1
                this.myStatus.def *= 1.1
                this.myStatus.men *= 1.1
            } else if (this.myStatus.myJob === 'Magician'){
                var tmpSum = this.myStatus.atk - this.myStatus.defaultAtk
                
                this.myStatus.level += 1
                this.myStatus.hp *= 1.15
                this.myStatus.atk = this.myStatus.defaultAtk + tmpSum
                this.myStatus.defaultAtk *= 1.2
                this.myStatus.str *= 1.1
                this.myStatus.intelligence *= 1.5
                this.myStatus.dex *= 1.2
                this.myStatus.vit *= 1.3
                this.myStatus.def *= 1.15
                this.myStatus.men *= 1.3
            } else if (this.myStatus.myJob === 'Warrior'){
                var tmpSum = this.myStatus.atk - this.myStatus.defaultAtk
                
                this.myStatus.level += 1
                this.myStatus.hp *= 1.3
                this.myStatus.atk = this.myStatus.defaultAtk + tmpSum
                this.myStatus.defaultAtk *= 1.3
                this.myStatus.str *= 1.3
                this.myStatus.intelligence *= 1.15
                this.myStatus.dex *= 1.15
                this.myStatus.vit *= 1.2
                this.myStatus.def *= 1.4
                this.myStatus.men *= 1.2
            } else if (this.myStatus.myJob === 'Knight'){
                var tmpSum = this.myStatus.atk - this.myStatus.defaultAtk
                
                this.myStatus.level += 1
                this.myStatus.hp *= 1.2
                this.myStatus.atk = this.myStatus.defaultAtk + tmpSum
                this.myStatus.defaultAtk *= 1.5
                this.myStatus.str *= 1.2
                this.myStatus.intelligence *= 1.15
                this.myStatus.dex *= 1.1
                this.myStatus.vit *= 1.4
                this.myStatus.def *= 1.25
                this.myStatus.men *= 1.2
            }
            
            if (this.myStatus.level < 10) {
                this.myStatus.needExp = parseInt(this.myStatus.needExp * 1.1)
            } else if (this.myStatus.level < 20) {
                this.myStatus.needExp = parseInt(this.myStatus.needExp * 1.15)
            } else if (this.myStatus.level < 30) {
                this.myStatus.needExp = parseInt(this.myStatus.needExp * 1.2)
            } else if (this.myStatus.level < 40) {
                this.myStatus.needExp = parseInt(this.myStatus.needExp * 1.3)
            } else if (this.myStatus.level < 50) {
                this.myStatus.needExp = parseInt(this.myStatus.needExp * 1.4)
            } else if (this.myStatus.level < 80) {
                this.myStatus.needExp = parseInt(this.myStatus.needExp * 1.5)
            } else if (this.myStatus.level < 100) {
                this.myStatus.needExp = parseInt(this.myStatus.needExp * 1.7)
            }
        }
        
        if ((this.myStatus.level >= 50) && (this.myStatus.myJob === 'Adventurer')) {
            this.jobListView = true
        } else {
            this.jobListView = false
        }

        if (!(this.myStatus.myJob === 'Adventurer') && !(this.jobStat)) {
            this.myStatus.atk += 100
            this.myStatus.defaultAtk += 100
            this.myStatus.str += 50
            this.myStatus.int += 50
            this.myStatus.dex += 50
            this.myStatus.vit += 50
            this.myStatus.def += 50
            this.myStatus.men += 50

            this.jobStat = true
        }

        
    }
})