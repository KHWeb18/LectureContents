public class NonDuplicateWithoutArrayTest {
    // 0 ~ 9까지의 숫자가 중복되지 않게 출력되게 만들어보자!(배열 없이)
    public static void main(String[] args) throws InterruptedException {
        final int BIN = 1;

        // 2진 비트 연산자 AND와 OR 연산자를 활용함
        // 또한 쉬프트 연산자를 함께 활용해서 각각의 비트를 채우는 형식으로 코드 구현

        int testBit = 0;
        int randNum;

        // 2진수에 대한 이해가 필요함( 이 문제를 다루기 위해)
        // 십진수 10을 이진수로 변환해보자
        // 변환절차
        // 1. 10에서 가장 근접하면서 10보다 작은 2^n을 찾는다 = 8
        // 2. 찾은 숫자 10 에서 8을 뺀 값인 2를 적는다.
        // 3. 값이 0이 나올때 까지 이 절차를 반복한다.
        // 4. 0이 된이후 뺏던 값들의 2^n에 해당하는 n 값들을 열거한다 ===> 3, 1
        // 5. 구한 숫자들이 각각 이진수의 자리수에 해당한다.
        // 6.       2^3     2^2     2^1     2^0
        //           1       0       1       0
        // 7. 검산 ===> (2^3 x 1) + ( 2^2 x 0 ) + (2^1 x 1) + (2^0 x 0 ) = 10

        for (int i = 0; i < 10; i++) {
            // 0 ~ 9 나오게 * 10 설정
            randNum = (int) (Math.random() * 10);

            // 나온 randNum 에 대한 중복판정을 어떻게 할 것 인가? bit 연산
            // 2^9  2^8 2^7 2^6 2^5 2^4 2^3 2^2 2^1 2^0
            //   1    1   1   1   1   1   1   1  1   1

            // BIN = 2로 시작하면 2^1 에서 시작하는 것이라
            // 맨 마지막값이 무조건 2^1 x 2^9이 되서 1024가 더해지므로 논리적 오류 발생
            // 그러므로 BIN = 1 로 만들어서 2^0 x 2^9 으로 512가 되게 처리해야 정상적인 결과값 출력

            // 쉬프트 연산의 결과 ( 비트를 왼쪽으로 이동시킨다)
            // 1 << 2 ===> 2^0 x 2^2 = 4    (비트를 왼쪽으로 2칸 이동시킴)
            // 1 << 4 ===> 2^0 x 2^4 = 16   (비트를 왼쪽으로 4칸 이동시킴)
            // 1 << 8 ===> 2^0 x 2^8 = 256  (비트를 왼쪽으로 8칸 이동시킴)
            // 1 >> 9 ===> 2^0 x 2^9 = 512  (비트를 왼쪽으로 9칸 이동시킴)

            //       10000   (1이라는 숫자를 왼쪽으로 2칸 이동시키면?)
            //     1000000   ( 10^2 이 곱해진다 )
            //      10000    (1이라는 숫자를 왼쪽으로 4칸 이동시키면 ?)
            //  100000000    (10^4 이 곱해진다)

            // 십진수기 떄문에 위치에 이동할 때마다 10 씩 곱해진다.

            // 이 부번은 중복이 있는지 없는지 검사하는 루틴
            // testBit는 int형이니까 전체가 4바이트(32바이트)
            // ex) 4, 5, 4, 1

            while ((testBit & (BIN << randNum)) != 0) {
                randNum = (int) (Math.random() * 10);
            }
            System.out.printf("ranNum = %d\n", randNum);

            // 실제 자리수 셋팅은 여기서한다
            // A += B ===> A = A + B
            // 위아래는 다른 의미 스타일만 같다.
            // A |= B ===> A = A | B
            testBit |= (BIN << randNum);

        }
        System.out.println("testBit의 최종값은 1023이다. 진짜? " + testBit);

        Thread.sleep(500);
    }
}



//21 -----> 16(2^4) + 4(2^2) + 1(2^0)
//            10101
// 1, 3, 5 번째 비트지만
// 실제 표현할때는 0번 비트 , 2번 비트, 4번비트로 표현해주도록 한다.

// 73 ---3 64(2^6) + 8(2^3) + 1(2^0)
//                  1001001
// 0번 비트 , 3번 비트, 6번 비트로 표현됨

// 2^9  2^8 2^7 2^6 2^5 2^4 2^3 2^2 2^1 2^0
//  1    0   0   0   0   0   0   0   0   0  2^9(512)
//  0    1   0   0   0   0   0   0   0   0  2^8(256)
//  0    0   1   0   0   0   0   0   0   0  2^7(128)
//  0    0   0   1   0   0   0   0   0   0  2^6(64)
//  0    0   0   0   1   0   0   0   0   0  2^5(32)
//  0    0   0   0   0   1   0   0   0   0  2^4(16)
//  0    0   0   0   0   0   1   0   0   0  2^3(8)
//  0    0   0   0   0   0   0   1   0   0  2^2(4)
//  0    0   0   0   0   0   0   0   1   0  2^1(2)
//  0    0   0   0   0   0   0   0   0   1  2^0(1)

// 관계연산자 AND와 비트연산자 AND는 서로 동작방식이 약간의 차이가 있다.
// 십진수 10과 십진수 5의 AND 연산은 아래와 같이 이루어진다.

// 1010 ------ 10
// 0101 ------ 5  AND
//------------------
//0000--------- 0

// 1010 ------ 10
// 0101 ------ 5  OR
//------------------
//1111 --------- 15

// 비트 연산자 AND는 각 비트의 자리수가 1(참)인 녀석들 끼리만 1(참)이 된다.
// 하나라도 0(거짓)이 있으면 해당 자리수는 0이 된다.

// 비트 연산자 OR는 각 비트의 자리수중 하나라도 1(참)이 있으면 1(참)이 된다.
// 양쪽 모두 0(거짓)을 가지고 있는 경우에만 0(거짓)이 된다.

// Q : bit OR 연산은 덧셈인가요?
// A :

// 1010 - 10
// 0111 - 7 OR
//--------------
//1111- 15==== 8 + 4 + 2 + 1
//10000 (2^4) - 1 = 1111(2) = 15

// 2^0 + 2^1 + 2^2 + ..... + 2^n = 2^(n+1) - 1

// 2진수 10101000 을 10진수로 바꿔보자!
// 2^7 + 2^5 + 2^3 = 8 + 32 + 128 = 168

// 2진수 11111100 을 10 진수로 바꿔보자
// 11111111 = 2^0 + 2^1 + ..... 2^7 => 2^8 - 1 = 256 - 1 = 255
// 255 -3 = 252