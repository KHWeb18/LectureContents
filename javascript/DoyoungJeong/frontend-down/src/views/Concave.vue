<template>
    <div>
        <h4>{{ turn }}님의 턴입니다.</h4>
        <table-component :table-data="tableData" 
                        :turn="turn"
                        :winner="winner"
                        v-on:updateTurn="updateTurn"
                        v-on:updateTableData="updateTableData"
                        v-on:updateWinner="updateWinner">
        </table-component>
        <!-- table-data 처럼 -을 넣어서 보내면 받는 컴포넌트에서 props로 인식하라는 뜻이다. 그게 vue의 명명 규칙이다 -->
        
        <h2 v-if="winner == 'tie'">무승부!</h2>
        <h2 v-else-if="winner">{{ winner }}님의 승리!</h2>
        <!-- 그냥 내가 해본 무승부 구현 -->

    </div>
</template>

<script>
import TableComponent from '../components/concave/TableComponent.vue'

export default {
    components: {
        TableComponent
    },
    data() {
        return {
            turn: 'O',
            winner: '',
            tableData: [
                ['', '', ''],
                ['', '', ''],
                ['', '', '']
            ]
        }
    },
    methods: {
        updateTurn(val) {
            this.turn = val
        },
        updateTableData() {
            this.tableData = [
                ['', '', ''],
                ['', '', ''],
                ['', '', '']
            ]
        },
        updateWinner(val) {
            this.winner = val
        }

    }
}
</script>
