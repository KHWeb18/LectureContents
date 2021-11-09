/*
아주 특수한 카지노에 왔다.
현재 내 수중엔 1000만원이 있다.
카지노에서 판돈을 걸 수 있고 베팅 비율은 Scanner를 통해 입력 받을 수 있다.
상대방이 파산하면 이기는 게임이다.
주사위 2개를 사용하는 게임이다.
숫자가 높은 사람이 이긴다(컴퓨터 vs 사람)
첫 번째 주사위가 짝수가 나온 경우에만 두 번째 주사위를 굴릴 수 있다.
두 번째 주사위는 특수 능력을 가지고 있는 주사위다.
숫자 1이 나오면 내 주사위 값을 + 3 할 수 있다.
숫자가 3이 나오면 상대방 주사위 값을 -2 할 수 있다.
숫자 4가 나오면 내 주사위 값이 0이 된다.
숫자 6이 나오면 각자 만든 주사위 값을 2배로 뻥튀기 한다.
(2배 뻥튀기는 첫번째 주사위 + 두번째 주사위를 모두 진행한 후 적용한다)
누가 파산하고 누가 승리를 거머쥐는지 프로그래밍해보자!
컴퓨터 돈, 내 돈, 판돈, 뽕빨 났는지 여부, 키보드 입력, 주사위 2개 사용
첫번째 주사위가 짝수가 아니면 두번째 주사위 사용 불가
두번째 주사위는 특수 스킬이 존재함
승패 판정은 두 개의 주사위 값의 합산으로 판정
 */

import java.util.Arrays;
import java.util.Scanner;

class DiceDeathGame { //기능이 변수명이나 메서드명에 담겨져있어서 읽기가 편하다..
    final int MAX_PLAYER = 2; //플레이어 고정
    final int DICE_IDX = MAX_PLAYER + 1; //왜 3이아니고 상수 +1일이까나..
    final int START_MONEY = 1000; //금액 고정

    final int FIRST_IDX = 0; //첫번째 주사위
    final int SECOND_IDX = 1;//두번째 주사위
    final int TOTAL_IDX = 2; //첫번째 주사위 + 두번째 주사위 합

    final int DICE_RANGE = 6; // 주사위 범위
    final int DICE_START_OFFSET = 1; // 주사위 시작 범위

    int comMoney; //컴퓨터 돈
    private int usrMoney; //유저 돈
    int betMoney; //베팅 금액

    int roundNum; //라운드 표시

    Boolean isAlive; //게임 on/off
    Scanner scan;

    int[] comDice; //컴퓨터 주사위
    int[] usrDice; //유저 주사위

    public DiceDeathGame () { //생성자에서 초기화 위주로 진행하자.
        roundNum = 0; //라운드 값 초기화

        comDice = new int[DICE_IDX]; //주사위 배열 범위
        usrDice = new int[DICE_IDX];

        isAlive = true; //반복문에서 진행하기위한 값
        scan = new Scanner(System.in); // scanner heap에 set

        comMoney = START_MONEY; //값 초기화
        usrMoney = START_MONEY;
    }
    private void bettingMoney () { //라운드, 베팅금액 설정
        System.out.printf("현재 %d 라운드입니다.\n", ++roundNum);
        System.out.printf("이게임을 시작한 당신 오늘 둘중 하나는 인생 로그아웃합니다.\n" +
                "돈이 부족하면 손모가지나 장기로 대체 가능합니다.\n" +
                "판돈을 입력하시오: ");
        betMoney = scan.nextInt();
    }
    public void gameStart () { //게임 시작 메서드
        do {
            bettingMoney();
            runDice();
            checkMagicDiceSkill();
            whoGetBetMoney();
            canWePlay();
            checkEachMoney();
        } while (isAlive);
    }
    private void checkEachMoney () { //남은 돈 확인
        System.out.printf("사용자 수중 금전: %d, 컴퓨터 수중 금전: %d\n", usrMoney, comMoney);
    }
    private void canWePlay () { //게임 on/off
        if (usrMoney <= 0 || comMoney <= 0) {
            isAlive = false;
        }
    }
    private void whoGetBetMoney () { // 승패여부  베팅 금액 이동
        int usrTotDice = usrDice[TOTAL_IDX];//총합
        int comTotDice = comDice[TOTAL_IDX];

        if (usrTotDice > comTotDice) {
            System.out.printf("이번판은 사용자가 이겼습니다! %d  %d T : %d(사용자) VS  %d %d T : %d(컴퓨터)\n",
                    usrDice[FIRST_IDX],usrDice[SECOND_IDX],usrTotDice,comDice[FIRST_IDX],comDice[SECOND_IDX], comTotDice);
            usrMoney += betMoney;
            comMoney -= betMoney;
        } else if (usrTotDice < comTotDice) {
            System.out.printf("이번판은 컴퓨터가 이겼습니다! %d %d T : %d(컴퓨터) VS %d  %d T : %d(사용자)\n",
                    comDice[FIRST_IDX],comDice[SECOND_IDX], comTotDice, usrDice[FIRST_IDX],usrDice[SECOND_IDX],usrTotDice);
            usrMoney -= betMoney;
            comMoney += betMoney;
        } else {
            System.out.printf("승부가 나지 않았습니다! %d(사용자) vs %d(컴퓨터)\n",
                    usrTotDice, comTotDice);
        }
    }
    private void checkSkill (int[] curDice, int[] targetDice) { // 스킬용 메서드
        switch (curDice[SECOND_IDX]) {
            case 1:
                curDice[TOTAL_IDX] = curDice[FIRST_IDX] + 3;
                break;
            case 3:
                targetDice[TOTAL_IDX] = targetDice[FIRST_IDX] - 2;
                break;
            case 4:
                curDice[TOTAL_IDX] = 0;
                break;
            case 6:
                curDice[TOTAL_IDX] = (curDice[FIRST_IDX]) * 2;
                targetDice[TOTAL_IDX] = (targetDice[FIRST_IDX]) * 2;
                break;
            default:
                curDice[TOTAL_IDX] = curDice[FIRST_IDX] + curDice[SECOND_IDX]; //0이 디폴트라서 초기화가 되서 두배값이 사리진다.
                break;
        }
    }
    private void checkMagicDiceSkill () { //스킬 사용 메서드
        // 사용자 관점에서의 2번째 주사위 스킬 발동
        System.out.println("유저");
        System.out.println(Arrays.toString(usrDice));
        System.out.println("컴");
        System.out.println(Arrays.toString(comDice));

        checkSkill(usrDice, comDice);
        // 컴퓨터 관점에서의 2번째 주사위 스킬 발동
        System.out.println("유저");
        System.out.println(Arrays.toString(usrDice));
        System.out.println("컴");
        System.out.println(Arrays.toString(comDice));

        checkSkill(comDice, usrDice);
        System.out.println("유저");
        System.out.println(Arrays.toString(usrDice));
        System.out.println("컴");
        System.out.println(Arrays.toString(comDice));
    }
    private void runSecondDice (int[] dice) { //두번째 주사위 사용 여부
        if (dice[FIRST_IDX] % 2 == 0) {
            dice[SECOND_IDX] = getRandomValue(DICE_RANGE, DICE_START_OFFSET);
        }
    }
    private void runFirstDice (int[] dice) { //랜덤 주사위 사용
        dice[FIRST_IDX] = getRandomValue(DICE_RANGE, DICE_START_OFFSET);
    }
    private void runDice () { //첫번째 주사위

        runFirstDice(usrDice);
        runFirstDice(comDice);

        runSecondDice(usrDice);
        runSecondDice(comDice);
    }
    public int getRandomValue (int range, int startOffset) { //값 최대값, 시작범위
        return (int)(Math.random() * range + startOffset);
    }


}

public class Prob45Answer {
    public static void main(String[] args) {
        DiceDeathGame ddg = new DiceDeathGame();//생성자에서 초기화

        ddg.gameStart(); //시작메서드
    }
} 