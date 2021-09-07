<template>
    <v-layout row justify-center>
            <v-dialog v-model="dialog" persistent max-width="450">

                <template v-slot:activator="{ on }">
                    <div class="col s4 m4 l4 xl4 gray darken-5 btn-flat waves-effect waves-teal" align="center" v-on="on">
                        Genre
                    </div>
                </template>
             
                <v-card>
                    <v-card-title class="headline">
                        <p class="headline">Genre</p>
                        <p class="description">장르를 설정하시면 맞는 공연을 추천해드려요! :)</p>
                    </v-card-title>
                    <v-card-text>
                        <div class="row">
                            <p class="genreText">Rock</p>
                            <v-checkbox style="margin-top: 5px;" class="shrink mr-2" label="전부 좋아요!"></v-checkbox>
                            <div class="row">                            
                                <v-checkbox class="shrink mr-2" label="Pop"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Metal"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Punk"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Core"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Extreme"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Shoegaze"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Acoustic"></v-checkbox>
                            </div>
                       </div>
                       <div class="row">
                            <p class="genreText">Hip-Hop</p>
                            <v-checkbox style="margin-top: 5px;" class="shrink mr-2" label="전부 좋아요!"></v-checkbox>
                            <div class="row">                            
                                <v-checkbox class="shrink mr-2" label="BoomBap"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Trap"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Old-School"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Singing-Rap"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Alternative"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Lo-Fi"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="R&B"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Dance"></v-checkbox>
                            </div>
                       </div>
                       <div class="row">
                            <p class="genreText">EDM</p>
                            <v-checkbox style="margin-top: 5px;" class="shrink mr-2" label="전부 좋아요!"></v-checkbox>
                            <div class="row">                            
                                <v-checkbox class="shrink mr-2" label="House"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Disco"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Techno"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Garage"></v-checkbox> 
                                <v-checkbox class="shrink mr-2" label="Euro"></v-checkbox>  
                                <v-checkbox class="shrink mr-2" label="Ambient"></v-checkbox>                     
                            </div>
                       </div>
                       <div class="row">
                            <p class="genreText">Jazz</p>
                            <v-checkbox style="margin-top: 5px;" class="shrink mr-2" label="전부 좋아요!"></v-checkbox>
                            <div class="row">                            
                                <v-checkbox class="shrink mr-2" label="Blues"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Swing"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Fusion"></v-checkbox>
                                <v-checkbox class="shrink mr-2" label="Contemporary"></v-checkbox> 
                                <v-checkbox class="shrink mr-2" label="Free"></v-checkbox>                    
                            </div>
                       </div>
                       <div>
                           <p class="description">찾으시는 장르가 없나요? :( <br> 밑에 입력하시면 저희가 취향을 최대한 반영해드릴게요!</p>
                           <input type="text" style="font-size: 12px; font-style: italic;" v-model="basicText" @click="resetText"/>
                       </div>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <!-- <v-btn class="teal darken-1" text @click.native="btn_apply($event)">
                            적용
                        </v-btn> 클래스로하면 버튼에 색이 더해짐 -->
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
            dialog: false,
            basicText: '찾으시는 장르를 입력하세요'
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

.genreText {
    font-size: 17px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    margin-top: -5px;
}

.checkAll {
    font-size: 12px;
    font-style: italic;
    margin-top: -20px;
}

</style>