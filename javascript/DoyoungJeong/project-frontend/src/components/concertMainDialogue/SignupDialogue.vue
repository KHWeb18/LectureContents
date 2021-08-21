<template>
    <v-layout row justify-center>
            <v-dialog v-model="signupDialogue" persistent max-width="500">
   
                <template v-slot:activator="{ on }">
                    <div v-if="!allWritten">
                        <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" @click="signup">제출</v-btn>
                        <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" 
                        style="margin-left: 10px;" outlined @click="goBack">뒤로가기</v-btn>
                    </div>
                    <div v-else-if="allWritten">
                        <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" @click="confirm" v-on="on">가입하기</v-btn>
                        <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" 
                        style="margin-left: 10px;" outlined @click="goBack">뒤로가기</v-btn>
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
        }
    },
    data() {
        return {
            signupDialogue: false
        }
    },
    methods: {
        cancel() {
            this.$emit('cancel')
        },
        signup() {
            this.$emit('signup')
        },
        confirm() {
            this.$emit('confirm')
        },
        btn_apply() {
            this.signupDialogue = false
            this.$router.push({
                name: 'InterestedSetUpPage',
            })
        },
        btn_cancel() {
            this.signupDialogue = false
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
