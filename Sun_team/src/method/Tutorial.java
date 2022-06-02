package method;

import java.util.Scanner;

public class Tutorial {

	public static void Tutorial(Scanner sc) {
		System.out.println("튜토리얼에 오신것을 환영합니다");
		// 튜토리얼은 3게임으로 구성 되어있으며 게임의 설명문이 나온다.
		System.out.println("낚시터에 오신 것을 확인합니다. 지금부터 낚시게임의 기본을 알려드릴게요!");
		System.out.print("우선 숫자 [1]을 입력해서 게임을 실행해 주세요. [1] 게임 실행하기 >>");
		int tans1 = sc.nextInt();
		int Option = 1;
		while (Option == 1) {
			if (tans1 == 1) {
				System.out.println("캐스팅에 성공하셨습니다.");
				System.out.println("입질이 오기 시작해요!");
				System.out.println("지금부터 시작입니다!" + 9 + "+" + 9 + " =" + "의 답은 무엇일까요?");
				int tans2 = sc.nextInt();
				if (tans2 == 18) {
					System.out.println("성공이에요! 고등어를 낚으셨어요!");
					break;
				} else {
					System.out.println("이런... 아쉽게 놓치셨네요.");
					break;
				}

			} else {
				System.out.println("숫자 1을 눌러주세요 ㅠㅠ");
				tans1 = sc.nextInt();

			}

		}
		System.out.println("이제 저희 게임이 어떠한 방식으로 진행되는지 눈치채셨나요?");
		System.out.println("저희 게임은 간단한 연산식으로 게임이 진행된답니다.");
		System.out.println("그럼 한번 더 게임을 해볼까요?");

		// 저장은 입력창에 SAVE 입력시 실행. 저장 및 종료는 SnE.
		// 튜토리얼 종료 후 낚시터에 오신 것을 환영합니다 => 돌아가기.
		System.out.print("숫자 [1]을 입력해서 게임을 실행해 주세요. [1] 게임 실행하기 >>");
		tans1 = sc.nextInt();

		while (Option == 1) {
			if (tans1 == 1) {
				System.out.println("캐스팅에 성공하셨습니다.");
				System.out.println("입질이 오기 시작해요!");
				System.out.println("지금부터 시작입니다!" + 10 + "+" + 9 + " =" + "의 답은 무엇일까요?");
				int tans2 = sc.nextInt();
				if (tans2 == 19) {
					System.out.println("성공이에요! 광주 창모 이명훈을 낚았어요!");
					System.out.println("스인개의 자랑 광주창모가 메태오를 시전하였습니다!");
					break;
				} else {
					System.out.println("이런... 아쉽게 놓치셨네요.");
					break;
				}

			} else {
				System.out.println("숫자 1을 눌러주세요 ㅠㅠ");
				tans1 = sc.nextInt();
			}
		}

		System.out.println("이렇게 재미있는 이스터 에그도 숨겨놨어요!");
		System.out.print("그럼... 마지막으로 한번만 더... [1] 게임 실행하기 >>");
		tans1 = sc.nextInt();
		while (Option == 1) {
			if (tans1 == 1) {
				System.out.println("캐스팅에 성공하셨습니다.");
				System.out.println("입질이 오기 시작해요!");
				System.out.println("지금부터 시작입니다!" + 10 + "+" + 10 + " =" + "의 답은 무엇일까요?");
				int tans2 = sc.nextInt();
				if (tans2 == 20) {
					System.out.println("성공이에요! 인어을 낚았어요!");
					System.out.println("인어와 사랑에 빠지며 게임이 종료되었습니다!");
					break;
				} else {
					System.out.println("이런... 아쉽게 놓치셨네요.");
					break;
				}

			} else {
				System.out.println("숫자 1을 눌러주세요 ㅠㅠ");
				tans1 = sc.nextInt();
			}
		}
		System.out.println("저희 게임의 목표는 인어를 잡거나 일정 점수에 도달하면 게임이 끝난답니다!");
		System.out.println("그럼 메인화면으로 돌아가서 새게임을 시작해볼까요?!");
	}
}
