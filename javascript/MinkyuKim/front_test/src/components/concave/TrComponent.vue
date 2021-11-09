<template>
    <tr>
        <!--rowData -->
        <td-component
                v-for="(cellData, index) in rowData"
                :key="index"
                :cell-data="cellData"
                :cell-index="index"
                :row-index="rowIndex"
                :table-data="tableData"
                :turn="turn"
                :winner="winner"
                v-on:updateTurn="updateTurn"
                v-on:updateTableData="updateTableData"
                v-on:updateWinner="updateWinner"
                v-model="propTurn">
        </td-component>
    </tr>
</template>

<script>
import TdComponent from './TdComponent.vue'
export default {
    components: {
        TdComponent
    },
    data () {
        return {
            propTurn: this.turn,
            propWin: this.winner
        }
    },
    props: {
        //TableComponent 에서 bind한 것들
        rowData: Array,
        rowIndex: Number,
        tableData: Array,
        turn: String,
        winner: String
    },
    methods: {
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