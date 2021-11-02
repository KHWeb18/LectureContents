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
        <!-- 결국 v-bind:의 용도는 상위 컴포넌트에서 하위 컴포넌트에게 정보를 전달하는 역할이다 -->
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
        rowData: Array,
        rowIndex: Number,
        tableData: Array,
        turn: String,
        winner: String
        //명명 규칙으로 인해 TableComponent에서 row-index의 형식으로 보내진 애들이 -이 없어진 이름으로 이 쪽의 props로 전송된다.
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
