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
            // 데이터가 이미 있으면 리턴 즉 이미 둔 곳은 또 둘수 없다.
             if (this.cellData) {
                return
            }
            // 값 세팅 
            // rowIndx:tr cellIndex:td this.turn:O,X 표기
            // 즉 O, X를 표기하는 하는 내용
            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)
            // let은 중첩되는걸 방지 var랑 같은것
            let win = false
            // 승리 조건(4가지 경우의수 가로, 세로, 대각선)
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
                // propWin 누가 이겼는지 판정 및 초기화
                this.game.propWin = this.turn

                this.$emit('updateWinner', this.game.propWin)
                this.$emit('updateTurn', 'O')
                this.$emit('updateTableData')
            } else {
                // 칸이 전부 채워졌는데 승리자가 없는경우
                let all = true
                this.tableData.forEach(row => {
                    row.forEach(cell => {
                        if (!cell) {
                            all = false
                        } 
                    })
                })
                if (all) {
                    //전부 채워지면 O부터 시작 
                    this.propWin = ''
                    this.$emit('updateTurn', 'O')
                    this.$emit('updateTableData')
                } else {
                    //턴이 왔다갔다 할때 O턴 X턴 표기 하는 구간 
                    //=== 같니?라고 물어보는것
                    //같으면 X :은 아니면 O
                    this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
                    this.$emit('updateTurn', this.game.propTurn)
                }
            }
        }
    }
}
</script>