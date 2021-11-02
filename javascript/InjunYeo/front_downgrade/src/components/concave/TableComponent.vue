<template>
    <table>
        <!--이중배열이니 rowData 는 이중배열의 열(1열,2열,3열로 쪼갠다) 그것의 인덱스번호가 index vfor의 사용법을 한번확인해보자-->
        <tr-component  
            v-for="(rowData,index) in tableData"
            :key="index"
            :row-data="rowData"
            :row-index="index"
            :table-data="tableData"
            :turn="turn"
            :winner="winner"
            v-on:updateTurn="updateTurn"
            v-on:updateTableData="updateTableData"
            v-on:updateWinner="updateWinner"
            v-model="propTurn">
        </tr-component>
    </table>
</template>

<script>

import TrComponent from './TrComponent.vue'
export default {
    data(){
        return{
            propTurn: this.turn,
            propWin: this.winner
        }

    },
    components: {
        TrComponent
    },
    props: {
        tableData: Array,
        turn: String,
        winner: String
    },
    methods:{
        updateTurn (val) {
            this.propTurn = val
            //여기
            this.$emit('updateTurn',this.propTurn)
        },
        updateTableData(){
            this.$emit('updateTableData')
        },
        updateWinner(val){
            this.propWin = val
            this.$emit('updateWinner', this.propWin)
        }

    }
}
</script>

<style>

table{
    border-collapse: collapse;
}

td{
    border: 1px solid black;
    width: 80px;
    height: 80px;
    text-align: center;

}
    
</style>