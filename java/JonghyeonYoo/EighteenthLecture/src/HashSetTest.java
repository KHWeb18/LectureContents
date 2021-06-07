import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();

        set.add("우유");
        set.add("빵");
        set.add("베이컨");
        set.add("소시지");
        set.add("파스타");
        set.add("계란");
        set.add("아메리카노");
        set.add("HAM");
        set.add("ham");


        // HashSet의 핵심 특성중 하나는 Java내에 존재하는 collection중 가장 빠른 속도를 자랑함
        // 속도가 매우 빠르다.!!
        // 또한 HashSet의 집합(Set)의 특성을 가지고 있어 중복을 허용하지 않는다.
        // 중요 : 순서가 중요하다면 ArrayList를 사용하세요.
        //       순서가 별로 중요하지 않고 빠른 처리를 원한다면 HashSet사용을 권장 합니다.

        /*
        set.add(20);
        set.add(10);
        set.add(40);
        set.add(80);
        set.add(5);
        set.add(25);
        set.add(15);
        //AVL 트리 개조형
        // 결론 : 순서가 중요한 알고리즘에서는 사용하지마세요
 */
        System.out.println(set);
    }
}