package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void insert(String id, String pw) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_4";
		String db_pw = "smhrd4";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into user_info(id ,pw) values (?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			int cnt = psmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("회원가입에 성공하였습니다! \n 이제 게임을 즐기러 가보실까요 ~~?");
			} else {
				System.out.println("회원가입 실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void select() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_4";
		String db_pw = "smhrd4";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select * from user_info";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			System.out.print("ID" + "\t");
			System.out.print("PW" + "\t");
			System.out.print("I_TEM" + "\t");
			System.out.print("APRICE" + "\t");
			System.out.print("MONEY" + "\t");

			while (rs.next()) {

				rs.next();
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String i_tem = rs.getString(3);
				String aprice = rs.getString(4);
				String money = rs.getString(5);
				System.out.println();
				System.out.print(id + "\t");
				System.out.print(pw + "\t");
				System.out.print(i_tem + "\t");
				System.out.print(aprice + "\t");
				System.out.print(money + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

		System.out.println("hello world");
	}

	public void login(UserDTO dto) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_4";
		String db_pw = "smhrd4";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "select PW from user_info where ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			rs = psmt.executeQuery();

			if (rs.next()) {
					
					String result = rs.getString("PW");
					if (result.equals(dto.getPw())) {
						System.out.println("로그인 성공");
						System.out.println(dto.getId() + "님 환영합니다!!!");
					} else {
						System.out.println("로그인 실패");
						dto.setId("");
						dto.setPw("");
					}

				

				// lee ayenggoon에 해당하는 이름은!!입니다.
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 연결 종료
			// rs, psmt, conn 순으로 닫아주세요!

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
	}

	public ArrayList<String[]> ranking() {
		ArrayList<String[]> result = new ArrayList<String[]>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_4";
		String db_pw = "smhrd4";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "select rownum,ID,APRICE from (select ID, APRICE from user_info order by APRICE desc) where rownum <=5";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String[] rank = { rs.getString("rownum"), rs.getString("ID"), rs.getString("aprice") };
				result.add(rank);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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
			return result;
		}
	}
}
