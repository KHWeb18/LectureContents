class A{
    int a =10;

    void b(){
        System.out.println("A");
    }
}

/*
extends 키워드가 바로 상속!
상속: 말 그대로 재산을 물려받는것,클래스의 내용물들을 활용할 수있게 된다.

 */

class AA extends A{
    int a= 20;

    void b(){
        System.out.println("AA");
    }

    void c(){
        System.out.println("C");
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        A a = new A();
        a.b();
        System.out.println("A a: "+a.a);

        AA aa = new AA();
        aa.b();
        aa.c();
        System.out.println("AA aa: "+aa.a);

        A a1= new AA();
        a1.b();
        System.out.println("A a1: "+a1.a);


    }

}
