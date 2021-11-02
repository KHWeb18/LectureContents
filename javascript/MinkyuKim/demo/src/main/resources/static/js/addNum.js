//++ 자바스크립트에서는 메소드가 아니라 펑션이라 지칭하며, 클래스 없는 메소드라 생각하면 된다.
function addNumber () {
    var num1 = parseInt(prompt("첫 번째 숫자는 ?"))
    var num2 = parseInt(prompt("두 번째 숫자는 ?"))
    var result = add(num1, num2);

    document.write("<p>" + num1 + " + " + num2 + " = " + result + "</p>"); 
}

function add(a, b) {
    var sum = a + b;
    return sum;
}
