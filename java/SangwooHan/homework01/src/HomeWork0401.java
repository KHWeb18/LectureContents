public class HomeWork0401 {
    public static void main(String[] args) {
        int sum = 0;
//AverageWithForTest

        for(int i = 1; i <=10; i++)
        // 현재 for 문은 i가 1에 시작해서 10에 같아질때까지 1씩 더해가는 로직이다.
        //이말은즉 1~10 10번 돌겠다는 뜻이다.
        // sum = sum +i 은 우항에서 좌항으로 대입하겠다 라는의미로
        //우항의 값인sum +i 를 좌항인 sum에 대입시키겠다.
        // 자 처음부터 한번씩 돌려보겠다.
        //처음1을 돌리면 결과값이 1이고
        //sum은 0이니까 0+1이 되어 sum은 최종적으로 1이 되었다.
        // 포문이 열번돌아야하니 이걸10번 반복한다 증가식으로인해
        // i는 2가되었고. 기존sum은 1이였지만 sum+i 로인해
        // 1+2가되어 sum은 3이되었다
        // 다시 i는 3이되었고, 3 = 3+3 즉 6이 되었고
        // 다시 i는 4   6 = 6+4  즉 10 이되었다
        //즉 1+2+3+4=10인것이다 현재이걸 10번 반복하면
        // 1+2+3+4+5+6+7+8+9+10 = 55 값 최종적인 포문 10번을돌았을때
        // sum에 저장된 값 은 55가 된다.

        {
            sum = sum+i;
            System.out.println("sum="+sum);
        }
        System.out.println("최종 핪산값="+sum);
//평균값을 구하는방법.
        // 포문이 열면 돌았기 떄문에 10번돌았을것이다. 열번을돌았기에 평균을구하려면 10번을 나누면 sum의 평균을 구할수있을것이다.
        // 하지만 소수점이 찍히므로, 소수점을 표현하는 float, double을 써야 소수점이 파악된다.
        float average = sum /10.0f;
        System.out.println("평균은=" + average);



    }
}
