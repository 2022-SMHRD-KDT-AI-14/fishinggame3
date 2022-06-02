package maingame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import end.EndMainTest;
import method.CallOfFishDAO;
import shop.Shop;

public class Game {

	public static void game(Scanner sc) {

		CallOfFishDAO dao = new CallOfFishDAO();
		Random r = new Random();
		Shop shop = new Shop();

		System.out.println("인어를 잡으면 결혼한다느 소문이 있던데 ~ 과연 !");// 데이터베이스에서 누적점수 가져오기
		System.out.print("우선 숫자 [1]을 입력해서 게임을 실행해 주세요. [1] 게임 실행하기 >> ");
		int tans1 = sc.nextInt();
		System.out.println("캐스팅에 성공하셨습니다.");
		System.out.println("낚시대"); // 낚시대 아스키아트 넣기 s>.<
		int num1, num2;
		
		int score = 0; // 물고기 점수

		int money = 0; // 물고기 돈

		int cnt = 0;

		String[] fish = fishtalking();
		
		// 5번 문제 풀면 상점 등장!
		// 메뉴가 나올때마다 돈 업데이트 점수 업데이트

		ArrayList<Integer> fishscore = dao.fscore();
		ArrayList<Integer> fishprice = dao.price();
		
		int menucnt = 0;
		while (true) {
			menucnt++;
			if (tans1 == 1) {
				num1 = r.nextInt(200) + 1;
				num2 = r.nextInt(200) + 1;
				System.out.println("입질이 오기 시작해요!");
				System.out.println("지금부터 시작입니다!" + num1 + "+" + num2 + "=" + "의 답은 무엇일까요?");
				int tans2 = sc.nextInt();
				if (tans2 == num1 + num2) {
					// 물고기를 랜덤으로 가져오기 - 등급별루 가격이랑 점수도 ~~
					// if 절에 점수를 스코어로 등록@! 돈도 같이 쌓여~~
					int rfish = r.nextInt(99) + 1;
					if (rfish > 97) {
						// 인어
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 1; i < result.size(); i++) {
							System.out.println(result.get(i) + "를 잡았습니다!");
							System.out.println("인어와의 결혼을 축하드려요~~~");
							System.out.println("그런 의미에서 낚시는 끝! 결혼생활 시작!");
							EndMainTest.Wedding();
						}
						break;
					} else if (rfish >= 92) {
						// 황쏘가리, 7성장어, 어름치, 쓰레기
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 5; i <= result.size() - 2; i++) {
							int num = r.nextInt(4) + 12;
							System.out.println(result.get(num) + "를 잡았습니다!");
							System.out.println(fish[num]);
							if (num == 13 || num == 14 || num == 15) {
								cnt++;
								System.out.println("당신은 보호종을 " + cnt + "마리 잡았습니다.");
							}else {
								EndMainTest.Garbage();
							}
							score += fishscore.get(num);
							money += fishprice.get(num);

							if (cnt == 3) {
								System.out.println("당신은 보호종 3마리를 잡았음으로 경찰서에 가게되었습니다.");
								System.out.println("다 잃어버렸누");
								EndMainTest.sadEnding();
								break;
								// 보호종 3마리 뽑으면 게임종료
							}

							break;
						}

					} else if (rfish >= 82) {
						// 명훈쌤, 수현쌤
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 7; i <= result.size() - 6; i++) {
							int num = r.nextInt(2) + 10;
							System.out.println(result.get(num) + "를 잡았습니다!");
							System.out.println(fish[num]);
							if( num == 11) {
								EndMainTest.Meteo();
							}
							if(num == 10) {
								EndMainTest.Meenoi();
							}
							score += fishscore.get(num);
							money += fishprice.get(num);
							break;
						}
					} else if (rfish >= 67) {
						// 해녀, 잉어킹, 북극곰
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 10; i <= result.size() - 8; i++) {
							int num = r.nextInt(3) + 7;
							System.out.println(result.get(num) + "를 잡았습니다!");
							System.out.println(fish[num]);
							if(num==8) {
								EndMainTest.PocketKing();
							}
							if(num==7) {
								EndMainTest.PolarBear();
							}
							score += fishscore.get(num);
							money += fishprice.get(num);
							break;
						}
					} else if (rfish >= 47) {
						// 돗돔, 병어, 방어
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 13; i <= result.size() - 11; i++) {
							int num = r.nextInt(3) + 4;
							System.out.println(result.get(num) + "를 잡았습니다!");
							System.out.println(fish[num]);
							EndMainTest.Fish();
							score += fishscore.get(num);
							money += fishprice.get(num);
							break;
						}

					} else {
						// 조기, 꽃게, 고등어, 오징어!!
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 17; i <= result.size() - 14; i++) {
							int num = r.nextInt(4);
							System.out.println(result.get(num) + "를 잡았습니다!");
							System.out.println(fish[num]);
							EndMainTest.Fish();
							score += fishscore.get(num);
							money += fishprice.get(num);
							break;
						}
					}
				}
			}
			if(menucnt == 5) {
				System.out.println();
				System.out.println("당신의 현재 점수는?! 짜라란 ~ >> " + score);				
				System.out.println("당신의 현재 소지금은 ?! 짜라란 ~ >> " + money);
				System.out.println("아이 재밌다~ 낚시 재밌다 ~~");
				System.out.println("선택의 시간 !");
				System.out.print("[1] 낚시 계속하기 [2] 상점 가기 [3] 종료 >> ");
				int choice = sc.nextInt();
				menucnt = 0;
				if(choice == 1) {
					continue;
				}else if(choice == 2) {
					shop.Shop("");// 아이디 불러오기
					// 상점 연결하면 되기
				}else if(choice == 3) {
					break;
				}else {
					System.out.println("잘못입력했습니다 ~ 다시 입력해주세요.");
				}
			}

		}
	}
	
	private static String[] fishtalking() {
		String[] fish = new String[17];
		fish[0] = "당신은 오징어입니다."; // 오징어
		fish[1] = ""; // 고등어
		fish[2] = ""; // 꽃게
		fish[3] = ""; // 조기
		fish[4] = ""; // 병어
		fish[5] = ""; // 방어
		fish[6] = ""; // 돗돔
		fish[7] = "북금곰은 Money를 찢어 ~ 물고기를 훔쳐 먹어~~"; // 북극곰
		fish[8] = "잉어킹으로 잉어즙 존맛 ~~~"; // 잉어킹
		fish[9] = "욕을 먹었습니다. !@#%!$#!@#%!$#"; // 해녀
		fish[10] = "스인개의 자랑 광주 미노이가 캐치마인드를 시작했습니다."; // 광주미노이 박수현
		fish[11] = "스인개의 자랑 광주 창모가 메테오를 시전했습니다. \nMeteor 거대 Meteor 난 네게 처박힐 Meteor야"; // 광주창모 이명훈
		fish[12] = "환경을 보호했습니당 ~~~"; // 쓰레기
		fish[13] = "보호종 어름치입니다."; // 어름치
		fish[14] = "보호종 7성장어입니다."; // 7성장어
		fish[15] = "보호종 황쏘가리입니다."; // 황쏘가리
		return fish;
	}
}
