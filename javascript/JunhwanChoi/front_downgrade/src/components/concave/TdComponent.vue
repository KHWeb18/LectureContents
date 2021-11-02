<template>
    <td @click="onClickTd">{{cellData}}</td>
</template>

<script>
export default {
    data(){
        return{
            game: {
                propTurn: this.turn,
                propWin: this.winner
            }

        }
    },
    props:{
        cellData: String,
        rowIndex: Number,
        cellIndex: Number,
        tableData: Array,
        turn: String,
        winner: String
    },

    methods:{
        onClickTd(){
            //데이터 값이 참일경우(있을경우) return 해라
            if(this.cellData){
                return 
            }
            //this.$set : 클릭했을 때 값 세팅
            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)

            let win= false

            //삼목 승리조건 설정
            if(
                this.tableData[this.rowIndex][0]===this.turn &&
                this.tableData[this.rowIndex][1]===this.turn &&
                this.tableData[this.rowIndex][2]===this.turn 
            ){
                win= true
            }else if(
                this.tableData[0][this.cellIndex] === this.turn &&
                this.tableData[1][this.cellIndex] === this.turn &&
                this.tableData[2][this.cellIndex] === this.turn 
            ){
                win= true
            }
            else if(
                this.tableData[0][0] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][2] === this.turn 
            ){
                win= true
            }else if(
                this.tableData[0][2]===this.turn &&
                this.tableData[1][1]===this.turn &&
                this.tableData[2][0]===this.turn 
            ){
                win=true
            }

            //이긴 상태
            if(win){
                this.game.propWin= this.turn

                this.$emit('updateWinner', this.game.propWin)
                this.$emit('updeteTurn', ' O')
                this.$emit('updateTableData')

            //이기지 않은 상태
            }else{
                //let: val과 유사.. 
                let all= true

                //열값 비교
                this.tableData.forEach(row=>{
                    row.forEach(cell=>{
                        if(!cell){
                            all=false
                        }
                    })
                })

                if(all){
                    this.propWin=''
                    this.$emit('updateTurn', 'O')
                    this.$emit('updateTableData')

                }else{
                    //페이지에서 turn 표시해주는 역할
                    this.game.propTurn=this.turn ==='O' ? 'X' : 'O'
                    this.$emit('updateTurn',this.game.propTurn)
                }
            }

        }
    }
}
</script>