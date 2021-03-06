public class NumberOfOrCase {
    public static void main(String[] args) {
        //1000개의 데이터 --> A 500개 or B 125개를 판별할 때 어느 데이터를 먼저 검사해야할지 코드 구현 연습

        //검사 횟수를 수월하게 뽑기 위해 1000에 나머지가 딱 나누어지는 숫자들로 집단의 개수를 설정하셨는데,
        //만약 더 복잡하게 집단의 수가 결정되면 어떻게 해야하나요? ex)A의 개수가 700개, B의 개수가 320개 등

        //검사 횟수가 왜 저렇게 도출되는지는 이해가 가는데 그게 왜 이 코드로 구현이 되는지 아직 잘 모르겠습니다..
        //감이 안잡혀서 추가 설명이 필요할것 같습니다..

        int Acount=0, Bcount=0;
        //A먼저 검사 시
        for(int i=1; i<=1000; i++) {
            if((++Acount != 0 && i%2==0) || (++Acount != 0 && i%8==0)) {
                ; //제가 이해한대로라면 if 뒤에 (++Acount != 0 && i%2==0)에서 Acount값이 1000이 나오고 그 옆 || 뒤에는
                  //어느 수식이 나오든 상관 없이 i%2==0에 해당되지 않는 나머지 500개를 검사, 즉 Acount가 500더해지므로 1000+500이 도출된다라고 봤습니다.
                  //이론적으로뿐만 아니라 실제 컴퓨터가 이런식으로 계산해서 답을 내는것인지??궁금합니다.
            }
        }
        System.out.println(Acount);

        //B먼저 검사 시
        for(int i=1; i<=1000; i++) {
            if((Bcount++ != 0 && i%8==0) || (Bcount++ != 0 && i%2==0)) {
                ;
            }
        }
        System.out.println(Bcount);

    }
}
