<template>
    <div>
        <h3>몬스터 세부사항 보기</h3>
        <table>
            <tr>
                <td>번호</td>
                <td><input type="text" :value="monster.monsterNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="monster.regDate" readonly></td>
            </tr>
            <tr>
                <td>몬스터명</td>
                <td><input type="text" :value="monster.monsterName" readonly></td>
            </tr>
            <tr>
                <td>HP</td>
                <td><input type="number" :value="monster.monsterHp" readonly></td>
            </tr>
            <tr>
                <td>EXP</td>
                <td><input type="number" :value="monster.monsterExp" readonly></td>
            </tr>
            <tr>
                <td>Money</td>
                <td><input type="number" :value="monster.monsterMoney" readonly></td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MonsterRead',
    props: {
        monster: {
            type: Object,
            required: true
        }
    }    
}
</script>

<style scoped>
/* td {
  text-align: center;
} */
</style>