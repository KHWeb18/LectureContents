<template>
    <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>

export default {
    data () {
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
        onClickTd () {
            // cellData가 이미 세팅되어 있다면 return
            if (this.cellData) {
                return
            }

            // $set : 값을 세팅함
            // tableData : 바둑판, cellIndex: 열
            // rowIndex(tr인덱스), cellIndex(td인덱스), this.turn(화면 상 o,x)
            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)
            
            // 처음에 이겼는지 졌는지 모르는 상태
            // let = var 같은 역할
            let win = false
            
            if (
                // tr값이 turn일때 (행으로 삼목완성)
                this.tableData[this.rowIndex][0] === this.turn &&
                this.tableData[this.rowIndex][1] === this.turn &&
                this.tableData[this.rowIndex][2] === this.turn
            ) {
                win = true
            } else if (
                // td값이 turn일때 (열로 삼목완성)
                this.tableData[0][this.cellIndex] === this.turn &&
                this.tableData[1][this.cellIndex] === this.turn &&
                this.tableData[2][this.cellIndex] === this.turn
            ) {
                win = true
            } else if (
                // 왼쪽시작 대각선(삼목완성)
                this.tableData[0][0] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][2] === this.turn
            ) {
                win = true
            } else if (
                // 오른쪽시작 대각선(삼목완성)
                this.tableData[0][2] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][0] === this.turn
            ) {
                win = true
            }
            
            if (win) {
                // propWin이 누가 이겼는지 판정함
                // 게임초기화, 턴바꾸기
                this.game.propWin = this.turn

                this.$emit('updateWinner', this.game.propWin)
                this.$emit('updateTurn', 'O')
                this.$emit('updateTableData')
            } else {
                let all = true
                // 판이 전부 채워졌지만 승리자가 없을때
                this.tableData.forEach(row => {
                    row.forEach(cell => {
                        if (!cell) {
                            all = false
                        }
                    })
                })
                if (all) {
                    this.propWin = ''
                    this.$emit('updateTurn', 'O')
                    this.$emit('updateTableData')
                    this.$emit('updateWinner','')
                } else {
                    // 턴에 따라, 누구 턴인지 알려줌
                    this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
                    this.$emit('updateTurn', this.game.propTurn)
                }
            }
        }
    }
}
</script>