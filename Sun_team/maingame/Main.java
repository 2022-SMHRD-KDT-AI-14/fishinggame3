package maingame;

import java.util.ArrayList;
import java.util.Scanner;

import method.Tutorial;
import method.UserDAO;
import method.UserDTO;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[낚시꾼으로 살아남기]");
		boolean stage1 = true;
		while (stage1) {
			System.out.print("[1] 로그인 [2] 회원가입 [3] 랭킹 확인 [4] 만든이들 [5] 종료 >> ");
			int menu = sc.nextInt();
			if (menu == 1) {
			while(stage1) {
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				UserDAO dao = new UserDAO();
				UserDTO dto = new UserDTO(id, pw);
				dao.login(dto);
				if(id.equals(dto.getId()) && pw.equals(dto.getPw())) {
					System.out.println("낚시터에 오신것을 환영합니다.");
					stage1 = false;
				}else {
					System.out.println("아이디 비밀번호를 확인해주세요.");
				}
			}

				while (true) {
					// 로그인 후 게임 반복 시작되는 while문
					System.out.print("[1] 튜토리얼 [2] 새로하기 [3] 종료 >>");
					// 메뉴에서 1번을 누르면 나오는 2차 메뉴

					int menu2 = sc.nextInt();

					if (menu2 == 1) {
						Tutorial.Tutorial(sc);

					} else if (menu2 == 2) {
						Game.game(sc);
						// 게임 스토리 처음부터 시작.
						// 주인공이 왜 낚시를 시작 했는가.
						// 1단계~3단계
						// 게임 오버 조건 =
						// 중간에 상점을 갈
					} else if (menu2 == 3) {
						// 시스템 종료 메서드 생성 필요
						// exit?
					} else {
						System.out.println("입력 번호를 확인 해 주세여");
					}
				}
				// 로그인 후 게임 시작의 while문 종료 괄호
			} else if (menu == 2) {
				UserDAO dao = new UserDAO();
				System.out.println("===== 회원 가입 =====");
				System.out.print("ID입력 : ");
				String id = sc.next();
				System.out.print("PW입력 : ");
				String pw = sc.next();
				dao.insert(id, pw);

			} else if (menu == 3) {
				UserDAO dao2 = new UserDAO();
				ArrayList<String[]> result = dao2.ranking();
				System.out.println("");
				System.out.println(" \t    ┌───────────────────────────────────────────┐");
				System.out.println(" \t    │                 [ Top 5 ]                 │");
				System.out.println(" \t    └───────────────────────────────────────────┘");
				System.out.println("");
				for (int i = 0; i < result.size(); i++) {
					System.out.print("\t\t\t" + result.get(i)[0] + "등\t");
					for (int j = 1; j <= 2; j++) {
						System.out.print(result.get(i)[j] + "\t");
					}
					System.out.println();

				}

			} else if (menu == 4) {
				System.out.println("==== 손좀 쓴 사람들 ====");

				System.out.println();
				System.out.println("༼ つ ◕_◕ ༽つ 베수현, 이민지, 차동주, 천만승, 김준영 ༼ つ ◕_◕ ༽つ");

			} else if (menu == 5) {
				// 게임 종료 메서드
			} else {
				System.out.println("입력 번호를 확인 해 주세여");
			}

		}
	}

}
