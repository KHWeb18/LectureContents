import java.util.Scanner;

class StudentsScore {
    private int[] scores;
    Scanner scan;

    private float mean;
    private float variance;
    private float stdDeviation;

    public StudentsScore () {
        scan = new Scanner(System.in);

        inputStudentsScore();
    }

    private void inputStudentsScore () {
        Boolean isTrue = true;
        int studentsNum;
        char code;

        while (isTrue) {
            System.out.print("학생 성적 기록을 진행하시겠습니까 ? (Y/N) ");
            // 문자열을 입력받아 첫번째 값만 가져옵니다.
            // 배열의 시작이 0이기 때문
            // 두번째를 가져올 것이라면 1
            // 세번째는 2, 네번째는 3, .... 형식으로 갑니다.
            code = scan.next().charAt(0);

            if (code == 'Y') {
                isTrue = false;
            } else if (code == 'N') {
                System.out.println("더 이상 점수 입력을 진행하지 않습니다.");
                // 매서드를 종료합니다(void 매서드라 리턴값은 없음)
                return;
            } else {
                System.out.println("올바른 값을 입력하세요!");
            }
        }

        System.out.print("몇 명의 학생 점수를 입력하시겠습니까 ? ");
        studentsNum = scan.nextInt();

        scores = new int[studentsNum];

        for (int i = 0; i < studentsNum; i++) {
            System.out.print("학생 점수를 입력하세요: ");

            scores[i] = scan.nextInt();
        }
    }

    public void calcAverage () {
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        mean = (float)sum / (float)scores.length;
    }
    public void calcVariance () {
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += Math.pow((scores[i] - mean), 2);
        }

        variance = (float)sum / (float)scores.length;
    }
    public void calcStdDeviation () {
        stdDeviation = (float)Math.sqrt(variance);
    }

    public float getMean() {
        return mean;
    }
    public float getVariance() {
        return variance;
    }
    public float getStdDeviation() {
        return stdDeviation;
    }
}
// 키보드 입력을 통해 점수를 입력 받도록 만들자
// 또한 특정키를 입력하면 더 이상 점수 입력을 받지 않고
public class StduentsManagerTest {
    public static void main(String[] args) {
        StudentsScore ss = new StudentsScore();

        ss.calcAverage();
        ss.calcVariance();
        ss.calcStdDeviation();

        System.out.printf("우리반의 평균은 %.4f, 분산 %.3f, 표준편차 %f\n",
                ss.getMean(), ss.getVariance(), ss.getStdDeviation());
    }
}