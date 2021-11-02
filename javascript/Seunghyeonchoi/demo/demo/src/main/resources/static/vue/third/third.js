var app = new Vue ({
//  현재 상점에서 아이템 리스트를 만들었다.
//  무기를 구매할 수 있게 하였다.
//
//  1. 구매 버튼을 눌러서 무기를 구매하도록 한다.
//  2. 소지금에서 구매한 값만큼 차감시킨다.
//  3. 구매후 착용하여 캐릭터 스탯을 상승시킨다.
//  4. 인벤토리창을 구현하여 현재 가지고 있는 장비 물품을 볼 수 있도록 만들어보자!

    el: '#app',
    data: {
        message: '우왕 뷰 짱',
        initMsg: '양방향 연결이 뭔지 함 볼까 ?',
        list: ['사과', '바나나', '딸기', '수박', '참외', '포도', '망고', '블루베리', '체리'],
        show: true,
        num: 3,
        count: 0,
        radius: 50,
        randomNumber: 0,
        shopView: false,
        shopList: [],
        shopListValue: [],
        totalPrice: 0,
        inventory: [],
        tempNumber: 0,
        inventoryView: false,
        characterStatus: {
            level: 1,
            hp: 70,
            mp: 30,
            atk: 10,
            str: 10,
            intelligence: 10,
            dex: 10,
            vit: 10,
            def: 10,
            men: 0,
            // 전체 필요 경험치량
            totalLevelBar: 10,
            // 현재 누적한 경험치량
            currentLevelBar: 0,
            money: 10000000000
        },
        monsterName: '',
        monsters: [
            { id: 1, name: '슬라임', hp: 30 },
            { id: 2, name: '고블린', hp: 50 },
            { id: 3, name: '카오스 드래곤', hp: 99999999 }
        ],
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
            { name: '리치', hp: 9000, exp: 500, money: 90000 },
            { name: '리치 킹', hp: 90000, exp: 2500, money: 900000 },
            { name: '카오스 드래곤', hp: 99999999, exp: 10000000, money: 100000000 },
            { name: '리무루 템페스트', hp: 999999999999999, exp: 999999999, money: 9999999999 }
        ],
        itemBook: [
            { name: 'HP 포션 I', price: 50, effect: { desc: 'hp 회복', amount: 200 }},
            { name: 'HP 포션 II', price: 200, effect: { desc: 'hp 회복', amount: 700 }},
            { name: 'HP 포션 III', price: 1000, effect: { desc: 'hp 회복', amount: 2000 }},
            { name: 'HP 포션 IV', price: 6000, effect: { desc: 'hp 회복', amount: 6000 }},
            { name: 'HP 포션 V', price: 42000, effect: { desc: 'hp 회복', amount: 15000 }},
            { name: '검', price: 10000000, effect: { desc: '무기', atk: 100 }},
            { name: '강철검', price: 50000000, effect: { desc: '무기', atk: 200 }},
            { name: '환두대도', price: 250000000, effect: { desc: '무기', atk: 350 }},
            { name: '발라리아 강철검', price: 1250000000, effect: { desc: '무기', atk: 500 }},
            { name: '칠지도', price: 10000000000, effect: { desc: '무기', atk: 1000 }},
        ]
    },
    methods: {
        purchase() {
            console.log('')
            console.log('purchase ()')   

            // var jsonData = JSON.stringify(this.shopList[1], ['price'])       

            
            
            // console.log(JSON.stringify(this.shopList[1], ['price']))
            // console.log(JSON.parse(jsonData).price)
            // console.log(this.totalPrice)
            // console.log(JSON.stringify(this.shopList[1], ['price']))
            // console.log(JSON.parse(JSON.stringify(this.shopList[1], ['price'])).price)
            // var jsonData = JSON.stringify(this.shopList[1], ['price']) 
            // console.log(JSON.parse(jsonData).price)
            
            

            console.log('shopListValue : ' + this.shopListValue)
            console.log('shopListValue.length : ' + this.shopListValue.length)

            console.log(':: 계산서 ::')
            for (var i = 0; i < this.shopListValue.length; i++)    {
              
                var j = this.shopListValue[i]                
                console.log('shopList[' + i + ']의 상품이름은 : '+ JSON.parse(JSON.stringify(this.shopList[j], ['name'])).name +
                '이고 가격은 : ' + JSON.parse(JSON.stringify(this.shopList[j], ['price'])).price + '원이다')

                this.totalPrice +=  JSON.parse(JSON.stringify(this.shopList[j], ['price'])).price

                
            console.log('연습 중1 : ' + JSON.parse(JSON.stringify(this.shopList[j], ['price'])).price)
            //둘 다 같은 표현이네
            console.log('연습 중2 : ' + JSON.parse(JSON.stringify(this.shopList[j].price)))
            }
            console.log('합계금액 : ' + this.totalPrice)

        },
        equipItem () {
            console.log('')
            console.log('equipItem ()')
            for (var i = 0; i < this.shopListValue.length; i++)    {
              
                var j = this.shopListValue[i]

                
                if (JSON.parse(JSON.stringify(this.shopList[j].effect.desc)) == 'hp 회복') {
                    this.characterStatus.hp += JSON.parse(this.shopList[j].effect.amount)
                    console.log("체력이 " + JSON.parse(this.shopList[j].effect.amount) + " 올랐습니다.")
                } else {
                    this.characterStatus.atk += JSON.parse(this.shopList[j].effect.atk)
                    console.log("공격력이 " + JSON.parse(this.shopList[j].effect.atk) + " 올랐습니다.")
                }

                // if (JSON.parse(JSON.stringify(this.shopList[j].effect.desc)) == 'hp 회복') {
                //     this.characterStatus.amout += JSON.parse(this.shopList[j].effect.amout)
                //     console.log("체력이 " + JSON.parse(this.shopList[j].effect.amount) + " 올랐습니다.")
                // } else {
                //     this.characterStatus.atk += JSON.parse(this.shopList[j].effect.atk)
                //     console.log("공격력이 " + JSON.parse(this.shopList[j].effect.atk) + " 올랐습니다.")
                // }
                
                // this.characterStatus.hp += JSON.parse(this.shopList[j].effect.amount)
                // console.log("체력이 " + JSON.parse(this.shopList[j].effect.amount) + " 회복됐습니다.")
                // var temp01 = JSON.parse(JSON.stringify(this.shopList[j], ['name'])).name  
                // console.log(temp01)
                // console.log(typeof temp01)
                // console.log(temp01 == 'HP 포션 II')
                // console.log('잠시 쉬고')
                // console.log('잠시 쉬고')
                // var temp02 = JSON.parse(JSON.stringify(this.shopList[j].effect.desc))  
                // console.log(temp02)
                // console.log(typeof temp02)
                // console.log(temp02 == 'hp 회복')
                // console.log(JSON.parse(JSON.stringify(this.shopList[j], ['name'])).name)
            }
            
        },
        myInventory () {
            console.log('')
            console.log('myInventory ()')  
         
            for (var i = 0; i < this.shopListValue.length; i++)    {
                var j = this.shopListValue[i]
                var e = this.tempNumber

                this.inventory[e+i+1] = JSON.parse(JSON.stringify(this.shopList[j], ['name'])).name                 
            }
            this.tempNumber += this.shopListValue.length

            console.log(':: Inventory ::')

            for (var i = 1; i < this.inventory.length; i++) {          
                console.log(+ i +'번 아이템 : ' + this.inventory[i])
            }
            console.log('장바구니 비우기 실행')
            this.shopListValue.length = 0
            console.log(this.shopListValue.length)
            

            
            
            // console.log(this.shopList.length)
            // console.log('this.shopList.splice(0, this.shopList.length) 실행')
            // this.shopList.splice(0, this.shopList.length)
            // console.log(this.shopList.length)
            // console.log('this.shopList.length = 0 실행')
            // this.shopList.length = 0
            // console.log(this.shopList.length)

        },
        shuffleShopList () {
            if (!this.shopView) {
                this.shopListValue = []
            }

            for (var i = 0; i < 10; i++) {
                var randIdx = Math.floor(Math.random() * this.itemBook.length)
                this.shopList[i] = this.itemBook[randIdx]
            }
        },
        buttonClickTest: function (event) {
            alert('뷰 짱')
        },
        increment: function () {
            this.count += 1
        },
        addMonster: function () {
            var max = this.monsters.reduce( function (a, b) {
                return a > b.id ? a : b.id
            }, 0)

            var randNum = Math.floor(Math.random() * this.monsterBook.length);

            this.monsters.push({
                id: max + 1,
                name: this.monsterBook[randNum].name,
                hp: this.monsterBook[randNum].hp
            })
        },
        addManyMonster () {
            // 100마리씩 추가
            for (var i = 0; i < 100; i++) {
                var max = this.monsters.reduce( function (a, b) {
                    return a > b.id ? a : b.id
                }, 0)

                var monBookLen = this.monsterBook.length
                var idx = Math.floor(Math.random() * monBookLen)

                this.monsters.push({
                    id: max + 1,
                    name: this.monsterBook[idx].name,
                    hp: this.monsterBook[idx].hp
                })
            }
        },
        removeMonster: function (index) {
            this.monsters.splice(index, 1);
        },
        userAttack: function (index) {
            this.monsters[index].hp -= this.characterStatus.atk
        },
        randomGeneration () {
            this.randomNumber = Math.floor(Math.random() * 10) + 1;
        },
        myDarknessDragon () {
            for (var i = 0; i < this.monsters.length; i++) {
                this.monsters[i].hp =
                    parseInt(this.monsters[i].hp - this.characterStatus.atk * 3.5)
            }
        }
    },
    beforeCreate() {
        console.log('Vue 객체를 만들기 이전입니다.')
    },
    created() {
        console.log('Vue 객체를 만들었습니다.')
    },
    beforeMount() {
        console.log('HTML 요소를 붙이기 전입니다.')
    },
    mounted() {
        console.log('HTML 요소를 붙입니다.')
    },
    beforeUpdate() {
        console.log('VDOM의 변화를 감지합니다.')
        // console.log('totalPrive의 현재 상태는 : ' + this.totalPrice)


        // 1, 2번 기능 : 구매 및 소지금 차감
        if ( this.totalPrice > 0) {
            console.log('')
            console.log('계산 실행')
            console.log("소지금액 : " + this.characterStatus.money)
            console.log("결제금액 : " + this.totalPrice)
            this.characterStatus.money = this.characterStatus.money - this.totalPrice 
            console.log("결제 후 소지금액 : " + this.characterStatus.money )
            this.totalPrice = 0
            j = this.shopListValue.length
            this.shopListValue.splice(j, 1)
            this.totalPrice = 0
        }


        var i
        for (i = 0; i < this.monsters.length; i++) {
            if (this.monsters[i].hp <= 0) {
                // 몬스터 제거 이전에 무엇을 해야할까요 ? 경험치 획득
                for (var j = 0; j < this.monsterBook.length; j++) {
                    if (this.monsters[i].name === this.monsterBook[j].name) {
                        this.characterStatus.currentLevelBar += this.monsterBook[j].exp
                        this.characterStatus.money += this.monsterBook[j].money
                    }
                }
                this.monsters.splice(i, 1)
            }
        }

        var criteria = this.characterStatus.currentLevelBar

        for (; this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar; ) {
            this.characterStatus.currentLevelBar =
                parseInt(this.characterStatus.currentLevelBar -
                    this.characterStatus.totalLevelBar)
            this.characterStatus.level += 1
            this.characterStatus.hp *= 1.2
            this.characterStatus.atk += 3
            this.characterStatus.def += 1

            // 레벨링 시스템 구축
            if (this.characterStatus.level < 10) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.1)
            } else if (this.characterStatus.level < 20) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.2)
            } else if (this.characterStatus.level < 30) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.3)
            } else if (this.characterStatus.level < 40) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.4)
            } else if (this.characterStatus.level < 50) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.5)
            } else if (this.characterStatus.level < 80) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.7)
            } else if (this.characterStatus.level < 100) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 2)
            }
        }
    },
    updated() {
        console.log('VDOM의 변화를 적용합니다.')
    },
    beforeDestroy() {
        console.log('Vue 객체를 파괴하기 이전입니다.')
    },
    destroyed() {
        console.log('Vue 객체를 파괴하였습니다.')
    }
})