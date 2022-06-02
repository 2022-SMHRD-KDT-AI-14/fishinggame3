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
	Connection conn; // DB 연결을 위한 객체
	PreparedStatement psmt; // SQL문을 실행하는 객체
	ResultSet rs; // Query의 결과값을 받아오는 객체
	
	MusicDTO MusicList = new MusicDTO();
	
	

	public void login() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. DB연결

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
		// DB 연결
		login();
		ShopEnter();
		System.out.println("상점에 오신 걸 환영합니다! 제가 준비 한 물건을 보세요. ");
		// ID와 맞는 돈 컬럼을 user_info 테이블에서 불러온다. while문 안에서 계속 세팅 안되게 while문 밖에서 변수 지정.
		String sql = "select MONEY from user_info where ID = ?";

		while (true) {
			

			System.out.println("[1] 릴 낚시대 (2000원) [2] 고급 릴 낚시대 (3000원) [3] 전설의 강태공 낚시대 (5000원) [4] 나가기>> ");
			// 상점에서 선택한 메뉴 번호를 input 변수에 저장
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("릴 낚시대를 선택했습니다.");
				System.out.println("기능 : 5등급 물고기 출현 확률 대폭 증가▲▲");
				System.out.println("구매하시겠습니까? [1] 네 [2] 아니오 >>");
				// 구매확정을 yn이라는 변수에 저장 후 선택지 제공
				int yn = sc.nextInt();
				if (yn == 1) {
					try {
						// 아이디 비교해서 돈 테이블 불러오기
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, ID);
						rs = psmt.executeQuery();

						if (rs.next()) {
							// 소지금 money 변수에 저장 후 소지금과 아이템 가격 비교 후 구매 및 비구매 갈림길
							int money = rs.getInt("MONEY");

							if (money >= 20) {
								ShopUpdate((money - 20), input, ID);
								// 소지금 업데이트 및 아이템 업데이트
								System.out.println("릴 낚시대를 구매하였습니다!");
							} else {
								// 소지금 부족시 상점 메인화면으로 롤백
								System.out.println("잔액이 부족합니다. 소지금을 확인해주세요.");
								System.out.println("소지금은 "+money+"원 입니다.");
							}
						}

					} catch (SQLException e) {
						e.printStackTrace();
						// 1번 릴낚시대 선택 시 트라이 캐치문! 오류 출력
					}

				} else if (yn == 2) {
					// 릴낚시대 구매 확정 선택지 중 2번 아니오 선택

				} else {
					// 릴 낚시대 구매 선택지 1 or 2 이외에 입력시 잘못 선택 클릭시 상점 메인으로 롤백
					System.out.println("잘못입력하셨습니다.");
				}

			} else if (input == 2) {
				System.out.println("고급 릴 낚시대를 선택했습니다.");
				System.out.println("기능 : 6등급 물고기 출현 제거");
				System.out.println("구매하시겠습니까? [1] 네 [2] 아니오 >>");
				int yn = sc.nextInt();
				if (yn == 1) {

					try {
						// 아이디 비교해서 돈 테이블 불러오기
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, ID);
						rs = psmt.executeQuery();

						if (rs.next()) {
							// 소지금 money 변수에 저장 후 소지금과 아이템 가격 비교 후 구매 및 비구매 갈림길
							int money = rs.getInt("MONEY");

							if (money >= 3000) {
								ShopUpdate((money - 3000), input, ID);
								// 소지금 업데이트 및 아이템 업데이트
								System.out.println("고급 릴 낚시대를 구매하였습니다!");
							} else {
								// 소지금 부족시 상점 메인 화면으로 롤백
								System.out.println("잔액이 부족합니다. 소지금을 확인해주세요.");
								System.out.println("소지금은 "+money+"원 입니다.");
							}
						}

					} catch (SQLException e) {
						// 2번 고급 릴낚시대 선택 시 트라이 캐치문! 오류 출력
						e.printStackTrace();
					}

				} else if (yn == 2) {
					// 고급 릴낚시대 구매 확정 선택지 중 2번 아니오 선택

				} else {
					// 고급 릴 낚시대 구매 선택지 1 or 2 이외에 입력시 잘못 선택 클릭시 상점 메인으로 롤백
					System.out.println("잘못입력하셨습니다.");
				}
			} else if (input == 3) {
				System.out.println("전설의 강태공 낚시대를 선택했습니다.");
				System.out.println("기능 : 언럭키 물고기 낚을 확률 감소");
				System.out.println("구매하시겠습니까? [1] 네 [2] 아니오 >>");
				int yn = sc.nextInt();
				if (yn == 1) {

					try {
						// 아이디 비교해서 돈 테이블 불러오기
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, ID);
						rs = psmt.executeQuery();

						if (rs.next()) {
							// 소지금 money 변수에 저장 후 소지금과 아이템 가격 비교 후 구매 및 비구매 갈림길
							int money = rs.getInt("MONEY");

							if (money >= 5000) {
								ShopUpdate((money - 5000), input, ID);
								// 소지금 업데이트 및 아이템 업데이트
								System.out.println("전설의 강태공 낚시대를 구매하였습니다!");
							} else {
								// 소지금 부족시 상점 메인 화면으로 롤백
								System.out.println("잔액이 부족합니다. 소지금을 확인해주세요.");
								System.out.println("소지금은 "+money+"원 입니다.");
							}
						}

					} catch (SQLException e) {
						// 3번 전설의 강태공의 낚시대 선택 시 트라이 캐치문! 오류 출력
						e.printStackTrace();
					}

				} else if (yn == 2) {
					// 전설의 강태공 낚시대 구매 확정 선택지 중 2번 아니오 선택

				} else {
					// 전설의 강태공 낚시대 구매 선택지 1 or 2 이외에 입력시 잘못 선택 클릭시 상점 메인으로 롤백
					System.out.println("잘못입력하셨습니다.");
				}
			} else if (input == 4) {
				System.out.println("상점을 나가겠습니다.");

				ShopEnd(); // DB 연결 종료
				break;

			} else {
				// 구매 선택지 1~4 이외에 입력 시 상점 메인화면으로 롤백
				System.out.println("잘못입력하셨습니다.");
			}

		}
	}

	public void ShopUpdate(int money, int input, String ID) {
		try {
			// sql문 다시 변수 지정
			String sql = "";
			// sql문에 USER_INFO라는 테이블의 MONEY 컬럼 업데이트. id와 같은 행에서
			sql = "update USER_INFO set MONEY = ? where id = ?";
			// sql문 실행
			psmt = conn.prepareStatement(sql);
			// ?에 대한 값 셋팅. 1번째 물음표 money, 2번째 물음표는 id 셋팅 
			 psmt.setInt(1, money);
			psmt.setString(2, ID);
			// DB 업데이트
			psmt.executeUpdate();

			sql = "update USER_INFO set I_TEM = ? where id = ?";
			// sql문 실행
			psmt = conn.prepareStatement(sql);
			// ?에 대한 값 셋팅. 1번째 물음표 input >> 낚시대 넘버링 , 2번째 물음표는 id 셋팅 
			psmt.setInt(1, input);
			psmt.setString(2, ID);
			// DB 업데이트
			psmt.executeUpdate();
			
			
			System.out.println("잔액은 "+money+"원");
			
		
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
