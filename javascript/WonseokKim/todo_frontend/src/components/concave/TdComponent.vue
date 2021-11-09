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
    methods: { // 밑에 함수 뜻은 이미 클릭한 자리니깐 아무런 동작을 하지 않는 다라는 뜻
        onClickTd () {
            if (this.cellData) {
                return
            }// 테이블 데이터에 tr부분에서 또 td부분으로 간다음에 다음턴으로 넘겨라
            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)
            let win = false
            
            if (
                this.tableData[this.rowIndex][0] === this.turn &&
                this.tableData[this.rowIndex][1] === this.turn &&
                this.tableData[this.rowIndex][2] === this.turn
            ) {
                win = true
            } else if (
                this.tableData[0][this.cellIndex] === this.turn &&
                this.tableData[1][this.cellIndex] === this.turn &&
                this.tableData[2][this.cellIndex] === this.turn
            ) {
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
            if (win) {
                this.game.propWin = this.turn
                this.$emit('updateWinner', this.game.propWin)
                this.$emit('updateTurn', 'O')
                this.$emit('updateTableData')
            } else {
                let all = true
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
                } else {
                    this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
                    this.$emit('updateTurn', this.game.propTurn)
                }
            }
        }
    }
}
</script>
