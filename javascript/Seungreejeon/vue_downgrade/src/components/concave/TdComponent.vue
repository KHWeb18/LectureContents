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
            // 값이 있는경우 리턴
            if (this.cellData) {
                return
            }
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
            // 이긴경우 해당턴에 이긴사람이 승자
            if (win) {
                //승자 설정
                this.game.propWin = this.turn
                //승자 부모 컴포넌트로 전달
                this.$emit('updateWinner', this.game.propWin)
                //시작 O의 턴으로 리셋
                this.$emit('updateTurn', 'O')
                this.$emit('updateTableData')
            } else {
                // 각 행의 열을 찾아서 비어있다면 all을 false로 둔다.
                // true가 나온다면 테이블을 새로 리셋한다.
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
                    //false의 경우 턴 교체
                    this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
                    this.$emit('updateTurn', this.game.propTurn)
                }
            }
        }
    }
}
</script>