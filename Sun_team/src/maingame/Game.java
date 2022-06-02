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

		System.out.println("�ξ ������ ��ȥ�Ѵٴ� �ҹ��� �ִ��� ~ ���� !");// �����ͺ��̽����� �������� ��������
		System.out.print("�켱 ���� [1]�� �Է��ؼ� ������ ������ �ּ���. [1] ���� �����ϱ� >> ");
		int tans1 = sc.nextInt();
		System.out.println("ĳ���ÿ� �����ϼ̽��ϴ�.");
		System.out.println("���ô�"); // ���ô� �ƽ�Ű��Ʈ �ֱ� s>.<
		int num1, num2;
		
		int score = 0; // ����� ����

		int money = 0; // ����� ��

		int cnt = 0;

		String[] fish = fishtalking();
		
		// 5�� ���� Ǯ�� ���� ����!
		// �޴��� ���ö����� �� ������Ʈ ���� ������Ʈ

		ArrayList<Integer> fishscore = dao.fscore();
		ArrayList<Integer> fishprice = dao.price();
		
		int menucnt = 0;
		while (true) {
			menucnt++;
			if (tans1 == 1) {
				num1 = r.nextInt(200) + 1;
				num2 = r.nextInt(200) + 1;
				System.out.println("������ ���� �����ؿ�!");
				System.out.println("���ݺ��� �����Դϴ�!" + num1 + "+" + num2 + "=" + "�� ���� �����ϱ��?");
				int tans2 = sc.nextInt();
				if (tans2 == num1 + num2) {
					// ����⸦ �������� �������� - ��޺��� �����̶� ������ ~~
					// if ���� ������ ���ھ�� ���@! ���� ���� �׿�~~
					int rfish = r.nextInt(99) + 1;
					if (rfish > 97) {
						// �ξ�
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 1; i < result.size(); i++) {
							System.out.println(result.get(i) + "�� ��ҽ��ϴ�!");
							System.out.println("�ξ���� ��ȥ�� ���ϵ����~~~");
							System.out.println("�׷� �ǹ̿��� ���ô� ��! ��ȥ��Ȱ ����!");
							EndMainTest.Wedding();
						}
						break;
					} else if (rfish >= 92) {
						// Ȳ���, 7�����, �ġ, ������
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 5; i <= result.size() - 2; i++) {
							int num = r.nextInt(4) + 12;
							System.out.println(result.get(num) + "�� ��ҽ��ϴ�!");
							System.out.println(fish[num]);
							if (num == 13 || num == 14 || num == 15) {
								cnt++;
								System.out.println("����� ��ȣ���� " + cnt + "���� ��ҽ��ϴ�.");
							}else {
								EndMainTest.Garbage();
							}
							score += fishscore.get(num);
							money += fishprice.get(num);

							if (cnt == 3) {
								System.out.println("����� ��ȣ�� 3������ ��������� �������� ���ԵǾ����ϴ�.");
								System.out.println("�� �Ҿ���ȴ�");
								EndMainTest.sadEnding();
								break;
								// ��ȣ�� 3���� ������ ��������
							}

							break;
						}

					} else if (rfish >= 82) {
						// ���ƽ�, ������
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 7; i <= result.size() - 6; i++) {
							int num = r.nextInt(2) + 10;
							System.out.println(result.get(num) + "�� ��ҽ��ϴ�!");
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
						// �س�, �׾�ŷ, �ϱذ�
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 10; i <= result.size() - 8; i++) {
							int num = r.nextInt(3) + 7;
							System.out.println(result.get(num) + "�� ��ҽ��ϴ�!");
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
						// ����, ����, ���
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 13; i <= result.size() - 11; i++) {
							int num = r.nextInt(3) + 4;
							System.out.println(result.get(num) + "�� ��ҽ��ϴ�!");
							System.out.println(fish[num]);
							EndMainTest.Fish();
							score += fishscore.get(num);
							money += fishprice.get(num);
							break;
						}

					} else {
						// ����, �ɰ�, ����, ��¡��!!
						ArrayList<String> result = dao.FishAll();
						for (int i = result.size() - 17; i <= result.size() - 14; i++) {
							int num = r.nextInt(4);
							System.out.println(result.get(num) + "�� ��ҽ��ϴ�!");
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
				System.out.println("����� ���� ������?! ¥��� ~ >> " + score);				
				System.out.println("����� ���� �������� ?! ¥��� ~ >> " + money);
				System.out.println("���� ��մ�~ ���� ��մ� ~~");
				System.out.println("������ �ð� !");
				System.out.print("[1] ���� ����ϱ� [2] ���� ���� [3] ���� >> ");
				int choice = sc.nextInt();
				menucnt = 0;
				if(choice == 1) {
					continue;
				}else if(choice == 2) {
					shop.Shop("");// ���̵� �ҷ�����
					// ���� �����ϸ� �Ǳ�
				}else if(choice == 3) {
					break;
				}else {
					System.out.println("�߸��Է��߽��ϴ� ~ �ٽ� �Է����ּ���.");
				}
			}

		}
	}
	
	private static String[] fishtalking() {
		String[] fish = new String[17];
		fish[0] = "����� ��¡���Դϴ�."; // ��¡��
		fish[1] = ""; // ����
		fish[2] = ""; // �ɰ�
		fish[3] = ""; // ����
		fish[4] = ""; // ����
		fish[5] = ""; // ���
		fish[6] = ""; // ����
		fish[7] = "�ϱݰ��� Money�� ���� ~ ����⸦ ���� �Ծ�~~"; // �ϱذ�
		fish[8] = "�׾�ŷ���� �׾��� ���� ~~~"; // �׾�ŷ
		fish[9] = "���� �Ծ����ϴ�. !@#%!$#!@#%!$#"; // �س�
		fish[10] = "���ΰ��� �ڶ� ���� �̳��̰� ĳġ���ε带 �����߽��ϴ�."; // ���ֹ̳��� �ڼ���
		fish[11] = "���ΰ��� �ڶ� ���� â�� ���׿��� �����߽��ϴ�. \nMeteor �Ŵ� Meteor �� �װ� ó���� Meteor��"; // ����â�� �̸���
		fish[12] = "ȯ���� ��ȣ�߽��ϴ� ~~~"; // ������
		fish[13] = "��ȣ�� �ġ�Դϴ�."; // �ġ
		fish[14] = "��ȣ�� 7������Դϴ�."; // 7�����
		fish[15] = "��ȣ�� Ȳ����Դϴ�."; // Ȳ���
		return fish;
	}
}
