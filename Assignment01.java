import java.util.Scanner;

public class Assignment01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] randomNum = new int[3];               //랜덤 숫자를 담을 배열 선언
        int[] inputNum = new int[randomNum.length]; //정답을 담을 배열 선언, 정답 배열 길이 == 랜덤 배열 길이

        //랜덤 숫자 생성
        boolean[] visitNum = new boolean[10];        //중복 확인을 위한 boolean배열 선언, 배열의 길이는 랜덤숫자의 범위만큼이다.
        int ranTemp = 0;                             //랜덤 숫자를 임시로 저장하기 위한 변수
        for (int i = 0; i < randomNum.length; i++) { // randomNum배열의 길이만큼 for문 반복
            ranTemp = (int)(Math.random()*10);       // 0~9사이의 숫자 중 랜덤한 숫자 하나를 ranTemp에 담는다.
            if(!(visitNum[ranTemp])) {               // visitNum 배열의 ranTemp번째 값이 false인 경우 입장
                randomNum[i] = ranTemp;              // ranTemp의 값을 randomNum[i]값에 저장
                visitNum[ranTemp] = true;            // 한번 if문으로 입장하면 현재위치에 true 값을 저장해서 중복을 방지한다.
            }
        }

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!"); //게임 시작 메세지 출력

        int count = 0; // 맞춘 시도를 count 하기 위한 변수
        while(true){   // 기회는 무제한이며, 숫자 3개를 모두 맞춘 경우, 게임 종료
            count++;   // 시도 +1

            System.out.print(count + "번째 시도 : ");
            int inTemp = sc.nextInt();     // 입력 값을 받는다.
            for (int i = inputNum.length-1; i >= 0; i--) {
                inputNum[i] = inTemp % 10; // inTemp 값을 10으로 나눈 나머지 값을 저장한다.
                inTemp /= 10;              // ex) 456 % 10 = 6, 45 % 10 = 5, 4 % 10 = 4
            }                              // ex)와 같이 1의 자리 수 부터 값을 저장하기 때문에 for문은 i=2 -> 0까지 i-- 해준다.

            int ball = 0;
            int strike = 0;
            for (int i = 0; i < randomNum.length; i++) {     // Strike, Ball 판단
                for (int j = 0; j < randomNum.length; j++) {
                    if (randomNum[i] == inputNum[j]) {       // 둘의 값이 같을때
                        if (i == j) {                        // 위치도 같으면 Strike++
                            strike++;
                        } else {                             // 위치는 틀리면 Ball++
                            ball++;
                        }
                    }
                }
            }

            if(strike == 3) {                             // 3S가 되면 break로 while문 탈출, 게임 종료
                System.out.println(strike+"S");
                System.out.println(count+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            } else if (strike != 0 && ball == 0) {        //ball 값이 없을땐 strike 값만 출력
                System.out.println(strike+"S");
            } else if (ball != 0 && strike == 0) {        //strike 값이 없을땐 ball 값만 출력
                System.out.println(ball+"B");
            }else {
                System.out.println(ball+"B"+strike+"S");  //나머지(0,0)일땐 모두 출력
            }
        }
        sc.close();
    }
}
