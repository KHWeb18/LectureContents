// 값 불러오기, 버튼
var app = new Vue ({
    el: '#app',
    data: {
        message: '우왕 뷰 짱',
        initMsg: "양방향 연결이 뭔지 함 볼까 ?",
        list: ['사과', '바나나', '딸기', '수박', '참외', '포도', '망고', '블루베리', '체리'],
        // 기존의 돔 방식 : 모두 찾아, 적용시키고 하느라 규모가 커질수록 오래걸림.
        // 가상돔 : 뺄거 빼고 가져다 씀 :속도가 빠르다.
        show: true
    },
    methods: {
        buttonClickTest: function (event) {
            //alert(event.target)
            alert('vue짱')
        }
    }
})

//html 코드에서 list에 있는것을 모두 item에 집어넣으라고 하고 있다.
// el -> id랑 맵핑(vue 인스턴스가 그려질 지점 지정)
// data -> 화면에 보여질 데이터를 정의
// item in list -> for-each문과 유사

/* html
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <!-- 어떤 동작을 하겠다는 가닥을 잡아놓고 -->

    <div id ="app">
        <p>{{ message }}</p>
        <ol>
            <li v-for="item in list">{{ item }}</li>
        </ol>
        <button v-on:click="buttonClickTest">클릭해봐!</button>

        <!--양방향 설정 -->
        <input v-model="initMsg">
        <p>{{ initMsg }}</p>

    </div>
    <!-- 위의 내용을 실행 하라고 명령함. -->
    <script src="/vue/second/for.js"></script>

    스크립트 구문은 맨 아래에 적어야함.
*/