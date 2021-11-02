<template>
    <div>
        <h3>몬스터 도감 읽기</h3>
        <table>
            <tr>
                <td>몬스터번호</td>
                <td><input type="text" :value="monster.monsterNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="monster.regDate" readonly></td>
            </tr>
            <tr>
                <td>몬스터이름</td>
                <td><input type="text" :value="monster.name" readonly></td>
            </tr>
            <tr>
                <td>몬스터정보</td>
                <td><textarea cols="50" rows="10" :value="monster.description" readonly></textarea></td>
            </tr>
            <tr>
                <td>hp</td>
                <td><input type="number" :value="monster.hp" readonly></td>
            </tr>
            <tr>
                <td>경험치</td>
                <td><input type="number" :value="monster.exp" readonly></td>
            </tr>
            <tr>
                <td>드랍머니</td>
                <td><input type="text" :value="monster.dropMoney" readonly></td>
            </tr>
            <tr>
                <td>드랍아이템</td>
                <td><input type="text" :value="monster.dropItem" readonly></td>
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