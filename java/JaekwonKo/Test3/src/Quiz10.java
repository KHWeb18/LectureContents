public class Quiz10 {
    public static void main(String[] args) {
        // 10번문제를 풀어 봅시다
        // 1000개의 데이터가 있다
        // 여기서 C에 해당하는 데이터는 30개있다
        // F에 해당하는 데이터는 500개있다
        // B에 해당하는 데이터는 240개 있다
        // A에 해당하는 데이터는 700개 있다
        // D에 해당하는 데이터는 350개 있다
        // C 혹은 F 둘 중 하나의 케이스를 판정하고자 한다
        // 어떻게 하면 가장 효율적으로 이 케이스들을 찾아낼 수 있을까 고민해보자


        // 일단 여기선 C혹은 F 둘 중 하나의 케이스를 한정한다고 하였으니
        // &&문이 아니라 ||문을 사용해야 할것 같다
        // 왜 || 문이 쓰일것 같아 ? --> 여기서 잘 봐야할 것이 C '혹은' F '둘 중 하나' 의 케이스를 판정 이라 하였으니
        // 둘 모두 만족이 아니라 하나만 만족 해도 되기 때문에 ||가 쓰여도 되지않나 라는 나의 생각.
        // 하지만 1000개의 한정적인 데이터가 있는데 각 데이터의 양을 합하면 1820개가 되어 버린다
        // 그렇다면 중복된 데이터도 있다는 말일것 같은데.....
        // 결과적으론 AND, OR, NOT 다써야하는거 아닐까...?
        // 도저히 모르겠다...ㅠ
    }
}
