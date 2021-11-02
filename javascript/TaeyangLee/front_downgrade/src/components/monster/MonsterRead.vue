<template>
    <div>
        <h3>Vue + Spring + DB 몬스터도감보기</h3>
        <table>
            <tr>
                <td>몬스터번호</td>
                <td><input type="text" :value="monster.monsterNo" readonly></td>
            </tr>
            <tr>
                <td>몬스터명</td>
                <td><input type="text" :value="monster.monster_name" readonly></td>
            </tr>
            <tr>
                <td>체력</td>
                <td><input type="number" :value="monster.monster_hp" readonly></td>
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