public class Lecture {
    public static void main(String[] args) {


        //십진수 21을 이진수로 만들어보자!
        //21 = 2^4 2^2 2^0 -> 10101
        //0,2,4비트에 1이 온다.
        //십진수 73을 이진수로 만들어보자!
        //73 = 2^6 2^8 2^0 ->1010101
        //관계연산자 AND와 비트연산자 AND는 서로 동작 방식에 약간의 차이가 있다.
        //비트연산자 AND는 각 비트의 자리수가 1(참)인 녀석들끼리만 1(참)이 된다.
        //비트연산자 OR은 각 비트의 자리수 중 하나라도 1(참)이 있으면 1(참)이 된다.
        //1111 = 8+4+2+1=15
        //1100 = 2^(4+1)-1-2^1-2^0=28
        //계산기기능있음
        //쉬프트 연산의 결과(비트를 왼쪽으로 이동시킴)
        //1<<2===>2^0 x 2^2 =4 (비트를 왼쪽으로 2칸 이동시킴)
        //이진수는 위치가 이동할 때마다 2씩 곱해진다.
        //비트연산자는 % |를 하나씩만 쓴다
        //final키워드는 값을 변경하지 못한다
        //10 & 8 = 8
        //10 ===>1010
        //8  ===>1000 AND
        //------------
        //8  ===>1000

        // 10===>00001010
        //136===>10001000 OR
        //----------------
        //138====>10001010
        //System.out.printf("%d << %d =%d,num1,num2,num1<<num2");
        //2 * 2^5 = 2^6(64)
        //왼쪽 쉬프트의 경우 단순히 2^n을 곱하면 되지만 오른쪽 쉬프트의 경우 그렇게 단순히 나누면 안된다.
        //오른쪽 쉬프트는 2^n으로 나누되 소수점을 버려야 한다.
        //종합적 결론 : 쉬프트 연산(>>,<<) 은 2^n을 곱하거나 나눈다.
        //20.2^1+2^3+2^5+2^6을 2진수로 표현해보자!
        //1101010
        //5>>2는 5/2^2
        //2<<8은 2*2^8
        //int 는 32비트(4바이트)
        //처음에만 testBit가 0이고 프로그램 돌아가면 0이 아니다.
        //인터럽트는 무엇인가?보통 개발자들은 이벤트라고 표현한다. 결국 이벤트라는 것이다.
        //이벤트라는 것은 최우선적으로 처리하는 작업이다. 우선순위가 가장 높다.
        //Thread.sleep()은 일종의 이벤트(인터럽트)에 해당한다. 모든 작업을 제쳐두고 이것을 최우선으로 처리하게 된다.
        //결국 쓰레드가 가장 중요헌 작업이므로 이 작업을 완료하기 전까지는 어떠한 작업도 수행하지 않는다.
        //그래서 0.5초 동안은 무조건적인 대기를 하게 된다.
        //









    }


}
