<template> <!-- 쓰지않는 컴포넌트 -->
    <v-layout row justify-center>
            <v-dialog v-model="signupDialogue" persistent max-width="500">
   
                <template v-slot:activator="{ on }">

                    <div v-if="allWritten && signupSuccess">
                        <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" v-on="on">추가 설정</v-btn>
                        <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" 
                        style="margin-left: 10px;" outlined @click="goBack">다음에 할래요</v-btn>
                    </div>
                </template>
         
                <v-card>
                    <v-card-title class="headline">
                        <p id="headline">SIGN UP</p>
                        <p id="description">가입을 축하드려요 :) 지금 관심있는 장르, 아티스트 설정을 하실 수 있습니다!</p>
                    </v-card-title>
                    
                    <v-card-text>
                        
                    </v-card-text>

                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click.native="btn_apply($event)">
                            지금 할래요!
                        </v-btn>
                        <v-btn color="teal darken-1" text @click.native="btn_cancel($event)">
                            괜찮아요 나중에할게요!
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>
</template>

<script>

export default {
    name: 'SignupDialogue',
    props: {
        allWritten: {
            type: Boolean,
            required: true
        },
        signupSuccess: {
            type: Boolean
        }
    },
    data() {
        return {
            signupDialogue: false
        }
    },
    methods: {
        btn_apply() {
            this.$router.push({
                name: 'InterestedSetUpPage',
            })
        },
        btn_cancel() {
            this.$router.push({
                name: 'MainPage',
            })
        },
        goBack() {
            this.$router.push({
                name: 'MainPage',
            })
        }
    }
}
</script>
