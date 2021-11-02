var userList = [];

var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList () {

    var name = document.querySelector("#name").value;
    var age = document.querySelector("#age").value;
    var major = document.querySelector("#major").value;


    if (name != "" && age != "" && major != "") {
        var item = name + ", " + age + ", " + major;
        userList.push(item);
        document.querySelector("#name","#age","major").value = "";
        document.querySelector("#name","#age","major").focus();
    }
    showList();
}

function showList () {

    var list = "<ul>";

    for (var i = 0; i < userList.length; i++) {
        list += "<li>" + userList[i] + "<span class='close' id=" + i + "> X</span></li>";
    }
    list += "</ul>";

    document.querySelector('#userList').innerHTML = list;

    var remove = document.querySelectorAll(".close");

    for (var i = 0; i < remove.length; i++) {
        remove[i].addEventListener("click", removeList);
    }
}

function removeList () {
    var id = this.getAttribute("id");

    userList.splice(id, 1);

    showList();
}