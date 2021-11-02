// 일종의 생성자 역할을 해줄 수 있는 함수
function Book (title, author, volume, price, url) {
    this.title = title;
    this.author = author;
    this.volume = volume;
    this.price = price;
    this.url = url;
}

// 작성한 함수를 사용해서 html, youtube, python 객체를 만든다.
var html = new Book('웹 마스터', 'Ko', '608', '38,000', '/lists');
var youtube = new Book('하루만에 만드는 유튜브', 'Kim', '1068', '40000', '/member/register');
var python = new Book('일주일만에 파이썬', 'Park', '352', '18000', '#');

// html, youtube, python 객체를 배열에 저장
var bookList = [html, youtube, python];

// bookList: [ {}, {}, {} ]
// html: { title: ~~~, author: ~~~, volume: ~~~, price: ~~~ }

document.write("<h1>책 제목으로 살펴보기!</h1>");

for (var i = 0; i < bookList.length; i++) {
    document.write("<p><a href='" + bookList[i].url + "'>" + bookList[i].title + ", 가격: " +
            bookList[i].price + ", 쪽수: " + bookList[i].volume + "</a></p>");
}