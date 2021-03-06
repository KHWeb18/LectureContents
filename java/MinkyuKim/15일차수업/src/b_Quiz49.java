import java.util.ArrayList;

//ArrayList에 중복을 허용하여 랜덤 숫자를 10개 만든다.
//랜덤 숫자의 범위는 10 ~ 12 다.
//여기서 각각의 숫자들이 몇 개씩 중복 되었는지 카운트해보자!
class ArrayListCount {
    ArrayList<Integer> intLists;
    ArrayList<Integer> duplicateLists;

    final int RAND_RANGE = 3;
    final int RAND_START_OFFSET = 10;
    final int DATA_LENGTH = 10;

    final int FIRST_VALUE = 10;
    final int SECOND_VALUE = 11;
    final int THIRD_VALUE = 12;

    final int FIRST_IDX = FIRST_VALUE - RAND_START_OFFSET;
    final int SECOND_IDX = SECOND_VALUE - RAND_START_OFFSET;
    final int THIRD_IDX = THIRD_VALUE - RAND_START_OFFSET;

    public ArrayListCount () {
        intLists = new ArrayList<Integer>();
        duplicateLists = new ArrayList<Integer>();

        for (int i = 0; i < DATA_LENGTH; i++) {
            intLists.add((int)(Math.random() * RAND_RANGE + RAND_START_OFFSET));
            //intLists.add(10);
        }

        for (int i = 0; i < RAND_RANGE; i++) {
            duplicateLists.add(0);
        }
    }

    public void cntDuplicate () {
        // forecah문 num에 값을 집어넣음 하나씩 inLists의 값을
        for (int num : intLists) {
            if (num == FIRST_VALUE) {
                // 10이 나올때마다 0번입력자리를 밀어내며 1씩 더함. 즉 중복된 10의 값수가 나옴.
                // remove에서 밀려난 1번 인덱스를 삭제하게됨.
                duplicateLists.add(FIRST_IDX,
                        duplicateLists.get(FIRST_IDX) + 1);
                // get은 인덱스의 값을 받아오는 것
                duplicateLists.remove(1);
            } else if (num == SECOND_VALUE) {
                duplicateLists.add(SECOND_IDX,
                        duplicateLists.get(SECOND_IDX) + 1);
                duplicateLists.remove(2);
            } else if (num == THIRD_VALUE) {
                duplicateLists.add(THIRD_IDX,
                        duplicateLists.get(THIRD_IDX) + 1);
                duplicateLists.remove(3);
            }
        }
    }

    @Override
    public String toString() {
        return "ArrayListCount{" +
                "intLists=" + intLists +
                ", duplicateLists=" + duplicateLists +
                '}';
    }
}

public class b_Quiz49 {
    public static void main(String[] args) {
        ArrayListCount alc = new ArrayListCount();

        System.out.println(alc);

        alc.cntDuplicate();

        System.out.println(alc);
    }
}