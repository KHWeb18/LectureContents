public class sixthquiz {
    public static void main(String[] args) {
        final int BIN = 1;
        int testBit = 0;
        int randNum;

        for (int i = 0; i < 10; i++) {
            randNum = (int)(Math.random() * 10);

            // 우선 randNum은 랜덤하게 나오겠지만 설명을 위해 특정 상황을 가정하도록 한다.
            // randNum은 아래와 같이 나온다고 가정해보자!
            // 2, 6, 3, 5, 2, 2, 1
            // 2^2, 2^6, 2^3, 2^5, 2^2, 2^2, 2^1

            // (1)
            // testBit        = 00 0000 0000
            // BIN << randNum = 00 0000 0100  AND
            // -----------------------------------
            //                  00 0000 0000 그러므로 결과는 0이 되어 while Loop 진입 x
            // testBit        = 00 0000 0000
            // BIN << randNum = 00 0000 0100  OR
            // -----------------------------------
            // testBit        = 00 0000 0100 중복이 발생하지 않음을 확인한 이후 testBit에 값을 설정함
            //                               여기에 값을 설정함으로써 이후 값은 위치에 AND가 발생하면
            //                               중복이라는 것을 판정할 수 있음

            // (2)
            // testBit        = 00 0000 0100
            // BIN << randNum = 00 0100 0000  AND
            // -----------------------------------
            //                  00 0000 0000 그러므로 결과는 0이 되어 while Loop 진입 x
            // testBit        = 00 0000 0100
            // BIN << randNum = 00 0100 0000  OR
            // -----------------------------------
            // testBit        = 00 0100 0100

            // (3)
            // testBit        = 00 0100 0100
            // BIN << randNum = 00 0000 1000  AND
            // -----------------------------------
            //                  00 0000 0000 그러므로 결과는 0이 되어 while Loop 진입 x
            // testBit        = 00 0100 0100
            // BIN << randNum = 00 0000 1000  OR
            // -----------------------------------
            // testBit        = 00 0100 1100

            // ....
            // ....
            // ....
            // (5)
            // testBit        = 00 0110 1100
            // BIN << randNum = 00 0000 0100  AND
            // -----------------------------------
            //                  00 0000 0100

            // (6)
            // testBit        = 00 0110 1100
            // BIN << randNum = 00 0000 0100  AND
            // -----------------------------------
            //                  00 0000 0100

            // (7)
            // testBit        = 00 0110 1100
            // BIN << randNum = 00 0000 0010  AND
            // -----------------------------------
            //                  00 0000 0000 그러므로 결과는 0이 되어 while Loop 탈출
            // testBit        = 00 0110 1100
            // BIN << randNum = 00 0000 0010  OR
            // -----------------------------------
            // testBit        = 00 0110 1110

            // ....
            // ....
            // ....
            // (최종 단계의 마지막 testBit를 보면)
            // testBit        = 11 1111 1111
            // 즉 2^8 자리가 0으로 설정되어 있다면 아직 랜덤값 8이 나오지 않음을 의미함
            // 2^0 자리가 0으로 설정되어 있다면 아직 숫자 0이 나오지 않았음을 의미함
            while ((testBit & (BIN << randNum)) != 0) {
                randNum = (int)(Math.random() * 10);
            }

            System.out.printf("randNum = %d\n", randNum);

            testBit |= (BIN << randNum);
        }
    }
}
}
