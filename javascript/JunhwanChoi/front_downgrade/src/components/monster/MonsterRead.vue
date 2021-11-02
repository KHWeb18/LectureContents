
<template>
    <div>
        <h3>몬스터 도감</h3>
        <table border="1">
            <tr>
                <td>몬스터번호</td>
                <td><input type="text" :value="monster.monsterNo" readonly></td>
            </tr>
            <tr>
                <td>몬스터명</td>
                <td><input type="text" :value="monster.name" readonly></td>
            </tr>
            <tr>
                <td>체력</td>
                <td><input type="text" :value="monster.hp" readonly></td>
            </tr>
            <tr>
                <td>경험치</td>
                <td><input type="text" :value="monster.exp" readonly></td>
            </tr>
            <tr>
                <td>드랍머니</td>
                <td><input type="text" :value="monster.dropMoney" readonly></td>
            </tr>
            <tr>
                <td>드랍아이템</td>
                <td><input type="text" :value="monster.dropItem" readonly></td>
            </tr>
            <tr>
                <td>몬스터설명</td>
                <td><textarea cols="50" rows="20" :value="monster.description" readonly></textarea></td>
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