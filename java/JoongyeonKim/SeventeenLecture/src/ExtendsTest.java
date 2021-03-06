class A {
    int a = 10;

    void b () {
        System.out.println("A");
    }
}

// extends 키워드가 바로 상속!
// 상속: 말 그대로 재산을 물려 받는것이다.
//      클래스의 내용물들을 활용할 수 있게 된다.
class AA extends A {
    int a = 20;

    void b () {
        System.out.println("AA");
    }
    void c () {
        System.out.println("C");
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        A a = new A();
        a.b();
        System.out.println("A a: " + a.a);

        AA aa = new AA();
        aa.b();
        aa.c();
        System.out.println("AA aa: " + aa.a);

        // new의 대상은 AA()이며
        // 접근 데이터는 데이터타입 A를 참조해야한다
        // 접근 데이터 : 객체 내부에 있는데이터
        A a1 = new AA();
        a1.b();  //AA로 생성되었기 때문에 AA객체가 출력된다  
        //a1.c(); A객체에 c가 존재하지 않기에 오류가 난다 (A a1 = new AA();로 생성할 경우 양 쪽에 동일한 이름의 변수가 존재해야 된다)크게 상관없음

        //AA클래스에 있는 메소드로 연결된다!
        //하지만 자료형은 생성된 객체 이름 앞의 자료형을 따라간다!
        System.out.println("A a1: " + a1.a);   //위의 예시처럼 두 대상이 다른 경우, 메소드는 new된 클래스의 메소드를 따라가고
        //변수의 경우는 객체 이름 앞에있는 데이터타입을 따라가게되는것이다
    }
}