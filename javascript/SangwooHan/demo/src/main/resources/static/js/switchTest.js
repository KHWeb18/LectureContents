var session = prompt("세션 선택! 1.마케팅, 2.개발, 3.디자인","1");

switch(session){
    case "1":
        document.write("<p>마케팅 및 투자 전략: <strong>201호</strong> 오후1시</p>");
        break;
        case "2":
            document.write("<p>마케팅 및 투자 전략: <strong>203호</strong> 오후3시</p>");
            break;
            case "3":
                document.write("<p>마케팅 및 투자 전략: <strong>205호</strong> 오전10시</p>");
                break;
                default:
                    alert("똑바로 입력하시오.");
                    break;
}