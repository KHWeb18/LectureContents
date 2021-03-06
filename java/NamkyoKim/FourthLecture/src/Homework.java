public class Homework {
    public static void main(String[] args) {
        //  15. for + if 문제
        //  1 ~ 100까지 숫자중 4의 배수만 출력해보자

        // i를 1로 초기화시켜 1부터 시작하고 ---> int i = 1;
        // i가 100 보다 작거나 같을때까지 조건을 걸고 ---> i <= 100;
        // 4의 배수를 구하는것이니까
        // i를 4로 나눴을때 나머지가 0이라면 println을 통해 화면에 출력
        // 다시 for문으로 돌아가 i++부분으로 i가 1씩증가하고
        // i가 100 보다 작거나 같을때까지니까 101이 됐을때 프로그램종료.
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                System.out.println(i);
            }
        }

        //  16. for + if 문제
        //  1 ~ 100까지 숫자중 11의 배수들의 합을 구해보자!

        // sum이라는 변수를 0으로 초기화 시켜준다. 왜 0으로 시켜주냐면 컴퓨터마다 디폴트를 인식하는 정수가 달라서인듯하다
        // 0xxxxx? 강사님이 설명해주셧던거같다 .
        // for문을 열고 i를 1로 초기화 i가 100 보다 작거나 같을때까지라는 조건을걸고
        // if문을 열고 i를 11로 나누었을때 0 이라면 11의 배수이기 때문에 이러한 i % 11 == 0 코드를 작성했다.
        // 그리고 sum += i; 로 중괄호안에 넣었다 저 의미는 sum = i + i 라서 for문이 끝날때 까지
        // sum에 i+i  11의 배수들의 합들이 저장된다.
        // 이제 출력을 하려 println으로 출력을 했는데 11의 배수들의 합이 나열되고 최종 합 까지 결과값이 나온다
        // 근데 저는 그냥 딱 11의 배수의 합만 내놓고 싶어서 고민해보면서 이곳저곳으로 프린트도 옮겨보고 그랬는데
        int sum = 0;
        for (int i = 1; i <= 100; i++) {

            if (i % 11 == 0) {
                sum += i;
                //System.out.println("1~100사이 11의 배수들의 합 : "+ sum );
            }
        }
        // for문이 끝나고 나서 이런식으로 하니 결과값만 나왔다 . for안에서 sum안에 저장되있던 합을 출력한건 알겠는데
        // for문안에서는 할 수 있는 방법이 없을까 생각하다 질문으로 남깁니다.
        System.out.println("1~100사이 11의 배수들의 합 : " + sum);


        // 17. Math.random() 응용 문제
        // 컴퓨터와 주사위 게임을 해보자!
        // 주사위를 2번 굴려서 합산 눈금 숫자가 큰 사람이 이기는 것으로 한다.


        // 이문제는 도저히 모르겠네요 ..
        // for문을 두바퀴 돌게 조건형성해서 Math.random() * 6 +1 을 두번해서 컴퓨터라는 변수에 넣고
        // me라는 변수에 똑같이 해서  합을 구해보려고 했지만 코드가 쳐지질않네요.
        // 개념상으로 이중포문이나 for if else 이용하면 될거같은데 ..
        // 무한루프 돌릴필요도 없이 2번 주사위 돌리게하고 2번 돌린값의 합을 구하고
        // 합끼리 if조건으로 합을 비교해서 이긴 변수에 위너 라고 딱 결과값 내고 싶었는데 ..

        int com = (int) (Math.random() * 6 + 1);
        int me = (int) (Math.random() * 6 + 1);


        for (int i = 1; i < 3; i++) {

        }
    }
}
