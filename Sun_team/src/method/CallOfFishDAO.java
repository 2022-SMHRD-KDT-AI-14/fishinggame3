package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CallOfFishDAO {

	Connection conn; // DB 연결을 위한 객체
	PreparedStatement psmt; // SQL문을 실행하는 객체
	ResultSet rs; // Query의 결과값을 받아오는 객체

	public void FishName(CallOfFishDTO dto) {
		process12();
		// 3. SQL문 실행
		String sql = "select fishname from fish where grade = ?"; // ?등급의 물고기 이름 출력
		try {
			psmt = conn.prepareStatement(sql);
			// ?는 반드시 execute전에 설정이 되어 있어야 한다
			psmt.setInt(1, dto.getGrade());
			rs = psmt.executeQuery();
			while (rs.next()) {
				String fishname = rs.getString("fishname");
				System.out.println(dto.getGrade() + "에 해당하는 이름은 " + fishname + "입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 종료
			connend();
		}
	}

	public ArrayList<Integer> FishNo(CallOfFishDTO dto) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		process12();
		// 3. SQL문 실행
		String sql = "select fno from fish where grade = ?"; // ?등급의 물고기 이름 출력
		try {
			psmt = conn.prepareStatement(sql);
			// ?는 반드시 execute전에 설정이 되어 있어야 한다
			psmt.setInt(1, dto.getGrade());
			rs = psmt.executeQuery();
			while (rs.next()) {
				int fno = rs.getInt("fno");
				result.add(fno);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "에 해당하는 이름은 " + fishname + "입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 종료
			connend();
		}
		return result;
	}

	public ArrayList<String> FishAll() {
		ArrayList<String> result = new ArrayList<String>();
		process12();
		// 3. SQL문 실행!
		String sql = "select fno, fishname from fish"; // ?등급의 물고기 이름 출력
		try {
			psmt = conn.prepareStatement(sql);
			// ?는 반드시 execute전에 설정이 되어 있어야 한다

			rs = psmt.executeQuery();
			while (rs.next()) {
				String fishname = rs.getString("fishname");
				result.add(fishname);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "에 해당하는 이름은 " + fishname + "입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 종료
			connend();
		}
		return result;
	}

	public ArrayList<Integer> fscore(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		process12();
		// 3. SQL문 실행
		String sql = "select fscore from fish order by fno asc"; // ?등급의 물고기 이름 출력
		try {
			psmt = conn.prepareStatement(sql);
			// ?는 반드시 execute전에 설정이 되어 있어야 한다
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int fscore = rs.getInt("fscore");
				result.add(fscore);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "에 해당하는 이름은 " + fishname + "입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 종료
			connend();
		}
		return result;
	}

	public ArrayList<Integer> price(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		process12();
		// 3. SQL문 실행
		String sql = "select price from fish order by fno asc"; // ?등급의 물고기 이름 출력
		try {
			psmt = conn.prepareStatement(sql);
			// ?는 반드시 execute전에 설정이 되어 있어야 한다
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int price = rs.getInt("price");
				result.add(price);
//					String fishname = rs.getString("fishname");
//					System.out.println(dto.getGrade() + "에 해당하는 이름은 " + fishname + "입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 종료
			connend();
		}
		return result;
	}
	
	private void connend() {
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

	private void process12() {
		// 1. 동적 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. DB 연결
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_4";
		String db_pw = "smhrd4";
		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
