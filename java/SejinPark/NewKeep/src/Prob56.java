import java.util.*;


public class Prob56 {
    public static void main(String[] args) {

        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String , Integer>>(); //키가 string,밸류가 map이 왔다
        Map<String, Integer>[] preparedMap = new HashMap[3];                                //map을 배열로 만듬

        String[] pattern = {"spear", "sword", "arrow"};

        for (int i = 0; i < 3; i++) {
            preparedMap[i] = new HashMap<String  , Integer>();                       //preparedMap이라는 해쉬맵 만듬

            for (int j = 0; j < 10; j++) {
                preparedMap[i].put(pattern[i] + j, j);                      //전체의 밸류-map형식으로 (키=밸류)
            }
        }

        for (int i = 0; i < 3; i++) {
            map.put(pattern[i], preparedMap[i]);                   //만든 preparedMap해쉬맵 배열에 키와 밸류 넣어줌
        }

        System.out.println(map);
//==================================================================================================
        System.out.println("카드를 분배합니다.");
        HashSet<Integer> hs = new HashSet<>();
        boolean isEnd = false;
        int[] arr2 = new int[10];
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String sculpture = pattern[(int)(Math.random() * 3)];  //pattern배열 0,1,2인덱스 모두 나옴. 즉 검,방패,화살이 돌아가며 나옴
            //int randNum = (int)(Math.random() * 10);          //0~9까지 모두 나옴. 여기서 중복이 나옴

           arr2[i]=(int)(Math.random() * 10);
            for (int str2 : arr2) {
                if (!al.contains(str2)) {
                    al.add(str2);
                }
            }
            System.out.println("사용자에게 분배된 카드는 = " + sculpture + " 문양의 " + al.get(i) + " 카드입니다!");


            /*같은 문양의 숫자가 연속되게 3개 나오는 경우(예 9 8 7) > 서로 다른 문양의 같은 숫자
            서로 다른 문양의 같은 숫자                           > 서로 다른 문양의 숫자가 연속되게 3개 나옴
            서로 다른 문양의 숫자가 연속되게 3개 나옴             > 서로 같은 문양이 3개 나옴*/

            //이거 비밀번호 만들때 쓰는거 같은데

            //1 같은문양3개 && 연속된 숫자3개

            //2 같은숫자3개
            //3 다른문양3개 && 연속된 숫자3개
            //4 같은문양3개

            /*function checkSequnceNumbers(target, counterLength = 6) {
  // under es6
  // let sequentialCounter = Array.apply(null, Array(counterLength)).map(Number.prototype.valueOf,0);
  let sequentialCounter = new Array(counterLength).fill(0);
  let count = 0;

  for (let i = 0, len = target.length; i < len; i++) {
    let subCount = 0;

    for (let j = 1; j < len; j++) {
      if (target[j] === target[i] + 1) {
        subCount = subCount + 1;
      } else {
        continue;
      }
    }

    count = count + subCount;
    if (subCount === 0) {
      sequentialCounter[count] = sequentialCounter[count] + 1;
      count = 0;
    }
  }

  return sequentialCounter;
}

let target = [1, 2, 3, 5, 6, 7, 8, 10, 11, 13, 16, 17];
console.log(checkSequnceNumbers(target));
// => [1, 2, 1, 1, 0, 0]
*/


        }
    }
}