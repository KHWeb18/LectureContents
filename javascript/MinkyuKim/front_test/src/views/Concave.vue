<template>
    <div>
        <!-- turn은 O , X를 의미 -->
        <div>{{ turn }}님의 턴입니다.</div>
        <!--행렬, 누가이겼는지, 턴 업데이트, 행렬 업데이트 -->
        <!--여기에서 tableData는 아래의 tableData
            :table-data는 table-component의 props로 맵핑-->
        <!--왜 props로 가게(맵핑)되나?
            table-component는 명명규칙에 의하여 TableComponent와 동일하게 인식되므로 TableComponent로 가게된다.
            마찬가지로 :table-data또한 props의 tableData로 가게된다. -->
            <!-- :turn은 아래의 data()에 있는 turn이고, 뒤에 "turn"은 props의 turn이다-->
        <table-component :table-data="tableData"
                        :turn="turn"
                        :winner="winner"
                        v-on:updateTurn="updateTurn"
                        v-on:updateTableData="updateTableData"
                        v-on:updateWinner="updateWinner">
        </table-component>
        <div v-if="winner">{{ winner }}님의 승리!</div>
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
        // 턴 상대를 바꾸는 것
        updateTurn (val) {
            this.turn = val
        },
        //테이블을 초기화시켜주는 것
        updateTableData () {
            this.tableData = [
                ['', '', ''],
                ['', '', ''],
                ['', '', '']
            ]            
        },
        //승자를 판별해내는 것
        updateWinner (val) {
            this.winner = val
            
        }
    }
}
</script> 