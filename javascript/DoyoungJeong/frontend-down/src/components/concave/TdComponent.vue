<template>
    <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>

export default {
    data() {
        return {
            game: {
                propTurn: this.turn,
                propWin: this.winner
            }
        }
    },
    props: {
        cellData: String,
        rowIndex: Number,
        cellIndex: Number,
        tableData: Array,
        turn: String,
        winner: String
    },
    methods: {
        onClickTd() {
            if(this.cellData) {
                return //이미 데이터가 세팅돼 있다면 return이 아무것도 없으므로 아무것도 하지 않는다!
            }

            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)
            //클릭했을 때 어느 열, 어느 행에 turn이 들어갈지 셋하고 O 또는 X를 넣음

            let win = false //var과 같은 개념 let

            if(
                this.tableData[this.rowIndex][0] === this.turn &&
                this.tableData[this.rowIndex][1] === this.turn &&
                this.tableData[this.rowIndex][2] === this.turn 
            ) {
                win = true
            } else if (
                this.tableData[0][this.cellIndex] === this.turn &&
                this.tableData[1][this.cellIndex] === this.turn &&
                this.tableData[2][this.cellIndex] === this.turn 
            )  {
                win = true
            } else if (
                this.tableData[0][0] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][2] === this.turn 
            ) {
                win = true
            } else if (
                this.tableData[0][2] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][0] === this.turn 
            ) {
                win = true
            }

            if(win) {
                this.game.propWin = this.turn
                //propWin은 누가 게임을 이겼는지 판정

                this.$emit('updateWinner', this.game.propWin)

                var startTurn = this.turn === 'O' ? 'X' : 'O'
                console.log(this.turn + '의 승리이므로 ' + startTurn + '의 선공')
                this.$emit('updateTurn', startTurn)
                //진 쪽이 선공하는거 구현해봄

                this.$emit('updateTableData')
            } else {
                let all = true
                this.tableData.forEach(row => {
                    row.forEach(cell => {
                        if(!cell) { 
                            all = false
                            //만약 table에서 cell이 하나라도 없다면 false
                            this.$emit('updateWinner', '')
                        }
                    })
                })

                if(all) {
                    this.propwWin = ''
                    this.$emit('updateTurn', 'O')
                    this.$emit('updateTableData')

                    var tie = 'tie'
                    this.$emit('updateWinner', tie)

                } else {
                    this.game.propTurn = this.turn === 'O' ? 'X' : 'O' 
                    //삼항 연산자이다.
                    //=== 의 뜻은 같으냐 물어보는것
                    //this.turn === 'O' ? 는 turn이 O과 같냐고 물어보는것이다.
                    //같으면 왼쪽에 있는 X를 this.game.propTurn에 넣고, 다르면 오른쪽에 있는 O를 this.game.propTurn에 넣는다!
                    this.$emit('updateTurn', this.game.propTurn)
                }
            }
        }
    }
}
</script>
