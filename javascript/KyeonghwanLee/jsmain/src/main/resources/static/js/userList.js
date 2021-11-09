var userList = [];

var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList(){
    
    //입력 데이터 가져오기
    var name = document.querySelector("#name").value;
    var age = document.querySelector("#age").value;
    var major = document.querySelector("#major").value;

    if (name != null){
        var item = name + ", " + age + "," + major;
        userList.push(name);
        userList.push(age);
        userList.push(major);
        //id가 "item"인 요소 값을 지움
        document.querySelector("#name").value = "";
        document.querySelector("#age").value = "";
        document.querySelector("#major").value = "";
        //입력창에 포커싱 적용
        document.querySelector("#name").focus();
    }

    showList();

}

function showList(){

    var list = "<ul>";



    for( var i = 0; i <userList.length; i++){
        list += "<li>" + userList[i] + "<span class ='close' name="+ i + "> X</span></li>";
        list += "<li>" + userList[i] + "<span class ='close' age="+ i + "> X</span></li>";
        list += "<li>" + userList[i] + "<span class ='close' major="+ i + "> X</span></li>";
    }

    list += "</ul>";

    document.querySelector('#userList').innerHTML = list;

    var remove = document.querySelectorAll(".close");

    for (var i = 0; i < remove.length; i++){
        remove[i].addEventListener("click", removeList);
    }
}

function removeList(){
    //모든 객체는 자기 자신인 this를 가지고 있어서
    // this(클릭한 삭제 버튼 x )의 id 값을 가져와 id로 설정
    var name = this.getAttribute("name");
    var age = this.getAttribute("age");
    var major = this.getAttribute("major");

    //itemList 배열에서 인덱스 값이 id인 요소 1개를 삭제함
    //(2개면 숫자가 2가 들어가며 3개면 3임)
    userList.splice(id, 3);

    //변경 정보를 다시 화면 출력함
    showList();
}