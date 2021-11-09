var itemList = [];

var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList () {
    var name = document.querySelector("#name").value;
    var age = document.querySelector("#age").value;
    var major = document.querySelector("#major").value;

    if (name != null) {
        var item = name + ", " + age + ", " + major;
        itemList.push(item);
        document.querySelector("#name").value = "";
        document.querySelector("#age").value = "";
        document.querySelector("#major").value = "";
    }

    showList();
}

function showList () {
    var list = "<ul>";

    for (var i = 0; i < itemList.length; i++) {
        list += "<li>" + itemList[i] + "<span class='close' id=" + i + "> X</span></li>";
        // 배열로 할 시 : list += "<li>" + "이름: " + name[i] ....    변수도 따로줘야함 var name = [] ....
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
    itemList.splice(id, 1);
    showList();
}