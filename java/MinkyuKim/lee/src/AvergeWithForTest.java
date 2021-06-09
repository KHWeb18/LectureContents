public class AvergeWithForTest {
    public static void main(String[] args) {
        int sum = 0;


        for(int i = 1; i <= 10; i++) {
            sum += i;
            System.out.println("sum = " + sum);
        }

        System.out.println("최종 합산 값 = " + sum);

        // 주식과 관련된 작업을 한다면 이 부분을 상당히 조심해야 한다.
        // 10.0f; 를 10;으로 작성할시 값이 다르게 나온다.
        // 차이가 나는 까닭은, 그냥 10의 경우 sum이 int형, 숫자 10도 디폴트로 int형입니다.
        // 기본적으로 정수는 int, 소수점은 dobule을 채택함

        // sum은 int형이지만 나누는 숫자가 소수점(float)이기 때문에
        // 강제로 소수점 연산이 수행되어 5.5라는 결과를 얻게됨됨
        /*
        float verage = sum / 10.0f;
        System.out.println("평균 = " + average);

         */
    }
}
