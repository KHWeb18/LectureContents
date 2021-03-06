import java.util.Scanner;
public class _5th_Quiz27 {
    public static void main(String[] args) {
//        아래와 같은 형태의 숫자 배치가 있다.
//        1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...   (피보나치수열)
//        사용자가 n를 입력하면 n번째 값을 구하는 코드 작성.

        //f(n)값 = f(n-1) + f(n-2)
        Scanner scan = new Scanner(System.in);

        System.out.print("f(n)의 값을 구한다. n: ");
        int n = scan.nextInt();
        int a = 1; // f(1)의 값
        int b = 1; // f(2)의 값
        int sum = 0;

        if (n <= 0) {
            System.out.println("1 이상의 값을 기입하시오");
        } else if (n < 3) {
            System.out.println(a);
        } else {
            for (int i = 1; i <= n-2; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println(sum);
        }
    }
}
