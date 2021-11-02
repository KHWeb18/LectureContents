var money  = 1000000;
var profit = money*(4/100);


calcMoney(1)
calcMoney(3)
calcMoney(10)


function calcMoney (days) {
    var finalMoney = money +(profit*days)
 
     document.querySelector("#money").innerText =
      "나의돈은?"+finalMoney 
 }
 