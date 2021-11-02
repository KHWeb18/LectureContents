<template>
  <div>
    <p class="blue lighten-5 red--text">Test</p>
    <p class="blue white--text">Test</p>
    <p class="blue darken-3">Test</p>
    <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
    <v-btn class="indigo white--text">기본 버튼</v-btn>
    <v-btn class="teal" dark>
      <v-icon>bluetooth</v-icon>
      <span>bluetooth</span>
    </v-btn>
    <v-btn fab color="orange" dark>
      <v-icon>bluetooth</v-icon>
    </v-btn>
    <v-btn color="red" class="hidden-xs-only">Visibility -xs-only</v-btn>
    <v-btn color="green" class="hidden-sm-only">Visibility -sm-only</v-btn>
    <v-btn color="blue" class="hidden-md-only">Visibility -md-only</v-btn>

    <!-- 앞서서 살펴봤던 container의 역할을 수행하며
         grid기능을 서포트해주고 기본적으로 페이지 중앙에 자동 배치함 
         추가적으로 너비를 자동 확장할 경우 fluid 옵션을 준다. -->
    <v-container fluid>
      <!-- Grid 시스템의 한 행을 정의함 -->
      <v-layout row wrap>
        <!-- 12개의 컬럼으로 이뤄져 한 행에서 제일 작은것들이 12개가
             만들어지면 다음으로 자동 넘김 처리 -->
        <v-flex xs12 md6 class="primary white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="green white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="green white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="green white--text">
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

    <v-layout row justify-center>
        <!-- 사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용
            대화상자가 뜨면서 결제할 것인지 취소할 것인지 어쩔건지 등등에 활용하기 좋음 -->
        <v-dialog v-model="dialog" persistent max-width="400">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">결제</v-btn>
            </template>
            <v-card>
            <v-card-title class="headline">
                {{ service.name }} 
            </v-card-title>
            <v-card-text>
                5성급 호텔이 30% 할인! {{ service.name }} 결제 하시겠습니까?
            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                취소
                </v-btn>
                <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                결제 승인
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
      message: "fuck",
      dialog: false,
      service: {
          name: '7박8일 여행 코스'
      }
    };
  },
  methods: {
      btn_click($event) {
          if($event.target.innerHTML == " 결제승인 ") {
              alert('결제가 완료되었습니다!')
              this.dialog = false
          }
      },
    roundBtnClick() {
      alert("Vuetify 버튼이라고 들어봤니 ?");
    },
  },
};
</script>

<style scoped>
h1 {
  margin: 10px;
}
p {
  padding: 10px;
  margin: 5px 10px;
}
</style>