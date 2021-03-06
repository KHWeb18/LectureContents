import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {
        String[] fruits = {"apple", "strawberry", "grape", "watermelon"};
        // asList()를 통해 배열등을 ArrayList로 변형할 수 있음
        ArrayList<String> fruitsList = new ArrayList<>(Arrays.asList(fruits));

        for (int i = 0; i < 4; i++) {
            System.out.printf("get(%d) = %s\n", i, fruitsList.get(i));
        }

        System.out.println("복제 이후!");

        // fruitsList의 내용을 clone 변수에 복제함
        // ArrayList에 구현되어 있는 clone은 객체를 복제할 수 있게 서포트한다.
        ArrayList<String> clone = (ArrayList<String>) fruitsList.clone();
        for (int i = 0; i < 4; i++) {
            // ArrayList에 있는 내용을 가져올때 get(index)를 사용합니다.
            // 여기서 index는 | 데이터1 | ---> | 데이터2 | ---> | 데이터8 | --->
            //                   0               1               2
            System.out.printf("get(%d) = %s\n", i, clone.get(i));
        }

        fruitsList.remove("grape");
        System.out.println("fruitsList의 grape 삭제 이후 clone 다시 보기");

        for (int i = 0; i < 4; i++) {
            System.out.printf("get(%d) = %s\n", i, clone.get(i));
        }

        System.out.println("fruitsList는 지워졌을까 ?");

        for (int i = 0; i < 3; i++) {
            System.out.printf("get(%d) = %s\n", i, fruitsList.get(i));
        }

        fruitsList.clear();
        System.out.println("after clear: " + fruitsList);

        // 검색 - indexOf
        System.out.println("포도 어딧니 ? " + clone.indexOf("grape"));
        System.out.println("딸기는 ? " + clone.indexOf("strawberry"));
        // 존재하지 않는 것은 -1 이 나옴(오류)
        System.out.println("드립을 치고 싶은데 ? " + clone.indexOf("드립"));

        // contains 또한 IndexOf와 유사하게 사용이 가능하다.
        System.out.println("포도 어딧니 ? " + clone.contains("grape"));
        System.out.println("딸기는 ? " + clone.contains("strawberry"));
        System.out.println("드립을 치고 싶은데 ? " + clone.contains("드립"));

        // contains()는 참 혹은 거짓으로 결과가 나오는 것을 확인할 수 있다.
    }
}