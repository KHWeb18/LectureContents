

public class fourteen {
    public static void main(String[] args) {
        ////51. 종합 문제
        //ArrayList를 활용하여 상점을 만들어보자!
        //구매, 판매, 목록보기
        //소지금, 물건의 구매가 등을 지정해서 적정 버튼을 누르면 처리되도록 만들어봅시다!
        //초기에 판매리스트에는 아무것도 없다.
        //초기에는 상점 주인이 파는 구매 리스트만 존재한다.
        //물건을 구매하면 구매한 물품이 판매 리스트에 보인다.
        //목록 보기는 단순히 현재 소지한 물건 리스트만 보여준다.


        // 판매 목록 array 하나
        // 같은 인덱스로 물건 가격 array 하나

        // 구매 목록(내 가방) array 하나
        // 똑같이 가격

        // 와리가리는 어떻게 하지? 검색으로 하자 값 받아다 인덱스 번호 찾고 그 숫자를 와리가리
        //

        Shop cd = new Shop();

        cd.setShopLists();
        cd.setMoney();
        cd.wellCome();


    }
}

// 배열에 있을때는
/*
for (int i = 0; i < ~~.length; i++) {
    if (arr[i].equals(키보드입력데이터)) {
        여기서 if문 내부로 들어가면 해당 i 인덱스가 찾은 데이터가 위치하는 인덱스임을 뜻함
    }
}
 */

/*
for (int i = 0; i < ~~~; i++) {
    ~~~
}
sout(i) ?
i 변수가 for문 내부에서만 사용할 수 있으므로 외부 사용 불가
 */