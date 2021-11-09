function showDetail () {
    document.querySelector('#desc').style.display = "block";
    document.querySelector('#open').style.display = "none";
}

function hideDetail () {
    //diplay 옵션에 none이 들어가면 눈에보이는 것들이 사라짐(데이터가 아닌 시각적인 부분에서만)
    // block은 세로로배치
    document.querySelector('#desc').style.display = "none";
    document.querySelector('#open').style.display = "block";
}

