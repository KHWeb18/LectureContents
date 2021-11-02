<template>
    <div align="center">
        <h3>Uploaded Monsters List on Now</h3>
        <table>
            <tr>
                <td align="center" width="80">No</td>
                <td align="center" width="120">Name</td>
                <td align="center" width="80">Level</td>
                <td align="center" width="100">Strength</td>
                <td align="center" width="100">HP</td>
                <td align="center" width="200">Attribute</td>
                <td align="center" width="100">Exp</td>
            </tr>
            <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <!-- 'monsters가 없으면' 이라는 뜻 -->
                <td colspan="7">
                    Any Monsters Has Not Uploaded Yet!
                </td>
            </tr>
            <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'MonsterReadPage', 
                        params: { monsterNo: monster.monsterNo.toString() } }">
                    {{ monster.name }}
                    </router-link>
                    
                </td>
                <td align="right">{{ monster.level }}</td>
                <td align="center">{{ monster.strength }}</td>
                <td align="right">{{ monster.hp }}</td>
                <td align="center">{{ monster.attribute }}</td>
                <td align="right">{{ monster.exp }}</td>
            </tr>
        </table>
    </div>
    
</template>

<script>

export default {
    name: 'MonsterStorage',
    props: {
        monsters: {
            type: Array
        }
    }

}
</script>
