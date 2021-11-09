var itemList = [];

// id가 add인 녀석을 클릭 했을때 addList()가 동작함
var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList () {
    // 입력 데이터 가져오기
    var name = document.querySelector("#name").value;
    var age = document.querySelector("#age").value;
    var major = document.querySelector("#major").value;


    if (name != null) {
        var item = name + ", " + age + ", " + major;
        // 입력 데이터 추가
       itemList.push(item);
        // id가 "item"인 요소 값을 지움
        document.querySelector("#name").value = "";
        document.querySelector("#age").value = "";
        document.querySelector("#major").value = "";
        // 입력창에 포커싱 적용

    }

    showList();
}


function showList() {
    var list = "<ul>";

    for(var i = 0; i< itemList.length; i++) {
        list += "<li>" + itemList[i] + "<span class='close' id=" + i + "> 삭제</span></li>";
    }
    list += "</ul>";

    document.querySelector('#userList').innerHTML = list;

    var remove = document.querySelectorAll(".close");

    for (var i = 0; i < remove.length; i++) {
        remove[i].addEventListener("click", removeList);
    }
}

function removeList () {
    // 모든 객체는 자기 자신인 this를 가지고 있어서
    // this(클릭한 삭제 버튼 x)의 id 값을 가져와 id로 설정
    var id = this.getAttribute("id");

    // itemList 배열에서 인덱스 값이 id인 요소 1개를 삭제함
    // (2개면 숫자가 2가 들어가며 3개면 3임)
    itemList.splice(id, 1);

    // 변경 정보를 다시 화면 출력함
    showList();
}