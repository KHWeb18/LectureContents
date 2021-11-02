<template>
    <div>
        <div>{{ turn }} 님의 턴입니다</div>
        <!-- tableData는 하단부 data에 있음
             v-bind된 table-data, turn, winner는 테이블 컴포넌트에 있음
             v-bind은 상위 컴포넌트가 하위 컴포넌트에게 데이터를 전달하도록 한다 -->

        <table-component :table-data="tableData"
                        :turn="turn"
                        :winner="winner"
                        v-on:updateTurn="updateTurn"
                        v-on:updateTableData="updateTableData"
                        v-on:updateWinner="updateWinner">
        </table-component>
        <div v-if="winner"> {{ winner }}님이 승리하였습니다.</div>
    </div>
</template>

<script>

import TableComponent from '@/components/concave/TableComponent.vue'
export default {
    components: {
        TableComponent
    },
    data () {
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
        // 누구의 턴인지
        updateTurn (val) {
            this.turn = val
        },
        // 테이블 초기화
        updateTableData () {
            this.tableData = [
                ['', '', ''],
                ['', '', ''],
                ['', '', '']
            ]
        },
        // 승자가 누구인지
        updateWinner (val) {
            this.winner = val
        }
    }
}
</script>