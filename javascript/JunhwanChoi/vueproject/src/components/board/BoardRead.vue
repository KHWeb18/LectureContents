<template>
    <div>
        <h3>최수바리의 후기</h3>
        
            <v-container>
                <table border="1">
                    <tr>
                        <td>백신종류</td>
                        <td><input type="text" :value="board.vaccine" readonly></td>
                    </tr>
                    <tr>
                        <td>나이</td>
                        <td><input type="text" :value="board.age" readonly></td>
                    </tr>
                    <tr>
                        <td>성별</td>
                        <td><input type="text" :value="board.gender" readonly></td>
                    </tr>
                    <tr>
                        <td>후기</td>
                        <td><textarea cols="50" rows="20" :value="board.content" readonly></textarea></td>
                    </tr>
                </table>
            </v-container>
            
    </div>
</template>

<script>
export default {
    name: 'BoardRead',
    props: {
        board: {
            type: Object,
            required: true
        }
    }    
}
</script>
