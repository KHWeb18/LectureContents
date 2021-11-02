<template>
  <div>
    <!-- 글씨, 배경색 -->
    <p class="blue lighten-5 red--text">Test</p>
    <p class="blue">Test</p>
    <p class="blue darken-3 white--text">Test</p>
    
    <!-- 버튼 -->
    <v-btn class="teal" rounded @click="roundBtnClick">Round Button</v-btn>
    <v-btn class="indigo white--text">Basic</v-btn>
    <v-btn class="orange" text>Basic</v-btn>
    <v-btn class="pink" dark>
      <v-icon>bluetooth</v-icon>
      <span>bluetooth</span>
    </v-btn>
    <v-btn fab color="purple" dark>
      <v-icon>bluetooth</v-icon>
    </v-btn>

    <!-- 버튼 숨기기 -->
    <v-btn color="red" class="hidden-xs-only">xs</v-btn> <!-- 화면 창이 작으면 xs버튼 사라짐 -->
    <v-btn color="orange" class="hidden-sm-only">sm</v-btn> <!-- 화면 창이 중간이면 sm버튼 사라짐 -->
    <v-btn color="yellow" class="hidden-md-only">md</v-btn> <!-- 화면 창이 크면 md버튼 사라짐 -->

    <!-- 그리드(Grid) -->
    <!-- container: container(화면 70% 차지)역할을 수행하며 그리드 기능을 서포트 해주고
         페이지 중앙정렬을 기본으로 함, 너비를 자동 확장할 경우 fluid 옵션을 줌 -->
    <v-container fluid>
      <!-- 그리드 시스템의 한 행을 정의 -->
      <v-layout row wrap>
        <!-- 12개의 컬럼으로 이루어져 한 행에서 제일 작은 것들이 12개가 만들어지면 자동으로 다음으로 넘어 감 -->
        <v-flex xs12 md6 class="primary white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="green white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="indigo white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="purple white--text">
          <div>{{ message }}</div>
        </v-flex>
      </v-layout>
      <v-layout row wrap>
        <v-flex xs4 md3 class="primary white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md3 class="primary white--text">
          <div>{{ message }}</div>
        </v-flex>
      </v-layout>
    </v-container>

    <!-- 알림창 -->
    <!-- justify-center: 양쪽 정렬 -->
    <v-layout row justify-center>
      <!-- v-dialog: 사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용
                     대화상자가 뜨면서 알림이나 선택 등등에 활용하기 좋음-->
      <v-dialog v-model="dialog" persistent max-width="400">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">결제</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            {{ service.name }}
          </v-card-title>
          <v-card-text>호텔 30% 할인! {{ service.name }} 결제하시겠습니까?</v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click.native="btn_click($event)">취소</v-btn>
            <v-btn color="teal darken-1" text @click.native="btn_click($event)">결제</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>
  </div> 
</template>


<script>
export default {
  data () {
    return {
      message: 'Grid!!!!!',
      dialog: false,
      service: {
        name: '일주일 여행 코스'
      }
    }
  },
  methods: {
    roundBtnClick () {
      alert('Vuetify button')
    },
    btn_click ($event) {
      if($event.target.innerHTML === '결제') {
        alert('결제가 완료되었습니다.')
        this.dialog = false
      }
    }
  }
}
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