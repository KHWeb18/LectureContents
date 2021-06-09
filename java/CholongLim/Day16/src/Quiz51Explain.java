// ArrayList를 활용하여 상점을 만들어보자!
// 구매, 판매, 목록보기
// 소지금, 물건의 구매가 등을 지정해서 적정 버튼을 누르면 처리되도록 만들어봅시다!
// 초기에 판매리스트에는 아무것도 없다.
// 초기에는 상점 주인이 파는 구매 리스트만 존재한다.
// 물건을 구매하면 구매한 물품이 판매 리스트에 보인다.
// 목록 보기는 단순히 현재 소지한 물건 리스트만 보여준다.

// 1. 상점 목록과 상점 가격은 배열로 처리한다.
// 2. 사용자의 구매 목록은 ArrayList로 처리한다.
// 3. 소지금을 설정한다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Market {
    private ArrayList<String> userBuyList;  // 구매목록
    private ArrayList<Integer> userBuyListStock;  // 구매물품 수량체크

    private String[] marketSellList = {"선풍기", "키보드", "마우스", "모니터"};  // 마켓의 판매상품
    private int[] marketSellListPrice = {380000, 80000, 70000, 400000};  // 판매상품의 가격

    private int myMoney;  // 수중 금액

    private Boolean continueShopping;
    Scanner scan;

    final int DEFAULT_IDX = 1;

    public Market () {
        userBuyList = new ArrayList<String>();
        userBuyListStock = new ArrayList<Integer>();

        continueShopping = false;

        scan = new Scanner(System.in);
    }

    public void doShopping () {
        do {
            // 1. 마켓에서 판매하는 물품을 보여줌
            showMarketSellList();
            // 2. 구매할 물건을 선택하세요.
            //    어떻게 선택하지 ?
            //    키보드 입력이나 뭔가가 필요한거 같네 ?
            //    가만 보니 초기에 Scanner를 안만들었구나 추가!
            selectBuyItem();
            // 3. 구매리스트가 작성되었다면 비용 산정 진행
            doPayment();
            // 4. 계속 구매할 것인지 여부 판단
            checkContinueShopping();
        } while (continueShopping);
    }

    private void checkContinueShopping () {
        Boolean isOK = false;

        do {
            System.out.print("쇼핑을 계속하시겠습니까 ? Y/N");
            scan.nextLine();
            String res = scan.nextLine();

            if (res.equals("Y")) {
                isOK = false;
                continueShopping = true;
            } else if (res.equals("N")) {
                isOK = false;
                continueShopping = false;
            } else {
                isOK = true;
                continue;
            }
        } while (isOK);
    }

    private void doPayment () {
        // userBuyList, userBuyListStock에
        // 구매 물품과 구매 물량이 기록되어 있음
        // 물건 가격 정보는 marketSellList, marketSellListPrice 를 통해 알 수 있음
        // userBuyList와 userBuyListStock을 활용하여 어떤 물건을 몇 개 구하는지 체크하고
        // marketSellList, marketSellListPrice를 활용하여 가격 정보를 획득하여
        // 전부 합산 얼마가 나오는지 계산하도록 한다.
        // 그리고 지갑에다가 적용한다.(지갑 설정기능이 빠져있음 현재)


//          myMoney -= (구매 물품 가격  * 구매물량)
//         userBuyList있는 구매 물품과 marketSellListPrice있는 상품 가격을 어떻게 관련시킬까?
//         marketSellList를 ArrayList화 하여,
//         [0] = 선풍기, [1] = 키보드, [2] = 마우스, [3] = 모니터로 만들어주고
//         indexOf(userBuyList.get(i))하였을때 marketSellList에서 해당 인덱스 번호를 찾아내기...
//        의 방법밖에 떠오르지 않는다.

        ArrayList<String> sellObj = new ArrayList<>(Arrays.asList(marketSellList));
        Boolean isntPay = false; //지불했다면 반복에서 벗어남
        do {
            System.out.println("현재 가지고 있는 소지금을 입력하세요 : ");
            myMoney = scan.nextInt();

            if (myMoney <= 0) {
                System.out.println("소지금을 다시 입력하세요.");
                isntPay = true;
                continue;
            } else if (myMoney > 0){
                System.out.println("==========영수증==========");
                for (int i = 0; i < userBuyList.size() ; i++) {
                    int obj = sellObj.indexOf(userBuyList.get(i));
                    int objPay = marketSellListPrice[obj];
                    myMoney -= (objPay * userBuyListStock.get(i));

                    System.out.printf("%s(수량 : %s)" +
                            "가격 : %s\n",userBuyList.get(i),userBuyListStock.get(i),objPay * userBuyListStock.get(i));
                }
            }
            System.out.println("나의 소지금 = " + myMoney);
            System.out.println("=========================");
        } while(isntPay);
    }

    private void selectBuyItemStock (String selectItem) {
        Boolean isntErrorAmount = true;
        int amount;

        do {
            System.out.print("구매할 수량을 선택하세요: ");

            amount = scan.nextInt();

            if (amount <= 0) {
                System.out.println("잘못된 수량이니 다시 입력해주세요!");
                continue;
            }
           // amount 값이 0보다 클때 ( 1 이상 )
            isntErrorAmount = false;
        } while (isntErrorAmount);

        createNonDuplicateBuyList(selectItem, amount);
    }

    // 어떤 물건을 구할지 결정하는 매서드
    private void selectBuyItem () {
        Boolean continueBuying = true;

        do {
            System.out.print("구매할 물건의 번호를 누르세요(결제진행: 0): ");

            int itemNum = scan.nextInt();

            if (itemNum > 4) {
                // itemNum이 4보다 큰 수 일때 ( 5, 6, 7, 8...)
                System.out.println("잘못된 물품을 선택하셨습니다!");
                continue;
            } else if (itemNum < 0) {
                // itemNum이 4보다 큰 수 일때 ( -1, -2, -3, -4...)
                System.out.println("잘못된 물품을 선택하셨습니다!");
                continue;
            } else if (itemNum == 0) {
                // itemNum이 0일때, 반복이 멈춤 ==> 결제진행
                continueBuying = false;
                continue;
            }

            // 실제 물건의 구매 수량을 결정하기 전에 해당 물품을 구매하므로 ArrayList 설정이 필요하다.
            // 이제 해당 작업을 여기에 추가해봅시다 ~

            // 현재 케이스에서는 중복에 대한 대처가 진행되지 않고 있음
            // 그러므로 중복을 감지하여 리스팅을 할 수 있는 매서드를 만들 필요가 있다!
            //userBuyList.add(marketSellList[itemNum - DEFAULT_IDX]);
            //System.out.println(userBuyList);

            // 현재 createNonDuplicateBuyList()도 stock을 처리하고
            // 아래쪽의 selectBuyItemStock()도 stock을 처리한다.
            // 이렇게 혼동이 발생하는 경우에는 누가 더 우선권을 가져야 하는지 분석이 필요하다.
            // cNDBL(줄여서)은 실제 물건의 구매에 있어서 중복이 있는지 검사한다.
            // createNonDuplicateBuyList(marketSellList[itemNum - DEFAULT_IDX]);

            // 물품을 모두 선택하고 몇 개 구할지 결정하는 매서드
            selectBuyItemStock(marketSellList[itemNum - DEFAULT_IDX]);

            System.out.println(userBuyList);
            System.out.println(userBuyListStock);
        } while (continueBuying);
    }

    // 중복 검사 후 수량 체크
    private void createNonDuplicateBuyList (String target, int amount) {
        // 실제 중복이 되었다면 인덱스 값이 나올 것이고
        // 중복이 없으면 -1이 나오게 될 것이다.
        int idx = userBuyList.indexOf(target);

        if (idx == -1) {    // 중복 없음
            userBuyList.add(target);
            // 구매물품 수량체크 배열에 수량 카운트
            userBuyListStock.add(amount);
        } else {            // idx가 중복된 요소를 알려줌
            // set(idx, 데이터)는 특정 인덱스의 값을 update(갱신)함
            // add(idx, 데이터) + remove(idx + 1)과 동일한 역할을 함
            userBuyListStock.set(idx, userBuyListStock.get(idx) + amount);
            //만약 키보드가 2개 있는 상태에서 키보드가 4개가 더 들어왔다.
            // idx = 0,
            // userBuyListStock.set( 0, userBuyListStock.get(idx) + amount);

        }
    }

    private void showMarketSellList () {
        int length = marketSellList.length;

        System.out.println("우리 마켓에서 판매하는 물품을 리스팅 합니다!");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d. %s: %d\n", i + 1, marketSellList[i], marketSellListPrice[i]);
            // 1. 선풍기 : 380000
            // 2. 키보드 : 80000
            // 3. 마우스 : 70000
            // 4. 모니터 : 400000
        }
    }
}

public class Quiz51Explain {
    public static void main(String[] args) {
        Market m = new Market();

        m.doShopping();
    }
}