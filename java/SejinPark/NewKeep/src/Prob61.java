import java.math.BigInteger;

class ThreadManager {
    final static int MAXTHREAD = 3;
    final static BigInteger START = new BigInteger("1");
    final static BigInteger END = new BigInteger("100000000000");
    final static int EVEN = 2;
    final static int SEVEN = 7;
    final static int ELEVEN = 11;
    final static int[] OPTION_ARR = { EVEN, SEVEN, ELEVEN };
    Thread[] thr;
    public ThreadManager () {
        thr = new Thread[MAXTHREAD];
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i] = new Thread(new DistributedThread(START, END, i, OPTION_ARR[i]));
        }
    }
    public void calcEachBigInteger () {
        calcEachBigIntegerStart();
    }
    public void calcEachBigIntegerStart () {
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].start();
        }
    }
    public void calcEachBigIntegerJoin () throws InterruptedException {
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].join();
        }
    }
}
class DistributedThread implements Runnable {
    BigInteger start;
    BigInteger end;
    int threadIdx;
    int option;

    static final BigInteger ONE = new BigInteger("1");

    BigInteger sum;
    BigInteger localSum;
    static BigInteger totalSum;

    public DistributedThread (BigInteger start, BigInteger end, int threadIdx, int option) {
        this.start = start;
        //this.end = end.add(BigInteger.ONE);
        this.end = new BigInteger("30").add(BigInteger.ONE);
        this.threadIdx = threadIdx;
        this.option = option;

        sum = BigInteger.ZERO;
        localSum = BigInteger.ZERO;
        totalSum = BigInteger.ZERO;
    }

    private synchronized void addAll () {
        totalSum = totalSum.add(localSum);
    }

    @Override
    public void run() {
        for (BigInteger i = start; i.compareTo(end) == -1; i = i.add(ONE)) {
            /* DEBUG 메시지
            System.out.println("threadIdx: " + threadIdx +
                    ", BigInteger 기반 비교를 시작합니다. 현재 i = " + i +
                    ", start = " + start + ", end = " + end +
                    ", i + ONE = " + i.add(ONE)); */
            // if (i % option == 0) {
            if (
                    (i.mod(new BigInteger(String.valueOf(option))).
                            compareTo(BigInteger.ZERO)
                    ) == 0
            ) {
                /* DEBUG 메시지
                System.out.println("threadIdx: " + threadIdx +
                        ", option: " + option +
                        ", 내가 찾는 숫자는: " + i); */
                sum = sum.add(i);
                localSum = localSum.add(i);

                System.out.println("threadIdx: " + threadIdx + ", sum = " + sum);
                // System.out.println("threadIdx: " + threadIdx + ", sum = " + sum);
            }
        }

        addAll();

        System.out.println("totalSum = " + totalSum);
    }
}

public class Prob61 {
    public static void main(String[] args) {
        ThreadManager tm = new ThreadManager();
        tm.calcEachBigInteger();
    }
}
// 2 4 6 8 10  12 14 16 18 20  22 24 26 28 30
// 32 x 7 + 16 => 224 + 16 = 240