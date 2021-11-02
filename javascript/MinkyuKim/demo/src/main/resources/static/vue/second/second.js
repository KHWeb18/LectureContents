// 값 불러오기, 버튼
var app = new Vue ({
    el: '#app',
    data: {
        message: '우왕 뷰 짱',
        initMsg: "양방향 연결이 뭔지 함 볼까 ?",
        list: ['사과', '바나나', '딸기', '수박', '참외', '포도', '망고', '블루베리', '체리'],
        show: true,
        num: 3,
        count: 0,
        radius: 50,
        randomNumber: 0,
        monsterName: '',
        //json에서 배열을 하는 형식은 [] 대괄호를 쓴다.
        monsters: [
            { id: 1, name: '슬라임', hp: 30},
            { id: 2, name: '고블린', hp: 50},
            { id: 3, name: '카오스 드래곤', hp: 9999999 }
        ]  
    },
    methods: {
        // event: 사용자가 어떤 이벤트를 발생시켰는지 알 수 있음. alert(event.~~~)
        buttonClickTest: function (event) {
            //alert(event.target)
            alert('vue짱')
        },
        // 작성 형식
        // 함수이름: function () { } ===> 중괄호 내부는 일반 매서드 작성과 동일
        increment: function () {
            this.count += 1
        },
        addMonster: function () {
            //샘플용 코드            
            var arr = [1, 2, 3, 4];
            // reduce (function (유지되는 값(즉 이긴녀석의 값이 이자리로 오게 된다.), 박복하며 비교하거나 연산 대상이 되는 값))
            // 처음에는 앞의 accumulator의 내용은 무조건 비어있다.  실제로 alert(accumulator)를 하면 0값이 나옴, 이어서 1, 3, 6, 10이 출력됨
            // 즉 return accumulator + cirrentValue 0 + 1 / 0 + 1 + 2 / 0 + 1 + 2 + 3 / 0 + 1 + 2 + 3 + 4
            var sum = arr.reduce( function (accumnulator, currentValue) {
                return accumnulator + currentValue
            }, 0)
            // alert(sum) //reduce 역할 알아보기용 경고창

            // reduce()를 사용하면 알아서 내부에 있는 요소를 전부 낱개로 쪼개서 하나하나 비교하게 됨(자바스크립트 문법)
            // 그래서 function(a, b)에 입력으로 들어가는 a, b는
            // 모두 monsters 배열에 있는 각각의 낱개 요소들임

            // reduce는 전체 순회를 끝낼때까지 동작이 값이 증발되지 않으며
            // 최종 결과를 얻을때까진 이전 결과를 유지하며 연산이 진행됨
            var max = this.monsters.reduce( function(a, b) {
            // 마지막에는 결국 제일 큰 숫자가 리턴이 된다. 
            return a > b.id ? a: b.id
            }, 0)

            this.monsters.push({
                id: max + 1,
                name: this.monsterName,
                hp: 500
            })
        },
        removeMonster: function(index) {
            // 찾은 인덱스 값에서 1개를 지워라
            // 즉 인데스 값의 정보를 지워라!
            // 자바스크립트에서는 ;클론을 적지 않아도 된다. 넣어도 상관없다.(컴파일에 문제가 없음)
            this.monsters.splice(index, 1);
        },
        userAttack: function (index) {
            this.monsters[index].hp -= 10
        },
        randomGeneration () {
            // 1 ~ 10까지 난수를 생성합니다.
            this.randomNumber = Math.floor(Math.random() * 10) + 1;
        }
    },
    // 아래 내용들은 web의 console에서 확인할 수 있다.
    // 평타를 누르면 update에서 감지를 한다. 따라서 몬스터를 죽이기 위해서는 update쪽에서 없애야 한다.
    // 따라서 사용자의 행동에 따라 변하는 것을 처리하기 위해서는 update쪽에서 처리를 해야 한다.
    beforeCreate() {
        console.log('Vue 객체를 만들기 이전입니다.')
    },
    created() {
        console.log('Vue 객체를 만들었습니다.')
    },
    beforeMount() {
        console.log('HTML 요소를 붙이기 전입니다.')
    },
    mounted() {
        console.log('HTML 요소를 붙입니다.')
    },
    beforeUpdate() {
        console.log('VDOM의 변화를 감지합니다.')

        var i
        for (i = 0; i < this.monsters.length; i++) {
            if (this.monsters[i].hp <= 0) {
                // splice 배열 요소 삭제 (i, 1) => hp가 0이하인 인덱스 i 1개를 삭제해라
                this.monsters.splice(i, 1)
            }
        }
    },
    updated() {
        console.log('VDOM의 변화를 적용합니다.')
    },
    beforeDestroy() {
        console.log('Vue 객체를 파괴하기 이전입니다.')
    },
    destroyed() {
        console.log('Vue 객체를 파괴하였습니다.')
    },
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