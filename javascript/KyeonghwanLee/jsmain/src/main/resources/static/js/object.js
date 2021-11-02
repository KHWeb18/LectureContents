// object = ? 객체
// 객체는 ? 데이터가 메모리에 올라간 상태
// 자바스크립트에서는 별도로 클래스나 특정 키워드 없이도 아래와 같이 그냥 중괄호로 묶어버리면 클래스 형태의 객체를 만들수 있다.
var toyRobot = {

    //자바스크립트 내부에서 값을 배치하는 작업은 JSON 형식을 따른다.
    productId: "1234-34",
    name: "Thunder Bird",
    price: "25,000,000",
    madeIn: "Korea",
    quantity: 1,
    //function이라는 매서드를 집어넣음
    showStock: function() {
        document.querySelector('#display').innerHTML = 
        this.name + "제품은" + this.quantity+"개 남아있다.";

    }
};

toyRobot.showStock();