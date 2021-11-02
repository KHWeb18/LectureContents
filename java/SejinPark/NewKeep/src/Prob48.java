import java.util.ArrayList;
import java.util.Arrays;
class Roulette {
    // ArrayList를 통해 사람 이름을 여러개 받을 수 있도록 구성
    ArrayList<String> nameLists;
    // 임시로 저장하는데 활용하기 위한 백업용 배열
    String[] tmpArr;
    // 랜덤한 숫자를 할당하는데 사용할 백업용 인덱스 배열
    int[] tmpIdx;
    // 당첨자들의 인덱스를 저장할 배열
    int[] success;
    // 실제 몇명의 참가자가 있는지
    int nameLength;
    // 중복 검사를 위한 변수
    Boolean isRedundant;
    final int SUCCESS_MAX = 3;
    final int DATA_INT = 1;
    final int DATA_STRING = 2;
    // 생성자 ===> 초기화
    public Roulette (String[] names) {
        nameLength = names.length;
        isRedundant = true;
        nameLists = new ArrayList<String>();
        tmpArr = new String[nameLength];
        tmpIdx = new int[nameLength];
        success = new int[SUCCESS_MAX];
        // for 문 사용하지 않고 배열 저장하기
        // names 배열을 tmpArr 배열에 대입함
        tmpArr = names;
        /*
        int i = 0;
        for (String name : names) {
            tmpArr[i++] = name;
        }
         */
    }
    // idx는 현재 할당받은 인덱스 값
    // | B | A | C |
    //          idx
    //   0   1
    // 현재 인덱스가 중복인지 아닌지 보는 것이므로
    // 현재 인덱스 앞에 있는 녀석까지중에 같은게 있는지 없는지만 보면 된다.
    private Boolean checkDuplicate (int[] arr, int idx) {
        for (int i = 0; i < idx; i++) {
            if (arr[i] == arr[idx]) {
                return true;
            }
        }
        return false;
    }
    public void doGemble () {
        checkDuplicateArr(tmpIdx);
        checkDuplicateArr(success);
        // printSuccessArr();
        printIntArr(tmpIdx);
        printStringArr(tmpArr);
        printIntArr(success);

        printWinner();
    }

    public void checkDuplicateArr (int[] arr) {
        int i = 0;
        isRedundant = true;
        do {
            arr[i] = (int)(Math.random() * nameLength);
            //success[i] = (int)(Math.random() * nameLength);
            if (checkDuplicate(arr, i)) {
                continue;
            }
            i++;
            if (i == arr.length) {
                isRedundant = false;
            }
        } while (isRedundant);
    }
    // 셔플(카드 섞기랑 동일)
    public void shuffle () {
        int i = 0;
        isRedundant = true;
        // 중복 검사를 하며 각각에 모든 중복되지 않는 숫자(0 ~ 사람숫자 - 1)를 할당함
        // 현재는 shuffle() 매서드와 checkSuccess() 매서드가 사실상 동일 패턴을 가지고 있음
        // 그러므로 리팩토링을 통해 이 부분의 중복을 제거할 수 있다.
        do {
            // 랜덤값 아무거나 가져옴
            tmpIdx[i] = (int)(Math.random() * nameLength);
            // 중복 검사
            if (checkDuplicate(tmpIdx, i)) {
                // 중복이면 다시 랜덤값 할당
                continue;
            }
            // 중복이 아니라면 다음 인덱스에 랜덤값을 받기 위해 인덱스 하나 증가
            i++;
            // 전체 사람 숫자만큼 랜덤을 모두 할당했다면 더 이상 반복이 필요 없으므로 루프 탈출
            if (i == nameLength) {
                isRedundant = false;
            }
        } while (isRedundant);
    }
    // 리팩토링 대상
    public void checkSuccess () {
        int i = 0;
        isRedundant = true;
        do {
            success[i] = (int)(Math.random() * nameLength);
            if (checkDuplicate(success, i)) {
                continue;
            }
            i++;
            if (i == 3) {
                isRedundant = false;
            }
        } while (isRedundant);
    }
    // 아래 두개의 매서드도 유사한듯 유사하지 않은 성향을 가짐
    // 그러므로 이 또한 리팩토링 대상이다.
    public void printSuccessArr () {
        for (int i = 0; i < 3; i++) {
            System.out.printf("success[%d] = %d\n", i, success[i]);
        }
    }
    // 위의 코드를 현재 상황에서 그나마 예쁘게 리팩토링 한다면
    public void printIntArr (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d  ", i, arr[i]);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }
    // 문자열 출력 <<< 리팩토링 대상
    public void printArr () {
        for (int i = 0; i < nameLength; i++) {
            System.out.printf("tmpArr[%d] = %s\n", i, tmpArr[i]);
        }
    }
    public void printStringArr (String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %s   ", i, arr[i]);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }
    // 아직 멀티 데이터 타입 처리하는 방식을 학습하지 않았기 때문에
    // String 타입의 배열, int 타입의 배열을 혼성하여 인자로 받을 수 없음
    public void printVariousArr (int[] arr, int option) {
        for (int i = 0; i < arr.length; i++) {
            if (option == DATA_INT) {
                System.out.printf("arr[%d] = %d\n", i, arr[i]);
            } else if (option == DATA_STRING) {
                System.out.printf("arr[%d] = %s\n", i, arr[i]);
            }
        }
    }

    public void printWinner () {
        for (int i = 0; i < success.length; i++) {
            System.out.printf("당첨자의 이름은 = %s\n", tmpArr[tmpIdx[success[i]]]);
        }
    }

    // sout(클래스 객체)
    // 클래스 객체 내부에 우리가 지정한 내용물을 볼 수 있다.
    // 지정한 내용물이란 ? return에서 뿌려주는 내용
    @Override
    public String toString() {
        return "Roulette{" +
                "tmpIdx=" + Arrays.toString(tmpIdx) +
                '}';
    }
}
public class Prob48 {
    public static void main(String[] args) {
        String[] names = {
                "박세진", "김창욱", "김민규", "김중연", "문성호",
                "강병화", "최승현", "유종현", "한상우", "전승리",
                "이경환", "최준환", "김원석", "여인준", "이태양",
                "김윤영", "정도영", "황정아", "임초롱", "김남교",
                "이주형", "김도연", "최혜주", "김도혜", "고재권",
                "임익환", "안보미", "이상훈"
        };
        Roulette r = new Roulette(names);
        // 여기서 첫 번째 출력이 으아아앜 으로 바뀐다는 것은
        // 역시나 객체(메모리)를 전달하면 규칙이 불변함을 의미한다.
        // (규칙: 메모리는 원본이 전달, 값은 복제)
        names[0] = "으아앜";
        //r.printArr();
        System.out.println(r);
        /*
        r.shuffle();
        System.out.println(r);
        r.checkSuccess();
        r.printSuccessArr();
         */
        r.doGemble();
        System.out.println(r);
    }
}