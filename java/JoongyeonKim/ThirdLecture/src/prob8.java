import java.util.Scanner;

public class prob8 {
    public static void main(String[] args) {
        //키보드 입력이 0이 들어오기 전까지는 계속 무한 반복하도록 프로그램을 작성합시다
        // 입력하는 키보드 값이 짝수인지 홀수인지 지속적으로 판별하도록 프로그래밍 해봅시다!
        Scanner scan = new Scanner(System.in);
        int select = 1;

        while (select != 0) {  // select는 0이 아니다!
            System.out.print("짝수인지 홀수인지 판별해보자: ");
            select = scan.nextInt();

            if (select % 2 == 0) {  //select가 입력 한 수에 맞추어 값이 출력됨
                System.out.println(select +"는 짝수!");
            } else {
                System.out.println(select + "는 홀수!");
            }
        }
    }
}
