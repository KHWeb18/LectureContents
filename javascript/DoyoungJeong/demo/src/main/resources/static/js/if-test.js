var userNumber = prompt("Input Number: ");
var displayArea = document.querySelector('#result');

if(userNumber != null) {
    if(userNumber % 3 ===0) {
        displayArea.innerHTML = userNumber + "는 3의 배수"
    } else  {
        displayArea.innerHTML = userNumber + "는 3의 배수가 아님."
    }

} else {
    alert("입력 취소")
}