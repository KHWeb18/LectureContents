<template>
    <table>
        <!--table을 사용하게 되는 경우 tr td(th)를 사용하게 된다.
        하지만 순수 html태그와 java태그를 tr, td를 통해 연결하기 어렵다(DOM을 사용하여야만 가능)
        따라서 전용컴포넌트 tr-component를 만들어 사용한다 -->
        <!-- 2중배열로 되어있는 tableData를 v-for를 이용하여 -->

        <!-- bind로 연결된 row-data/row-index/table-data/turn/winner 는 TrComponent의 props로 연결된다.(명명규칙) -->
        <!-- 상위컴포넌트를 알기 위해서는 내가 전달하는 컴포넌트가 있는지, 
            즉 아래처럼 tr-component로(하위컴포넌트) props를 통해 정보를 전달하게됨-->

        <!--tableData는 rowData만큼(3번) 루프를 돌게 되므로, <tr><td> 또한 3번 반복되게 된다. 
            또한 클릭을 할 경우 비동기처리를 시킨다.-->
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
    // props는 bind 로 받은것들 세팅하는 곳
    props: {
        // views/Concave.vue에서 bind한 tableData가 Array다, turn과 winner도 마찬가지
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