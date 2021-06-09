import java.util.Scanner;

public class SwitchStringTest {
    public static void main(String[] args) {
        System.out.println("문자열도 switch 처리가 되나요? 일단 입력해봅시다 :");
        Scanner scan = new Scanner(System.in);


        String str = scan.nextLine();

        //주의점 앞선 예에서도 적었지만 switch에 사용되는 데이터 타입과
        //case에서 사용하는 데이터타입을 이치시킬 필요가 있다.why n

        switch (str) {
            case "hi" :
                System.out.println("안녕");
                break;
            case "sorry" :
                System.out.println("미안");
                break;
            default:
                System.out.println("그런 말은 못 배움");
        }
    }
}
