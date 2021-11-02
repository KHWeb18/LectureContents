
var vueapp = document.querySelector('#vueapp p');
function showDetail () {
    document.querySelectorAll("#vueapp p").style.visibility = "visible";
    document.querySelector("#open").style.visibility = "hidden";
}

function hideDetail() {
    document.querySelectorAll("#vueapp p").style.display = "hidden";
    document.querySelector("#open").style.display = "visible";
}
