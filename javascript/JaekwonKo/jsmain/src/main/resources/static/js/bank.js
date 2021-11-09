var myMoney = 100000000;

document.querySelector('#accent').innerText = myMoney + "원";

calcMoney(1);
calcMoney(3);
calcMoney(10);

function calcMoney (years) {
    var tmpMoney = myMoney;

    for(var i =0; i < years; i++) {
        tmpMoney *= 1.03;
    }

    document.querySelector("#money" + years).innerText =
        Math.round(tmpMoney) + "원";
}