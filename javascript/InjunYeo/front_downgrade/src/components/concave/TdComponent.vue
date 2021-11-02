<template>
    <td @click="onClickTd"> {{cellData}} </td>
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
    props: {
        cellData: String,
        rowIndex: Number,
        cellIndex: Number,
        tableData: Array,
        turn: String,
        winner: String
    },
    methods:{
        onClickTd(){
            if(this.cellData){
                return
            }

            this.$set(this.tableData[this.rowIndex],this.cellIndex, this.turn)

            //let은 뭘까? const가 있고 let이있지만 let은 중복선언을 방지해줌 var랑 큰차이없음
            let win = false

            if(
                this.tableData[this.rowIndex][0] === this.turn &&
                this.tableData[this.rowIndex][1] === this.turn &&
                this.tableData[this.rowIndex][2] === this.turn

            ){
                win = true
            }
            else if(
                this.tableData[0][0] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][2] === this.turn
            ){
                win = true
            }
            else if(
                this.tableData[0][this.cellIndex] === this.turn &&
                this.tableData[1][this.cellIndex] === this.turn &&
                this.tableData[2][this.cellIndex] === this.turn
            ){
                win = true
            }
            else if(
                this.tableData[0][2] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][0] === this.turn
            ){
                win = true
            }

            if(win){

                this.game.propWin = this.turn

                this.$emit('updateWinner',this.game.propWin)
                this.$emit('updateTurn','O')
                this.$emit('updateTableData')
            }else{
                let all = true
                this.$emit('updateWinner','')
                this.tableData.forEach(row => {
                    row.forEach(cell=>{
                        if(!cell){
                            all = false
                        }
                    })
                })

                //모든칸이 다찼으나 승리자가 없을때 동작하는 코드
                if(all){
                    this.propWin=''
                    this.$emit('updateTurn','O')
                    this.$emit('updateTableData')
                //여기서 턴을 바꿔주는 역할
                }else{  
                    //===같은가? 라는뜻
                    this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
                    this.$emit('updateTurn',this.game.propTurn)
                }

            }
            
        }
    }
}
</script>