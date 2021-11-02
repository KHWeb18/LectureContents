package com.example.jswithspring.utility;

import java.util.*;

public class Test {
    String[] sample = {"I", "walk", "the", "line", "Apple", "hit", "me", "Ground", "attack", "you"};

    List<String> list = Arrays.asList(sample);

    public void doTest () {
        Set fruits = new HashSet();

        fruits.add("strawberry");
        fruits.add("watermelon");
        fruits.add("grape");
        fruits.add("orange");
        fruits.add("apple");
        fruits.add("banana");

        List fruitsList = new ArrayList(fruits);
        fruitsList.add("ofcourse");
        Collections.sort(fruitsList);
        System.out.println(fruitsList);

        //거꾸로
        Collections.reverse(fruitsList);
        System.out.println(fruitsList);

        //길이순
        // 이 부분은 Comparator 때문에 익명 객체를 만들어 사용한 형식이 됨
        // interface 이므로 반드시 구현해줘야 하는 부분중 하나가 compare 에 해당한다.
        // 실제 두 개의 문자열을 어떻게 비교할 것인지 compare에 명시를 해주는데
        // 현재 케이스의 경우엔 두개의 문자열 s1, s2를 받아서
        // Integer.compare(s2의 길이, s1의 길이)로 비교를 하고 있다.
        Comparator<String> c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                // x < y ? -1 : (x == y ? 0 : 1);
                // x는 s1, y는 s2
                // s1이 s2 보다 작다면 -1,
                // 그렇지 않고 x와 y가 같으면 0,
                // 이것도 아니라면 1 (s1이 s2 보다 크다는 뜻)

                // Integer.compare(s2.length(), s1.length())
                // 결론: 앞에 s2를 배치하면 길이가 긴 녀석을 출력하고
                //      앞에 s1을 배치하면 길이가 짧은 녀석을 먼저 배치하게 된다.

                // [apple, banana, grape, ofcourse, orange, strawberry, watermelon]
                // [watermelon, strawberry, orange, ofcourse, grape, banana, apple]
                // [watermelon, strawberry, ofcourse, orange, banana, grape, apple]

                return Integer.compare(s1.length(), s2.length());
                // [apple, banana, grape, ofcourse, orange, strawberry, watermelon]
                // [watermelon, strawberry, orange, ofcourse, grape, banana, apple]
                // [grape, apple, orange, banana, ofcourse, watermelon, strawberry]
            }
        };

        // 내부에서 c.compare(a, b);
        // c.compare(a[runHi++], a[lo]) >= 0
        // 전체 리스트를 순회하면서 길이가 긴 녀석을 우선적으로 배치하게됨
        // 현재 자바의 경우 QuickSort 방식이 아닌 TimSort를 사용하고 있음
        Collections.sort(fruitsList, c);
        System.out.println(fruitsList);
    }

    // 길이순 정렬 방식을 찾아봤는데
    // compare 결과값이 1, 0, -1이 나오는 건 알겠는데 sort가 이 값을 어떻게 활용해서 길이순으로 정렬하는 건지 궁금합니다

}