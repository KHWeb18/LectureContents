public class DummyMemo {
    public static void main(String[] args) {
        System.out.println("메모");
    }
}

/*
Multi-Tasking
스타 선수들을 보면 화면 전환이 오지게 빠르고
유닛 컨트롤 하면서 생산하고 일꾼찍고 견제도 하고 난리가 납니다.
(엄밀하게 말해서 아주 빠르게 순차적으로 일어날 뿐 실제로는 정말 동시에 일어나지 않습니다)
컴퓨터의 Multi-Tasking 개념도 동일한데
아주 빠르게 순차적으로 동작하기 때문에 우리가 느끼기엔 동시에 발생하는것 처럼 느껴질 뿐
* 의문 ? 아까 CPU는 오직 한 순간에 한 가지 일만 처리함
우리의 상황을 생각해봅시다!
1. 인터넷 창을 모두 키고 있습니다.
2. 프로그래밍 해야하니까 인텔리제이도 키고 있습니다.
3. 줌 화상 회의 프로그램도 켜놓고 있습니다.
4. 문서 프로그램 등등 여러가지 프로그램들이 켜져 있는 상태
5. 카톡도 켜져 있고
6. 네이트온도 커져있고
7. 슬랙 앱도 돌고 있고 ...
???????? 이게 뭥미 ?
도대체 CPU가 한 순간에 한 가지 일만 한다는데 이건 어떻게 설명해야할까 ?
어쨋든 이것은 불변의 진리인데 그럼 이게 어떻게 되는걸까 ?
1. CPU의 동작 주파수를 보자!
   3.00 GHz 가 나오고 있다(학원컴)
ARM(RISC), Intel(CISC)
기준은 2.0GHz에 맞춰서 계산해보자!
Hz 뜻이 뭘까요 ? 1초에 몇 번 진동하는가를 의미하는 단위
컴퓨터에서 얘기하는 주파수는 결국 클럭(clock)을 의미하는 것으로
초당 몇 개의 명령어를 처리할 수 있는지로 귀결됩니다.
G = 10^9 = 1000000000 = 10억
2GHz = 20억
1초에 20억개의 명령을 처리할 수 있다 <<<
20억을 기준으로 하였을때 2000개는 ???
2000000000 / 2000 = 1000000 = 100만배
최고 운동 신경을 가진 운동 선수가 육안으로 식별할 수 있는 가장 짧은 시간은 몇 초일까요 ?
0.3x 초 정도라고 합니다.
1초 -> 20억, 0.1초 -> 2억 ===> 0.3초 ===> 6억, 0.3x초 ===> 6 ~ 7억 사이의 명령어를 처리할 수 있음을 의미함
현재 작업표시줄에 나타나는 프로세스가 대략 100개 정도 됩니다.
100개의 프로세스가 모두 명령 2000개씩을 실행한다고 해봐야 200000 <<< 20만개 밖에 안되죠.
만약 모든 프로세스가 0.0001초씩 동작을 한다고 가정해보자!
대략 1000개 프로세스가 모두 한 바퀴 순회하는데 얼마나 걸리나요 ? 0.1초
(아주 빠르게 순차적으로 일어날 뿐 ...)
지금까지 진행했던 이 과정 자체를 우리는 Multi-Tasking 이라고 부릅니다.
현재 여기서 생략되어 있는 내용이 하나 있습니다(Context Switching 이라는 개념이 생략되어 있음)
eax, ebx는 하드웨어 레지스터(Memory Hierarchy의 최상위에 있던 레지스터입니다)
ex) 컨텍스트 스위칭 도입이 없는 상태
Thread 1
mov eax, 3    // eax = 3                          (1)
mov ebx, 4    // ebx = 4                          (4)
add eax, ebx  // eax = eax + ebx  ---> ???  (5) 7 + 4 = 11 ??????
Thread 2
mov eax, 7     // eax = 7                (2)
mov ebx, 2     // ebx = 2                (3)
add eax, ebx   // eax = eax + ebx
ex) 컨텍스트 스위칭을 도입한 상태
Thread 1
mov eax, 3    // eax = 3                          (1) ----> 제어권을 넘기기 전에 현재 하드웨어 레지스터 정보를 메모리에 저장함
                                                                      (이 정보는 운영체제가 관리하고 있어서 찾을 수 있음)
mov ebx, 4    // ebx = 4                          (4) <--- 다시 돌아와서 이전에 저장한 정보를 메모리에서 찾아서 복원함
add eax, ebx  // eax = eax + ebx  ---> ???  (5) 3 + 4 = 7 (데이터의 무결성을 보장함)
Thread 2
mov eax, 7     // eax = 7                (2)
mov ebx, 2     // ebx = 2                (3) ----> 자신의 제어권이 역시 넘어가기 전에 하드웨어 레지스터 정보를 백업함
add eax, ebx   // eax = eax + ebx
Mutex vs Spinlock의 차이점이 뭡니까 ?
 */
