<template>
    <tr>
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

                // :cell-data="cellData"
                // :cell-index="index"
                // :row-index="rowIndex"
                // :table-data="tableData"
                // :turn="turn"
                // :winner="winner"
                // 이번엔 6개 td-component로 날아간다!



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

    //그치? 5개 넘어온 거 여기도 5개지?
    // - 없어지면서 대문자로 바뀐 거에 주목!    
    props: {
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
    text-align: center;
}
</style> 