
import java.util.ArrayList;
import java.util.Scanner;
class Market {
    private ArrayList<String> userBuyList;
    private ArrayList<Integer> userBuyListStock;
    private String[] marketSellList = {"선풍기", "키보드", "마우스", "모니터"};
    private int[] marketSellListPrice = {380000, 80000, 70000, 400000};
    private int myMoney;
    private Boolean continueShopping;
    Scanner scan;
    final int DEFAULT_IDX = 1;
    public Market () {
        userBuyList = new ArrayList<String>();
        userBuyListStock = new ArrayList<Integer>();
        continueShopping = false;

        scan = new Scanner(System.in);

        myMoney = 10000000;
    }

    // 16일차!
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

        scan.nextLine();

        do {
            System.out.print("쇼핑을 계속하시겠습니까 ? Y/N");
            System.out.print("쇼핑을 계속하시겠습니까 ? (Y/N) ");

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
        int length = marketSellList.length;

        // userBuyList는 별도의 연결리스트
        // marketSellList는 별도의 배열
        for (int i = 0; i < length; i++) {
            for (String element : userBuyList) {
                // 해당 i 번째 인덱스의 요소 위치에 price를 사용하면 됨을 의미함
                // "선풍기", "키보드", "마우스", "모니터" <<<--- marketSellList의 순서
                // 우리가 키보드 입력을 통해서 받는 userBuyList는 위의 순서대로 배치되지 않는다.
                // "모니터", "마우스", "키보드", "선풍기" 순이라 가정해보자!
                // System.out.println("element = " + element + ", i = " + i);

                if (marketSellList[i].equals(element)) {
                    // myMoney -= marketSellListPrice[i] * (수량)
                    myMoney -= marketSellListPrice[i] * userBuyListStock.get(userBuyList.indexOf(element));
                    System.out.printf("찾은 물품 = %s, 가격 = %d, 수량 = %d\n",
                            element, marketSellListPrice[i],
                            userBuyListStock.get(userBuyList.indexOf(element)));

                    // 방법 1) 결제 완료 이후 구매 리스트를 비울 필요가 있음
                    //        현재 케이스에서는 값을 지워버리면 루프를 도는 중에 지워지기 때문에 문제가 발생함!
                    /*
                    int deleteIdx = userBuyList.indexOf(element);
                    userBuyListStock.remove(deleteIdx);
                    userBuyList.remove(deleteIdx);
                     */
                }
            }
        }

        System.out.printf("현재 당신은 %d 원을 가지고 있습니다.\n", myMoney);
        // 방법 2) 결제 완료 이후 구매 리스트를 비울 필요가 있음
        userBuyListStock.clear();
        userBuyList.clear();
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
                System.out.println("잘못된 물품을 선택하셨습니다!");
                continue;
            } else if (itemNum < 0) {
                System.out.println("잘못된 물품을 선택하셨습니다!");
                continue;
            } else if (itemNum == 0) {
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
    private void createNonDuplicateBuyList (String target, int amount) {
        // 실제 중복이 되었다면 인덱스 값이 나올 것이고
        // 중복이 없으면 -1이 나오게 될 것이다.
        int idx = userBuyList.indexOf(target);
        if (idx == -1) {    // 중복 없음
            userBuyList.add(target);
            userBuyListStock.add(amount);
        } else {            // idx가 중복된 요소를 알려줌
            // set(idx, 데이터)는 특정 인덱스의 값을 update(갱신)함
            // add(idx, 데이터) + remove(idx + 1)과 동일한 역할을 함
            userBuyListStock.set(idx, userBuyListStock.get(idx) + amount);
        }
    }
    private void showMarketSellList () {
        int length = marketSellList.length;
        System.out.println("우리 마켓에서 판매하는 물품을 리스팅 합니다!");
        for (int i = 0; i < length; i++) {
            System.out.printf("%d. %s: %d\n", i + 1, marketSellList[i], marketSellListPrice[i]);
        }
    }
}
public class Prob51 {
    public static void main(String[] args) {
        Market m = new Market();
        m.doShopping();
    }
}