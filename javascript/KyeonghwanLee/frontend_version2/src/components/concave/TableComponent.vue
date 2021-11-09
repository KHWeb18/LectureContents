<template>
    <table>
        <tr-component
                v-for="(rowData, index) in tableData"
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
import TrComponent from './TrComponent'
export default {
    data () {
        return {
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
    methods://받은값들 앞으로 보냄 
        {
        updateTurn (val) {
            this.propTurn = val
            this.$emit('updateTurn', this.propTurn)
        },
        updateTableData () {
            this.$emit('updateTableData')
        },
        updateWinner (val) {
            this.propWin = val
            this.$emit('updateWinner', this.propWin)
        }
    }
}
</script>

<style>
table {
    border-collapse: collapse;
}
td {
    border: 1px solid black;
    width: 80px;
    height: 80px;
    text-align: center;
}
</style>