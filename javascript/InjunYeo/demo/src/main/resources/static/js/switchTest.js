var session = prompt("세션 선택! 1. 마케팅, 2.개발, 3.디자인");

switch (session) {
    case "1":
        document.write("<p> 마케팅 및 투자 전략: <strong>201호</strong> 오후 1시</p>");
        break;
    case "2":
        document.write("<p> tms570 펌웨어 개발: <strong>203호</strong> 오후 3시</p>");
        break;
    case "3":
        document.write("<p> UX/UI 디자인의 진수: <strong>205호</strong> 오전 10시</p>");
        break;
    default:
        alert("올바른입력하시오");
        break;
}