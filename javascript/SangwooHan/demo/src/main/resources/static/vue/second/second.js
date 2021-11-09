var app = new Vue ({
    el: '#app',
    data: {
        message: '와우 뷰 짱',
        initMsg: '양빙향 연결이 뭔지 함볼까?',
        list: ['고블린','황금고블린','도깨비','사나운들쥐','주인없는고양이','황금쥐','도토리다람쥐','독버섯',
        '사나운들개','부서진피아노','거대한말벌','바나나킹콩','바나나잃은킹콩','두둥실풍선',
        '폭력적인원숭이','위험한곰','새끼곰','꿀벌'],
        show: true,
        num: 3,
        count: 0,
        radius: 50,
        randomNumber: 0,
        monsterName: '',
        monsters: [
            {id: 1, name2:'슬라임', hp:300},
            {id: 2, name2:'고블린', hp:500},
            {id: 3, name2:'스케버스주니어1세', hp:999999}
        ]
    },
    methods: {
        buttonClickTest: function (event){
            alert("데헷")
        },

    //작성 형식
    // 함수이름: function () {} ===> 중괄호 내부는 일반 매서드 작성과 동일
    increment: function (){
        this.count += 1
             },
             addMonster: function (){

                var arr = [1,2,3,4];
                var sum = arr.reduce(function (accumulator, currentValue){
                    return accumulator +currentValue
                },0)

                alert(sum)
                 // reduce()를 사용하면 알아서 내부에 있는 요소를 전부 낱개로 쪼개서 하나하나 비교하게됨
                 // 그래서 function (a,b)에 입력으로 들어가는 a,b는
                 // 모두 monsters 배열에 있는 각각의 낱개 요소들임
                 // 계속 낱개 단위로 끝까지 비교를 한다면
                 // 마지막엔 제일 큰숫자 결국 맨마지막 녀석를 얻게 될것

                 //reduce는 전체 순회를 끝날떄까지 동작이 값이 증발되지않으며
                 // 최종결과를 얻을떄까진 이전 결과를 유지하며 연산이 진행됨
                 var max = this.monsters.reduce( function (a,b){
                    return a > b.id ? a : b.id
                 },0)

                 this.monsters.push({
                     id: max +1,
                     name2 : this.monsterName,
                     hp: 500
                 })
             },
             removeMonster: function (index) {
                   // 찾은 인덱스 값에서 1개를 지워라
            // 즉 인덱스 값의 정보를 지워라!
            this.monsters.splice(index,1);
             },

             userAttack: function (index){

                this.monsters[index].hp -=10
             },
             randomGeneration (){
                 this.randomNumber = Math.floor(Math.random() * 10) +1;
             }

             
       

        },
        beforeCreate() {
            console.log('Vue 객체를 만들기 이전입니다.')
        },
        created() {
            console.log('vue 객체를 만들었습니다.')
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
           for(i = 0; i< this.monsters.length; i++){
            if (this.monsters[i].hp <= 0){
                    this.monsters.splice(i,1)
            }
           } 
        },

          


        
        updated() {
            console.log('VDOM의 변화를 적용합니다.')
        },
        beforeDestroy() {
            console.log('Vue객체를 파괴하기 이전입니다.')
        },
        destroyed() {
            console.log('vue 객체를 파괴하였습니다.')
        },

})