package method;

import java.util.Scanner;

public class Tutorial {

	public static void Tutorial(Scanner sc) {
		System.out.println("Ʃ�丮�� ���Ű��� ȯ���մϴ�");
		// Ʃ�丮���� 3�������� ���� �Ǿ������� ������ ������ ���´�.
		System.out.println("�����Ϳ� ���� ���� Ȯ���մϴ�. ���ݺ��� ���ð����� �⺻�� �˷��帱�Կ�!");
		System.out.print("�켱 ���� [1]�� �Է��ؼ� ������ ������ �ּ���. [1] ���� �����ϱ� >>");
		int tans1 = sc.nextInt();
		int Option = 1;
		while (Option == 1) {
			if (tans1 == 1) {
				System.out.println("ĳ���ÿ� �����ϼ̽��ϴ�.");
				System.out.println("������ ���� �����ؿ�!");
				System.out.println("���ݺ��� �����Դϴ�!" + 9 + "+" + 9 + " =" + "�� ���� �����ϱ��?");
				int tans2 = sc.nextInt();
				if (tans2 == 18) {
					System.out.println("�����̿���! ��� �����̾��!");
					break;
				} else {
					System.out.println("�̷�... �ƽ��� ��ġ�̳׿�.");
					break;
				}

			} else {
				System.out.println("���� 1�� �����ּ��� �Ф�");
				tans1 = sc.nextInt();

			}

		}
		System.out.println("���� ���� ������ ��� ������� ����Ǵ��� ��ġä�̳���?");
		System.out.println("���� ������ ������ ��������� ������ ����ȴ�ϴ�.");
		System.out.println("�׷� �ѹ� �� ������ �غ����?");

		// ������ �Է�â�� SAVE �Է½� ����. ���� �� ����� SnE.
		// Ʃ�丮�� ���� �� �����Ϳ� ���� ���� ȯ���մϴ� => ���ư���.
		System.out.print("���� [1]�� �Է��ؼ� ������ ������ �ּ���. [1] ���� �����ϱ� >>");
		tans1 = sc.nextInt();

		while (Option == 1) {
			if (tans1 == 1) {
				System.out.println("ĳ���ÿ� �����ϼ̽��ϴ�.");
				System.out.println("������ ���� �����ؿ�!");
				System.out.println("���ݺ��� �����Դϴ�!" + 10 + "+" + 9 + " =" + "�� ���� �����ϱ��?");
				int tans2 = sc.nextInt();
				if (tans2 == 19) {
					System.out.println("�����̿���! ���� â�� �̸����� ���Ҿ��!");
					System.out.println("���ΰ��� �ڶ� ����â�� ���¿��� �����Ͽ����ϴ�!");
					break;
				} else {
					System.out.println("�̷�... �ƽ��� ��ġ�̳׿�.");
					break;
				}

			} else {
				System.out.println("���� 1�� �����ּ��� �Ф�");
				tans1 = sc.nextInt();
			}
		}

		System.out.println("�̷��� ����ִ� �̽��� ���׵� ���ܳ����!");
		System.out.print("�׷�... ���������� �ѹ��� ��... [1] ���� �����ϱ� >>");
		tans1 = sc.nextInt();
		while (Option == 1) {
			if (tans1 == 1) {
				System.out.println("ĳ���ÿ� �����ϼ̽��ϴ�.");
				System.out.println("������ ���� �����ؿ�!");
				System.out.println("���ݺ��� �����Դϴ�!" + 10 + "+" + 10 + " =" + "�� ���� �����ϱ��?");
				int tans2 = sc.nextInt();
				if (tans2 == 20) {
					System.out.println("�����̿���! �ξ��� ���Ҿ��!");
					System.out.println("�ξ�� ����� ������ ������ ����Ǿ����ϴ�!");
					break;
				} else {
					System.out.println("�̷�... �ƽ��� ��ġ�̳׿�.");
					break;
				}

			} else {
				System.out.println("���� 1�� �����ּ��� �Ф�");
				tans1 = sc.nextInt();
			}
		}
		System.out.println("���� ������ ��ǥ�� �ξ ��ų� ���� ������ �����ϸ� ������ ������ϴ�!");
		System.out.println("�׷� ����ȭ������ ���ư��� �������� �����غ����?!");
	}
}
