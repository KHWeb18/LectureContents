<template>
    <div>
        <h3>몬스터 목록 읽기</h3>
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
                <td>이름</td>
                <td><input type="text" :value="monster.monster_name" readonly></td>
            </tr>
            <tr>
                <td>HP</td>
                <td><input type="text" :value="monster.monster_hp" readonly></td>
            </tr>
            <tr>
                <td>몬스터 경험치</td>
                <td><input type="text" :value="monster.monster_exp" readonly></td>
            </tr>
            <tr>
                <td>몬스터 드랍머니</td>
                <td><input type="text" :value="monster.monster_money" readonly></td>
            </tr>
            <tr>
                <td>상세설명</td>
                <td><textarea cols="50" rows="20" :value="monster.monster_description" readonly></textarea></td>
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
