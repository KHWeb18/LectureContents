var userNumber = prompt("Input Number: ")
var displayArea = document.querySelector('#result');

if (userNumber != null){
    if(userNumber % 3 === 0){
        displayArea.innerHTML = userNumber + "는 3의배수입니다.";
    }else{
        displayArea.innerHTML =userNumber + "는 3의 배수가 아닙니다!";

    }

    

}else{
    alert('동작취소');
}

// (==) 의경우 서로 타입이 달라도 같은타입으로 강제변환하여 비교함
// (===) 타입까지 같아야 일치하는것으로 인정 