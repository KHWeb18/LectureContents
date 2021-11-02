<template>
    <div>
        <p class="blue lighten-5 red--text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
        <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
        <v-btn class="indigo white--text">기본 버튼</v-btn>
        <v-btn class="teal" text>기본 버튼</v-btn>
        <v-btn class="teal" dark>
            <v-icon>bluetooth</v-icon>
            <span>bluetooth</span>
        </v-btn>
        <v-btn fab color="orange" dark>
            <v-icon>bluetooth</v-icon>            
        </v-btn>
        <!-- 크기 md > sm > xs 순이며, 큰순서대로 사라짐?-->
        <v-btn color="grey" class="hidden-xs-only">Visibility -xs-only</v-btn>
        <v-btn color="blue" class="hidden-sm-only">Visibility -sm-only</v-btn>
        <v-btn color="green" class="hidden-md-only">Visibility -md-only</v-btn>
    
        <!-- 앞서 살펴봤던 container의 역할을 수행하며 
             grid 기능을 서포트해주고 기본적으로 페이지 중앙에 자동 배치함 
             추가적으로 너비를 자동 확장할 경우 fluid 옵션을 준다. -->
        <v-container fluid>
            <!-- Grid 시스템의 한 행을 정의함
                 raw 행 wrap 감싸다 
                 즉, 전체를 감싸서 삐져나오는 것이 없게 하겠다라는 의미 -->
            <v-layout row wrap>
                <!-- 12개의 컬럼으로 이루어져 한 행에서 제일 작은것들이 12개가 만들어지면 다음으로 자동 넘김 처리 -->
                <!-- md의 합이 12로 이루어진다 -->
                <v-flex xs12 md6 class="primary white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="grey white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="black white--text">
                    <div>{{ message }}</div>
                </v-flex>
            </v-layout>

            <v-layout row wrap>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{ message }}</div>
                </v-flex>
            </v-layout>
        </v-container>


        <!-- justify-center 양쪽 정렬 -->
        <v-layout row justify-center>
            <!-- 사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용 
                 대화상자가 뜨면서 결제할 것인지 취소할 것인지 어쩔건지 등등에 활용하기 좋음 -->
            <v-dialog v-model="dialog" persistent max-width="400">
                <!-- 부모컴포넌트에 on을 전송-->
                <!-- on(=mouse click event)은 이벤트 동작을 의미하며, 클릭을 할 시 버튼클릭 부분인 btn_click으로 넘어가게 된다.-->
                <!-- v-slot:activator의 activator는 구동시키다라는 의미 -->
                <!-- v-on에서 on => { on } => card-actions 순으로 동작 -->
                <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">결제</v-btn>
                </template>
                <!-- 결제를 누르게 되면 v-card가 뜨게되어있음 즉 v-slot:activator="{on}"(v-on)이 상속되어있음-->
                <v-card>
                    <v-card-title class="headline">
                        {{ service.name }}
                    </v-card-title>
                    <v-card-text>
                        5성급 호텔이 30% 할인! {{ service.name }} 결제하시겠습니까 ?
                    </v-card-text>
                    <v-card-actions>
                    <!-- 공백 만들기 -->
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                            취소
                        </v-btn>
                        <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                            결제승인
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>
    </div>

</template>

<script>
export default {    
    data() {
        return {
            message: '환장',
            dialogue: false,
            service: {
                name: '7박 8일 여행 코스'
            }
        }
    },
    //dialog 대화창 띄워주는 것
    methods: {
        btn_click ($event) {
            if($event.target.innerHTML == " 결제승인 ") {
                alert('결제가 완료되었습니다!')
                this.dialog = false
            }
        },
        roundBtnClick() {
            alert('Vuetify 버튼이라고 들어봤니 ?')
        }

    }
}
</script>

<style scoped>
h1 {
    margin: 10px;
}
p{
    padding: 10px;
    margin: 5px 10px;
}
</style>