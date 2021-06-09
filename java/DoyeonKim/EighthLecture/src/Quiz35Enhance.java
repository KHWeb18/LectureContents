import java.util.Scanner;

class TestDice3 { //클래스는 중복되면 안된다
    int comDice;
    int userDice;

    Scanner scan;

    TestDice3() {
        comDice = getRandomDice();
        userDice = getRandomDice();

        scan = new Scanner(System.in);
    }

    int getRandomDice() {
    return (int)(Math.random() * 6 + 1);
    }


    // 리턴이 없어서 void(Setter도 리턴이 없어서 void)
    void checkWinner() {
        switch (whoWin()) {
            case 1:
                System.out.printf("폐관수련입니다. %d(컴퓨터) vs %d(사용자)\n", comDice, userDice);
                break;
            case 2:
                System.out.printf("사용자가 이겼습니다. %d(컴퓨터) vs %d(사용자)\n", comDice, userDice);
                break;
            case 3:
                System.out.printf("비겼으니 형은 면하였습니다. %d(컴퓨터) vs %d(사용자)\n", comDice, userDice);
                break;
        }
    }

    int whoWin() {
        if (comDice > userDice) {
            return 1;
        } else if (comDice < userDice) {
            return 2;
        } else {
            return 3;
        }
    }

    Boolean redoDiceGame() {
        System.out.println("게임을 계속 하시겠습니까? 0(아니오), 1(예) ");
        int num = scan.nextInt();

        Boolean isTrue = false;

        switch (num) {
            case 0: //0을 누르면 종료
                isTrue = false;
                break;
            case 1:
                //게임을 다시 재개하므로 주사위값을 새롭게 설정해야함
                comDice = getRandomDice();
                userDice = getRandomDice();
                isTrue = true;
                break;
        }
       return isTrue;
     }
}

public class Quiz35Enhance {
    public static void main(String[] args) {
        TestDice3 td = new TestDice3();
        // do~while()의 경우엔
        //무조건 처음엔 실행하고 이후엔 조건에 따라 반복 할지말지 결정
        do {
            td.checkWinner();
        }  while (td.redoDiceGame()); // 다시 진행할지 여부설정
        // 주사위를 다시 굴려서 셋팅


    }
}
// Q: if, switch, for, do ~ while 등등은 class 인가요 ?
// A: 이들은 모두 키워드(keyword)라는 것에 해당하는 녀석들입니다.
//    클래스에 해당하는 것은 아니며 특정 동작을 서포트하는 컴파일러 전용 키워드라고 보면 됩니다.