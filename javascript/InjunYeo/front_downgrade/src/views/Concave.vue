<template>
    <div>
        <div>{{ turn }} 님의 차례입니다.</div>
        <table-component :table-data="tableData"
                        :turn="turn"
                        :winner="winner"
                        v-on:updateTurn="updateTurn"
                        v-on:updateTableData="updateTableData"
                        v-on:updateWinner="updateWinner">
        </table-component>
        <div v-if="winner">{{ winner }} 님의 승리</div>
    </div>
</template>

<script>

import TableComponent from '@/components/concave/TableComponent.vue'
export default {
    components: {
        TableComponent
    },
    data(){
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
        updateTurn(val){
            this.turn = val
        },
        updateTableData(){
            this.tableData=[
                ['', '', ''],
                ['', '', ''],
                ['', '', '']

            ]
        },
        updateWinner (val) {
            this.winner = val
        }

    }
    
}
</script>