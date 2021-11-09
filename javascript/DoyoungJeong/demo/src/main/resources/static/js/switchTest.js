var session = prompt("choose lecture - 1. marketing, 2. development, 3. design ", "1");

switch(session) {
    case "1":
        document.write("<p>마케팅 및 투자 전략: <strong>201호 1pm</strong></p>");
        break;
    case "2":
            document.write("<p>펌웨어 개발: <strong>203호 1pm</strong></p>");
            break;    
    case "3":
        document.write("<p>디자인 전략: <strong>204호 1pm</strong></p>");
        break;
    case "4":
            document.write("<p>경영학 이론: <strong>205호 1pm</strong></p>");
            break;   
    default:
        alert('올바른 값입력');
        break;                   
}