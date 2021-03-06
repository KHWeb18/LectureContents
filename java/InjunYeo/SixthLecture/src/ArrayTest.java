public class ArrayTest {
    public static void main(String[] args) {

        /*
        배열을 써야하는 이유
        동일한 데이터 타입의 변수가 여러개 필요할때 일일히 int a,b,c,d,e,f,g,...등등
        만약회사에서 직원1000명을 관리해야 한다 가정한다면
        이것을 일일히 변수로 선언하기는 힘들것이다
        배열을 만들어서 관리를 하자.
         */

        int arr[] = {1,2,3,4,5};

        /*
        배열을 만드는 방법
        1. stack에 할당하는 방법(지역변수)
            1-1. 일단은 배열의 데이터 타입(int 같은)을 적는다.
            1-2. 배열의 이름이 될 변수명을 적는다.
            1-3. 배열임을 알리기위해 []을 변수옆에 적어준다.
            1-4. 필요하다면 배열의 값을 초기화한다.
                (이때 원소로 지정한 숫자에 따라 배열의 길이가 지정된다)
            * 가변으로 구성하고 싶다면 new를 사용해야하는데 이것은 다음주에 학습하도록 한다.

            아래와 같은 데이터를 살펴보자
            int arr[] ={1,2,3,4,5};
            위 데이터는 아래와 같은 형식으로 저장된다.

            arr / 1 / 2 / 3 / 4 / 5 /
                [0] [1] [2] [3] [4]
            배열의 인덱스(방) 번호는 0번부터 시작함에 주의하도록 한다.
            그러나 방 번호가 순차적으로 증가하기 때문에
            for문이나 while 문등의 반복문과의 혼합구성에 있어 매우 탁월하다.

         */

        for (int i = 0;i<5;i++){
            System.out.printf("arr[%d] = %d\n", i ,arr[i]);
        }
    }
}

/*
stack(지역변수)에 할당한다는 것은 지역변수로 처리함을 의미한다.
그렇기때문에 나중에 메서드나 클래스를 학습한 이후 스택에 할당하면
해당 메서드 혹은 클래스 내부에서만 해당 배열이 활성화 됩니다.
 */