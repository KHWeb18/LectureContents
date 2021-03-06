// 18번. 십진수 21을 이진수로 표현해보자!
// 21 ---> 16(2^4) + 4(2^2) + 1(2^0)
//          10101
// 1, 3, 5 번째 비트지만
// 실제 표현할때는 0번 비트, 2번 비트, 4번 비트로 표현해주도록 한다.

// 19번. 십진수 73을 이진수로 표현해보자!
// 73 ---> 64(2^6) + 8(2^3) + 1(2^0)
//            1001001
// 0번 비트, 3번 비트, 6번 비트로 표현됨

// 20~21번. 2^0 + 2^3 + 2^6 + 2^7 + 2^8 + 2^9 을 2진수로 표현해보자!
// 2^9   2^8   2^7   2^6   2^5   2^4   2^3   2^2   2^1   2^0
//  1     0     0     0     0     0     0     0     0     0     2^9(512)
//  0     1     0     0     0     0     0     0     0     0     2^8(256)
//  0     0     1     0     0     0     0     0     0     0     2^7(128)
//  0     0     0     1     0     0     0     0     0     0     2^6(64)
//  0     0     0     0     1     0     0     0     0     0     2^5(32)
//  0     0     0     0     0     1     0     0     0     0     2^4(16)
//  0     0     0     0     0     0     1     0     0     0     2^3(8)
//  0     0     0     0     0     0     0     1     0     0     2^2(4)
//  0     0     0     0     0     0     0     0     1     0     2^1(2)
//  0     0     0     0     0     0     0     0     0     1     2^0(1)
