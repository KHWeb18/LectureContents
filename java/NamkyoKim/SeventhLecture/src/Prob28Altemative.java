import java.util.Scanner;

public class Prob28Altemative {

        public static void main(String[] args) {
            //아래와 같은 형태의 숫자들이 있다.
            //1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, ...
            //n을 입력해서 n번째 값을 구하도록 프로그래밍 해보자!

            System.out.println("1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,......");

            Scanner sc = new Scanner(System.in);
            System.out.print("몇번째 번호를 구해드릴까요 ? 숫자를 입력해 주세요 : ");

            int num = sc.nextInt();


            if (num <= 0) {
                System.out.println("잘못된 값을 입력하였습니다");
            } else if (num < 2) {
                System.out.println("당신이 찾는 값은 1입니다");
            } else {
                int numArr[] = new int[num];

                numArr[0] = 1;

                for (int i = 1; i < numArr.length; i++) {
                    // Math.pow (A, B)는 A^B(A의 B승)을 계산한다.
                    // Math.pow는 double을 결과로 내놓기 때문에 강제로 int 타입으로 변형함.
                    numArr[i] = (int) Math.pow(2, i);
                }
                System.out.printf("%d 번째 항은 = %d\n", num, numArr[num - 1]);
            }


        }
    }


