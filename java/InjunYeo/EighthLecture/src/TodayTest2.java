class Dice2{
    int comDice;
    int userDice;

    Dice2(){
        comDice = getRandomDice();
        userDice = getRandomDice();
    }

    int getRandomDice(){
        return (int)(Math.random()*6+1);
    }

    void checkWinner(){
        switch(whoWin()){
            case 1:
                System.out.printf("폐관수련입니다. %d(컴퓨터) vs %d(사용자)\n", comDice, userDice);
                break;
            case 2:
                System.out.printf("사용자가 이겼습니다.%d(컴퓨터) vs %d(사용자)\n", comDice, userDice);
                break;
            case 3:
                System.out.printf("비겼습니다.%d(컴퓨터) vs %d(사용자)\n", comDice, userDice);
                break;
        }


    }

    int whoWin(){
        if(comDice > userDice){
            return 1;
        }
        else if(comDice<userDice){
            return 2;
        }
        else{
            return 3;
        }
    }
}

public class TodayTest2 {
    public static void main(String[] args) {
        Dice2 d = new Dice2();

        d.checkWinner();
    }

}
