import java.util.HashMap;
import java.util.Map;

class Student {
    int age;
    String name;

    public Student (int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class HashMapTest {
    public static void main(String[] args) {
        // Map의 특성중 하나가 key와 value가 분리됨
        // Map<Key, Value>
        // 특별히 특정 데이터타입을 지켜줘야 하는 것은 없다.
        // 나는 "열쇠"를 키로 사용하고 "으아아앜!"을 값으로 쓸거야! 하면 쓰면 된다.
        Map<Integer, Student> st = new HashMap<Integer, Student>();

        // 앞에 오는 숫자는 인덱스가 아니다.
        // 단지 사물함을 여는데 필요한 열쇠일 뿐
        st.put(7, new Student(42, "Bob"));
        st.put(2, new Student(33, "Chris"));
        st.put(44, new Student(27, "Denis"));
        st.put(3, new Student(29, "David"));

        System.out.println(st);

        st.remove(2);

        System.out.println(st);

        st.put(3, new Student(77, "Jesica"));

        System.out.println(st);

        for (Map.Entry<Integer, Student> s : st.entrySet()) {
            Integer key = s.getKey();
            Student value = s.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }

        // 나는 "열쇠"를 키로 사용하고 "으아아앜!"을 값으로 쓸거야! 하면 쓰면 된다.
        Map<String, Integer> strMap = new HashMap<String, Integer>();

        strMap.put("열쇠", 5);

        // HashMap을 사용할때는 이 방식이 변하지 않습니다.
        // 추상화의 연장선 관점에서 아래 사항을 준수하여 코딩하면 어떤 상황에서든 key, value 값을 얻을 수 있습니다.
        // Entry<키 데이터타입, 밸류 데이터타입> 형식은 지켜주세요.
        for (Map.Entry<String, Integer> map : strMap.entrySet()) {
            String key = map.getKey();
            Integer value = map.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}