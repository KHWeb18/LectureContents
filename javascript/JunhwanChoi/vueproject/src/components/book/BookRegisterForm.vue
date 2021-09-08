<template>
    <v-container>

         <v-card>
                <v-app id="inspire">
            <div>
            <v-sheet
                tile
                height="54"
                class="d-flex"
            >
                <v-btn
                icon
                class="ma-2"
                @click="$refs.calendar.prev()"
                >
                <v-icon>mdi-chevron-left</v-icon>
                </v-btn>
                <v-spacer></v-spacer>
                <v-btn
                icon
                class="ma-2"
                @click="$refs.calendar.next()"
                >
                <v-icon>mdi-chevron-right</v-icon>
                </v-btn>
            </v-sheet>
            <v-sheet height="600">
                <v-calendar
                ref="calendar"
                v-model="value"
                :weekdays="weekday"
                :type="type"
                @change="getEvents"
                ></v-calendar>
            </v-sheet>
            </div>
        </v-app>
        </v-card>
        <hr>

        <form @submit.prevent="onSubmit">
            <h3>예약</h3>
            <table>
                <tr>
                    <td>Month</td>
                    <td><input type="text" v-model="month"></td>
                </tr> <tr>
                    <td>Day</td>
                    <td><input type="text" v-model="day"></td>
                </tr> <tr>
                    <td>Time</td>
                    <td><input type="text" v-model="time"></td>
                </tr>
                <tr>
                    <td>place</td>
                    <td><input type="text" v-model="place"></td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>

        
    </v-container>
</template>

<script>
export default {
    name: 'BookRegisterForm',
    data () {
        return {
            month: '',
            day: '',
            time: '',
            place: '',
        }
    },
    methods: {
        onSubmit () {
            const { month, day, time, place } = this
            this.$emit('submit', {month, day, time, place })
        }
    }
}
</script>

<style scoped>
hr{
    color:blue;
    
}
    
</style>