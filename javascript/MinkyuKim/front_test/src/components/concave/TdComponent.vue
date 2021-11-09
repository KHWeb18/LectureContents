<template>
    <!--누가 클릭을 했는지 -->
    <!--최종적으로 td에 걸려있는 것은 click. 클릭을 하면 onClickTd가 실행된다.-->
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
        // TrComponent.vue에서 bind한 것 
        cellData: String,
        rowIndex: Number,
        cellIndex: Number,
        tableData: Array,
        turn: String,
        winner: String
    },
    methods: {
        onClickTd () {
            // 이미 데이터가 셋팅이 되어 있으면, 이라는 의미
            if (this.cellData) {
                return
            }
            // this.$set의 역할은 
            // tableData는 바둑판 rowIndex행 번호 cellIndex는 열 번호, 즉, 클릭 시 행,열 번호를 표시하겠다라는 의미
            // this.rowIndex는 tr에 해당되는 부분(값), this.cellIndex는 td에 해당되는 부분을 의미
            // 우리가 선택하는 위치에(this.turn) O, X를 표기하라
            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)
            let win = false
            
            // 삼목판때기
            if (
                // 0번 1번 2번 (한줄)이 완성이 될 경우 승리판정
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

            // this.turn은 현재 이긴사람의 턴, 즉 propWin 이 누가 이겼는지 판정
            if (win) {
                this.game.propWin = this.turn

                // 우승자 판별
                this.$emit('updateWinner', this.game.propWin)
                // 새게임 시작 O부터 시작
                this.$emit('updateTurn', 'O')
                // 승부가 나게된다면, tableData초기화
                this.$emit('updateTableData')

            // 승부가 나지 않았음에도 불구하고, 삼목판(tableData)이 가득 찼을 때
            } else {
                let all = true
                // forEach로 열(row)값을 비교 => 이후 forEach로 행(cell) 값 비교
                // 열값이 가득차있더라도 cell값이 비어있다면 (!cell) false
                this.tableData.forEach(row => {
                    row.forEach(cell => {
                        if (!cell) {
                            all = false
                        }
                    })
                })
                if (all) {
                    this.propWin = ''
                    // 새로운 판을 시작하면 O부터 시작
                    this.$emit('updateTurn', 'O')
                    this.$emit('updateTableData')
                } else {
                    // 누구의 턴인지 알려주는 역할
                    // === 는 '같다'가 아닌 '같나?'라는 질문. 
                    // 즉 아래의 의미는 turn이 O와 같냐. 같으면 X 아니면 O
                    // '?'는 삼항연산자로, 같으면 전자, 아니면 후자를 반환하게 된다.
                    this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
                    this.$emit('updateTurn', this.game.propTurn)
                }
            }
        }
    }
}
</script> 

<style scoped>
table {
    border-collapse: collapse;
}
td {
    border: 1px solid black;
    width: 80px;
    height: 80px;
    /*text-align: center;*/
}
</style> 