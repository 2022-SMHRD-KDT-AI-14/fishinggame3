package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import music.MusicDTO;

public class Shop {

	Scanner sc = new Scanner(System.in);
	Connection conn; // DB ������ ���� ��ü
	PreparedStatement psmt; // SQL���� �����ϴ� ��ü
	ResultSet rs; // Query�� ������� �޾ƿ��� ��ü
	
	MusicDTO MusicList = new MusicDTO();
	
	

	public void login() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. DB����

		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String us_id = "campus_e_0516_4";
		String us_pw = "smhrd4";

		try {
			conn = DriverManager.getConnection(url, us_id, us_pw);
			
			if (conn != null) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Shop(String ID) {
		// DB ����
		login();
		ShopEnter();
		System.out.println("������ ���� �� ȯ���մϴ�! ���� �غ� �� ������ ������. ");
		// ID�� �´� �� �÷��� user_info ���̺��� �ҷ��´�. while�� �ȿ��� ��� ���� �ȵǰ� while�� �ۿ��� ���� ����.
		String sql = "select MONEY from user_info where ID = ?";

		while (true) {
			

			System.out.println("[1] �� ���ô� (2000��) [2] ��� �� ���ô� (3000��) [3] ������ ���°� ���ô� (5000��) [4] ������>> ");
			// �������� ������ �޴� ��ȣ�� input ������ ����
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("�� ���ô븦 �����߽��ϴ�.");
				System.out.println("��� : 5��� ����� ���� Ȯ�� ���� �������");
				System.out.println("�����Ͻðڽ��ϱ�? [1] �� [2] �ƴϿ� >>");
				// ����Ȯ���� yn�̶�� ������ ���� �� ������ ����
				int yn = sc.nextInt();
				if (yn == 1) {
					try {
						// ���̵� ���ؼ� �� ���̺� �ҷ�����
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, ID);
						rs = psmt.executeQuery();

						if (rs.next()) {
							// ������ money ������ ���� �� �����ݰ� ������ ���� �� �� ���� �� �񱸸� ������
							int money = rs.getInt("MONEY");

							if (money >= 20) {
								ShopUpdate((money - 20), input, ID);
								// ������ ������Ʈ �� ������ ������Ʈ
								System.out.println("�� ���ô븦 �����Ͽ����ϴ�!");
							} else {
								// ������ ������ ���� ����ȭ������ �ѹ�
								System.out.println("�ܾ��� �����մϴ�. �������� Ȯ�����ּ���.");
								System.out.println("�������� "+money+"�� �Դϴ�.");
							}
						}

					} catch (SQLException e) {
						e.printStackTrace();
						// 1�� �����ô� ���� �� Ʈ���� ĳġ��! ���� ���
					}

				} else if (yn == 2) {
					// �����ô� ���� Ȯ�� ������ �� 2�� �ƴϿ� ����

				} else {
					// �� ���ô� ���� ������ 1 or 2 �̿ܿ� �Է½� �߸� ���� Ŭ���� ���� �������� �ѹ�
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}

			} else if (input == 2) {
				System.out.println("��� �� ���ô븦 �����߽��ϴ�.");
				System.out.println("��� : 6��� ����� ���� ����");
				System.out.println("�����Ͻðڽ��ϱ�? [1] �� [2] �ƴϿ� >>");
				int yn = sc.nextInt();
				if (yn == 1) {

					try {
						// ���̵� ���ؼ� �� ���̺� �ҷ�����
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, ID);
						rs = psmt.executeQuery();

						if (rs.next()) {
							// ������ money ������ ���� �� �����ݰ� ������ ���� �� �� ���� �� �񱸸� ������
							int money = rs.getInt("MONEY");

							if (money >= 3000) {
								ShopUpdate((money - 3000), input, ID);
								// ������ ������Ʈ �� ������ ������Ʈ
								System.out.println("��� �� ���ô븦 �����Ͽ����ϴ�!");
							} else {
								// ������ ������ ���� ���� ȭ������ �ѹ�
								System.out.println("�ܾ��� �����մϴ�. �������� Ȯ�����ּ���.");
								System.out.println("�������� "+money+"�� �Դϴ�.");
							}
						}

					} catch (SQLException e) {
						// 2�� ��� �����ô� ���� �� Ʈ���� ĳġ��! ���� ���
						e.printStackTrace();
					}

				} else if (yn == 2) {
					// ��� �����ô� ���� Ȯ�� ������ �� 2�� �ƴϿ� ����

				} else {
					// ��� �� ���ô� ���� ������ 1 or 2 �̿ܿ� �Է½� �߸� ���� Ŭ���� ���� �������� �ѹ�
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
			} else if (input == 3) {
				System.out.println("������ ���°� ���ô븦 �����߽��ϴ�.");
				System.out.println("��� : ��Ű ����� ���� Ȯ�� ����");
				System.out.println("�����Ͻðڽ��ϱ�? [1] �� [2] �ƴϿ� >>");
				int yn = sc.nextInt();
				if (yn == 1) {

					try {
						// ���̵� ���ؼ� �� ���̺� �ҷ�����
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, ID);
						rs = psmt.executeQuery();

						if (rs.next()) {
							// ������ money ������ ���� �� �����ݰ� ������ ���� �� �� ���� �� �񱸸� ������
							int money = rs.getInt("MONEY");

							if (money >= 5000) {
								ShopUpdate((money - 5000), input, ID);
								// ������ ������Ʈ �� ������ ������Ʈ
								System.out.println("������ ���°� ���ô븦 �����Ͽ����ϴ�!");
							} else {
								// ������ ������ ���� ���� ȭ������ �ѹ�
								System.out.println("�ܾ��� �����մϴ�. �������� Ȯ�����ּ���.");
								System.out.println("�������� "+money+"�� �Դϴ�.");
							}
						}

					} catch (SQLException e) {
						// 3�� ������ ���°��� ���ô� ���� �� Ʈ���� ĳġ��! ���� ���
						e.printStackTrace();
					}

				} else if (yn == 2) {
					// ������ ���°� ���ô� ���� Ȯ�� ������ �� 2�� �ƴϿ� ����

				} else {
					// ������ ���°� ���ô� ���� ������ 1 or 2 �̿ܿ� �Է½� �߸� ���� Ŭ���� ���� �������� �ѹ�
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
			} else if (input == 4) {
				System.out.println("������ �����ڽ��ϴ�.");

				ShopEnd(); // DB ���� ����
				break;

			} else {
				// ���� ������ 1~4 �̿ܿ� �Է� �� ���� ����ȭ������ �ѹ�
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}

		}
	}

	public void ShopUpdate(int money, int input, String ID) {
		try {
			// sql�� �ٽ� ���� ����
			String sql = "";
			// sql���� USER_INFO��� ���̺��� MONEY �÷� ������Ʈ. id�� ���� �࿡��
			sql = "update USER_INFO set MONEY = ? where id = ?";
			// sql�� ����
			psmt = conn.prepareStatement(sql);
			// ?�� ���� �� ����. 1��° ����ǥ money, 2��° ����ǥ�� id ���� 
			 psmt.setInt(1, money);
			psmt.setString(2, ID);
			// DB ������Ʈ
			psmt.executeUpdate();

			sql = "update USER_INFO set I_TEM = ? where id = ?";
			// sql�� ����
			psmt = conn.prepareStatement(sql);
			// ?�� ���� �� ����. 1��° ����ǥ input >> ���ô� �ѹ��� , 2��° ����ǥ�� id ���� 
			psmt.setInt(1, input);
			psmt.setString(2, ID);
			// DB ������Ʈ
			psmt.executeUpdate();
			
			
			System.out.println("�ܾ��� "+money+"��");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

	public void ShopEnd() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void ShopEnter() {
		System.out.println("\r\n"
				+ "\r\n"
				+ "     :,~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     \r\n"
				+ "    ;,,                                      ;    \r\n"
				+ "   .*-~~-~:-~-:--~---~---------~~~-:-~-:--~~~*    \r\n"
				+ "      .-. !   !..,.  ....    ..,.  ;...;  ,,...   \r\n"
				+ "   !  .-..!   ;..,.  ....    ....  ;...;  ,,..!   \r\n"
				+ "   *!;!***=!!!*!!!*!!***!!!!!*;!!!!=!*!*!!!!**!   \r\n"
				+ "   !  .,..!   !. ,.  ....    ....  ;...!  ,,..!   \r\n"
				+ "   ~  -:..;. ,;..:.  !..~-  *..,:  :-.,;  :-.,-   \r\n"
				+ "    *=:~==~!*;~==~:*=~!=:;=!~**:~==~;*!~==~~!*    \r\n"
				+ "    *::~~~~~~~~~~~~~~~~~~~~~-~~~~~~~~~~~~~~~~=    \r\n"
				+ "    *:;*!!!!!;;;;;;;;;;!;!!*~~*;;;;;;;;;;!~~~*    \r\n"
				+ "    *:;-,                  !~~*,         !~~~*    \r\n"
				+ "    !:;-,                  !~~*,         !~~~*    \r\n"
				+ "    !:;-,                  !~~*, .       !~~~*    \r\n"
				+ "    *:;-,                  !~~*,.        !~~-*    \r\n"
				+ "    *:;-,                  !~~!.         !~~-!    \r\n"
				+ "    *:;-,,,,,,,.,..,,,,,,,,!~~*,         !~~~*    \r\n"
				+ "    *:;-,,,,,,,,,,,,,,,.,,,!~~*,         !~~~*    \r\n"
				+ "    *::!!!!!!!!!!!!!!!!!!!!!~~*,         !~~~*    \r\n"
				+ "    *::~~~~~~~~~~~~~~~~~~~~~~~*,,,,,,,,.,!~~~*    \r\n"
				+ "   .-,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.,,,,-,   \r\n"
				+ "   ~                                          -   \r\n"
				+ "   ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,   \r\n"
				+ "                                                  \r\n"
				+ "");
	}
}
