<template>
    <v-container>
        <table border="1">
            <tr v-for="(board, idx) in boards" v-bind:key="idx">
                <td align="center">
                    <img :src="require(`@/assets/img/${board.img}`)">
                </td>
            </tr>
        </table>
    </v-container>
</template>

<script>

export default {
    name: 'ImgTestPage',
    data () {
        return {
            info: 'Spyder.jpg',
            boards: [
                {
                    img: 'Spyder.jpg'
                },
                {
                    img: 'tesla_model_x.jpg'
                }
            ]
        }
    }
}

</script>