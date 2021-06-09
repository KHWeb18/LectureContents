class Cat {
    String gender;
    String name;
    int age;
    int weight;

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getWeight() {
        return weight;
    }
    void setWeight(int weight) {
        this.weight = weight;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }

    String getGender() {
        return gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

}

public class QuizTest32 {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.setName("냥냥냥");
        d.setGender("F");
        d.setAge(2);
        d.setWeight(5);

        System.out.println(" 야옹이의 신상정보를 공개합니다. ");

        System.out.printf(" 이름 : %s, 성별 : %s, 나이 : %d, 몸무게 : %d kg\n", d.getName(), d.getGender(), d.getAge(), d.getWeight());
    }
}
