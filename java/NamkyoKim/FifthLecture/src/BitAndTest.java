public class BitAndTest {
    public static void main(String[] args) {
        int num1 = 10, num2 = 8;


        // & 이 비트 연산자 AND
        // 관계 연산자에서는 && 형태로 존재했음

        //ex        10101011001100
        //          01110111011100 AND
        //--------------------------------------
        //          00100011001100
        //          2^12 2^8 2^7 2^4 2^3
        //              4504??                  노가다로 해보고 요령 조금 알아서 파악한듯!!

        // 10 ===> 1010
        // 8 ===> 1000 AND
        // ----------------
        // 8 ===> 1000
        System.out.printf("%d And %d = %d\n ",num1,num2,num1 & num2);

        num2 = 138;

        // 138 ===> 100001010
        // 10 ===>      1010 AND
        //------------------------
        // 10 ===> 00001010

        System.out.printf("%d And %d = %d\n ",num1,num2,num1 & num2);
    }
}
