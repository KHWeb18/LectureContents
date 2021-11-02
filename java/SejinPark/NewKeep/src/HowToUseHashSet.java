import java.util.HashSet;
import java.util.Set;

public class HowToUseHashSet {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<Integer>();

        Integer[] sample = {1,1,3,2,4,1,1,1};

        // 집합의 특성: 중복 허용 x
        for (int str : sample) {
            if (s.add(str)) { //★HashSet.add는 넣고,동시에 true반환/없으면 false반환
                System.out.println("중복되었습니다: " + str);
            }
        }

        // size()는 원소의 개수
        System.out.println(s.size() + " 중복을 제외한 단어: " + s);
    }
}