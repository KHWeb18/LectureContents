<template>
    <v-layout row justify-center>
            <v-dialog v-model="dialog" persistent max-width="400">
                <!-- dialog는 팝업창 띄워주는역할 -->
                <template v-slot:activator="{ on }">
                    <!-- <v-btn color="primary" dark v-on="on">Genre</v-btn> -->
                    <div class="col s4 m4 l4 xl4 gray btn-flat waves-effect waves-yellow" align="center" v-on="on">                    
                        Date
                    </div>
                </template>
                <!-- 팝업창에서 선택하는 폼이라는데.. 이해가 잘안되서 패턴처럼 외우는게 나을듯 
                어쨋든 이 dialog 기능을 on시키는거라고 생각하면된다. -->
                <v-card>
                    <v-card-title class="headline">
                        <p class="headline">Date</p>
                        <p class="description">입력하신 날짜에 해당하는 공연을 추천해드려요! :)</p>
                    </v-card-title>
                    <v-card-text>
                        <div class="row">
                            <p style="font-size: 15px; margin-top: 13px; margin-right: 40px;">from</p>
                            <input type="date" name="date" style="width: 270px;">
                            <p style="font-size: 15px; margin-top: 13px; margin-right: 40px;">to</p>                       
                            <input type="date" name="date" style="width: 288px;">
                        </div>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click.native="btn_apply($event)">
                            적용
                        </v-btn>
                        <v-btn color="teal darken-1" text @click.native="btn_cancel($event)">
                            취소
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>
</template>

<script>

export default {
    name: 'Dialogue',
    data() {
        return {
            dialog: false
        }
    },
    methods: {
        btn_apply() {
            alert('적용되었습니다.')
            this.dialog = false
        },
        btn_cancel() {
            alert('변경 취소')
            this.dialog = false
        },
        resetText() {
            this.basicText = ''
        }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,900&display=swap');

.headline {
    font-size: 30px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    margin-right: 10px;
}

.description {
    font-size: 12px;
    font-style: italic;
    margin-top: 10px;
}

</style>
