var quiz = new Vue ({
    el: '#book',
    data: {
        randomNumber: 0,
        monsterBook: [
            {id: 1, name: '루피', HP: 3400 },
            {id: 2, name: '상디', HP: 2500 },
            {id: 3, name: '쵸파', HP: 1700 },
            {id: 4, name: '피카츄', HP: 100 },
            {id: 5, name: '찌리리공', HP: 1100 },
            {id: 6, name: '칠색조', HP: 111000 },
            {id: 7, name: '썬더', HP: 10100 },
            {id: 8, name: '손오공', HP: 11111000 },
            {id: 9, name: '베지터', HP: 1111000 },
            {id: 10, name: '프리저', HP: 11000 },
            {id: 11, name: '마인부우', HP: 1110100 },
            {id: 12, name: '셀', HP: 101010 },
            {id: 13, name: '타노스', HP: 111000 },
            {id: 14, name: '베놈', HP: 11000 },
            {id: 15, name: '람보', HP: 5000 },
            {id: 16, name: '닌자', HP: 3000 },
            {id: 17, name: '사무라이', HP: 5000 },
            {id: 18, name: '법사', HP: 100 },
            {id: 19, name: '네크로멘서', HP: 600 },
            {id: 20, name: '사자', HP: 1000 },
        ]
    },
    methods: {
        randomMonster: function () {
            this.randomNumber = Math.floor(Math.random() * 20) + 1;

        }
        appearingMonster: function (index) {
            this.monsterBook(this.randomMonster)
                        this.monsterBook.push({
                            id: randomNumber
        }


            
        },

})